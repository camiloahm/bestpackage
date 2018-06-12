package com.mobiquityinc.packer.model;

import lombok.Builder;

import java.util.List;

@Builder
public class Package {

    private List<PackageThing> packageThings;

}
