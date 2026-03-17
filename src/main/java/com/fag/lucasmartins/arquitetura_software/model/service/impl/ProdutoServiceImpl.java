package com.fag.lucasmartins.arquitetura_software.model.service.impl;

import com.fag.lucasmartins.arquitetura_software.controller.mapper.ProdutoDTOMapper;
import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.model.service.ProdutoService;
import com.fag.lucasmartins.arquitetura_software.view.dto.CadastrarProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoResponse;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoResponse cadastrar(CadastrarProdutoRequest request) {
        ProdutoBO produto = ProdutoDTOMapper.toBo(request);

        produto.validar();
        produto.calcularPrecoFinal();

        produtoRepository.salvar(produto);

        return ProdutoDTOMapper.toResponse(produto);
    }
}
