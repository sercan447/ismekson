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

import com.ismek.model.BaseReturn;
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
		BaseReturn<String> br = new BaseReturn();

		try {
			
			kullaniciToservice.save(kullaniciToSinav);
			br.setCode("0000");
			br.setMessage("Kullanýcý cevabý baþarýlý ile eklendi...");
			br.setData(null);
		}catch(Exception e)
		{
			br.setCode("0001");
			br.setMessage("Kullanýcý cevabý ekleme iþleminde hata oluþtu....");
			br.setData(null);
			return ResponseEntity.ok().body(br);
		}
		
		return ResponseEntity.ok().body(br);
	}
	
	@GetMapping("/findSinavListByKullaniciId/{kullaniciId}")
	public ResponseEntity<List<KullaniciToSinav>> findSinavListByKullaniciId(@PathVariable("kullaniciId")long kullaniciId ){
		
		return ResponseEntity.ok().body(kullaniciToservice.getByKullanici(kullaniciId));
	}
}

