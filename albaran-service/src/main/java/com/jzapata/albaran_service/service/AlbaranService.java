package com.jzapata.albaran_service.service;

import com.jzapata.albaran_service.model.Albaran;

import java.util.List;

public interface AlbaranService {

    public List<Albaran> getAllAlbarans();

    public Albaran save(Albaran albaran);

    public Albaran getAlbaran(Long id);

    public void deleteAlbaran(Long id);

}
