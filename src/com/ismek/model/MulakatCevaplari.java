package com.ismek.model;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Entity
@Table(name="tbl_Mulakat_Cevaplari")
public class MulakatCevaplari implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="m_cevap_id")
    private long mCevapId;

    @Column(name="cevap")
    private String cevap;

   @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="kts_id")
    @JsonIgnore
    private KullaniciToSinav ktsId;
   

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="mulakat_id")
    //@JsonIgnore
    private Mulakat mulakat;
    


    public long getmCevapId() {
        return mCevapId;
    }

    public void setmCevapId(long mCevapId) {
        this.mCevapId = mCevapId;
    }

    public String getCevap() {
        return cevap;
    }

    public void setCevap(String cevap) {
        this.cevap = cevap;
    }

   
    public KullaniciToSinav getKtsId() {
        return ktsId;
    }

    public void setKtsId(KullaniciToSinav ktsId) {
        this.ktsId = ktsId;
    }

    public Mulakat getMulakat() {
        return mulakat;
    }

    public void setMulakat(Mulakat mulakat) {
        this.mulakat = mulakat;
    }
    
    
    
}
