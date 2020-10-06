//package com.lukas.ramonas.cms.Model;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import javax.persistence.*;
//
///*******************************************
// * Defined entity model
// *******************************************/
//
//@Entity(name = "Role")
//@Table(name = "role_table")
//public class Role implements GrantedAuthority {
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Integer role_id;
//
//    private String name;
//
//    public Integer getId() {
//        return role_id;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String getAuthority() {
//        return this.name;
//    }
//}