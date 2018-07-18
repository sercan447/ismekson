package com.ismek.soruanaliz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ismek.model.SoruAnaliz;

@Service
@Transactional
public class SoruAnalizServiceImp implements SoruAnalizService {

    @Autowired
    private SoruAnalizDao soruAnalizDao;

    @Transactional
    @Override
    public long save(SoruAnaliz soruAnaliz) {
        return soruAnalizDao.save(soruAnaliz);
    }

    @Override
    public SoruAnaliz get(long id) {
        return soruAnalizDao.get(id);
    }

    @Override
    public List<SoruAnaliz> list() {
        return soruAnalizDao.list();
    }

    @Transactional
    @Override
    public void update(long id, SoruAnaliz soruAnaliz) {
        soruAnalizDao.update(id, soruAnaliz);
    }

    @Transactional
    @Override
    public void delete(long id) {
        soruAnalizDao.delete(id);
    }

}
