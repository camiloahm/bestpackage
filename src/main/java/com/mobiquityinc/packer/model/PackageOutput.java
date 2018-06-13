package com.mobiquityinc.packer.model;

import com.google.common.base.Strings;
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

    @Override
    public String toString() {
        return Strings.isNullOrEmpty(packageOutput) ? "" : packageOutput;
    }
}
