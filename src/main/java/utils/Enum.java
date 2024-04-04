/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author dmx
 */
public class Enum {

//    static Object valueOf(Class<Enum> enumType, String string) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    public static enum LoaiViTri {
        BAN_TRUNG_TAM, BAN_CANH_CUA_SO, BAN_PHIA_GOC, BAN_GAN_QUAY_PHUC_VU;
    };

    public static enum LoaiTrangThai {
        BAN_CO_KHACH, BAN_TRONG, BAN_DA_DUOC_DAT;
    };

    public static enum LoaiTrangThaiMon {
        DANG_KINH_DOANH, NGUNG_KINH_DOANH, TAM_DUNG_PHUC_VU;
    };

    public static enum LoaiTrangThaiDichVu {
        DANG_KINH_DOANH, NGUNG_KINH_DOANH, TAM_DUNG_PHUC_VU;
    };

    public static enum LoaiTrangThaiHoaDon {
        DA_THANH_TOAN, HUY_BO, CHO_THANH_TOAN;
    };

    public static enum LoaiVaiTro {
        NHAN_VIEN_PHUC_VU, NHAN_VIEN_QL;
    };

    public static enum LoaiTheThanhVien {
        STANDARD, BRONZE, SILVER, GOLD, DIAMOND;
    };

    public static enum LoaiKhuyenMai {
        SU_KIEN_DAC_BIET, SAN_PHAM, MEM_BRONZE, MEM_SILVER, MEM_GOLD, MEM_DIAMOND;
    };

    public static enum LoaiTrangThaiKhuyenMai {
        HET_HAN, CON_AP_DUNG, TAM_NGUNG;
    };
}
