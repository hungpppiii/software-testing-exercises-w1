package com.javacode;

import static org.junit.Assert.*;

public class DummyTelTest {

    @org.junit.Test
    public void tinhTien() {
        DummyTel dummyTel = new DummyTel();
        assertEquals(15.49, dummyTel.tinhTien(5, 59), 0.000001);
        assertEquals(15.49, dummyTel.tinhTien(18, 59), 0.000001);
        assertEquals(30.98, dummyTel.tinhTien(17, 59), 0.000001);
        assertEquals(28.11, dummyTel.tinhTien(8, 63), 0.000001);
    }
}