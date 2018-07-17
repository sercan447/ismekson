package com.ismek.mulakatcevaplari;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ismek.model.MulakatCevaplari;



public interface MulakatCevaplariService {

	long save(MulakatCevaplari mulakat);
	MulakatCevaplari get(long id);
    List<MulakatCevaplari> list();
    void update(long id, MulakatCevaplari Update);
    void delete(long id);
}
