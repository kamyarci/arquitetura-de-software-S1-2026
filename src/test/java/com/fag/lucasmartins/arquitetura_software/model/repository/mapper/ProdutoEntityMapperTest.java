package com.fag.lucasmartins.arquitetura_software.model.repository.mapper;

import com.fag.lucasmartins.arquitetura_software.model.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.model.repository.entity.ProdutoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoEntityMapperTest {

    @Test
    void deveConverterBoParaEntity() {
        ProdutoBO bo = new ProdutoBO("Mesa", 200.0, 10);
        bo.calcularPrecoFinal();

        ProdutoEntity entity = ProdutoEntityMapper.toEntity(bo);

        assertEquals("Mesa", entity.getNome());
        assertEquals(200.0, entity.getPreco());
        assertEquals(200.0, entity.getPrecoFinal());
        assertEquals(10, entity.getEstoque());
    }

    @Test
    void deveConverterEntityParaBo() {
        ProdutoEntity entity = new ProdutoEntity("Mesa", 200.0, 200.0, 10);

        ProdutoBO bo = ProdutoEntityMapper.toBo(entity);

        assertEquals("Mesa", bo.getNome());
        assertEquals(200.0, bo.getPreco());
        assertEquals(10, bo.getEstoque());
    }
}
