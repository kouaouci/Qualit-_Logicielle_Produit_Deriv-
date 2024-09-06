package Esport_Tournament.Esport_Tournament.models;

import jakarta.persistence.*;

@Entity(name = "FraisDePort")
@Table(name = "FraisDePort")

public class FraisDePort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "montant")
    private Double montant;
    @OneToOne(mappedBy = "fraisDePort")
    private Pays pays;
    public FraisDePort() {
    }
    public FraisDePort(Double montant) {
        this.montant = montant;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getMontant() {
        return montant;
    }
    public void setMontant(Double montant) {
        this.montant = montant;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FraisDePort{");
        sb.append("id=").append(id);
        sb.append(", montant=").append(montant);
        sb.append('}');
        return sb.toString();
    }




}
