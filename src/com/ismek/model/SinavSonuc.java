package com.ismek.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tbl_Sinav_Sonuc")
public class SinavSonuc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="s_sonuc_id",nullable=false)
    private long sSonucId;

    @Column(name="d_sayisi",nullable=false)
    private Integer dSayisi;

    @Column(name="y_sayisi",nullable=false)
    private Integer ySayisi;

    @Column(name="bos_sayisi",nullable=false)
    private Integer bosSayisi;

    @Column(name="son_puan",nullable=false)
    private Integer sonPuan;

    @OneToOne
    @JoinColumn(name="kts_id",unique=true)
    private KullaniciToSinav kts;

    public long getsSonucId() {
        return sSonucId;
    }

    public void setsSonucId(long sSonucId) {
        this.sSonucId = sSonucId;
    }

    public Integer getdSayisi() {
        return dSayisi;
    }

    public void setdSayisi(Integer dSayisi) {
        this.dSayisi = dSayisi;
    }

    public Integer getySayisi() {
        return ySayisi;
    }

    public void setySayisi(Integer ySayisi) {
        this.ySayisi = ySayisi;
    }

    public Integer getBosSayisi() {
        return bosSayisi;
    }

    public void setBosSayisi(Integer bosSayisi) {
        this.bosSayisi = bosSayisi;
    }

    public Integer getSonPuan() {
        return sonPuan;
    }

    public void setSonPuan(Integer sonPuan) {
        this.sonPuan = sonPuan;
    }

    public KullaniciToSinav getKts() {
        return kts;
    }

    public void setKts(KullaniciToSinav kts) {
        this.kts = kts;
    }
}
