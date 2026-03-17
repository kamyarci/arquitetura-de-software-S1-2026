package com.fag.lucasmartins.arquitetura_software.model.bo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoBOTest {

    @Test
    void deveCriarProdutoComDadosCorretos() {
        ProdutoBO produto = new ProdutoBO("Cadeira", 200.0, 10);

        assertEquals("Cadeira", produto.getNome());
        assertEquals(200.0, produto.getPreco());
        assertEquals(10, produto.getEstoque());
    }

    @Test
    void deveIdentificarProdutoPremium() {
        ProdutoBO produto = new ProdutoBO("Cadeira Premium", 200.0, 10);
        assertTrue(produto.isPremium());
    }

    @Test
    void deveIdentificarProdutoPremiumCaseInsensitive() {
        ProdutoBO produto = new ProdutoBO("Cadeira PREMIUM", 200.0, 10);
        assertTrue(produto.isPremium());
    }

    @Test
    void deveIdentificarProdutoNaoPremium() {
        ProdutoBO produto = new ProdutoBO("Cadeira Simples", 200.0, 10);
        assertFalse(produto.isPremium());
    }

    @Test
    void deveValidarProdutoPremiumComPrecoValido() {
        ProdutoBO produto = new ProdutoBO("Cadeira Premium", 150.0, 10);
        assertDoesNotThrow(produto::validar);
    }

    @Test
    void deveLancarExcecaoQuandoPremiumComPrecoAbaixoDoMinimo() {
        ProdutoBO produto = new ProdutoBO("Cadeira Premium", 50.0, 10);
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, produto::validar);
        assertEquals("Produtos Premium não podem custar menos de R$ 100,00.", ex.getMessage());
    }

    @Test
    void deveValidarProdutoNaoPremiumComQualquerPreco() {
        ProdutoBO produto = new ProdutoBO("Cadeira", 10.0, 5);
        assertDoesNotThrow(produto::validar);
    }

    @Test
    void deveAplicarDescontoDeAtacadoQuandoEstoqueIgualOuMaiorQue50() {
        ProdutoBO produto = new ProdutoBO("Mesa", 100.0, 50);
        produto.calcularPrecoFinal();
        assertEquals(90.0, produto.getPrecoFinal());
    }

    @Test
    void naoDeveAplicarDescontoQuandoEstoqueMenorQue50() {
        ProdutoBO produto = new ProdutoBO("Mesa", 100.0, 49);
        produto.calcularPrecoFinal();
        assertEquals(100.0, produto.getPrecoFinal());
    }

    @Test
    void deveDefinirEObterIdCorretamente() {
        ProdutoBO produto = new ProdutoBO("Mesa", 100.0, 10);
        produto.setId(42L);
        assertEquals(42L, produto.getId());
    }
}
