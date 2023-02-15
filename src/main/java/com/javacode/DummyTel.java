package com.javacode;

/**
 *
 * @author Hung
 * @version 1.0
 */
public class DummyTel {

    /**
     * Tinh tien dien thoai
     *
     * @param startTime
     * @param callDuration
     * @return the cost of the call
     */
    public double tinhTien(String startTime, int callDuration) {
        double totalMoney = 0;
        double discount = 1;
        int startHour = Integer.parseInt(startTime.split(":")[0]);
//        System.out.println("hour: " + startHour);
//        cuộc gọi từ 18:00 đến trươc 08:00 được giảm 50% giá cước
        if (startHour >= 18 || startHour < 8) {
            discount = 0.5;
        }

//        System.out.println("discount: " + discount);
//        System.out.println("callDur: " + callDuration);

//      tính chi phí cuộc gọi
        totalMoney = callDuration * 0.5 * discount;

//        System.out.println("totalMoney 1: " + totalMoney);
//        cuộc gọi dài hơn 60 phút được giảm 15%
        if (callDuration > 60) {
            totalMoney -= totalMoney * 0.15;
        }

//        System.out.println("totalMoney 2: " + totalMoney);

//        tính thuế 5%
        totalMoney += totalMoney * 0.05;
//        System.out.println("totalMoney 3: " + totalMoney);

        return (double) Math.round(totalMoney * 100) / 100;
    }
}
