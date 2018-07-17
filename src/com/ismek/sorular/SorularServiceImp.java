package com.ismek.sorular;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.Sorular;

@Service
public class SorularServiceImp implements SorularService {

    @Autowired
    private SorularDao sorularDao;

   
    @Override
    public long save(Sorular sorular) {
        return sorularDao.save(sorular);
    }

    @Override
    public Sorular get(long id) {
        return sorularDao.get(id);
    }

    @Override
    public List<Sorular> list() {
        return sorularDao.list();
    }

    @Override
    public void update(long id, Sorular sorular) {
        sorularDao.update(id, sorular);
    }

  
    @Override
    public void delete(long id) {
        sorularDao.delete(id);
    }

}
