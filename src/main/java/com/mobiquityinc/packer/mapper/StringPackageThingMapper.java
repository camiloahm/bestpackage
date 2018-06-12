package com.mobiquityinc.packer.mapper;

import com.mobiquityinc.packer.model.PackageThing;
import lombok.extern.slf4j.Slf4j;

/**
 * Maps a String input line into a PackageThing Object
 */
@Slf4j
final class StringPackageThingMapper implements PackageThingMapper<String, PackageThing> {

    @Override
    public PackageThing map(String packageThingSource) {
        return null;
    }
}
