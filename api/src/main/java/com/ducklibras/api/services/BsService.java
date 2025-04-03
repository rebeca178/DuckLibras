package com.ducklibras.api.services;

import org.springframework.stereotype.Service;


import com.ducklibras.api.models.repo.BsRepo;



import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BsService {

    @Autowired
    private BsRepo bsRepo;


    
}
