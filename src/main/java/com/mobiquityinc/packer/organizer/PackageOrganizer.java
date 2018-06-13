package com.mobiquityinc.packer.organizer;

import com.mobiquityinc.packer.model.PackageInput;
import com.mobiquityinc.packer.model.PackageOutput;

import java.util.List;

/**
 * Decides how to organize the packages to be sent based on different business rules
 */
public interface PackageOrganizer {

    List<PackageOutput> organize(List<PackageInput> packages);
}
