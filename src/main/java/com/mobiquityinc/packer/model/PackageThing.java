package com.mobiquityinc.packer.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PackageThing {

    private short thingIndex;
    private short weight;
    private float price;

}
