package com.ismek.sinavsonuc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismek.model.SinavSonuc;

@Service
public class SinavSonucServiceImp implements SinavSonucService {

	
	@Autowired
	private SinavSonucDao sinavSonucDao;

	@Override
	public long save(SinavSonuc sinavSonuc) {
		// TODO Auto-generated method stub
		return sinavSonucDao.save(sinavSonuc);
	}

	@Override
	public SinavSonuc get(long id) {
		
		return sinavSonucDao.get(id);
	}

	@Override
	public List<SinavSonuc> list() {
		
		return sinavSonucDao.list();
	}

	@Override
	public void update(long id, SinavSonuc Update) {
		sinavSonucDao.update(id,Update);
		
	}

	@Override
	public void delete(long id) {
		sinavSonucDao.delete(id);
		
	}
}
