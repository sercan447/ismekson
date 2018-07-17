package com.ismek.kullanicitosinav;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismek.model.KullaniciToSinav;

@Service
public class KullaniciToSinavServiceImp implements KullaniciToSinavService {

	@Autowired
	private KullaniciToSinavDao kullaniciTosinav;
	
	@Override
	public long save(KullaniciToSinav kullanicitosinav) {
		
		return kullaniciTosinav.save(kullanicitosinav);
	}

	@Override
	public KullaniciToSinav get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KullaniciToSinav> list() {
		
		return kullaniciTosinav.list();
	}

	@Override
	public void update(long id, KullaniciToSinav kullanicitosinav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<KullaniciToSinav> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
