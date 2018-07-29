package com.ismek.kullanici;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.Kullanici;
import com.ismek.model.Sinav;

@Service

public class KullaniciServiceImpl implements KullaniciService{

	@Autowired
	private KullaniciDao kullaniciDao;
	
	@Override
	public long save(Kullanici kullanici) {
		return kullaniciDao.save(kullanici);
	}

	@Override
	public Kullanici get(long id) {
		return kullaniciDao.get(id);
	}

	@Override
	public List<Kullanici> listKullanici() {
		return kullaniciDao.listKullanici();
	}

	@Override
	public void update(long id, Kullanici kullanici) {
		kullaniciDao.update(id, kullanici);
		
	}

	@Override
	public void delete(long id) {
		kullaniciDao.delete(id);
	}

	@Override
	public Kullanici login(String tcNo, String telefon) {
		
		return kullaniciDao.login(tcNo, telefon);
	}



}
