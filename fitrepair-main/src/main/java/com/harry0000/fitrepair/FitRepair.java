package com.harry0000.fitrepair;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.harry0000.fit.Reader;
import com.harry0000.fit.message.Record;

public class FitRepair {
    private static final Logger logger = LoggerFactory.getLogger(FitRepair.class);
    private static final String DEST_FILE_SUFFIX = "_repair";

    /**
     * @param srcPath
     * @return
     */
    protected static Path getDestFilePath(final Path srcPath) {
        final String name = srcPath.getFileName().toString();
        final int idx = name.indexOf('.');
        final String destFileName;
        if (idx < 0) {
            destFileName = name + DEST_FILE_SUFFIX;
        } else {
            destFileName = new StringBuilder(name.length() + DEST_FILE_SUFFIX.length())
              .append(name.substring(0, idx))
              .append(DEST_FILE_SUFFIX)
              .append(name.substring(idx))
              .toString();
        }

        return srcPath.resolveSibling(destFileName);
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        for (final String arg : args) {
            final Path fitFile = Paths.get(arg);
            if (!Reader.isVaild(fitFile)) {
                logger.warn("Ignore invalid fit file: \"{}\"", arg);
                continue;
            }

            final List<Record> invalids = new Checker().check(fitFile);
            final boolean result = new Repair().repair(fitFile, getDestFilePath(fitFile), invalids);
            logger.debug("Power repair result = {}", result);
        }
    }

}
