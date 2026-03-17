package com.fag.lucasmartins.arquitetura_software.model.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

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

    protected ProdutoEntity() {
    }

    public ProdutoEntity(String nome, double preco, double precoFinal, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.precoFinal = precoFinal;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
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
