package com.ismek.kullanicitosinav;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.KullaniciToSinav;


@Repository
@Transactional
public class KullaniciToSinavDaoImp  implements KullaniciToSinavDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public long save(KullaniciToSinav kullanicitosinav) {
		sessionfactory.getCurrentSession().save(kullanicitosinav);
		return kullanicitosinav.getKtsId();
	}

	@Override
	public KullaniciToSinav get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<KullaniciToSinav> list() {
		Session session = sessionfactory.getCurrentSession();
		Criteria cr = session.createCriteria(KullaniciToSinav.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<KullaniciToSinav> kullanicitosinavlist = cr.list();
		return kullanicitosinavlist;
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
