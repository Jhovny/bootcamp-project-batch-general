package com.nttdata.bootcamp.batch.general.domain.repository;


import com.nttdata.bootcamp.batch.general.domain.ClientEntity;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;


import java.util.List;

public interface IClienteRepository {

   Observable<List<ClientEntity>> findAll();
    Single<ClientEntity> save(ClientEntity client);


}
