package com.ismek.sinavsonuc;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.SinavSonuc;
import com.ismek.model.Sinav;

@Repository
@Transactional
public class SinavSonucDaoImp implements SinavSonucDao{

	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(SinavSonuc sinavSonuc) {
		sessionFactory.getCurrentSession().save(sinavSonuc);
		return sinavSonuc.getsSonucId();
	}

	@Override
	public SinavSonuc get(long id) {
		return sessionFactory.getCurrentSession().get(SinavSonuc.class,id);
	}

	@Override
	public List<SinavSonuc> list() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(SinavSonuc.class);
		List<SinavSonuc> sinavsonuclist = cr.list();
		return sinavsonuclist;
	}

	@Override
	public void update(long id, SinavSonuc Update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		SinavSonuc sinavsonuc = session.load(SinavSonuc.class, id);
		
		session.delete(sinavsonuc);
		session.flush();
		
	}
	
}
