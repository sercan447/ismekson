package com.ismek.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismek.model.Role;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public long save(Role role) {
		
		return roleDao.save(role);
	}

	@Override
	public Role get(long id) {
		
		return roleDao.get(id);
	}

	@Override
	public List<Role> list() {
	
		return roleDao.list();
	}

	@Override
	public void update(long id, Role update) {
		roleDao.update(id, update);
		
	}

	@Override
	public void delete(long id) {
		roleDao.delete(id);
		
	}

}
