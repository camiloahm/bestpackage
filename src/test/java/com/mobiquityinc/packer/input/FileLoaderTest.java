package com.mobiquityinc.packer.input;

import org.junit.Test;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileLoaderTest {


    private final InputLoader inputLoader = new FileLoader();

    @Test
    public void shouldReturnEmptyIfInvalidPath() {
        Optional<List<String>> input = inputLoader.loadFile(null);

        assertThat(input).isEmpty();
    }

    @Test
    public void shouldReturnEmptyIfPathNotFound() {
        Optional<List<String>> input = inputLoader.loadFile("NotFoundPath");

        assertThat(input).isEmpty();

    }

    @Test
    public void shouldReturnTestFile() throws URISyntaxException {
        Optional<List<String>> input = inputLoader.loadFile(getClass().getClassLoader()
                .getResource("in/test").toURI().getPath());

        assertThat(input).contains(Arrays.asList("Camilo", "Test"));
    }

}
