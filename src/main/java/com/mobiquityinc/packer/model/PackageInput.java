package com.mobiquityinc.packer.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * Represent the package and the possible things that can be sent
 */
@Getter
@Builder
public class PackageInput {

    private float maxWeight;
    private List<PackageThing> packageThings;

}
