	package com.ismek.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tbl_Sinav")
public class Sinav implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sinav_id")
    private long sinavId;

    @Column(name="sinav_kodu")
    @Size(min = 2,max =25 ,message = "2 ve 25 karakterden fazla giremezsiniz ")
    private String sinavKodu;

   // @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    @Column(name="sinav_tarihi",nullable=false)
    private Date sinavTarihi;

    @Column(name="sinav_suresi",nullable=false)
    private Integer sinavSuresi;

    @Column(name="soru_sayisi",nullable=false)
    private Integer soruSayisi;
    	

    @Column(name="bs_saati")
   // @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date bsSaati;

    @Column(name="sinav_salonu")
    private String sinavSalonu;

    @Column(name="katki_yuzdesi")
    private float katkiYuzdesi;

  
   // @CreationTimestamp
    @Column(name="olusturma_tarihi")
  //  @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date olusturmaTarihi;
    
    @Column(name="is_aktif")
    private Boolean isAktif;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ogretmen_id")
    @JsonIgnore //OGRETMEN BILGILERINI GOSTEREBILIRSINIZ BURADA
    private Kullanici ogretmenId;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="brans_id")
	//@JsonBackReference  //SINAVIN HANGI BRANÞA AIT OLDUGUNU GOSTEREBILIRSINIZ
	private Brans brans;

	   	    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_SinavToSorular", joinColumns = @JoinColumn(name = "sinav_id"),inverseJoinColumns = @JoinColumn(name = "soru_id"))
    @JsonIgnore
    private Set<Sorular> sorulars;
   
    //BU SINAVI ALMIÞ KULLANICILAR LÝSTESI DONUYOR 
    @OneToMany( fetch= FetchType.EAGER,mappedBy="sinav")
    @JsonIgnore
    private Set<KullaniciToSinav> kullanicitosinav;
    
   
	public long getSinavId() {
		return sinavId;
	}

	public void setSinavId(long sinavId) {
		this.sinavId = sinavId;
	}

	public String getSinavKodu() {
		return sinavKodu;
	}

	public void setSinavKodu(String sinavKodu) {
		this.sinavKodu = sinavKodu;
	}

	public Date getSinavTarihi() {
		return sinavTarihi;
	}

	public void setSinavTarihi(Date sinavTarihi) {
		this.sinavTarihi = sinavTarihi;
	}

	public Integer getSinavSuresi() {
		return sinavSuresi;
	}

	public void setSinavSuresi(Integer sinavSuresi) {
		this.sinavSuresi = sinavSuresi;
	}

	public Integer getSoruSayisi() {
		return soruSayisi;
	}

	public void setSoruSayisi(Integer soruSayisi) {
		this.soruSayisi = soruSayisi;
	}

	public Date getBsSaati() {
		return bsSaati;
	}

	public void setBsSaati(Date bsSaati) {
		this.bsSaati = bsSaati;
	}

	public String getSinavSalonu() {
		return sinavSalonu;
	}

	public void setSinavSalonu(String sinavSalonu) {
		this.sinavSalonu = sinavSalonu;
	}

	public float getKatkiYuzdesi() {
		return katkiYuzdesi;
	}

	public void setKatkiYuzdesi(float katkiYuzdesi) {
		this.katkiYuzdesi = katkiYuzdesi;
	}

	public Date getOlusturmaTarihi() {
		return olusturmaTarihi;
	}

	public void setOlusturmaTarihi(Date olusturmaTarihi) {
		this.olusturmaTarihi = olusturmaTarihi;
	}

	public Kullanici getOgretmenId() {
		return ogretmenId;
	}

	public void setOgretmenId(Kullanici ogretmenId) {
		this.ogretmenId = ogretmenId;
	}

	public Boolean isAktif() {
		return isAktif;
	}

	public void setAktif(Boolean isAktif) {
		this.isAktif = isAktif;
	}

	public Brans getBrans() {
		return brans;
	}

	public void setBrans(Brans brans) {
		this.brans = brans;
	}

    public Set<Sorular> getSorulars() {
		return sorulars;
	}

	public void setSorulars(Set<Sorular> sorulars) {
		this.sorulars = sorulars;
	}

	public Set<KullaniciToSinav> getKullanicitosinav() {
		return kullanicitosinav;
	}

	public void setKullanicitosinav(Set<KullaniciToSinav> kullanicitosinav) {
		this.kullanicitosinav = kullanicitosinav;
	}
	

}
