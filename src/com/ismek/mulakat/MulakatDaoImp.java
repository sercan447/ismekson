package com.ismek.mulakat;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.Mulakat;


@Repository
@Transactional
public class MulakatDaoImp  implements MulakatDao{

	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public long save(Mulakat mulakat) {
		sessionfactory.getCurrentSession().save(mulakat);
		return mulakat.getMulakatId();
	}

	@Override
	public Mulakat get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mulakat> list() {
		Session session = sessionfactory.getCurrentSession();
		Criteria cr = session.createCriteria(Mulakat.class);
		List<Mulakat> mulakatlist = cr.list();
		return mulakatlist;
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
