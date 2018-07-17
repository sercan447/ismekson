package com.ismek.model;


import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "tbl_Role")
@Table
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;
    
    @Column(name = "roles")
    private String roles;

    public Role() {}


	public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }


	

	

    
    
	
    
    
}


