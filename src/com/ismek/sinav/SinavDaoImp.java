package com.ismek.sinav;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.Kullanici;
import com.ismek.model.KullaniciToSinav;
import com.ismek.model.Sinav;
import com.ismek.model.Sorular;

@Repository
@Transactional
public class SinavDaoImp implements SinavDao{

	
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public long save(Sinav sinav) {
	sessionfactory.getCurrentSession().save(sinav);
		return sinav.getSinavId();
	}

	@Override
	public Sinav get(long id) {
		
		return sessionfactory.getCurrentSession().get(Sinav.class,id);
	}

	@Override
	public List<Sinav> list() {
		
			/*Session session = sessionfactory.getCurrentSession();
			Criteria cr = session.createCriteria(Sinav.class);
			List<Sinav> sinavlist = cr.list();
			return sinavlist;*/
		
		Session session = sessionfactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Sinav> cq = cb.createQuery(Sinav.class);
        Root<Sinav> root = cq.from(Sinav.class);
        cq.select(root);
        Query<Sinav> query = session.createQuery(cq);
		
        return query.list();
	}

	@Override
	public void update(long id, Sinav update) {
		
		Session session = sessionfactory.getCurrentSession();
		Sinav sinav2 = session.load(Sinav.class, id);
		
		try {

		sinav2.setAktif(update.isAktif());
		sinav2.setBrans(update.getBrans());
		sinav2.setBsSaati(update.getBsSaati());
		sinav2.setKatkiYuzdesi(update.getKatkiYuzdesi());
		sinav2.setOgretmenId(update.getOgretmenId());
		sinav2.setOlusturmaTarihi(update.getOlusturmaTarihi());
		sinav2.setSinavKodu(update.getSinavKodu());
		sinav2.setSinavSalonu(update.getSinavSalonu());
		sinav2.setSinavSuresi(update.getSinavSuresi());
		sinav2.setSinavTarihi(update.getSinavTarihi());
		sinav2.setSorulars(update.getSorulars());
		sinav2.setSoruSayisi(update.getSoruSayisi());
		
		
		}catch(Exception e) {
			
		}finally {
			session.flush();
		}
		
		
	}

	@Override
	public void delete(long id) {
		Session session = sessionfactory.getCurrentSession();
		Sinav sinav = session.load(Sinav.class, id);
		
		session.delete(sinav);
		session.flush();
	}

	@Override
	public List<Sorular> getSorularBySinavId(long id) {
	
		Sinav sinav = sessionfactory.getCurrentSession().get(Sinav.class,id);
		
		List<Sorular> sor = new ArrayList<Sorular>(sinav.getSorulars());

		Collections.sort(sor, new Comparator<Sorular>() {

		        public int compare(Sorular o1, Sorular o2) {
		        	if (o1.getSoruId() > o2.getSoruId()) {
						return 1;
					}else if (o1.getSoruId() < o2.getSoruId()) {
						return -1;
					}else if (o1.getSoruId() == o2.getSoruId()) {
						return 0;
					}
		            return 0;
		        }
		    });
		
        return sor;
	}

}
