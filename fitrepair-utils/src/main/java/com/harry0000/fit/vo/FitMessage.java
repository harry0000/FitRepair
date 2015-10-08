package com.harry0000.fit.vo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum FitMessage {
    FILE_ID(0),
    CAPABILITIES(1),
    DEVICE_SETTINGS(2),
    USER_PROFILE(3),
    HRM_PROFILE(4),
    SDM_PROFILE(5),
    BIKE_PROFILE(6),
    ZONE_STARGET(7),
    HR_ZONE(8),
    POWER_ZONE(9),
    MET_ZONE(10),
    SPORT(12),
    GOAL(15),
    SESSION(18),
    LAP(19),
    RECORD(20),
    EVENT(21),
    DEVICE_INFO(23),
    WORKOUT(26),
    WORKOUT_STEP(27),
    SCHEDULE(28),
    WEIGHT_SCALE(30),
    COURSE(31),
    COURSE_POINT(32),
    TOTALS(33),
    ACTIVITY(34),
    SOFTWARE(35),
    FILE_CAPABILITIES(37),
    MESSAGE_CAPABILITIES(38),
    FIELD_CAPABILITIES(39),
    FILE_CREATOR(49),
    BLOOD_PRESSURE(51),
    SPEED_ZONE(53),
    MONITORING(55),
    TRAINING_FILE(72),
    HRV(78),
    LENGTH(101),
    MONITORING_INFO(103),
    PAD(105),
    SLAVE_DEVICE(106),
    CADENCE_ZONE(131),
    SEGMENT_LAP(142),
    MEMO_GLOB(145),
    SEGMENT_ID(148),
    SEGMENT_LEADERBOARD_ENTRY(149),
    SEGMENT_POINT(150),
    SEGMENT_FILE(151),
    GPS_METADATA(160),
    CAMERA_EVENT(161),
    TIMESTAMP_CORRELATION(162),
    GYROSCOPE_DATA(164),
    ACCELEROMETER_DATA(165),
    THREED_SENSOR_CALIBRATION(167),
    VIDEO_FRAME(169),
    OBDII_DATA(174),
    NMEA_SENTENCE(177),
    AVIATION_ATTITUDE(178),
    VIDEO(184),
    VIDEO_TITLE(185),
    VIDEO_DESCRIPTION(186),
    VIDEO_CLIP(187),
    UNKNOWN(-1);
/*
    MFG_RANGE_MIN(0x0000FF00), // 0xFF00 - 0xFFFE reserved for manufacturer specific messages
    MFG_RANGE_MAX(0x0000FFFE); // 0xFF00 - 0xFFFE reserved for manufacturer specific messages
*/

    private static final Map<Integer, FitMessage> MESSAGES;
    static {
        final FitMessage[] msgs = FitMessage.values();
        final Map<Integer, FitMessage> m = new HashMap<>(msgs.length);
        for (final FitMessage msg : msgs) {
            m.put(msg.number, msg);
        }
        m.remove(UNKNOWN.number);
        MESSAGES = Collections.unmodifiableMap(m);
    }

    /**
     * @param msgNumber
     * @return
     */
    public static FitMessage get(final short msgNumber) {
        return Optional.ofNullable(MESSAGES.get(Short.toUnsignedInt(msgNumber)))
                       .orElse(UNKNOWN);
    }

    private final int number;

    /**
     * @param number
     */
    private FitMessage(final int number) {
        this.number = number;
    }

}
