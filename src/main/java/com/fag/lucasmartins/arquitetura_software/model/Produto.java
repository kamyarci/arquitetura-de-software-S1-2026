package com.fag.lucasmartins.arquitetura_software.model;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @Column(name = "preco_final", nullable = false)
    private double precoFinal;

    @Column(nullable = false)
    private int estoque;

    protected Produto() {
    }

    public Produto(String nome, double preco, int estoque) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
