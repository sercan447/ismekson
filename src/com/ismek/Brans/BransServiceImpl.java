package com.ismek.Brans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.Brans;

@Service
@Transactional(readOnly=true)
public class BransServiceImpl implements BransService{

	@Autowired
	private BransDao bransDao;

	@Transactional
	@Override
	public long save(Brans brans) {
		return bransDao.save(brans);
	}

	@Override
	public Brans get(long id) {
		return bransDao.get(id);
	}

	@Override
	public List<Brans> listBrans() {
		return bransDao.listBrans();
	}

	@Transactional
	@Override
	public void update(long id, Brans brans) {
		bransDao.update(id, brans);
	}

	@Transactional
	@Override
	public void delete(long id) {
		bransDao.delete(id);
	}

	@Override
	public void addKullaniciToBrans(long kullaniciId, long bransId) {
		bransDao.addKullaniciToBrans(kullaniciId, bransId);
	}

	@Override
	public void addSoruToBrans(long soruId, long bransId) {
		bransDao.addSoruToBrans(soruId, bransId);
	}
	
	
	
}
