package com.mobiquityinc.packer.mapper;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.mobiquityinc.packer.model.PackageInput;


/**
 * Initializes dependency injection graph for package mapper
 */
public final class MapperModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(new TypeLiteral<PackageInputMapper<String, PackageInput>>() {
        })
                .to(StringPackageInputMapper.class).asEagerSingleton();

    }
}
