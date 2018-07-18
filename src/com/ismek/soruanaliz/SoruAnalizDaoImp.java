package com.ismek.soruanaliz;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.SoruAnaliz;

import java.util.List;

@Repository
@Transactional
public class SoruAnalizDaoImp implements SoruAnalizDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(SoruAnaliz soruAnaliz) {
        sessionFactory.getCurrentSession().save(soruAnaliz);
        return soruAnaliz.getAnalizId();
    }

    @Override
    public SoruAnaliz get(long id) {
        return sessionFactory.getCurrentSession().get(SoruAnaliz.class,id);
    }

    @Override
    public List<SoruAnaliz> list() {
        Session session =sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<SoruAnaliz> cq = cb.createQuery(SoruAnaliz.class);
        Root<SoruAnaliz> root = cq.from(SoruAnaliz.class);
        cq.select(root);
        Query<SoruAnaliz> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(long id, SoruAnaliz soruAnaliz) {
        Session session = sessionFactory.getCurrentSession();
        SoruAnaliz soruAnaliz2 = session.byId(SoruAnaliz.class).load(id);
        soruAnaliz2.setBosSayisi(soruAnaliz.getBosSayisi());
        soruAnaliz2.setDogruSayisi(soruAnaliz.getDogruSayisi());
       // soruAnaliz2.setSoruId(soruAnaliz.getSoruId());
        //soruAnaliz2.setYanlisSayisi(soruAnaliz.getSoruId());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = sessionFactory.getCurrentSession();
        SoruAnaliz soruAnaliz = session.byId(SoruAnaliz.class).load(id);
        session.delete(soruAnaliz);
    }
}
