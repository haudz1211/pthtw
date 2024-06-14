package com.drl.pojo;

import com.drl.pojo.Comment;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-14T12:54:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(NguoiDung.class)
public class NguoiDung_ { 

    public static volatile SingularAttribute<NguoiDung, Date> namSinh;
    public static volatile SingularAttribute<NguoiDung, String> password;
    public static volatile SetAttribute<NguoiDung, Comment> commentSet;
    public static volatile SingularAttribute<NguoiDung, String> ho;
    public static volatile SingularAttribute<NguoiDung, Integer> id;
    public static volatile SingularAttribute<NguoiDung, Short> gioiTinh;
    public static volatile SingularAttribute<NguoiDung, String> avatar;
    public static volatile SingularAttribute<NguoiDung, String> ten;
    public static volatile SingularAttribute<NguoiDung, String> email;

}