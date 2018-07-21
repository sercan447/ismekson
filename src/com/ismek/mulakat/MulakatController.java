package com.ismek.mulakat;

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

import com.ismek.model.Mulakat;



@RestController
@RequestMapping("/api/v1/mulakat")
public class MulakatController {

	
	@Autowired
	private MulakatService mulakatservice;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Mulakat>> list(){
		
		return ResponseEntity.ok(mulakatservice.list());
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Mulakat> get(@PathVariable("id") long id){
		
		Mulakat mulakat = mulakatservice.get(id);
		return ResponseEntity.ok().body(mulakat);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> create(@RequestBody Mulakat mulakat)
	{
		mulakatservice.save(mulakat);
		return ResponseEntity.ok().body("Ekleme islemi tamam");
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id ,@RequestBody Mulakat mulakat)
	{
		mulakatservice.update(id, mulakat);
		return ResponseEntity.ok().body("Güncelleme islemi gerceklestirilmistir");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")long id){
		mulakatservice.delete(id);
		return ResponseEntity.ok().body("Silinme iþlei gerçekleþtirildi.");
	}
	
}
