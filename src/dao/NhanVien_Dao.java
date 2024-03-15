/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import entity.NhanVien;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import static utils.AppUtils.*;
/**
 *
 * @author Laptop
 */
public class NhanVien_Dao {
    
    public NhanVien getThongTinCaNhan(String maNV) {
        return null;
    }
    
//  *  
    private void createNhanVienID(NhanVien nv) {
        int date = nv.getNgayBatDauLam().getDate();
        String year = nv.getNgayBatDauLam().getYear() + "";
        String sdt = nv.getSoDienThoai();
        String dd = date < 10 ? "0" + date : date + "";
        String yy = year.substring(year.length() - 2);
        String xxx = sdt.substring(sdt.length() - 3);
        nv.setMaNV("NV" + nv.getGioiTinh() + nv.getTuoi() + dd + yy + xxx);
    }
    
    public boolean insertNhanVien(NhanVien nhanVien) {
        createNhanVienID(nhanVien);
        String SQL = "INSERT INTO NhanVien ([MaNV], [HoTen], [DiaChi], [TrangThai], [Tuoi], [SoDienThoai], [NgayBatDauLam], [VaiTro], [GioiTinh])"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(nhanVien, SQL);
    }
    
    public int dangNhap(String tenDangNhap, String matKhau) {
        Connection con = connect();
        int isLoginSuccess = -1;
        try {
            Statement myStmt = con.createStatement();
            PreparedStatement pstms = con.prepareStatement("SELECT * FROM TaiKhoan tk join NhanVien nv ON tk.MaNV = nv.MaNV WHERE nv.MaNV = ? AND tk.matKhau = ?");
            pstms.setString(1, tenDangNhap);
            pstms.setString(2, matKhau);
            ResultSet myRs = pstms.executeQuery();
            while(myRs.next()) {
                isLoginSuccess = myRs.getInt("VaiTro");
            }
        } catch (Exception e) {
        }
        return isLoginSuccess;
    }
}
