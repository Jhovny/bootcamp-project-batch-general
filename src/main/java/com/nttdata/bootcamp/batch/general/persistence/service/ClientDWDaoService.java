package com.nttdata.bootcamp.batch.general.persistence.service;

import com.nttdata.bootcamp.batch.general.domain.repository.IClientDW;
import com.nttdata.bootcamp.batch.general.persistence.model.dao.IClientDwDao;
import com.nttdata.bootcamp.batch.general.persistence.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ClientDWDaoService implements IClientDW {

    @Autowired
    private IClientDwDao iClientDwDao;


    @Override
    public Client save(Client client) {

       return  iClientDwDao.save(client);

    }


}