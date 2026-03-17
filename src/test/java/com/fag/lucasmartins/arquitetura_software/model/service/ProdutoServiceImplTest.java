package com.fag.lucasmartins.arquitetura_software.model.service;

import com.fag.lucasmartins.arquitetura_software.model.repository.ProdutoRepository;
import com.fag.lucasmartins.arquitetura_software.model.service.impl.ProdutoServiceImpl;
import com.fag.lucasmartins.arquitetura_software.view.dto.CadastrarProdutoRequest;
import com.fag.lucasmartins.arquitetura_software.view.dto.ProdutoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceImplTest {

    @Mock
    private ProdutoRepository produtoRepository;

    private ProdutoServiceImpl produtoService;

    @BeforeEach
    void setUp() {
        produtoService = new ProdutoServiceImpl(produtoRepository);
    }

    @Test
    void deveCadastrarProdutoComSucesso() {
        CadastrarProdutoRequest request = new CadastrarProdutoRequest();
        request.setNome("Mesa");
        request.setPreco(200.0);
        request.setEstoque(10);

        doNothing().when(produtoRepository).salvar(any());

        ProdutoResponse response = produtoService.cadastrar(request);

        assertEquals("Produto cadastrado com sucesso!", response.getMensagem());
        assertEquals("Mesa", response.getNome());
        assertEquals(200.0, response.getPreco());
        assertEquals(10, response.getEstoque());
        verify(produtoRepository, times(1)).salvar(any());
    }

    @Test
    void deveCadastrarProdutoComDescontoDeAtacado() {
        CadastrarProdutoRequest request = new CadastrarProdutoRequest();
        request.setNome("Mesa");
        request.setPreco(100.0);
        request.setEstoque(50);

        doNothing().when(produtoRepository).salvar(any());

        ProdutoResponse response = produtoService.cadastrar(request);

        assertEquals(90.0, response.getPrecoFinal());
    }

    @Test
    void deveLancarExcecaoParaProdutoPremiumComPrecoInvalido() {
        CadastrarProdutoRequest request = new CadastrarProdutoRequest();
        request.setNome("Mesa Premium");
        request.setPreco(50.0);
        request.setEstoque(10);

        assertThrows(IllegalArgumentException.class, () -> produtoService.cadastrar(request));
        verify(produtoRepository, never()).salvar(any());
    }
}
