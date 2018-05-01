package com.lucasisoppo.comanda.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pedidoItem")
@SequenceGenerator(name = "PEDIDOITEM_SEQ", allocationSize = 1)
public class PedidoItem {
    
    
    @Id
    @Column(name = "ID_PEDIDOITEM")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "PEDIDOITEM_SEQ")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;
    
    @Column(name = "vlUnitario", precision = 15,scale = 2)
    private BigDecimal valorUnitario;
    
    @Column(name = "qtde", precision = 15, scale = 2)
    private BigDecimal quantidade;
    
    @Column(name = "vlTotal", precision = 15, scale = 2)
    private BigDecimal valotTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValotTotal() {
        return valotTotal;
    }

    public void setValotTotal(BigDecimal valotTotal) {
        this.valotTotal = valotTotal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.produto);
        hash = 23 * hash + Objects.hashCode(this.valorUnitario);
        hash = 23 * hash + Objects.hashCode(this.quantidade);
        hash = 23 * hash + Objects.hashCode(this.valotTotal);
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
        final PedidoItem other = (PedidoItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.valorUnitario, other.valorUnitario)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.valotTotal, other.valotTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PedidoItem{" + "id=" + id + ", produto=" + produto + ", valorUnitario=" + valorUnitario + ", quantidade=" + quantidade + ", valotTotal=" + valotTotal + '}';
    }
    
    
}
