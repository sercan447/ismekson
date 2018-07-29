package com.ismek.kullanici;

import java.util.List;

import com.ismek.model.Kullanici;
import com.ismek.model.Sinav;

public interface KullaniciService {


	long save(Kullanici kullanici);

    Kullanici get(long id);

    List<Kullanici> listKullanici();

    void update(long id, Kullanici kullanici);

    void delete(long id);
    
    Kullanici login(String tcNo,String telefon);
	
    
}
