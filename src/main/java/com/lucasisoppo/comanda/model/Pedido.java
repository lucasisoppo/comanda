package com.lucasisoppo.comanda.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedidos")
@SequenceGenerator(name = "PEDIDOS_SEQ", allocationSize = 1)
public class Pedido {
    
    @Id
    @Column(name = "ID_PEDIDO")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "PEDIDOS_SEQ")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Mesa cliente;
    
    @Column(name = "DT_EMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissao;
    
    @Column(name = "DT_APROVACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aprovacao;
    
    @JoinColumn(name = "ID_PEDIDO")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PedidoItem> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mesa getCliente() {
        return cliente;
    }

    public void setCliente(Mesa cliente) {
        this.cliente = cliente;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Date aprovacao) {
        this.aprovacao = aprovacao;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.cliente);
        hash = 23 * hash + Objects.hashCode(this.emissao);
        hash = 23 * hash + Objects.hashCode(this.aprovacao);
        hash = 23 * hash + Objects.hashCode(this.itens);
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
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.emissao, other.emissao)) {
            return false;
        }
        if (!Objects.equals(this.aprovacao, other.aprovacao)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente + ", emissao=" + emissao + ", aprovacao=" + aprovacao + ", itens=" + itens + '}';
    }
    
    
}
