package com.mobiquityinc.packer;

import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;
import com.mobiquityinc.packer.exception.APIException;
import com.mobiquityinc.packer.exception.ErrorCode;
import com.mobiquityinc.packer.model.PackageOutput;
import com.mobiquityinc.packer.model.PackageThing;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Packer application entry point
 */
@Slf4j
public class Packer {

    public static void main(String[] args) {

        log.info("The app is starting");

        final Stopwatch stopWatch = Stopwatch.createStarted();
        final String path = getPath(args);
        final String result = pack(path);
        log.info("Assignment: Package Challenge");
        log.info("Output: \n" + result);
        stopWatch.stop();

        log.info("The app has finished");
        log.info("Process time in ms: " + stopWatch.elapsed().toMillis());

    }

    static String pack(String path) {
        return PackerConfiguration.initDependencies().getInstance(PackerService.class)
                .solvePackageChallenge(path)
                .stream()
                .map(OutputFormatter::getOutput)
                .collect(Collectors.joining("\n"));
    }

    static String getPath(String[] args) {
        if (args == null || args.length == 0 || args.length > 1) {
            log.error(ErrorCode.INVALID_ARGS.getMessage());
            throw new APIException(ErrorCode.INVALID_ARGS);
        }

        return args[0];
    }

}
