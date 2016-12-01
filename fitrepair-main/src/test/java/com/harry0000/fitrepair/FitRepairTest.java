package com.harry0000.fitrepair;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FitRepairTest {

    @Test
    public void getDestFilePath_onlyFileName() {
        final Path srcFile = Paths.get("1990-01-01-00-00-00.fit");

        final Path actual = FitRepair.getDestFilePath(srcFile);

        assertThat(actual, is(Paths.get("1990-01-01-00-00-00_repair.fit")));
    }

    @Test
    public void getDestFilePath_rootPath() {
        final Path srcFile = Paths.get("\\1990-01-01-00-00-00.fit");

        final Path actual = FitRepair.getDestFilePath(srcFile);

        assertThat(actual, is(Paths.get("\\1990-01-01-00-00-00_repair.fit")));
    }

    @Test
    public void getDestFilePath_relativePath() {
        final Path srcFile = Paths.get("..\\1990-01-01-00-00-00.fit");

        final Path actual = FitRepair.getDestFilePath(srcFile);

        assertThat(actual, is(Paths.get("..\\1990-01-01-00-00-00_repair.fit")));
    }

    @Test
    public void getDestFilePath_fullPath() {
        final Path srcFile = Paths.get("C:\\Garmin\\Activities\\1990-01-01-00-00-00.fit");

        final Path actual = FitRepair.getDestFilePath(srcFile);

        assertThat(actual, is(Paths.get("C:\\Garmin\\Activities\\1990-01-01-00-00-00_repair.fit")));
    }

    @Test
    public void getDestFilePath_noExtensions() {
        final Path srcFile = Paths.get("C:\\Garmin\\Activities\\1990-01-01-00-00-00");

        final Path actual = FitRepair.getDestFilePath(srcFile);

        assertThat(actual, is(Paths.get("C:\\Garmin\\Activities\\1990-01-01-00-00-00_repair")));
    }

    @Test
    public void getDestFilePath_multipleExtensions() {
        final Path srcFile = Paths.get("C:\\Garmin\\Activities\\1990-01-01-00-00-00.fit.bkup");

        final Path actual = FitRepair.getDestFilePath(srcFile);

        assertThat(actual, is(Paths.get("C:\\Garmin\\Activities\\1990-01-01-00-00-00_repair.fit.bkup")));
    }

}
