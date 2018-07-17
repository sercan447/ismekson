package com.ismek.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismek.model.Role;




@RestController
@RequestMapping("/api/v1/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/")
	public ResponseEntity<List<Role>> list(){
		
		return ResponseEntity.ok(roleService.list());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Role> get(@PathVariable("id") long id){
		
		Role role = roleService.get(id);
		return ResponseEntity.ok().body(role);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")long id)
	{
		roleService.delete(id);
		return ResponseEntity.ok().body("Silme iþlemi Gerçekleþtirildi.");
	}
	
	/*sýnýf ýcerýsýndeki KullanýcýToRole Sýnýfýna veri göndermek zorunda degilsin*/
	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody Role role)
	{
		roleService.save(role);
		return ResponseEntity.ok().body("Ekleme islemi tamam");
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id ,@RequestBody Role role)
	{
		roleService.update(id, role);
		return ResponseEntity.ok().body("Güncelleme islemi gerceklestirilmistir");
	}
	
}