/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import dto.TaiKhoanDTO;
import entity.TaiKhoan;
import java.util.Date;
import static utils.AppUtils.*;
/**
 *
 * @author Laptop
 */
public class TaiKhoanDAO {
    
    private void createDefaultPass(TaiKhoanDTO tk) {
       String matKhau = "12345678";
       tk.setMatKhau(matKhau);
    }
    
    public boolean insertTaiKhoan(TaiKhoanDTO tk) {
        createDefaultPass(tk);
        tk.setNgayTao(new Date());
        tk.setNgayKetThuc(new Date());
        String SQL = "INSERT INTO TaiKhoan ([MaNV],[MatKhau],[NgayTao],[NgayKetThuc]) VALUES (?,?,?,?)";
        return insert(tk, SQL);
    }
}
