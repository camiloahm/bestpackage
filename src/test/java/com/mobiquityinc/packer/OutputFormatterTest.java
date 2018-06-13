package com.mobiquityinc.packer;

import com.mobiquityinc.packer.model.PackageOutput;
import com.mobiquityinc.packer.model.PackageThing;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputFormatterTest {

    @Test
    public void concatPackageThings() {

        PackageThing thing1 = PackageThing
                .builder()
                .thingIndex((short) 4)
                .price(76f)
                .weight(72.30f)
                .build();

        PackageThing thing2 = PackageThing
                .builder()
                .thingIndex((short) 7)
                .price(76f)
                .weight(72.30f)
                .build();

        List<PackageThing> packageThings1 = new ArrayList<>();
        packageThings1.add(thing1);
        packageThings1.add(thing2);


        String output = OutputFormatter.concatPackageThings(packageThings1);
        assertThat(output).isEqualTo("4,7");
    }


    @Test
    public void getOutputWithOutpuPackagesWithoutResult() {

        List<PackageThing> packageThings = new ArrayList<>();

        //Given a empty package
        PackageOutput packageOutput = PackageOutput
                .builder()
                .packageThings(packageThings)
                .build();


        //should return a message
        String output = OutputFormatter.getOutput(packageOutput);
        assertThat(output).isEqualTo("-");
    }


    @Test
    public void getOutputWithInvalidOutpuPackage() {

        //Given a package with invalid output
        PackageOutput packageOutput = PackageOutput
                .builder()
                .packageOutput("Invalid Output")
                .build();

        //should return a message
        String output = OutputFormatter.getOutput(packageOutput);
        assertThat(output).isEqualTo("Invalid Output");
    }

    @Test
    public void getValidOutput() {

        PackageThing thing1 = PackageThing
                .builder()
                .thingIndex((short) 4)
                .price(76f)
                .weight(72.30f)
                .build();

        PackageThing thing2 = PackageThing
                .builder()
                .thingIndex((short) 7)
                .price(76f)
                .weight(72.30f)
                .build();

        List<PackageThing> packageThings1 = new ArrayList<>();
        packageThings1.add(thing1);
        packageThings1.add(thing2);


        String output = OutputFormatter.concatPackageThings(packageThings1);
        assertThat(output).isEqualTo("4,7");
    }
}
