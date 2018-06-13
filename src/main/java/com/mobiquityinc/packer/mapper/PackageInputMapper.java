package com.mobiquityinc.packer.mapper;

/**
 * Maps from source input to some package input
 *
 * @param <S> Source
 * @param <T> Target
 */
public interface PackageInputMapper<S, T> {

    T map(S packageInputMapper);
}
