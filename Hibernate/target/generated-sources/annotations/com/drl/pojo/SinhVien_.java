package com.drl.pojo;

import com.drl.pojo.Lop;
import com.drl.pojo.NamHoc;
import com.drl.pojo.SinhVienHoatDong;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-12T23:12:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(SinhVien.class)
public class SinhVien_ { 

    public static volatile SingularAttribute<SinhVien, NamHoc> namHocId;
    public static volatile SingularAttribute<SinhVien, Integer> id;
    public static volatile SetAttribute<SinhVien, SinhVienHoatDong> sinhVienHoatDongSet;
    public static volatile SingularAttribute<SinhVien, Lop> lopId;

}