package com.ismek.mulakat;

import java.util.List;

import com.ismek.model.Mulakat;

public interface MulakatService {


	long save(Mulakat mulakar);
    Mulakat get(long id);
    List<Mulakat> list();
    void update(long id, Mulakat Update);
    void delete(long id);

}
