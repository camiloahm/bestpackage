package com.mobiquityinc.packer.input;

import com.google.inject.AbstractModule;

/**
 * Initializes dependency injection graph for input loader
 */
public final class InputModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(InputLoader.class).to(FileLoader.class).asEagerSingleton();

    }
}
