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
    @JoinColumn(name = "ID_MESA")
    private Mesa mesa;
    
    @Column(name = "DT_PEDIDO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPedido;
    
    @JoinColumn(name = "ID_PEDIDO")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PedidoItem> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa cliente) {
        this.mesa = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date emissao) {
        this.dataPedido = dataPedido;
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
        hash = 23 * hash + Objects.hashCode(this.mesa);
        hash = 23 * hash + Objects.hashCode(this.dataPedido);
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
        if (!Objects.equals(this.mesa, other.mesa)) {
            return false;
        }
        if (!Objects.equals(this.dataPedido, other.dataPedido)) {
            return false;
        }
        if (!Objects.equals(this.itens, other.itens)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", mesa=" + mesa + ", dataPedido=" + dataPedido + ", itens=" + itens + '}';
    }


}
