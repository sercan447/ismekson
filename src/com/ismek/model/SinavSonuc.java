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
    private int dSayisi;

    @Column(name="y_sayisi",nullable=false)
    private int ySayisi;

    @Column(name="bos_sayisi",nullable=false)
    private int bosSayisi;

    @Column(name="son_puan",nullable=false)
    private int sonPuan;

    @OneToOne
    @JoinColumn(name="kts_id",unique=true)
    private KullaniciToSinav ktsId;

    public long getsSonucId() {
        return sSonucId;
    }

    public void setsSonucId(long sSonucId) {
        this.sSonucId = sSonucId;
    }

    public int getdSayisi() {
        return dSayisi;
    }

    public void setdSayisi(int dSayisi) {
        this.dSayisi = dSayisi;
    }

    public int getySayisi() {
        return ySayisi;
    }

    public void setySayisi(int ySayisi) {
        this.ySayisi = ySayisi;
    }

    public int getBosSayisi() {
        return bosSayisi;
    }

    public void setBosSayisi(int bosSayisi) {
        this.bosSayisi = bosSayisi;
    }

    public int getSonPuan() {
        return sonPuan;
    }

    public void setSonPuan(int sonPuan) {
        this.sonPuan = sonPuan;
    }

    public KullaniciToSinav getKtsId() {
        return ktsId;
    }

    public void setKtsId(KullaniciToSinav ktsId) {
        this.ktsId = ktsId;
    }
}
