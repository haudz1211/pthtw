package com.drl.pojo;

import com.drl.pojo.Lop;
import com.drl.pojo.NamHoc;
import com.drl.pojo.NguoiDung;
import com.drl.pojo.SinhVienHoatDong;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-06-21T16:30:09")
@StaticMetamodel(SinhVien.class)
public class SinhVien_ { 

    public static volatile SingularAttribute<SinhVien, Integer> namSinh;
    public static volatile SingularAttribute<SinhVien, NamHoc> namHocId;
    public static volatile SingularAttribute<SinhVien, String> ho;
    public static volatile SingularAttribute<SinhVien, Integer> nienKhoa;
    public static volatile SingularAttribute<SinhVien, Integer> id;
    public static volatile SingularAttribute<SinhVien, Short> gioiTinh;
    public static volatile SetAttribute<SinhVien, SinhVienHoatDong> sinhVienHoatDongSet;
    public static volatile SingularAttribute<SinhVien, String> ten;
    public static volatile SingularAttribute<SinhVien, NguoiDung> nguoiDung;
    public static volatile SingularAttribute<SinhVien, Lop> lopId;

}