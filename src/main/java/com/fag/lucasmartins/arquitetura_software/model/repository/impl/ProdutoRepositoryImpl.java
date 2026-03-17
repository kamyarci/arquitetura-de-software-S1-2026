package com.fag.lucasmartins.arquitetura_software.model.repository.impl;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.model.repository.entity.ProdutoEntity;
import com.fag.lucasmartins.arquitetura_software.model.repository.jpa.ProdutoJpaRepository;
import com.fag.lucasmartins.arquitetura_software.model.repository.mapper.ProdutoEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoJpaRepository produtoJpaRepository;

    public ProdutoRepositoryImpl(ProdutoJpaRepository produtoJpaRepository) {
        this.produtoJpaRepository = produtoJpaRepository;
    }

    @Override
    public void salvar(ProdutoBO produto) {
        ProdutoEntity entity = ProdutoEntityMapper.toEntity(produto);
        produtoJpaRepository.save(entity);
    }
}
