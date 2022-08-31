package com.nttdata.bootcamp.batch.general.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientEntity {

    private String codeClient;
    private int quantityProduct;
}
