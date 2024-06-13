package com.drl.pojo;

import com.drl.pojo.HocKiNamHoc;
import com.drl.pojo.SinhVien;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-12T23:12:57", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(NamHoc.class)
public class NamHoc_ { 

    public static volatile SetAttribute<NamHoc, HocKiNamHoc> hocKiNamHocSet;
    public static volatile SetAttribute<NamHoc, SinhVien> sinhVienSet;
    public static volatile SingularAttribute<NamHoc, Integer> id;
    public static volatile SingularAttribute<NamHoc, Integer> namHoc;

}