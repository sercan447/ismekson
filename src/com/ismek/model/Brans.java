package com.ismek.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tbl_Brans")
public class Brans implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="brans_id")
    private long bransId;
    
 
    @Column(name="brans_adi")
   // @Size(max =60 ,message = "2 arası 25 karakterden fazla giremezsiniz ")
    private String bransAdi;

    @Column(name="kontenjan")
    private Integer kontenjan;
        
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_BransToSorular", joinColumns = @JoinColumn(name = "brans_id"),inverseJoinColumns = @JoinColumn(name = "soru_id"))
    @JsonIgnore
    private Set<Sorular> sorulars;
    
//    @ManyToMany(fetch = FetchType.EAGER,mappedBy="branslar")
//    private List<Kullanici> kullanicilar;
    
    @OneToMany(mappedBy="brans")
    @JsonIgnore
    private List<Sinav> sinav = new ArrayList<Sinav>();

    public Brans() {}
    
    
    
//    
//    public List<Kullanici> getKullanicilar() {
//		return kullanicilar;
//	}
//
//
//
//
//	public void setKullanicilar(List<Kullanici> kullanicilar) {
//		this.kullanicilar = kullanicilar;
//	}




	public long getBransId() {
        return bransId;
    }

    public void setBransId(long bransId) {
        this.bransId = bransId;
    }

    public String getBransAdi() {
        return bransAdi;
    }

    public void setBransAdi(String bransAdi) {
        this.bransAdi = bransAdi;
    }

    public Integer getKontenjan() {
        return kontenjan;
    }

    public void setKontenjan(Integer kontenjan) {
        this.kontenjan = kontenjan;
    }


	public Set<Sorular> getSorulars() {
        return sorulars;
    }

    public void setSorulars(Set<Sorular> sorulars) {
        this.sorulars = sorulars;
    }

	public List<Sinav> getSinav() {
		return sinav;
	}

	public void setSinav(List<Sinav> sinav) {
		this.sinav = sinav;
	}

	


	
	
    
    
}
