package com.nttdata.bootcamp.batch.general.persistence.service;

import com.nttdata.bootcamp.batch.general.domain.ClientEntity;
import com.nttdata.bootcamp.batch.general.domain.repository.IClienteRepository;

import com.nttdata.bootcamp.batch.general.persistence.model.document.Client;
import com.nttdata.bootcamp.batch.general.persistence.model.dao.ClientDao;
import com.nttdata.bootcamp.batch.general.persistence.mapper.IClientEntityMapper;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteDaoService implements IClienteRepository {
    private static final Logger log = LoggerFactory.getLogger(ClienteDaoService.class);

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private IClientEntityMapper mapper;


    @Override
    public Observable<List<ClientEntity>> findAll() {
        return null;
    }

    @Override
    public Single<ClientEntity> save(ClientEntity clientEntity) {

        Single<Client> clientUpdate= clientDao.findByCode(clientEntity.getCodeClient())
                .map(z -> { z.setQuantityProduct(z.getQuantityProduct() + clientEntity.getQuantityProduct()); return z;})
                .flatMap(clientDao::save).doAfterTerminate(() -> log.info("Cliente actualizado")) ;
        //clientUpdate.subscribe(d -> log.info("correo "+d.getEmail()));
        return mapper.mapSingleToViewModel(clientUpdate);
    }
}
