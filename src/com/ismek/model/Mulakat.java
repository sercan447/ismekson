	package com.ismek.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="tbl_Mulakat")
public class Mulakat implements Serializable {


    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @Column(name="mulakat_id")
    private int mulakatId;

    @Column(name="m_sorulari")
    private String mSorulari;
    
   /* @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private MulakatCevaplari mulakatcevaplari;
    */

    public int getMulakatId() {
        return mulakatId;
    }

    public void setMulakatId(int mulakatId) {
        this.mulakatId = mulakatId;
    }

    public String getmSorulari() {
        return mSorulari;
    }

    public void setmSorulari(String mSorulari) {
        this.mSorulari = mSorulari;
    }
/*
	public MulakatCevaplari getMulakatcevaplari() {
		return mulakatcevaplari;
	}

	public void setMulakatcevaplari(MulakatCevaplari mulakatcevaplari) {
		this.mulakatcevaplari = mulakatcevaplari;
	}
*/
	
    
    
    
    
}
