package com.harry0000.fit;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.Test;

public class ReaderTest {

    @Test
    public void isValid() throws URISyntaxException {
        assertThat(
            Reader.isValid(Paths.get(getClass().getResource("Activity.fit").toURI())),
            is(true)
        );
    }

    @Test
    public void readActivity() throws IOException {
        readValidFitFile("Activity.fit");
    }

    @Test
    public void readMonitoringFile() throws IOException {
        readValidFitFile("MonitoringFile.fit");
    }

    @Test
    public void readSettings() throws IOException {
        readValidFitFile("Settings.fit");
    }

    @Test
    public void readWeightScaleMultiUser() throws IOException {
        readValidFitFile("WeightScaleMultiUser.fit");
    }

    @Test
    public void readWeightScaleSingleUser() throws IOException {
        readValidFitFile("WeightScaleSingleUser.fit");
    }

    @Test
    public void readWorkoutCustomTargetValues() throws IOException {
        readValidFitFile("WorkoutCustomTargetValues.fit");
    }

    @Test
    public void readWorkoutIndividualSteps() throws IOException {
        readValidFitFile("WorkoutIndividualSteps.fit");
    }

    @Test
    public void readWorkoutRepeatGreaterThanStep() throws IOException {
        readValidFitFile("WorkoutRepeatGreaterThanStep.fit");
    }

    @Test
    public void readWorkoutRepeatSteps() throws IOException {
        readValidFitFile("WorkoutRepeatSteps.fit");
    }

    /**
     * @param fitFileName
     * @throws IOException 
     */
    public void readValidFitFile(final String fitFileName) throws IOException {
        final Reader reader = new Reader();
        assertThat(
            reader.read(getClass().getResourceAsStream(fitFileName)),
            is(true)
        );
    }

}
