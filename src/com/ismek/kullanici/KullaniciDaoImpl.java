package com.ismek.kullanici;

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
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.Kullanici;


@Repository
@Transactional
@EnableTransactionManagement
public class KullaniciDaoImpl implements KullaniciDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Kullanici kullanici) {
		sessionFactory.getCurrentSession().save(kullanici);
        return kullanici.getKullaniciId();
	}

	@Override
	public Kullanici get(long id) {
		return sessionFactory.getCurrentSession().get(Kullanici.class,id);
	}

	@Override
	public List<Kullanici> listKullanici() {
		Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Kullanici> cq = cb.createQuery(Kullanici.class);
        Root<Kullanici> root = cq.from(Kullanici.class);
        cq.select(root);
        Query<Kullanici> query = session.createQuery(cq).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
        return query.list();
       // return session.createCriteria(Kullanici.class).list();
		
		
		
		
	}

	@Override
	public void update(long id, Kullanici kullanici) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Kullanici> getByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Kullanici> fQuery = session.createNamedQuery("Kullanici.findByName",Kullanici.class);
		fQuery.setParameter("adi", name);
		List<Kullanici> listKullanici = fQuery.getResultList();
		
		return listKullanici;
	}

	@Override
	public Kullanici login(String tcNo, String telefon) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<Kullanici> sorgu =  session.createNamedQuery("Kullanici.findByLogin",Kullanici.class);
		sorgu.setParameter("tcNo",tcNo);	
		sorgu.setParameter("telefon", telefon);
		
		Kullanici kullanici = sorgu.getSingleResult();
		return kullanici;
	}

}
