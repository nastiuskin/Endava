package com.endava.springbooticek.service;

import com.endava.springbooticek.entity.LabelEntity;
import com.endava.springbooticek.repository.LabelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelService {

    @Autowired
    private LabelRepo labelRepo;

    public LabelEntity getLabelEntityByTitle(String title){
        return labelRepo.getLabelEntityByTitle(title);
    }
}
