package com.fag.lucasmartins.arquitetura_software.service.impl;

import com.fag.lucasmartins.arquitetura_software.dto.CadastrarProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponse;
import com.fag.lucasmartins.arquitetura_software.model.Produto;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponse cadastrar(CadastrarProdutoRequest request) {
        Produto produto = new Produto(request.getNome(), request.getPreco(), request.getEstoque());

        produto.validar();
        produto.calcularPrecoFinal();

        produtoRepository.salvar(produto);

        return new ProdutoResponse(
                "Produto cadastrado com sucesso!",
                produto.getNome(),
                produto.getEstoque(),
                produto.getPreco(),
                produto.getPrecoFinal()
        );
    }
}
