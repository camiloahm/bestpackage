package com.mobiquityinc.packer;

import com.mobiquityinc.packer.input.InputLoader;
import com.mobiquityinc.packer.model.PackageThing;
import com.mobiquityinc.packer.mapper.PackageThingMapper;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Service that determines which things to put into the package so that the
 * total weight is less than or equal to the package limit and the total cost is as large as possible.
 * You would prefer to send a package which weights less in case there is more than one package with the
 * same price.
 */
@Slf4j
final class PackerService {

    private final InputLoader inputLoader;
    private final PackageThingMapper<String, PackageThing> packageMapper;


    @Inject
    public PackerService(InputLoader inputLoader, PackageThingMapper<String, PackageThing> packageMapper) {
        this.inputLoader = inputLoader;
        this.packageMapper = packageMapper;
    }

    public String solvePackageChallenge(String path) {

        Optional<List<String>> lines = inputLoader.loadFile(path);


        return null;
    }
}
