package com.harry0000.fitrepair;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.harry0000.fitrepair.FitRepair;

public class FitRepairTest {

    @Test
    public void getDestFilePath_onlyFileName() {
        final File srcFile = new File("1990-01-01-00-00-00.fit");

        final String actual = FitRepair.GetDestFilePath(srcFile);

        assertThat(actual, is("1990-01-01-00-00-00_repair.fit"));
    }

    @Test
    public void getDestFilePath_rootPath() {
        final File srcFile = new File("\\1990-01-01-00-00-00.fit");

        final String actual = FitRepair.GetDestFilePath(srcFile);

        assertThat(actual, is("\\1990-01-01-00-00-00_repair.fit"));
    }

    @Test
    public void getDestFilePath_relativePath() {
        final File srcFile = new File("..\\1990-01-01-00-00-00.fit");

        final String actual = FitRepair.GetDestFilePath(srcFile);

        assertThat(actual, is("..\\1990-01-01-00-00-00_repair.fit"));
    }

    @Test
    public void getDestFilePath_fullPath() {
        final File srcFile = new File("C:\\Garmin\\Activities\\1990-01-01-00-00-00.fit");

        final String actual = FitRepair.GetDestFilePath(srcFile);

        assertThat(actual, is("C:\\Garmin\\Activities\\1990-01-01-00-00-00_repair.fit"));
    }

    @Test
    public void getDestFilePath_noExtensions() {
        final File srcFile = new File("C:\\Garmin\\Activities\\1990-01-01-00-00-00");

        final String actual = FitRepair.GetDestFilePath(srcFile);

        assertThat(actual, is("C:\\Garmin\\Activities\\1990-01-01-00-00-00_repair"));
    }

    @Test
    public void getDestFilePath_multipleExtensions() {
        final File srcFile = new File("C:\\Garmin\\Activities\\1990-01-01-00-00-00.fit.bkup");

        final String actual = FitRepair.GetDestFilePath(srcFile);

        assertThat(actual, is("C:\\Garmin\\Activities\\1990-01-01-00-00-00_repair.fit.bkup"));
    }

}
