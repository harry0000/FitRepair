package com.harry0000.fitrepair;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.harry0000.fit.Reader;
import com.harry0000.fit.message.Record;

public class FitRepair {
    private static final Logger logger = LoggerFactory.getLogger(FitRepair.class);
    private static final String DEST_FILE_SUFFIX = "_repair";

    /**
     * @param srcFile
     * @return
     */
    protected static String GetDestFilePath(final File srcFile) {
        final Path srcPath = srcFile.toPath();
        final String name = srcPath.getFileName().toString();
        final int idx = name.indexOf('.');
        if (idx < 0) {
            return srcFile.getPath() + DEST_FILE_SUFFIX;
        }

        final StringBuilder sb = new StringBuilder();
        final Path parent = srcPath.getParent();
        if (parent != null) {
            final String path = parent.toString();
            sb.append(path);
            if (!"\\".equals(path)) {
                sb.append('\\');
            }
        }

        sb.append(name.substring(0, idx))
          .append(DEST_FILE_SUFFIX)
          .append(name.substring(idx));

        return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        for (final String arg : args) {
            final File fitFile = new File(arg);
            if (!Reader.isVaild(fitFile)) {
                logger.warn("Ignore invalid fit file: \"{}\"", arg);
                continue;
            }

            final List<Record> invalids = new Checker().check(fitFile);
            final boolean result = new Repair().repair(fitFile, new File(GetDestFilePath(fitFile)), invalids);
            logger.debug("Power repair result = {}", result);
        }
    }

}
