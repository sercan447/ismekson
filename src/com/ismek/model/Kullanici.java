
package com.ismek.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tbl_Kullanici")
@NamedQuery(name = "Kullanici.findByLogin",
										query = "SELECT d FROM Kullanici d WHERE d.tcNo = :tcNo AND d.telefon = :telefon")

public class Kullanici implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kullanici_id")
    private long kullaniciId;

   
    @Column(name="tc_no",nullable=false,unique=true)
    @Size(max =11 ,message = "Tc no 11 haneli olmalıdır. ")
    private String tcNo;

    @Column(name="adi",nullable=false)
    @Size(min = 2,max =20 ,message = "2 ile 20 karakterden fazla giremezsiniz ")
    private String ad;

    @Column(name="soyadi",nullable=false)
    @Size(min = 2,max =25 ,message = "2 ile 25 karakterden fazla giremezsiniz ")
    private String soyAdi;

    @Column(name="telefon")
    @Size(max =15 ,message = "15 karakterden fazla giremezsiniz ")
    private String telefon;

    @Column(name="mail")
    @Size(max =50 ,message = "50 karakterden fazla giremezsiniz ")
    private String mail;

    @CreationTimestamp
    @Column(name="dogum_tarihi")
    private Date dogumTarihi;

    @Column(name="cinsiyet")
    @Size(max =1 ,message = "1 karakterden fazla giremezsiniz ")
    private String cinsiyet;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_KullaniciToRole",joinColumns = @JoinColumn(name = "kullanici_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
   // @JsonIgnore
    private Set<Role> roles;
    
   
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_KullaniciToBrans", joinColumns = @JoinColumn(name = "kullanici_id"), inverseJoinColumns = @JoinColumn(name = "brans_id"))
   // @JsonIgnore
    private Set<Brans> branslar;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy="kullanici")
    @JsonIgnore
    private Set<Sorular> sorular;
    
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="ogretmenId")
    @JsonIgnore
    private List<Sinav> sinav = new ArrayList<Sinav>();
    
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="kullanici")
    @JsonIgnore
    private Set<KullaniciToSinav> kullaniciToSinav;

    public Kullanici() {
    	
    	
    }
    

	public long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAdi() {
        return soyAdi;
    }

    public void setSoyAdi(String soyAdi) {
        this.soyAdi = soyAdi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Set<Brans> getBranslar() {
        return branslar;
    }

    public void setBranslar(Set<Brans> branslar) {
        this.branslar = branslar;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


	public Set<Sorular> getSorular() {
		return sorular;
	}


	public void setSorular(Set<Sorular> sorular) {
		this.sorular = sorular;
	}


	public List<Sinav> getSinav() {
		return sinav;
	}


	public void setSinav(List<Sinav> sinav) {
		this.sinav = sinav;
	}


	public Set<KullaniciToSinav> getKullaniciToSinav() {
		return kullaniciToSinav;
	}


	public void setKullaniciToSinav(Set<KullaniciToSinav> kullaniciToSinav) {
		this.kullaniciToSinav = kullaniciToSinav;
	}




	

		
    
    
    
}