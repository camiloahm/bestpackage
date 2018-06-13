package com.mobiquityinc.packer.input;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

/**
 * Loads an Input for Packer App from a File path
 */
@Slf4j
final class FileLoader implements InputLoader {

    @Override
    public Optional<List<String>> loadFile(String path) {
        try {
            return Optional.ofNullable(Files.readAllLines(Paths.get(path)));
        } catch (IOException | NullPointerException e) {
            log.error("Something went wrong loading the file: ", e);
            return Optional.empty();
        }
    }

}
