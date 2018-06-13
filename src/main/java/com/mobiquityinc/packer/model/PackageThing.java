package com.mobiquityinc.packer.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Represents an Element in that can be sent in a package
 */
@Getter
@Builder
@EqualsAndHashCode
public class PackageThing {

    private short thingIndex;
    private float weight;
    private float price;

}
