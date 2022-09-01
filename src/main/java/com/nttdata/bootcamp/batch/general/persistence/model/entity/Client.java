package com.nttdata.bootcamp.batch.general.persistence.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name="ta_cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "cod_client")
    private String codClient;

    @Column(name = "quantity_product")
    private int quantityProduct;



}
