package com.ismek.Brans;

import java.util.List;

import com.ismek.model.Brans;
import com.ismek.model.Kullanici;
import com.ismek.model.Sorular;

public interface BransService {

    long save(Brans brans);

    Brans get(long id);

    List<Brans> listBrans();

    void update(long id, Brans brans);

    void delete(long id);
    
    void addKullaniciToBrans(long kullaniciId, long bransId);
    
    void addSoruToBrans(long soruId, long bransId);
    
    List<Sorular> getSorularByBransId(long id);
    
    List<Kullanici> getKullanicilarByBransId(long id);
}
