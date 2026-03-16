package com.fag.lucasmartins.arquitetura_software.repository.impl;

import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoJpaRepository;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Autowired
    private ProdutoJpaRepository produtoJpaRepository;

    @Override
    public void salvar(Produto produto) {
        produtoJpaRepository.save(produto);
    }
}
