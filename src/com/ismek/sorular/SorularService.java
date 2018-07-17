package com.ismek.sorular;

import java.util.List;

import com.ismek.model.Sorular;

public interface SorularService {
	
    long save(Sorular sorular);
    Sorular get(long id);
    List<Sorular> list();
    void update(long id, Sorular sorular);
    void delete(long id);
}
