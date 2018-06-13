package com.mobiquityinc.packer.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the package and the possible things that can be sent
 */
@Getter
@Builder
public class PackageInput {

    private float maxWeight;
    private List<PackageThing> packageThings;

    public boolean isValid() {
        return maxWeight <= 100 && packageThings.size() <= 15 && itemsAreValid();
    }

    private boolean itemsAreValid() {
        return packageThings
                .stream()
                .filter(x -> x.getWeight() < 0 || x.getWeight() > 100 || x.getPrice() < 0 || x.getPrice() > 100)
                .collect(Collectors.toList())
                .isEmpty();
    }
}
