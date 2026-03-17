package com.fag.lucasmartins.arquitetura_software.model.service;

import com.fag.lucasmartins.arquitetura_software.view.dto.CadastrarProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoResponse;

public interface ProdutoService {

    ProdutoResponse cadastrar(CadastrarProdutoRequest request);
}
