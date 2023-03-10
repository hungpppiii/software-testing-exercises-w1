package com.javacode;

/**
 *
 * @author Hung
 * @version 1.0
 */
public class DummyTel {



    /**
     * DummyTel class constructor
     */
    public DummyTel () {
    }

    /**
     * Tinh tien dien thoai
     *
     * @return the cost of the call
     */
    public double tinhTien(int startHour, int callDuration) {
        double totalMoney = 0;
        double discount = 1;
//        cuộc gọi từ 18:00 đến trươc 08:00 được giảm 50% giá cước
        if (startHour >= 18 || startHour < 8) {
            discount = 0.5;
        }

//      tính chi phí cuộc gọi
        totalMoney = callDuration * 0.5 * discount;

//        cuộc gọi dài hơn 60 phút được giảm 15%
        if (callDuration > 60) {
            totalMoney -= totalMoney * 0.15;
        }

//        tính thuế 5%
        totalMoney += totalMoney * 0.05;

        return (double) Math.round(totalMoney * 100) / 100;
    }
}
