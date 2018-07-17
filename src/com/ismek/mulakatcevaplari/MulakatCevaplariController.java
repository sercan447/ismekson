package com.ismek.mulakatcevaplari;

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

import com.ismek.model.MulakatCevaplari;



@RestController
@RequestMapping("/api/v1/mulakatcevaplari")
public class MulakatCevaplariController {
	
	
	@Autowired
	private MulakatCevaplariService mulakatcevaplariservice;
	
	@GetMapping("/")
	public ResponseEntity<List<MulakatCevaplari>> list(){
		
		return ResponseEntity.ok(mulakatcevaplariservice.list());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<MulakatCevaplari> get(@PathVariable("id") long id){
		
			MulakatCevaplari mulakatcevaplari = mulakatcevaplariservice.get(id);
			return ResponseEntity.ok().body(mulakatcevaplari);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody MulakatCevaplari mulakatcevaplari)
	{
		mulakatcevaplariservice.save(mulakatcevaplari);
		return ResponseEntity.ok().body("Ekleme islemi tamam");
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id ,@RequestBody MulakatCevaplari mulakatcevaplari)
	{
		mulakatcevaplariservice.update(id, mulakatcevaplari);
		return ResponseEntity.ok().body("Güncelleme islemi gerceklestirilmistir");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")long id){
		mulakatcevaplariservice.delete(id);
		return ResponseEntity.ok().body("Silinme iþlei gerçekleþtirildi.");
	}
	
	

}
