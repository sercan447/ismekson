package com.ismek.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tbl_SoruAnaliz")
public class SoruAnaliz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analiz_id")
    private long analizId;
    @Column(name = "dogru_sayisi")
    private Integer dogruSayisi;
    @Column(name = "yanlis_sayisi")
    private Integer yanlisSayisi;
    @Column(name = "bos_sayisi")
    private Integer bosSayisi;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="soru_id")
    //@JsonIgnore
    private Sorular soru;
    
    
    public long getAnalizId() {
        return analizId;
    }

    public void setAnalizId(long analizId) {
        this.analizId = analizId;
    }

    public Integer getDogruSayisi() {
        return dogruSayisi;
    }

    public void setDogruSayisi(Integer dogruSayisi) {
        this.dogruSayisi = dogruSayisi;
    }

    public Integer getYanlisSayisi() {
        return yanlisSayisi;
    }

    public void setYanlisSayisi(Integer yanlisSayisi) {
        this.yanlisSayisi = yanlisSayisi;
    }

    public Integer getBosSayisi() {
        return bosSayisi;
    }

    public void setBosSayisi(Integer bosSayisi) {
        this.bosSayisi = bosSayisi;
    }

	public Sorular getSoru() {
		return soru;
	}

	public void setSoru(Sorular soru) {
		this.soru = soru;
	}
    
    
}
