package com.ismek.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Set;

@Entity(name = "tbl_Sorular")
public class Sorular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "soru_id")
    private long soruId;
    @Column(name = "soru")
    private String soru;
    @Column(name = "secenekler")
    private String secenekler;
    @Column(name = "secenek_sayisi")
    private String secenekSayisi;
    @Column(name = "cevap")
    private String cevap;
    @Temporal(TemporalType.DATE)
    @Column(name = "ekleme_tarihi")
    private Date eklemeTarihi;
    @Column(name = "soru_puan")
    private Integer soruPuan;
    @Column(name = "is_onay")
    private Integer isOnay;
    @Column(name = "is_aktif")
    private Integer isAktif;
    @Column(name = "zorluk_seviyesi")
    private String zorlukSeviyesi;
    
    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="kullanici_id")
    @JsonIgnore // burayý ACABILIR SORUYU YAZAN KISILERI GOSTEREBILIRSINIZ
    private Kullanici kullanici;
    
    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<Brans> brans;
    
    @OneToOne(fetch = FetchType.EAGER)
   // @JsonIgnore
    private SoruAnaliz soruanaliz;

    public Sorular() {}

    public long getSoruId() {
        return soruId;
    }

    public void setSoruId(long soruId) {
        this.soruId = soruId;
    }

    public String getSoru() {
        return soru;
    }

    public void setSoru(String soru) {
        this.soru = soru;
    }

    public String getSecenekler() {
        return secenekler;
    }

    public void setSecenekler(String secenekler) {
        this.secenekler = secenekler;
    }

    public String getSecenekSayisi() {
        return secenekSayisi;
    }

    public void setSecenekSayisi(String secenekSayisi) {
        this.secenekSayisi = secenekSayisi;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

    public Date getEklemeTarihi() {
        return eklemeTarihi;
    }

    public void setEklemeTarihi(Date eklemeTarihi) {
        this.eklemeTarihi = eklemeTarihi;
    }

    public Integer getSoruPuan() {
        return soruPuan;
    }

    public void setSoruPuan(Integer soruPuan) {
        this.soruPuan = soruPuan;
    }

    public Integer getIsOnay() {
        return isOnay;
    }

    public void setIsOnay(Integer isOnay) {
        this.isOnay = isOnay;
    }

    public Integer getIsAktif() {
        return isAktif;
    }

    public void setIsAktif(Integer isAktif) {
        this.isAktif = isAktif;
    }

    public String getZorlukSeviyesi() {
        return zorlukSeviyesi;
    }

    public void setZorlukSeviyesi(String zorlukSeviyesi) {
        this.zorlukSeviyesi = zorlukSeviyesi;
    }

	public Kullanici getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}

	public Set<Brans> getBrans() {
		return brans;
	}

	public void setBrans(Set<Brans> brans) {
		this.brans = brans;
	}

	public SoruAnaliz getSoruanaliz() {
		return soruanaliz;
	}

	public void setSoruanaliz(SoruAnaliz soruanaliz) {
		this.soruanaliz = soruanaliz;
	}


}
