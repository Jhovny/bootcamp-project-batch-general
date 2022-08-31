package com.nttdata.bootcamp.batch.general.persistence.model.dao;
import com.nttdata.bootcamp.batch.general.persistence.model.document.Client;

import io.reactivex.rxjava3.core.Single;
import org.springframework.data.repository.reactive.RxJava3CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends RxJava3CrudRepository<Client, String> {

    Single<Client> findByCode(String code);

}
