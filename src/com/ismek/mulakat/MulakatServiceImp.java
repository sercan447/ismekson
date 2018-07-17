package com.ismek.mulakat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismek.model.Mulakat;
@Service
public class MulakatServiceImp implements MulakatService {

	@Autowired
	private MulakatDao mulakatDao;
	
	@Override
	public long save(Mulakat mulakar) {
		
		return mulakatDao.save(mulakar);
	}

	@Override
	public Mulakat get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mulakat> list() {
	
		return mulakatDao.list();
	}

	@Override
	public void update(long id, Mulakat Update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
