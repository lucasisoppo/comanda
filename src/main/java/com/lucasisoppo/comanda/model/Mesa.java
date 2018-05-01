package com.lucasisoppo.comanda.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "mesa")
@SequenceGenerator(name = "MESAS_SEQ", allocationSize = 1)
public class Mesa {
    
    @Id
    @Column(name = "ID_MESA")
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "MESAS_SEQ")
    private Long id;
    
    @Column(name = "numero", length = 30)
    private String numero;
    
    @Column(name="qtdeCadeiras", length = 30)
    private Integer qtdeCadeiras;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.numero);
        hash = 19 * hash + Objects.hashCode(this.qtdeCadeiras);
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
        final Mesa other = (Mesa) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.qtdeCadeiras, other.qtdeCadeiras)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + id + ", numero=" + numero + ", qtdeCadeiras=" + qtdeCadeiras + '}';
    }
    
}
