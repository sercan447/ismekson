package com.ismek.Brans;

import java.util.List;
import java.util.Set;

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

import com.ismek.model.Brans;
import com.ismek.model.Sorular;

@RestController
@RequestMapping("/api/v1/brans")
public class BransController {
	
	@Autowired
	private BransService bransService;
	
	// Yeni Brans ekle
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Brans brans){
		long id = bransService.save(brans);
		return ResponseEntity.ok().body("Yeni branÅŸ eklendi... "+ id);
	}
	
	// istenen id'li brans getir
	@GetMapping("/get/{id}")
	public ResponseEntity<Brans> get(@PathVariable("id") long id){
		Brans brans = bransService.get(id);
		return ResponseEntity.ok().body(brans);
	}
	
	// Butun branslari getir
	@GetMapping("/getAll")
	public ResponseEntity<List<Brans>> getAll(){
		List<Brans> branslar = bransService.listBrans();
		return ResponseEntity.ok().body(branslar);
	}
	
	// istenen id'li bransi guncelle
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Brans brans){
		bransService.update(id, brans);
		return ResponseEntity.ok().body("[" + id + "] li brans guncellendi...");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		bransService.delete(id);
		return ResponseEntity.ok().body("[" + id + "] li brans silindi...");
	}
	
	//istenen id'li bransýn sorularini getir
	@GetMapping("/findSorularByBransId/{id}")
	public ResponseEntity<List<Sorular>> findSorularByBransId(@PathVariable("id") long id){
		
		return ResponseEntity.ok().body(bransService.getSorularByBransId(id));
	}
}
