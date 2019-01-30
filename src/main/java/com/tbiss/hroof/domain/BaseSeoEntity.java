package com.tbiss.hroof.domain;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseSeoEntity extends BaseEntity {

    private String metaTitle;
    private String metaDescription ;
    private String metaKeywords ;



    public BaseSeoEntity() {
    }


}
