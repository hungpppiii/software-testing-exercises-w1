package com.javacode;

import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class DummyTelTest {

    private static DummyTel dummyTel;

    /**
     * hàm setup các điều kiện để bắt đầu test
     */
    @BeforeClass
    public static void setup() {
        dummyTel = new DummyTel();
    }

    /**
     * Kiểm thử phân lơp tương đương mạnh phương thức tinhTien.
     * Các lớp của biến startHour: (minInt, 0), [0, 8:00), [8:00, 18:00), [18:00, 23:59], (24, maxInt).
     * Các lớp của biến callDuration: (minInt, 0], [0, 60], (60, maxInt).
     * có 5 * 3 = 15 test case sinh ra từ cac lớp tương đương của 2 biến startHour và callDuration.
     */
    @org.junit.Test
    public void kiemThuPhanLopTinhTien() {
//        callDuration thuộc [-oo, 0)
//        ham tinhTien return -1 khi các biến nằm ngoài miền hợp lệ
        assertEquals(-1, dummyTel.tinhTien(-1, -10), 0.00001);
        assertEquals(-1, dummyTel.tinhTien(7, -10), 0.00001);
        assertEquals(-1, dummyTel.tinhTien(10, -20), 0.00001);
        assertEquals(-1, dummyTel.tinhTien(20, -50), 0.00001);
        assertEquals(-1, dummyTel.tinhTien(25, -100), 0.00001);

//        callDuration thuộc [0, 60]
        assertEquals(-1, dummyTel.tinhTien(-1, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(7, 30), 0.00001);
        assertEquals(15.8, dummyTel.tinhTien(10, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(20, 30), 0.00001);
        assertEquals(-1, dummyTel.tinhTien(25, 30), 0.00001);

//        callDuration thuộc (60, +oo]
        assertEquals(-1, dummyTel.tinhTien(-1, 70), 0.00001);
        assertEquals(15.6, dummyTel.tinhTien(7, 70), 0.00001);
        assertEquals(31.2, dummyTel.tinhTien(10, 70), 0.00001);
        assertEquals(15.6, dummyTel.tinhTien(20, 70), 0.00001);
        assertEquals(-1, dummyTel.tinhTien(25, 70), 0.00001);
    }


    /**
     * Kiểm thử giá trị bên biên mạnh phương thức tinhTien.
     * startHour thuộc [08:00, 18:00) giá đầy đủ, các khoảng t/g còn lại được giảm 50%.
     * chọn các giá trị để kiểm thử của biến startHour: (-1, 0, 1, 7, 8, 9, 12, 17, 18, 19, 23, 24, 25).
     * callDuration thuộc [0, 60] giá đầy đủ, khoảng [60, +oo) được giảm 15%.
     * chọn các giá trị để kiểm thử của biến callDuration:(-1, 0, 1, 30, 59, 60, 61, 10000).
     */
    @org.junit.Test
    public void kiemThuBienManhTinhTien() {
//        test case : (startHour(nom), callDuration(nom))
        assertEquals(15.8, dummyTel.tinhTien(12, 30), 0.00001);

//        callDuration(nom) và lần lượt tất cả giá trị biên của startHour
        assertEquals(-1, dummyTel.tinhTien(-1, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(0, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(1, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(7, 30), 0.00001);
        assertEquals(15.8, dummyTel.tinhTien(8, 30), 0.00001);
        assertEquals(15.8, dummyTel.tinhTien(9, 30), 0.00001);
        assertEquals(15.8, dummyTel.tinhTien(12, 30), 0.00001);
        assertEquals(15.8, dummyTel.tinhTien(17, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(18, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(19, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(23, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(24, 30), 0.00001);
        assertEquals(-1, dummyTel.tinhTien(25, 30), 0.00001);

//        startHour(nom) và lần lượt tất cả giá trị biên của callDuration
//        callDuration < 0 sẽ trả về 1
        assertEquals(-1, dummyTel.tinhTien(12, -1), 0.00001);

        assertEquals(0, dummyTel.tinhTien(12, 0), 0.00001);
        assertEquals(0.5, dummyTel.tinhTien(12, 1), 0.00001);
        assertEquals(31, dummyTel.tinhTien(12, 59), 0.00001);
        assertEquals(31.5, dummyTel.tinhTien(12, 60), 0.00001);
        assertEquals(27.2, dummyTel.tinhTien(12, 61), 0.00001);
        assertEquals(4462.5, dummyTel.tinhTien(12, 10000), 0.00001);
    }

    /**
     * Kiểm thử biên tổ hợp hàm tinhTien
     * startHour thuộc [00:00, 24:00) giá đầy đủ, các khoảng t/g còn lại được giảm 50%.
     * chọn các giá trị để kiểm thử của biến startHour: (0, 1, 7, 8, 9, 12, 17, 18, 19, 23).
     * callDuration thuộc [0, 60] giá đầy đủ giá đầy đủ, khoảng [60, +oo) được giảm 15%.
     * chọn các giá trị để kiểm thử của biến callDuration:(1, 30, 59, 60, 61, 10000).
     */
    @org.junit.Test
    public void kiemThuBienToHopTinhTien() {
        assertEquals(15.8, dummyTel.tinhTien(12, 30), 0.00001);

//        callDuration(nom) và lần lượt tất cả giá trị biên của startHour
        assertEquals(7.9, dummyTel.tinhTien(0, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(1, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(7, 30), 0.00001);
        assertEquals(15.8, dummyTel.tinhTien(8, 30), 0.00001);
        assertEquals(15.8, dummyTel.tinhTien(9, 30), 0.00001);
        assertEquals(15.8, dummyTel.tinhTien(12, 30), 0.00001);
        assertEquals(15.8, dummyTel.tinhTien(17, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(18, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(19, 30), 0.00001);
        assertEquals(7.9, dummyTel.tinhTien(23, 30), 0.00001);

//        startHour(nom) và lần lượt tất cả giá trị biên của callDuration

        assertEquals(0.5, dummyTel.tinhTien(12, 1), 0.00001);
        assertEquals(31, dummyTel.tinhTien(12, 59), 0.00001);
        assertEquals(31.5, dummyTel.tinhTien(12, 60), 0.00001);
        assertEquals(27.2, dummyTel.tinhTien(12, 61), 0.00001);
        assertEquals(4462.5, dummyTel.tinhTien(12, 10000), 0.00001);

//        các góc
        assertEquals(31.5, dummyTel.tinhTien(8, 60), 0.00001);
        assertEquals(15.8, dummyTel.tinhTien(18, 60), 0.00001);
        assertEquals(0, dummyTel.tinhTien(8, 0), 0.00001);
        assertEquals(0, dummyTel.tinhTien(8, 0), 0.00001);

//        gần góc
        assertEquals(31, dummyTel.tinhTien(8, 59), 0.00001);
        assertEquals(15.5, dummyTel.tinhTien(18, 59), 0.00001);
        assertEquals(0.5, dummyTel.tinhTien(8, 1), 0.00001);
        assertEquals(0.3, dummyTel.tinhTien(18, 1), 0.00001);

        assertEquals(15.8, dummyTel.tinhTien(19, 60), 0.00001);
        assertEquals(31.5, dummyTel.tinhTien(9, 60), 0.00001);
        assertEquals(0, dummyTel.tinhTien(19, 0), 0.00001);
        assertEquals(0, dummyTel.tinhTien(9, 0), 0.00001);

    }
}
