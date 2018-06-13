package com.mobiquityinc.packer.organizer;

import com.google.inject.AbstractModule;

/**
 * Initializes dependency injection graph for Organizer loader
 */
public final class OrganizerModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(PackageOrganizer.class).to(DefaultPackageOrganizer.class).asEagerSingleton();

    }
}
