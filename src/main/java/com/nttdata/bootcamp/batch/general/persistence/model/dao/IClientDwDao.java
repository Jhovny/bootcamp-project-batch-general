package com.nttdata.bootcamp.batch.general.persistence.model.dao;

import com.nttdata.bootcamp.batch.general.persistence.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface IClientDwDao extends CrudRepository<Client, String> {

}
