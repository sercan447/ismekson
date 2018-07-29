package com.ismek.sinav;

import java.util.List;

import com.ismek.model.Sinav;
import com.ismek.model.Sorular;

public interface SinavService {
	
	long save(Sinav sinav);
    Sinav get(long id);
    List<Sinav> list();
    void update(long id, Sinav sinavUpdate);
    void delete(long id);
    List<Sorular> getSorularBySinavId(long id);
    
}
