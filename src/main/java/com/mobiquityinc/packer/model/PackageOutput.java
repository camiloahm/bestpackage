package com.mobiquityinc.packer.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * Represents the package that will be sent
 */
@Builder
@Getter
@EqualsAndHashCode
public class PackageOutput {

    private List<PackageThing> packageThings;
    private String packageOutput;

}
