package com.mobiquityinc.packer.mapper;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.mobiquityinc.packer.model.PackageThing;


/**
 * Initializes dependency injection graph for mapper package
 */
public class MapperModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(new TypeLiteral<PackageThingMapper<String, PackageThing>>() {})
                .to(StringPackageThingMapper.class);

    }
}
