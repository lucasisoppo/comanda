package com.lucasisoppo.pedidos.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
@SequenceGenerator(name = "PRODUTOS_SEQ", allocationSize = 1)
public class Produto {
    
    @Id
    @Column(name = "ID_PRODUTO")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "PRODUTOS_SEQ")
    private Long id;
    
    @Column(name= "cd_produto", length = 20, unique = true)
    private String codigo;
    
    @Column(name = "descricao", length = 255)
    private String descricao;
    
    @Column(name= "preco", precision = 15 ,scale=5)
    private BigDecimal preco;
    
    @Column(name = "qtde", precision = 15)
    private BigDecimal quantidade;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.codigo);
        hash = 17 * hash + Objects.hashCode(this.descricao);
        hash = 17 * hash + Objects.hashCode(this.preco);
        hash = 17 * hash + Objects.hashCode(this.quantidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade=" + quantidade + '}';
    }
    
    
}
