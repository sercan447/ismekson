package com.ismek.sorular;

import java.util.List;

import com.ismek.model.Sorular;

public interface SorularDao {

    long save(Sorular sorular);
    Sorular get(long id);
    List<Sorular> list();
    void update(long id, Sorular soruAnaliz);
    void delete(long id);

}
