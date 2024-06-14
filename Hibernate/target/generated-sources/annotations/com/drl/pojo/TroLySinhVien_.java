package com.drl.pojo;

import com.drl.pojo.HoatDong;
import com.drl.pojo.Khoa;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-14T12:54:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(TroLySinhVien.class)
public class TroLySinhVien_ { 

    public static volatile SetAttribute<TroLySinhVien, HoatDong> hoatDongSet;
    public static volatile SingularAttribute<TroLySinhVien, Integer> id;
    public static volatile SingularAttribute<TroLySinhVien, Khoa> khoaId;

}