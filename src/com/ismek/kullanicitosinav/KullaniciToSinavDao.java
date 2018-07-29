package com.ismek.kullanicitosinav;

import java.util.List;


import com.ismek.model.KullaniciToSinav;
import com.ismek.model.Sinav;

public interface KullaniciToSinavDao {
	
	
	long save(KullaniciToSinav kullanicitosinav);

	KullaniciToSinav get(long id);

    List<KullaniciToSinav> list();

    void update(long id, KullaniciToSinav kullanicitosinav);

    void delete(long id);
    
    List<KullaniciToSinav> getByName(String name);
    
    List<KullaniciToSinav> getByKullanici(long id);

    
}
