package uk.tvidal.kpi

enum class GpioPin(val pin: Byte) {
    P1_03(0), P1_05(1), P1_07(4), P1_08(14),
    P1_10(15), P1_11(17), P1_12(18), P1_13(21),
    P1_15(22), P1_16(23), P1_18(24), P1_19(10),
    P1_21(9), P1_22(25), P1_23(11), P1_24(8),
    P1_26(7),

    V2_P1_03(2), V2_P1_05(3), V2_P1_07(4),
    V2_P1_08(14), V2_P1_10(15), V2_P1_11(17), V2_P1_12(18),
    V2_P1_13(27), V2_P1_15(22), V2_P1_16(23), V2_P1_18(24),
    V2_P1_19(10), V2_P1_21(9), V2_P1_22(25), V2_P1_23(11),
    V2_P1_24(8), V2_P1_26(7), V2_P1_29(5), V2_P1_31(6),
    V2_P1_32(12), V2_P1_33(13), V2_P1_35(19), V2_P1_36(16),
    V2_P1_37(26), V2_P1_38(20), V2_P1_40(21),

    V2_P5_03(28), V2_P5_04(29), V2_P5_05(30), V2_P5_06(31),

    BPLUS_03(2),
    BPLUS_05(3), BPLUS_07(4), BPLUS_08(14), BPLUS_10(15),
    BPLUS_11(17), BPLUS_12(18), BPLUS_13(27), BPLUS_15(22),
    BPLUS_16(23), BPLUS_18(24), BPLUS_19(10), BPLUS_21(9),
    BPLUS_22(25), BPLUS_23(11), BPLUS_24(8), BPLUS_26(7),
    BPLUS_29(5), BPLUS_31(6), BPLUS_32(12), BPLUS_33(13),
    BPLUS_35(19), BPLUS_36(16), BPLUS_37(26), BPLUS_38(20),
    BPLUS_40(21);
}
