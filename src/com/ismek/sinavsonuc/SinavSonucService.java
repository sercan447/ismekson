package com.ismek.sinavsonuc;

import java.util.List;

import com.ismek.model.SinavSonuc;

public interface SinavSonucService {
	long save(SinavSonuc sinavSonuc);
	SinavSonuc get(long id);
    List<SinavSonuc> list();
    void update(long id, SinavSonuc Update);
    void delete(long id);
}
