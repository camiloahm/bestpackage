package com.mobiquityinc.packer;

import com.mobiquityinc.packer.exception.APIException;
import com.mobiquityinc.packer.model.PackageOutput;
import com.mobiquityinc.packer.model.PackageThing;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PackerTest {

    @Test(expected = APIException.class)
    public void testGetPathWithNullArguments() {

        Packer.getPath(null);
    }


    @Test(expected = APIException.class)
    public void testGetPathWithMoreThanOneArgument() {

        Packer.getPath(new String[]{"http://", "123"});
    }


    @Test
    public void testGetPathWithValidArguments() {

        String path = Packer.getPath(new String[]{"/home/camilo/Documents/dev/bestpackage/src/test/resources/in/baseCase"});
        assertThat(path).isNotBlank();
    }
    

    @Test
    public void testPack() throws URISyntaxException {

        //Given
        String path = getClass().getClassLoader().getResource("in/baseCase").toURI().getPath();
        String result = Packer.pack(path);


        PackageThing thing1_1 = PackageThing
                .builder()
                .thingIndex((short) 4)
                .price(76f)
                .weight(72.30f)
                .build();

        List<PackageThing> packageThings1 = new ArrayList<>();
        packageThings1.add(thing1_1);

        PackageOutput expectedPackageOutput1 = PackageOutput
                .builder()
                .packageThings(packageThings1)
                .build();

        PackageThing thing3_1 = PackageThing
                .builder()
                .thingIndex((short) 2)
                .price(74f)
                .weight(14.55f)
                .build();

        PackageThing thing3_2 = PackageThing
                .builder()
                .thingIndex((short) 7)
                .price(74f)
                .weight(60.02f)
                .build();

        List<PackageThing> packageThings3 = new ArrayList<>();
        packageThings3.add(thing3_2);
        packageThings3.add(thing3_1);


        PackageOutput expectedPackageOutput3 = PackageOutput
                .builder()
                .packageThings(packageThings3)
                .build();

        //Then
        assertThat(result).contains("4\n" + "-\n" + "7,2\n" + "9,6");
    }

}
