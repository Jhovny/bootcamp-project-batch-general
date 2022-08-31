package com.nttdata.bootcamp.batch.general.domain.service;

import com.nttdata.bootcamp.batch.general.domain.ClientEntity;
import com.nttdata.bootcamp.batch.general.domain.repository.IClienteRepository;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository iClienteRepository;

    public Single<ClientEntity> save (ClientEntity client){
        return iClienteRepository.save(client);
    }


}
