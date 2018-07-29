package com.ismek.sinav;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ismek.Brans.BransService;
import com.ismek.kullanici.KullaniciService;
import com.ismek.model.Sinav;
import com.ismek.model.Sorular;


@RestController
@RequestMapping("/api/v1/sinav")
public class SinavController {

	@Autowired
	private SinavService sinavservice;
	@Autowired
	private BransService bransService;
	@Autowired
	private KullaniciService kullaniciService;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Sinav>> list(){
		
		return ResponseEntity.ok(sinavservice.list());
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Sinav> get(@PathVariable("id") long id){
		
		Sinav sinav = sinavservice.get(id);
		return ResponseEntity.ok().body(sinav);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> create(@RequestBody Sinav sinav)
	{
		sinavservice.save(sinav);
		return ResponseEntity.ok().body("Ekleme islemi tamam");
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id ,@RequestBody Sinav sinav)
	{
		sinavservice.update(id, sinav);
		return ResponseEntity.ok().body("Güncelleme islemi gerceklestirilmistir");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")long id){
			sinavservice.delete(id);
		return ResponseEntity.ok().body("Silinme iþlei gerçekleþtirildi.");
	}
	
	@GetMapping("/findSorularBySinavId/{id}")
	public ResponseEntity<List<Sorular>> findSorularBySinavId(@PathVariable("id") long id){
		
		 
		return ResponseEntity.ok().body(sinavservice.getSorularBySinavId(id));
	}
	
	/*
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> HataHandle(Exception e) {
		
		return new ResponseEntity<Object>("HATA ALDIK "+e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
	}
	*/
}
