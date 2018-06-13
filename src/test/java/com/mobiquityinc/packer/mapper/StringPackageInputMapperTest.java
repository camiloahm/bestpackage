package com.mobiquityinc.packer.mapper;

import com.mobiquityinc.packer.model.PackageInput;
import com.mobiquityinc.packer.model.PackageThing;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringPackageInputMapperTest {

    private final PackageInputMapper<String, PackageInput> packageInputMapper = new StringPackageInputMapper();

    @Test
    public void mapBaseCaseIntoInput() {

        //Given
        String in = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) " +
                "(6,46.34,€48)";
        PackageInput packageInputResult = packageInputMapper.map(in);

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

        PackageInput expectedPackage = PackageInput
                .builder()
                .maxWeight((short) 81)
                .packageThings(packageThings)
                .build();

        //Then
        assertThat(packageInputResult.getPackageThings()).contains(packageThing1);
        assertThat(packageInputResult.getPackageThings()).contains(packageThing2);
        assertThat(packageInputResult.getPackageThings()).contains(packageThing3);
        assertThat(packageInputResult.getPackageThings()).contains(packageThing4);
        assertThat(packageInputResult.getPackageThings()).contains(packageThing5);
        assertThat(packageInputResult.getPackageThings()).contains(packageThing6);
    }
}
