package Esport_Tournament.Esport_Tournament.DTO;

public class AdresseDTO {

    private Long id;
    private String rue;
    private String codePostal;
    private String ville;
    private String pays;

    public AdresseDTO() {
    }

    public AdresseDTO(Long id, String rue, String codePostal, String ville, String pays) {
        this.id = id;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    public Long getId() {
        return id;
    }

    public String getRue() {
        return rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
