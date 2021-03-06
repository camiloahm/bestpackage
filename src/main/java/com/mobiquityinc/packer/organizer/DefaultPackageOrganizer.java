package com.mobiquityinc.packer.organizer;

import com.mobiquityinc.packer.model.PackageInput;
import com.mobiquityinc.packer.model.PackageOutput;
import com.mobiquityinc.packer.model.PackageThing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

final class DefaultPackageOrganizer implements PackageOrganizer {

    @Override
    public List<PackageOutput> organize(List<PackageInput> packages) {

        return packages
                .stream()
                .map(this::getPackageOutput)
                .collect(Collectors.toList());
    }


    private PackageOutput getPackageOutput(PackageInput packageInput) {

        if (!packageInput.isValid()) {
            return PackageOutput
                    .builder()
                    .packageOutput("Invalid Package Input")
                    .build();
        }

        int numberOfITems = packageInput.getPackageThings().size();   // number of items
        int maxWeight = Math.round(packageInput.getMaxWeight());   // maximum weight

        // opt[n][w] = max profit of packing items 1..n with weight limit w
        int[][] opt = new int[numberOfITems + 1][maxWeight + 1];
        // sol[n][w] = does opt solution to pack items 1..n with weight limit w include item n?
        boolean[][] sol = new boolean[numberOfITems + 1][maxWeight + 1];

        List<PackageThing> packagesToBeSent = new ArrayList<>();
        List<PackageThing> packagesToBeFiltered = packageInput.getPackageThings();

        for (int n = 1; n <= numberOfITems; n++) {
            PackageThing packageThing = packagesToBeFiltered.get(n - 1);
            for (int w = 1; w <= maxWeight; w++) {
                // don't take item n
                int option1 = opt[n - 1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (packageThing.getWeight() <= w) {
                    int weight = Math.round(packageThing.getWeight());
                    option2 = Math.round(packageThing.getPrice() + opt[n - 1][w - weight]);
                }

                // select better of two options
                opt[n][w] = Math.max(option1, option2);
                sol[n][w] = (option2 > option1);

            }
        }

        // determine which items to take
        for (int n = numberOfITems, w = maxWeight; n > 0; n--) {
            if (sol[n][w]) {
                packagesToBeSent.add(packagesToBeFiltered.get(n - 1));
                w = w - Math.round(packagesToBeFiltered.get(n - 1).getWeight());
            }
        }

        return PackageOutput
                .builder()
                .packageThings(packagesToBeSent)
                .build();
    }


}
