package com.mobiquityinc.packer.mapper;

/**
 * Maps from source input to some package target
 *
 * @param <S> Source
 * @param <T> Target
 */
public interface PackageThingMapper<S, T> {

    T map(S packageThingSource);
}
