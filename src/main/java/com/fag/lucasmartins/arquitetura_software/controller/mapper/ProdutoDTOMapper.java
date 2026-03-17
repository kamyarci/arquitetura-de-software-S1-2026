package com.fag.lucasmartins.arquitetura_software.controller.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.view.dto.CadastrarProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoResponse;

public class ProdutoDTOMapper {

    private ProdutoDTOMapper() {
    }

    public static ProdutoBO toBo(CadastrarProdutoRequest request) {
        return new ProdutoBO(request.getNome(), request.getPreco(), request.getEstoque());
    }

    public static ProdutoResponse toResponse(ProdutoBO bo) {
        return new ProdutoResponse(
                "Produto cadastrado com sucesso!",
                bo.getNome(),
                bo.getEstoque(),
                bo.getPreco(),
                bo.getPrecoFinal()
        );
    }
}
