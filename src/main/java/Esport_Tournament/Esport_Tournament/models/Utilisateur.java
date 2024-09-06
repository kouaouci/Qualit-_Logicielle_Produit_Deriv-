package Esport_Tournament.Esport_Tournament.models;

import jakarta.persistence.*;

@Entity(name = "utilisateur")
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "motDePasse")
    private String motDePasse;
    @ManyToOne
    @JoinColumn(name = "idAdresse")
    private Adresse adresse;
    @ManyToOne
    @JoinColumn(name = "idPays")
    private Pays pays;
    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;


    public Utilisateur() {
    }

    public Utilisateur(String email, String motDePasse) {

        this.email = email;
        this.motDePasse = motDePasse;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilisateur{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(motDePasse).append('\'');

        return sb.toString();
    }
}

