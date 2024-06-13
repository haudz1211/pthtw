package com.drl.pojo;

import com.drl.pojo.HoatDong;
import com.drl.pojo.Lop;
import com.drl.pojo.TroLySinhVien;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-12T23:12:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Khoa.class)
public class Khoa_ { 

    public static volatile SetAttribute<Khoa, HoatDong> hoatDongSet;
    public static volatile SingularAttribute<Khoa, Integer> id;
    public static volatile SetAttribute<Khoa, TroLySinhVien> troLySinhVienSet;
    public static volatile SingularAttribute<Khoa, String> ten;
    public static volatile SetAttribute<Khoa, Lop> lopSet;

}