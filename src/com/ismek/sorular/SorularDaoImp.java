package com.ismek.sorular;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.Sorular;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class SorularDaoImp implements SorularDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Sorular sorular) {
        sessionFactory.getCurrentSession().save(sorular);
        return sorular.getSoruId();
    }

    @Override
    public Sorular get(long id) {
        return sessionFactory.getCurrentSession().get(Sorular.class,id);
    }

    @Override
    public List<Sorular> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Sorular> cq = cb.createQuery(Sorular.class);
        Root<Sorular> root = cq.from(Sorular.class);
        cq.select(root);
        Query<Sorular> query = session.createQuery(cq);
        return query.getResultList();
        
    	
    	/*Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Sorular.class);
		List<Sorular> sorularlist = cr.list();
		return sorularlist;
		*/
    }

    @Override
    public void update(long id, Sorular sorular) {
        Session session = sessionFactory.getCurrentSession();
        Sorular sorular2 = session.byId(Sorular.class).load(id);
        sorular2.setSoru(sorular.getSoru());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        Sorular sorular = session.byId(Sorular.class).load(id);
        session.delete(sorular);
    }
}
