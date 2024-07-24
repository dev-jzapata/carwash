package com.jzapata.albaran_service.service.impl;

import com.jzapata.albaran_service.model.Albaran;
import com.jzapata.albaran_service.repository.AlbaranRepository;
import com.jzapata.albaran_service.service.AlbaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AlbaranServiceImpl implements AlbaranService {

    @Autowired
    private AlbaranRepository albaranRepository;

    @Override
    public List<Albaran> getAllAlbarans() {
        return albaranRepository.findAll();
    }

    @Override
    public Albaran save(Albaran albaran) {
        return albaranRepository.save(albaran);
    }

    @Override
    public Albaran getAlbaran(Long id) {
        return albaranRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAlbaran(Long id) {
        try{
            albaranRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
