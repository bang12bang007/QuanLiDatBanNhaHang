/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Column;
import java.util.Objects;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import utils.Enum.LoaiTrangThai;
import utils.Enum.LoaiViTri;

/**
 *
 * @author Laptop
 */
//@Entity
@NoArgsConstructor
public class Ban {
//    @Id
    private String maBan;
    private LoaiViTri viTri;
    private int soGhe;
    private LoaiTrangThai trangThai;
    private String maBanGop;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="maTang")
    private String maTang;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.maBan);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ban other = (Ban) obj;
        return Objects.equals(this.maBan, other.maBan);
    }
}
