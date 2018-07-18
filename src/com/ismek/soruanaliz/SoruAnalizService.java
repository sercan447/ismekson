package com.ismek.soruanaliz;

import java.util.List;

import com.ismek.model.SoruAnaliz;

public interface SoruAnalizService {

    long save(SoruAnaliz soruAnaliz);
    SoruAnaliz get(long id);
    List<SoruAnaliz> list();
    void update(long id, SoruAnaliz soruAnaliz);
    void delete(long id);
}

