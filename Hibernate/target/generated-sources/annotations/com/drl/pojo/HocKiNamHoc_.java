package com.drl.pojo;

import com.drl.pojo.HoatDong;
import com.drl.pojo.HocKi;
import com.drl.pojo.NamHoc;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-14T12:54:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(HocKiNamHoc.class)
public class HocKiNamHoc_ { 

    public static volatile SetAttribute<HocKiNamHoc, HoatDong> hoatDongSet;
    public static volatile SingularAttribute<HocKiNamHoc, NamHoc> namHocId;
    public static volatile SingularAttribute<HocKiNamHoc, Integer> id;
    public static volatile SingularAttribute<HocKiNamHoc, HocKi> hocKiId;

}