package com.ismek.Role;

import java.util.List;

import com.ismek.model.Role;

public interface RoleService {
	
	long save(Role Role);
    Role get(long id);
    List<Role> list();
    void update(long id, Role Update);
    void delete(long id);

}
