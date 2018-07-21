package com.ismek.sinavsonuc;

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

import com.ismek.model.SinavSonuc;
import com.ismek.model.Sinav;

@RestController
@RequestMapping("/api/v1/sinavsonuc")
public class SinavSonucController {
	
	
	@Autowired
	private SinavSonucService sinavSonucService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<SinavSonuc>> list(){
		
		return ResponseEntity.ok(sinavSonucService.list());
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<SinavSonuc> get(@PathVariable("id") long id){
		
		SinavSonuc sinavsonuc = sinavSonucService.get(id);
		return ResponseEntity.ok().body(sinavsonuc);
	}

	@PostMapping("/save")
	public ResponseEntity<?> create(@RequestBody SinavSonuc sinavsonuc)
	{
		sinavSonucService.save(sinavsonuc);
		return ResponseEntity.ok().body("Ekleme islemi tamam");
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id ,@RequestBody SinavSonuc sinavsonuc)
	{
		sinavSonucService.update(id, sinavsonuc);
		return ResponseEntity.ok().body("Güncelleme islemi gerceklestirilmistir");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")long id){
		sinavSonucService.delete(id);
		return ResponseEntity.ok().body("Silinme iþlei gerçekleþtirildi.");
	}
	
	
	
}
