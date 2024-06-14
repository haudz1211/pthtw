package com.drl.pojo;

import com.drl.pojo.BaiViet;
import com.drl.pojo.Comment;
import com.drl.pojo.NguoiDung;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-06-14T12:54:25", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SetAttribute<Comment, Comment> commentSet;
    public static volatile SingularAttribute<Comment, Comment> commentId;
    public static volatile SingularAttribute<Comment, Integer> id;
    public static volatile SingularAttribute<Comment, String> noiDung;
    public static volatile SingularAttribute<Comment, BaiViet> baiVietId;
    public static volatile SingularAttribute<Comment, NguoiDung> nguoiDungId;
    public static volatile SingularAttribute<Comment, Date> thoiGian;

}