package com.ismek.Role;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.Role;

@Repository
@Transactional
public class RoleDaoImp implements RoleDao{


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Role role) {
		sessionFactory.getCurrentSession().save(role);
		return role.getRoleId();
	}

	@Override
	public Role get(long id) {
		return sessionFactory.getCurrentSession().get(Role.class, id);
	}

	@Override
	public List<Role> list() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Role.class);
		List<Role> rolelist = cr.list();
		return rolelist;
	}

	@Override
	public void update(long id, Role Update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.load(Role.class, id);
		
		session.delete(role);
		session.flush();
	}
	
	
	
}
