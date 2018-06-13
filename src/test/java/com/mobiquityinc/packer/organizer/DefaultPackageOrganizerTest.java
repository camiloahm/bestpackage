package com.mobiquityinc.packer.organizer;

import com.mobiquityinc.packer.model.PackageInput;
import com.mobiquityinc.packer.model.PackageOutput;
import com.mobiquityinc.packer.model.PackageThing;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultPackageOrganizerTest {

    private final PackageOrganizer packageOrganizer = new DefaultPackageOrganizer();

    @Test
    public void organizeInvalidPackageItemsWithMoreThan15Items() {

        //Given a package with 20 Elements
        List<PackageInput> packageInputs = new ArrayList<>();
        PackageThing packageThing1 = PackageThing
                .builder()
                .thingIndex((short) 1)
                .price(60f)
                .weight(70f)
                .build();

        List<PackageThing> packageThings = IntStream.range(0, 20)
                .mapToObj(i -> packageThing1)
                .collect(Collectors.toList());


        PackageInput result = PackageInput
                .builder()
                .maxWeight((short) 81)
                .packageThings(packageThings)
                .build();

        packageInputs.add(result);

        List<PackageOutput> packageOutput = packageOrganizer.organize(packageInputs);


        //Then package output should be invalid
        assertThat(packageOutput.get(0).getPackageOutput()).isNotBlank();
    }


    @Test
    public void organizeInvalidPackageWeightMoreThan100() {

        //Given a packcage with weight of 200
        List<PackageInput> packageInputs = new ArrayList<>();
        List<PackageThing> packageThings = new ArrayList<>();
        PackageThing packageThing1 = PackageThing
                .builder()
                .thingIndex((short) 1)
                .price(45f)
                .weight(53.38f)
                .build();

        packageThings.add(packageThing1);

        PackageInput result = PackageInput
                .builder()
                .maxWeight((short) 200)
                .packageThings(packageThings)
                .build();

        packageInputs.add(result);

        List<PackageOutput> packageOutput = packageOrganizer.organize(packageInputs);

        //Then package output should be invalid
        assertThat(packageOutput.get(0).getPackageOutput()).isNotBlank();
    }


    @Test
    public void organizeInvalidPackageItemsWithWeightMoreThan100() {

        //Given a package with an item with weight of 102f
        List<PackageInput> packageInputs = new ArrayList<>();
        List<PackageThing> packageThings = new ArrayList<>();
        PackageThing packageThing1 = PackageThing
                .builder()
                .thingIndex((short) 1)
                .price(45f)
                .weight(102f)
                .build();

        packageThings.add(packageThing1);

        PackageInput result = PackageInput
                .builder()
                .maxWeight((short) 81)
                .packageThings(packageThings)
                .build();

        packageInputs.add(result);

        List<PackageOutput> packageOutput = packageOrganizer.organize(packageInputs);

        //Then package output should be invalid
        assertThat(packageOutput.get(0).getPackageOutput()).isNotBlank();
    }


    @Test
    public void organizeInvalidPackageItemsWithPriceMoreThan100() {

        //Given a package with price of 300 it should be invalid
        List<PackageInput> packageInputs = new ArrayList<>();
        List<PackageThing> packageThings = new ArrayList<>();
        PackageThing packageThing1 = PackageThing
                .builder()
                .thingIndex((short) 1)
                .price(300f)
                .weight(70f)
                .build();

        packageThings.add(packageThing1);

        PackageInput result = PackageInput
                .builder()
                .maxWeight((short) 81)
                .packageThings(packageThings)
                .build();

        packageInputs.add(result);

        List<PackageOutput> packageOutput = packageOrganizer.organize(packageInputs);

        //Then package output should be invalid
        assertThat(packageOutput.get(0).getPackageOutput()).isNotBlank();
    }


    @Test
    public void organizeBasicPackage() {

        //Given 81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)
        List<PackageInput> packageInputs = new ArrayList<>();
        List<PackageThing> packageThings = new ArrayList<>();
        PackageThing packageThing1 = PackageThing
                .builder()
                .thingIndex((short) 1)
                .price(45f)
                .weight(53.38f)
                .build();
        PackageThing packageThing2 = PackageThing
                .builder()
                .thingIndex((short) 2)
                .price(98f)
                .weight(88.62f)
                .build();
        PackageThing packageThing3 = PackageThing
                .builder()
                .thingIndex((short) 3)
                .price(3f)
                .weight(78.48f)
                .build();
        PackageThing packageThing4 = PackageThing
                .builder()
                .thingIndex((short) 4)
                .price(76)
                .weight(72.30f)
                .build();
        PackageThing packageThing5 = PackageThing
                .builder()
                .thingIndex((short) 5)
                .price(9f)
                .weight(30.18f)
                .build();
        PackageThing packageThing6 = PackageThing
                .builder()
                .thingIndex((short) 6)
                .price(48f)
                .weight(46.34f)
                .build();

        packageThings.add(packageThing1);
        packageThings.add(packageThing2);
        packageThings.add(packageThing3);
        packageThings.add(packageThing4);
        packageThings.add(packageThing5);
        packageThings.add(packageThing6);

        PackageInput result = PackageInput
                .builder()
                .maxWeight((short) 81)
                .packageThings(packageThings)
                .build();

        packageInputs.add(result);

        List<PackageOutput> packageOutput = packageOrganizer.organize(packageInputs);

        //Then (4,72.30,€76)
        assertThat(packageOutput.get(0).getPackageThings()).containsOnly(packageThing4);
    }


}
