package com.mobiquityinc.packer.input;

import java.util.List;
import java.util.Optional;

/**
 * Loads an Input for Packer App
 */
public interface InputLoader {

    Optional<List<String>> loadFile(String path);

}
