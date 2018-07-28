package com.ismek.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="tbl_KullaniciToSinav")
public class KullaniciToSinav implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kts_id")
    private int ktsId;

    @Column(name="ogr_cevap")
  //  @Max(value=100)
    private String ogrCevap;

    @Column(name="is_onay")
    private boolean isOnay;

    @Column(name="is_durum")
    private boolean isDurum;

    @Column(name="m_puan")
    private Integer mPuan;

    @Column(name="sinav_puan")
    private Integer sinavPuan;

    @Column(name="ip_adresi")
   // @Max(value=20)
    private String ipAdresi;

    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="kullanici_id")
    //@JsonIgnore
    private Kullanici kullanici;

  
    
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="sinav_id")
    @JsonIgnore
    private Sinav sinav;
    
    
    @OneToMany(fetch=FetchType.EAGER,mappedBy="ktsId")
    @JsonIgnore
    private Set<MulakatCevaplari> mulakatcevaplari;
    
    @OneToOne(mappedBy = "kts")
    @JsonIgnore
    private SinavSonuc sinavsonuc;

    public int getKtsId() {
        return ktsId;
    }

    public void setKtsId(int ktsId) {
        this.ktsId = ktsId;
    }

    public String getOgrCevap() {
        return ogrCevap;
    }

    public void setOgrCevap(String ogrCevap) {
        this.ogrCevap = ogrCevap;
    }

    public boolean isOnay() {
        return isOnay;
    }

    public void setOnay(boolean onay) {
        isOnay = onay;
    }

    public boolean isDurum() {
        return isDurum;
    }

    public void setDurum(boolean durum) {
        isDurum = durum;
    }

    public Integer getmPuan() {
        return mPuan;
    }

    public void setmPuan(Integer mPuan) {
        this.mPuan = mPuan;
    }

    public Integer getSinavPuan() {
        return sinavPuan;
    }

    public void setSinavPuan(Integer sinavPuan) {
        this.sinavPuan = sinavPuan;
    }

    public String getIpAdresi() {
        return ipAdresi;
    }

    public void setIpAdresi(String ipAdresi) {
        this.ipAdresi = ipAdresi;
    }

   public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    
     public Sinav getSinav() {
        return sinav;
    }
    public void setSinav(Sinav sinav) {
		this.sinav = sinav;
	}

  
	public Set<MulakatCevaplari> getMulakatcevaplari() {
		return mulakatcevaplari;
	}

	public void setMulakatcevaplari(Set<MulakatCevaplari> mulakatcevaplari) {
		this.mulakatcevaplari = mulakatcevaplari;
	}

	public SinavSonuc getSinavsonuc() {
		return sinavsonuc;
	}

	public void setSinavsonuc(SinavSonuc sinavsonuc) {
		this.sinavsonuc = sinavsonuc;
	}

	

    
    
}
