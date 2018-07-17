package com.ismek.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tbl_SoruAnaliz")
public class SoruAnaliz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analiz_id")
    private int analizId;
    @Column(name = "dogru_sayisi")
    private int dogruSayisi;
    @Column(name = "yanlis_sayisi")
    private int yanlisSayisi;
    @Column(name = "bos_sayisi")
    private int bosSayisi;
    @Column(name = "soru_id")
    private int soruId;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "soruanaliz")
    @JsonIgnore
    private Sorular soru;
    
    
    public int getAnalizId() {
        return analizId;
    }

    public void setAnalizId(int analizId) {
        this.analizId = analizId;
    }

    public int getDogruSayisi() {
        return dogruSayisi;
    }

    public void setDogruSayisi(int dogruSayisi) {
        this.dogruSayisi = dogruSayisi;
    }

    public int getYanlisSayisi() {
        return yanlisSayisi;
    }

    public void setYanlisSayisi(int yanlisSayisi) {
        this.yanlisSayisi = yanlisSayisi;
    }

    public int getBosSayisi() {
        return bosSayisi;
    }

    public void setBosSayisi(int bosSayisi) {
        this.bosSayisi = bosSayisi;
    }

    public int getSoruId() {
        return soruId;
    }

    public void setSoruId(int soruId) {
        this.soruId = soruId;
    }

	public Sorular getSoru() {
		return soru;
	}

	public void setSoru(Sorular soru) {
		this.soru = soru;
	}
    
    
}
