package Esport_Tournament.Esport_Tournament.models;

import jakarta.persistence.*;

@Entity(name = "ModeDePaiment")
@Table(name = "ModeDePaiment")
public class ModeDePaiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nom")
    private String nom;


    public ModeDePaiment() {
    }

    public ModeDePaiment(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ModeDePaiment{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
