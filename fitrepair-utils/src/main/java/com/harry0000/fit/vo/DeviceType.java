package com.harry0000.fit.vo;

public class DeviceType {

    public enum Antplus implements ValueObject<Integer> {
        ANTFS(1),
        BIKE_POWER(11),
        ENVIRONMENT_SENSOR_LEGACY(12),
        MULTI_SPORT_SPEED_DISTANCE(15),
        CONTROL(16),
        FITNESS_EQUIPMENT(17),
        BLOOD_PRESSURE(18),
        GEOCACHE_NODE(19),
        LIGHT_ELECTRIC_VEHICLE(20),
        ENV_SENSOR(25),
        RACQUET(26),
        WEIGHT_SCALE(119),
        HEART_RATE(120),
        BIKE_SPEED_CADENCE(121),
        BIKE_CADENCE(122),
        BIKE_SPEED(123),
        STRIDE_SPEED_DISTANCE(124);

        /**
         * @param value
         * @return
         */
        public static Antplus get(final int value) {
            return VoUtils.get(Antplus.values(), value);
        }

        private final int value;

        /**
         * @param value
         */
        private Antplus(final int value) {
            this.value = value;
        }

        /* (non-Javadoc)
         * @see com.harry0000.Fit.vo.ValueObject#getValue()
         */
        @Override
        public Integer getValue() {
            return value;
        }
    }

    private DeviceType() {}

}
