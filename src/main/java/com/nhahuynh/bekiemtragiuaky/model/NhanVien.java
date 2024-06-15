package com.nhahuynh.bekiemtragiuaky.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "NHANVIEN")
@Setter
@Getter
public class NhanVien {

    @Id
    @Column(length = 3)
    private String maNV;
    @Column(length = 100, nullable = false)
    private String tenNV;
    @Column(length = 3)
    private String phai;
    @Column(length = 200)
    private String noiSinh;
    private double luong;

    @ManyToOne
    @JoinColumn(name = "maPhong")
    private PhongBan phongBan;
}
