package com.mobiquityinc.packer.mapper;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.mobiquityinc.packer.model.PackageInput;
import com.mobiquityinc.packer.model.PackageThing;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Maps a String input line into a PackageInput Object
 */
@Slf4j
final class StringPackageInputMapper implements PackageInputMapper<String, PackageInput> {

    /**
     * Maps 81 : (1,53.38,€45) (2,88.62,€98) into a PackageInput
     *
     * @param packageInputs
     * @return PackageInput
     */
    @Override
    public PackageInput map(String packageInputs) {

        List<String> stringSplitOnColon = Splitter.on(':')
                .trimResults()
                .splitToList(packageInputs);

        return PackageInput
                .builder()
                .maxWeight(Float.parseFloat(stringSplitOnColon.get(0)))
                .packageThings(getPackageThings(stringSplitOnColon.get(1)))
                .build();
    }


    /**
     * Maps this expression like this one (1,53.38,€45) (2,88.62,€98) into a list of PackageThing
     *
     * @param packageThings
     * @return List<PackageThing>
     */
    private List<PackageThing> getPackageThings(String packageThings) {

        return Splitter.on(" ")
                .splitToList(packageThings)
                .stream()
                .map(this::getPackageThing)
                .collect(Collectors.toList());

    }

    /**
     * Maps this expression like this one (6,46.34,€48) into a PackageThing
     *
     * @param thing
     * @return PackageThing
     */
    private PackageThing getPackageThing(String thing) {
        //Remove parenthesis "(" ")" (
        final String plainThing = thing.substring(1, thing.length() - 1);
        final String plainThingWithoutMoneySign = plainThing.replaceAll("€", "");


        List<String> stringThing = Splitter.on(",")
                .trimResults()
                .splitToList(plainThingWithoutMoneySign);

        return PackageThing
                .builder()
                .thingIndex(Short.parseShort(stringThing.get(0)))
                .weight(Float.parseFloat(stringThing.get(1)))
                .price(Float.parseFloat(stringThing.get(2)))
                .build();
    }

}
