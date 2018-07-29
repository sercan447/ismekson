package com.ismek.kullanicitosinav;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.Kullanici;
import com.ismek.model.KullaniciToSinav;
import com.ismek.model.Sinav;


@Repository
@Transactional
public class KullaniciToSinavDaoImp  implements KullaniciToSinavDao{
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public long save(KullaniciToSinav kullanicitosinav) {
		sessionfactory.getCurrentSession().saveOrUpdate(kullanicitosinav);
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

	@Override
	public List<KullaniciToSinav> getByKullanici(long id) {
		Session session = sessionfactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<KullaniciToSinav> cq = cb.createQuery(KullaniciToSinav.class);
        Root<KullaniciToSinav> root = cq.from(KullaniciToSinav.class);
        cq.select(root).where(cb.and(
        	    cb.equal(root.get("kullanici"), id),
        	    cb.equal(root.get("isDurum"), 0)));
        
        Query<KullaniciToSinav> query = session.createQuery(cq).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
        return query.list();
	}

}
