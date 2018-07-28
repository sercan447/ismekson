package com.ismek.kullanici;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	// Ä°stenen id'li kullanici'Ä± getir
	
	@GetMapping("/get/{id}")	
	public ResponseEntity<Kullanici> get(@PathVariable("id") long id){
		Kullanici kullanici = kullaniciService.get(id);
		return ResponseEntity.ok().body(kullanici);
	}
	
	// BÃ¼tÃ¼n kullaniciÄ± getir
	@GetMapping("/getAll")
	public ResponseEntity<List<Kullanici>> getAll(){
		List<Kullanici> kullanicilar = kullaniciService.listKullanici();
		return ResponseEntity.ok().body(kullanicilar);
	}
	
	// Ä°stenen id'li kullanici'Ä± gÃ¼ncelle
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
	
	
	
	@GetMapping("/login/{tcno}/{telefon}")
	public ResponseEntity<?> logintwo(@PathVariable("tcno")String tcno,@PathVariable("telefon")String telefon){
		
		BaseReturn<Kullanici> bs = new BaseReturn<Kullanici>();
		
		Kullanici kullanici = kullaniciService.login(tcno, telefon);
		if(kullanici != null)
		{
			bs.setCode("0000");
			bs.setMessage("Kullanýcý iþlemi baþarýlý");
			bs.setData(kullanici);
			
			return ResponseEntity.ok().body(bs);
		}
		bs.setCode("0001");
		bs.setMessage("Kullanýcý adý veya þifreniz hatalýdýr.");
		bs.setData(null);
	
		return ResponseEntity.ok().body(bs);
			
	}
	
	
	/*@GetMapping("/login/{tcNo}/{telefon}")
	public ResponseEntity<?> login(@PathVariable("tcNo")String tcno,@PathVariable("telefon")String telefon){
		
		Kullanici kullanici = kullaniciService.login(tcno, telefon);
		if(kullanici != null) {
		Set<GrantedAuthority> grand = new HashSet<>();
	
			for(Role role : kullanici.getRoles()) {
				grand.add(new SimpleGrantedAuthority(role.getRoles()));
			}
	
		return ResponseEntity.ok().body(new User(kullanici.getTcNo(),kullanici.getTelefon(),grand));	
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bulunamadý. 2");	
		}		
			//return ResponseEntity.ok().body(kullanici);
		
	}
	*/
	
	
}
