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
    public static enum LoaiViTri {
        BAN_TRUNG_TAM,BAN_CANH_CUA_SO,BAN_PHIA_GOC,BAN_GAN_QUAY_PHUC_VU;
    };
    public static enum LoaiTrangThai {
        BAN_CO_KHACH,BAN_TRONG,BAN_DA_DUOC_DAT;
    };
    
    public static enum LoaiVaiTro {
        NHAN_VIEN_PHUC_VU,NHAN_VIEN_QL;
    };
    public static enum LoaiTheThanhVien {
        STANDARD,BRONZE,SILVER,GOLD,DIAMOND;
    };
    public static enum LoaiKhuyenMai {
        SU_KIEN_DAC_BIET,SAN_PHAM,MEM_BRONZE,MEM_SILVER,MEM_GOLD,MEM_DIAMOND;
    };
}
