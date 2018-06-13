package com.mobiquityinc.packer;

import com.google.common.base.Strings;
import com.mobiquityinc.packer.model.PackageOutput;
import com.mobiquityinc.packer.model.PackageThing;

import java.util.List;
import java.util.stream.Collectors;

class OutputFormatter {

    private OutputFormatter() {
    }

    static String getOutput(PackageOutput x) {
        if (!Strings.isNullOrEmpty(x.getPackageOutput())) {
            return x.getPackageOutput();
        }
        String outputLine = concatPackageThings(x.getPackageThings());
        return Strings.isNullOrEmpty(outputLine) ? "-" : outputLine;
    }

    static String concatPackageThings(List<PackageThing> packageThings) {
        return packageThings
                .stream()
                .map(po -> po.getThingIndex() + "")
                .collect(Collectors.joining(","));
    }
}
