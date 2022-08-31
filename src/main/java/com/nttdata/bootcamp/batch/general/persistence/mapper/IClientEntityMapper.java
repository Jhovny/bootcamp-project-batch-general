

package com.nttdata.bootcamp.batch.general.persistence.mapper;

import com.nttdata.bootcamp.batch.general.domain.ClientEntity;
import com.nttdata.bootcamp.batch.general.persistence.model.document.Client;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClientEntityMapper {


    @Mappings({
            @Mapping(source = "codeClient", target = "code"),
            @Mapping(source = "quantityProduct", target = "quantityProduct")
    })
    Client mapToModel(ClientEntity viewModel);

    @Mappings({
            @Mapping(source = "code", target = "codeClient"),
            @Mapping(source = "quantityProduct", target = "quantityProduct")
    })
    ClientEntity mapToViewModel(Client model);

    List<Client> mapListToModel(List<ClientEntity> viewModels);

    List<ClientEntity> mapListToViewModel(List<Client> models);

    default Single<Client> mapSingleToModel(Single<ClientEntity> viewModel) {
        return viewModel.map(this::mapToModel);
    }

    default Single<ClientEntity> mapSingleToViewModel(Single<Client> model) {
        return model.map(this::mapToViewModel);
    }

    default Observable<Client> mapObservableToModel(Observable<ClientEntity> viewModels) {
        return viewModels.map(this::mapToModel);
    }

    default Observable<ClientEntity> mapObservableToViewModel(Observable<Client> models) {
        return models.map(this::mapToViewModel);
    }

}
