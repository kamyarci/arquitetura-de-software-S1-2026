package com.fag.lucasmartins.arquitetura_software.model.repository.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.entity.ProdutoEntity;

public class ProdutoEntityMapper {

    public static ProdutoEntity toEntity(ProdutoBO bo) {
        return new ProdutoEntity(bo.getNome(), bo.getPreco(), bo.getPrecoFinal(), bo.getEstoque());
    }

    public static ProdutoBO toBo(ProdutoEntity entity) {
        ProdutoBO bo = new ProdutoBO(entity.getNome(), entity.getPreco(), entity.getEstoque());
        bo.setId(entity.getId());
        return bo;
    }
}
