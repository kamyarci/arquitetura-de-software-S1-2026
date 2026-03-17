package com.fag.lucasmartins.arquitetura_software.model.bo;

public class ProdutoBO {

    private Long id;
    private String nome;
    private double preco;
    private double precoFinal;
    private int estoque;

    public ProdutoBO(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public boolean isPremium() {
        return nome != null && nome.toLowerCase().contains("premium");
    }

    public void validar() {
        if (isPremium() && preco < 100.0) {
            throw new IllegalArgumentException("Produtos Premium não podem custar menos de R$ 100,00.");
        }
    }

    public void calcularPrecoFinal() {
        precoFinal = preco;
        if (estoque >= 50) {
            precoFinal = preco - (preco * 0.10);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public int getEstoque() {
        return estoque;
    }
}
