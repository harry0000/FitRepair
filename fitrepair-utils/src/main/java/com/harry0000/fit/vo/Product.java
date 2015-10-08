package com.harry0000.fit.vo;

public class Product {

    public enum Garmin implements ValueObject<Integer> {
        HRM1(1),
        AXH01(2), // AXH01 HRM chipset
        AXB01(3),
        AXB02(4),
        HRM2SS(5),
        DSI_ALF02(6),
        HRM3SS(7),
        HRM_RUN_SINGLE_BYTE_PRODUCT_ID(8), // hrm_run model for HRM ANT+ messaging
        BSM(9), // BSM model for ANT+ messaging
        BCM(10), // BCM model for ANT+ messaging
        AXS01(11), // AXS01 HRM Bike Chipset model for ANT+ messaging
        HRM_TRI_SINGLE_BYTE_PRODUCT_ID(12), // hrm_tri model for HRM ANT+ messaging
        FORERUNNER225_SINGLE_BYTE_PRODUCT_ID(14), // Forerunner225 model for HRM ANT+ messaging
        FORERUNNER301_CHINA(473),
        FORERUNNER301_JAPAN(474),
        FORERUNNER301_KOREA(475),
        FORERUNNER301_TAIWAN(494),
        FORERUNNER405(717),
        FORERUNNER50(782),
        FORERUNNER405_JAPAN(987),
        FORERUNNER60(988),
        DSI_ALF01(1011),
        FORERUNNER310XT(1018),
        EDGE500(1036),
        FORERUNNER110(1124),
        EDGE800(1169),
        EDGE500_TAIWAN(1199),
        EDGE500_JAPAN(1213),
        CHIRP(1253),
        FORERUNNER110_JAPAN(1274),
        EDGE200(1325),
        FORERUNNER910XT(1328),
        EDGE800_TAIWAN(1333),
        EDGE800_JAPAN(1334),
        ALF04(1341),
        FORERUNNER610(1345),
        FORERUNNER210_JAPAN(1360),
        VECTOR_SS(1380),
        VECTOR_CP(1381),
        EDGE800_CHINA(1386),
        EDGE500_CHINA(1387),
        FORERUNNER610_JAPAN(1410),
        EDGE500_KOREA(1422),
        FORERUNNER70(1436),
        FORERUNNER310XT_4T(1446),
        AMX(1461),
        FORERUNNER10(1482),
        EDGE800_KOREA(1497),
        SWIM(1499),
        FORERUNNER910XT_CHINA(1537),
        FENIX(1551),
        EDGE200_TAIWAN(1555),
        EDGE510(1561),
        EDGE810(1567),
        TEMPE(1570),
        FORERUNNER910XT_JAPAN(1600),
        FORERUNNER620(1623),
        FORERUNNER220(1632),
        FORERUNNER910XT_KOREA(1664),
        FORERUNNER10_JAPAN(1688),
        EDGE810_JAPAN(1721),
        VIRB_ELITE(1735),
        EDGE_TOURING(1736), // Also Edge Touring Plus
        EDGE510_JAPAN(1742),
        HRM_TRI(1743),
        HRM_RUN(1752),
        FORERUNNER920XT(1765),
        EDGE510_ASIA(1821),
        EDGE810_CHINA(1822),
        EDGE810_TAIWAN(1823),
        EDGE1000(1836),
        VIVO_FIT(1837),
        VIRB_REMOTE(1853),
        VIVO_KI(1885),
        FORERUNNER15(1903),
        VIVO_ACTIVE(1907),
        EDGE510_KOREA(1918),
        FORERUNNER620_JAPAN(1928),
        FORERUNNER620_CHINA(1929),
        FORERUNNER220_JAPAN(1930),
        FORERUNNER220_CHINA(1931),
        APPROACH_S6(1936),
        VIVO_SMART(1956),
        FENIX2(1967),
        EPIX(1988),
        FENIX3(2050),
        EDGE1000_TAIWAN(2052),
        EDGE1000_JAPAN(2053),
        FORERUNNER15_JAPAN(2061),
        EDGE520(2067),
        EDGE1000_CHINA(2070),
        FORERUNNER620_RUSSIA(2072),
        FORERUNNER220_RUSSIA(2073),
        VECTOR_S(2079),
        EDGE1000_KOREA(2100),
        FORERUNNER920XT_TAIWAN(2130),
        FORERUNNER920XT_CHINA(2131),
        FORERUNNER920XT_JAPAN(2132),
        VIRBX(2134),
        VIVO_SMART_APAC(2135),
        ETREX_TOUCH(2140),
        EDGE25(2147),
        VIVO_FIT2(2150),
        FORERUNNER225(2153),
        VIVO_ACTIVE_APAC(2160),
        VECTOR_2(2161),
        VECTOR_2S(2162),
        VIRBXE(2172),
        FORERUNNER620_TAIWAN(2173),
        FORERUNNER220_TAIWAN(2174),
        FENIX3_CHINA(2188),
        FENIX3_TWN(2189),
        VARIA_HEADLIGHT(2192),
        VARIA_TAILLIGHT_OLD(2193),
        FORERUNNER225_ASIA(2219),
        VARIA_RADAR_TAILLIGHT(2225),
        VARIA_RADAR_DISPLAY(2226),
        EDGE20(2238),
        D2_BRAVO(2262),
        VARIA_REMOTE(2276),
        SDM4(10007), // SDM4 footpod
        EDGE_REMOTE(10014),
        TRAINING_CENTER(20119),
        ANDROID_ANTPLUS_PLUGIN(65532),
        CONNECT(65534);

        /**
         * @param value
         * @return
         */
        public static Garmin get(final int value) {
            return VoUtils.get(Garmin.values(), value);
        }

        private final int value;

        /**
         * @param value
         */
        private Garmin(final int value) {
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

    private Product() {}

}
