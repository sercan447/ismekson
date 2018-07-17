package com.ismek.sorular;

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

import com.ismek.model.Sorular;

@RestController
@RequestMapping("/api/v1/sorular")
public class SorularController {
    @Autowired
    private SorularService sorularService;

    /*---Yeni Soru Analiz Ekle---*/
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Sorular sorular) {
        long id = sorularService.save(sorular);
        return ResponseEntity.ok().body("Yeni soru eklendi...  !" + id);
    }

    /*---Belirli bir tane Soru Analizi Don ---*/
    @GetMapping("/get/{id}")
    public ResponseEntity<Sorular> get(@PathVariable("id") long id) {
        Sorular soruAnaliz = sorularService.get(id);
        return ResponseEntity.ok().body(soruAnaliz);
    }

    /*---Tum Soru listesini don---*/
    @GetMapping("/getAll")
    public ResponseEntity<List<Sorular>> list() {
        List<Sorular> liste = sorularService.list();
        return ResponseEntity.ok().body(liste);
    }

    /*---Bir kayit guncelle ---*/
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Sorular sorular) {
        sorularService.update(id, sorular);
        return ResponseEntity.ok().body("kayit basariyla guncellendi...  !");
    }

    /*---Belirli bir Kayit Silme---*/
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        sorularService.delete(id);
        return ResponseEntity.ok().body("kayit basari ile silindi...  ! ");
    }
}
