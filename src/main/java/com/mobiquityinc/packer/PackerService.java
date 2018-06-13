package com.mobiquityinc.packer;

import com.mobiquityinc.packer.input.InputLoader;
import com.mobiquityinc.packer.mapper.PackageInputMapper;
import com.mobiquityinc.packer.model.PackageInput;
import com.mobiquityinc.packer.model.PackageOutput;
import com.mobiquityinc.packer.organizer.PackageOrganizer;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service that determines which things to put into the package solving the package challenge.
 */
@Slf4j
final class PackerService {

    private final InputLoader inputLoader;
    private final PackageInputMapper<String, PackageInput> packageMapper;
    private final PackageOrganizer packageOrganizer;


    @Inject
    public PackerService(InputLoader inputLoader, PackageInputMapper<String, PackageInput> packageMapper, PackageOrganizer packageOrganizer) {
        this.inputLoader = inputLoader;
        this.packageMapper = packageMapper;
        this.packageOrganizer = packageOrganizer;
    }

    public List<PackageOutput> solvePackageChallenge(String path) {

        List<PackageInput> packages = inputLoader.loadFile(path).get()
                .stream()
                .map(packageMapper::map)
                .collect(Collectors.toList());

        return packageOrganizer.organize(packages);
    }
}
