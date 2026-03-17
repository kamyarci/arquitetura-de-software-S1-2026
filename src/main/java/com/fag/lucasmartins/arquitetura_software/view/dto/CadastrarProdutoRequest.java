package com.fag.lucasmartins.arquitetura_software.view.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CadastrarProdutoRequest {

    @NotBlank(message = "O nome do produto é obrigatório")
    private String nome;

    @Min(value = 0, message = "O estoque não pode ser negativo")
    private int estoque;

    @Positive(message = "O preço deve ser maior que zero")
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
