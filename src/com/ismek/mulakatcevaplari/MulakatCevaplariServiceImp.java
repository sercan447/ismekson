package com.ismek.mulakatcevaplari;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismek.model.MulakatCevaplari;

@Service
public class MulakatCevaplariServiceImp implements MulakatCevaplariService{

	
	@Autowired
	private MulakatCevaplariDao mulakatCevaplariDao;	
	
	
	@Override
	public long save(MulakatCevaplari mulakatCevaplari) {
		return mulakatCevaplariDao.save(mulakatCevaplari);
	}

	@Override
	public MulakatCevaplari get(long id) {
		
		return mulakatCevaplariDao.get(id);
	}

	@Override
	public List<MulakatCevaplari> list() {
		
		return mulakatCevaplariDao.list();
	}

	@Override
	public void update(long id, MulakatCevaplari Update) {
		mulakatCevaplariDao.update(id, Update);
		
	}

	@Override
	public void delete(long id) {
		mulakatCevaplariDao.delete(id);		
	}

}
