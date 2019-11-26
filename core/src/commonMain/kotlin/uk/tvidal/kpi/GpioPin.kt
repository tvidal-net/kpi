package uk.tvidal.kpi

enum class GpioPin(val pin: UByte) {
    P1_03(0u), P1_05(1u), P1_07(4u), P1_08(14u),
    P1_10(15u), P1_11(17u), P1_12(18u), P1_13(21u),
    P1_15(22u), P1_16(23u), P1_18(24u), P1_19(10u),
    P1_21(9u), P1_22(25u), P1_23(11u), P1_24(8u),
    P1_26(7u),

    V2_P1_03(2u), V2_P1_05(3u), V2_P1_07(4u),
    V2_P1_08(14u), V2_P1_10(15u), V2_P1_11(17u), V2_P1_12(18u),
    V2_P1_13(27u), V2_P1_15(22u), V2_P1_16(23u), V2_P1_18(24u),
    V2_P1_19(10u), V2_P1_21(9u), V2_P1_22(25u), V2_P1_23(11u),
    V2_P1_24(8u), V2_P1_26(7u), V2_P1_29(5u), V2_P1_31(6u),
    V2_P1_32(12u), V2_P1_33(13u), V2_P1_35(19u), V2_P1_36(16u),
    V2_P1_37(26u), V2_P1_38(20u), V2_P1_40(21u),

    V2_P5_03(28u), V2_P5_04(29u), V2_P5_05(30u), V2_P5_06(31u),

    BPLUS_03(2u),
    BPLUS_05(3u), BPLUS_07(4u), BPLUS_08(14u), BPLUS_10(15u),
    BPLUS_11(17u), BPLUS_12(18u), BPLUS_13(27u), BPLUS_15(22u),
    BPLUS_16(23u), BPLUS_18(24u), BPLUS_19(10u), BPLUS_21(9u),
    BPLUS_22(25u), BPLUS_23(11u), BPLUS_24(8u), BPLUS_26(7u),
    BPLUS_29(5u), BPLUS_31(6u), BPLUS_32(12u), BPLUS_33(13u),
    BPLUS_35(19u), BPLUS_36(16u), BPLUS_37(26u), BPLUS_38(20u),
    BPLUS_40(21u);
}
