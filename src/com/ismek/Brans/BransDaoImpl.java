package com.ismek.Brans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.Brans;
import com.ismek.model.Kullanici;
import com.ismek.model.Sorular;



@Repository
@Transactional
public class BransDaoImpl implements BransDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Brans brans) {
		sessionFactory.getCurrentSession().save(brans);
        return brans.getBransId();
	}

	@Override
	public Brans get(long id) {
		 return sessionFactory.getCurrentSession().get(Brans.class,id);
	}

	@Override
	public List<Brans> listBrans() {
		Session session =sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Brans> cq = cb.createQuery(Brans.class);
        Root<Brans> root = cq.from(Brans.class);
        cq.select(root);
        Query<Brans> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Brans brans) {
		Session session = sessionFactory.getCurrentSession();
		Brans brans2 = session.byId(Brans.class).load(id);
		brans2.setBransAdi(brans.getBransAdi());
		brans2.setKontenjan(brans.getKontenjan());
		//brans2.setKullanicilar(brans.getKullanicilar());
		brans2.setSorulars(brans.getSorulars());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Brans brans = session.byId(Brans.class).load(id);
		session.delete(brans);
	}

	@Override
	public void addKullaniciToBrans(long kullaniciId, long bransId) {
		Session session = sessionFactory.getCurrentSession();
		Brans brans = session.byId(Brans.class).load(bransId);
		Kullanici kullanici = session.byId(Kullanici.class).load(kullaniciId);
		//brans.getKullanicilar().add(kullanici);
		//kullanici.getBranslar().add(brans);
	}

	@Override
	public void addSoruToBrans(long soruId, long bransId) {
		Session session = sessionFactory.getCurrentSession();
		Brans brans = session.byId(Brans.class).load(bransId);
		Sorular soru = session.byId(Sorular.class).load(soruId);
		brans.getSorulars().add(soru);
		//soru.getBranslar().add(brans);
		
	}

	@Override
	public List<Sorular> getSorularByBransId(long id) {
		Brans brans = sessionFactory.getCurrentSession().byId(Brans.class).load(id);
		List<Sorular> sorular = new ArrayList<Sorular>(brans.getSorulars());
		return sorular;
	}

	@Override
	public List<Kullanici> getKullanicilarByBransId(long id) {
		Brans brans = sessionFactory.getCurrentSession().byId(Brans.class).load(id);
		//List<Kullanici> kullanicilar = new ArrayList<Sorular>(brans.getSorulars());
		return null;
	}
	
	
}
