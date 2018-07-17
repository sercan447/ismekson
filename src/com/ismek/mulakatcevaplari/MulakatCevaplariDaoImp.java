package com.ismek.mulakatcevaplari;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.MulakatCevaplari;



@Repository
@Transactional
public class MulakatCevaplariDaoImp implements MulakatCevaplariDao{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public long save(MulakatCevaplari mulakatCevaplari) {
		sessionfactory.getCurrentSession().save(mulakatCevaplari);
		return mulakatCevaplari.getmCevapId();
	}

	@Override
	public MulakatCevaplari get(long id) {
		
		return sessionfactory.getCurrentSession().get(MulakatCevaplari.class, id);
	}

	@Override
	public List<MulakatCevaplari> list() {
		Session session = sessionfactory.getCurrentSession();
		Criteria cr = session.createCriteria(MulakatCevaplari.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<MulakatCevaplari> mulakatcevaplarilist = cr.list();
		return mulakatcevaplarilist;
	}

	@Override
	public void update(long id, MulakatCevaplari Update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
