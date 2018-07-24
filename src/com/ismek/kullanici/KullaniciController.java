package com.ismek.kullanici;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ismek.model.Kullanici;
import com.ismek.model.Role;


@RestController
@RequestMapping("/api/v1/kullanici")
public class KullaniciController {

	@Autowired
	private KullaniciService kullaniciService;
	
	// Yeni Brans ekle
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Kullanici kullanici){
		long id = kullaniciService.save(kullanici);
		return ResponseEntity.ok().body("Yeni kullanici eklendi... "+ id);
	}
	
	// İstenen id'li kullanici'ı getir
	
	@GetMapping("/get/{id}")	
	public ResponseEntity<Kullanici> get(@PathVariable("id") long id){
		Kullanici kullanici = kullaniciService.get(id);
		return ResponseEntity.ok().body(kullanici);
	}
	
	// Bütün kullaniciı getir
	@GetMapping("/getAll")
	public ResponseEntity<List<Kullanici>> getAll(){
		List<Kullanici> kullanicilar = kullaniciService.listKullanici();
		return ResponseEntity.ok().body(kullanicilar);
	}
	
	// İstenen id'li kullanici'ı güncelle
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Kullanici kullanici){
		kullaniciService.update(id, kullanici);
		return ResponseEntity.ok().body("[" + id + "] li kullanici guncellendi...");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		kullaniciService.delete(id);
		return ResponseEntity.ok().body("[" + id + "] li kullanici silindi...");
	}
	
	/*
	@GetMapping("/{mail}/{tcno}")
	public ResponseEntity<?> logintwo(@PathVariable("tcno")String mail,@PathVariable("telefon")String tcno){
		
		Kullanici kullanici = kullaniciService.login(mail, tcno);
		if(kullanici != null)
		{
			return ResponseEntity.ok().body(kullanici);
		}
			return ResponseEntity.ok().body(kullanici);
			
	}
	*/
	
	@GetMapping("/login/{tcNo}/{telefon}")
	public ResponseEntity<?> login(@PathVariable("tcNo")String tcno,@PathVariable("telefon")String telefon){
		
		Kullanici kullanici = kullaniciService.login(tcno, telefon);
		if(kullanici != null) {
		Set<GrantedAuthority> grand = new HashSet<>();
	
			for(Role role : kullanici.getRoles()) {
				grand.add(new SimpleGrantedAuthority(role.getRoles()));
			}
	
		return ResponseEntity.ok().body(new User(kullanici.getTcNo(),kullanici.getTelefon(),grand));	
		}		
			return ResponseEntity.ok().body(kullanici);
		
	}
	
}
