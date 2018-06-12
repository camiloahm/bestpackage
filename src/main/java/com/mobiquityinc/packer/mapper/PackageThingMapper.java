package com.mobiquityinc.packer.mapper;

public interface PackageThingMapper<S, T> {

    T map(S packageThingSource);
}
