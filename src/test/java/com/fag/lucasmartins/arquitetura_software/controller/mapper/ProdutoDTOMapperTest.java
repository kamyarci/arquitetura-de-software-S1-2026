package com.fag.lucasmartins.arquitetura_software.controller.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.view.dto.CadastrarProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoDTOMapperTest {

    @Test
    void deveConverterRequestParaBo() {
        CadastrarProdutoRequest request = new CadastrarProdutoRequest();
        request.setNome("Mesa");
        request.setPreco(200.0);
        request.setEstoque(10);

        ProdutoBO bo = ProdutoDTOMapper.toBo(request);

        assertEquals("Mesa", bo.getNome());
        assertEquals(200.0, bo.getPreco());
        assertEquals(10, bo.getEstoque());
    }

    @Test
    void deveConverterBoParaResponse() {
        ProdutoBO bo = new ProdutoBO("Mesa", 200.0, 10);
        bo.calcularPrecoFinal();

        ProdutoResponse response = ProdutoDTOMapper.toResponse(bo);

        assertEquals("Produto cadastrado com sucesso!", response.getMensagem());
        assertEquals("Mesa", response.getNome());
        assertEquals(200.0, response.getPreco());
        assertEquals(10, response.getEstoque());
        assertEquals(200.0, response.getPrecoFinal());
    }
}
