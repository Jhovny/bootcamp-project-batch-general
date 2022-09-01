package com.nttdata.bootcamp.batch.general.domain.service;

import com.nttdata.bootcamp.batch.general.domain.repository.IClientDW;
import com.nttdata.bootcamp.batch.general.persistence.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientDWService {

    @Autowired
    private IClientDW iClientDW;

    public Client save(Client clien){
        return iClientDW.save(clien);

    }


}
