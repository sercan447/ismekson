package com.ismek.kullanicitosinav;

import java.util.List;

import com.ismek.model.KullaniciToSinav;

public interface KullaniciToSinavService {
	
	
	
	long save(KullaniciToSinav kullanicitosinav);

	KullaniciToSinav get(long id);

    List<KullaniciToSinav> list();

    void update(long id, KullaniciToSinav kullanicitosinav);

    void delete(long id);
    
    List<KullaniciToSinav> getByName(String name);

}
