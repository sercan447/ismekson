package com.ismek.kullanicitosinav;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismek.model.KullaniciToSinav;
import com.ismek.model.Sinav;

@RestController
@RequestMapping("/api/v1/kullanicitosinav")
public class KullaniciToSinavController {

	@Autowired
	private KullaniciToSinavService kullaniciToservice;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<KullaniciToSinav>> list(){
		
		return ResponseEntity.ok(kullaniciToservice.list());
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> create(@RequestBody KullaniciToSinav kullaniciToSinav){
		
		try {
		
			kullaniciToservice.save(kullaniciToSinav);
		
		}catch(Exception e)
		{
			return ResponseEntity.ok().body("Eklenme iþleminde hata oluþtu. : "+e.toString());
		}
		
		return ResponseEntity.ok().body("Basariyla eklendi");
	}
	
	@GetMapping("/findSinavListByKullaniciId/{kullaniciId}")
	public ResponseEntity<List<KullaniciToSinav>> findSinavListByKullaniciId(@PathVariable("kullaniciId")long kullaniciId ){
		
		return ResponseEntity.ok().body(kullaniciToservice.getByKullanici(kullaniciId));
	}
}

