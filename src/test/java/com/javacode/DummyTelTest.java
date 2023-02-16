package com.javacode;

import static org.junit.Assert.*;

public class DummyTelTest {

    /**
     * hàm test phương thức tinhTien của lớp DummyTel
     * 2 đầu vào thời gian bắt đầu 5h và thời gian gọi điện 59 phút
     * số tiền điện thoại kì vọng là 15.49
     */
    @org.junit.Test
    public void tinhTien1() {
        DummyTel dummyTel = new DummyTel(5, 59);
        double result = dummyTel.tinhTien();
        assertEquals(15.49, result, 0.000001);

    }

    /**
     * hàm test phương thức tinhTien của lớp DummyTel
     * 2 đầu vào thời gian bắt đầu 18h và thời gian gọi điện 59 phút
     * số tiền điện thoại kì vọng là 15.49
     */
    @org.junit.Test
    public void tinhTien2() {
        DummyTel dummyTel = new DummyTel(18, 59);
        double result = dummyTel.tinhTien();
        assertEquals(15.49, dummyTel.tinhTien(), 0.000001);

    }
    /**
     * hàm test phương thức tinhTien của lớp DummyTel
     * 2 đầu vào thời gian bắt đầu 17h và thời gian gọi điện 59 phút
     * số tiền điện thoại kì vọng là 30.98
     */
    @org.junit.Test
    public void tinhTien3() {
        DummyTel dummyTel = new DummyTel(17, 59);
        double result = dummyTel.tinhTien();
        assertEquals(30.98, result, 0.000001);

    }

    /**
     * hàm test phương thức tinhTien của lớp DummyTel
     * 2 đầu vào thời gian bắt đầu 8h và thời gian gọi điện 63 phút
     * số tiền điện thoại kì vọng là 28.11
     */
    @org.junit.Test
    public void tinhTien4() {
        DummyTel dummyTel = new DummyTel(8, 63);
        double result = dummyTel.tinhTien();
        assertEquals(28.11, result, 0.000001);
    }

    /**
     * hàm test phương thức tinhTien của lớp DummyTel
     * 2 đầu vào thời gian bắt đầu 8h và thời gian gọi điện 60 phút
     * số tiền điện thoại kì vọng là 28.11
     */
    @org.junit.Test
    public void tinhTien5() {
        DummyTel dummyTel = new DummyTel(8, 60);
        double result = dummyTel.tinhTien();
        assertEquals(31.50, result, 0.000001);
    }
}