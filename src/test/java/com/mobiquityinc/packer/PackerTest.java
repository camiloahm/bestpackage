package com.mobiquityinc.packer;

import com.mobiquityinc.packer.exception.APIException;
import org.junit.Test;

public class PackerTest {


    @Test(expected = APIException.class)
    public void shouldThrowRuntimeIfNullArguments() {

        Packer.getPath(null);
    }

    @Test(expected = APIException.class)
    public void shouldThrowRuntimeIfInvalidArguments() {

        Packer.getPath(new String[]{"", ""});
    }


}
