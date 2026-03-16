package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.dto.CadastrarProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponse;

public interface ProdutoService {

    ProdutoResponse cadastrar(CadastrarProdutoRequest request);
}
