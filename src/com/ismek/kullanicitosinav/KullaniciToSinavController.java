package com.ismek.kullanicitosinav;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/")
	public ResponseEntity<List<KullaniciToSinav>> list(){
		
		return ResponseEntity.ok(kullaniciToservice.list());
	}
	
	@PostMapping("/")
	public ResponseEntity<?> create(@RequestBody KullaniciToSinav kullaniciToSinav){
		
		try {
		
			kullaniciToservice.save(kullaniciToSinav);
		
		}catch(Exception e)
		{
			return ResponseEntity.ok().body("Eklenme iþleminde hata oluþtu. : "+e.toString());
		}
		
		return ResponseEntity.ok().body("Basariyla eklendi");
	}
}
