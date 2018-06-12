package com.mobiquityinc.packer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mobiquityinc.packer.input.InputModule;

/**
 * Defines a small object graph using Guice.
 * The graph contains the concrete dependencies to every dependency injection.
 */
final class PackerConfigurationTest {

    private PackerConfigurationTest() {
    }

    static Injector initDependencies() {
        return Guice.createInjector(new InputModule());
    }
}
