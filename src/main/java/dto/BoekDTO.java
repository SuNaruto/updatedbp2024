package dto;

public class BoekDTO {

    private int boek_id;
    private String titel;
    private String auteur;
    private int aantal;

    public int getBoek_id() {
        return boek_id;
    }

    public void setBoek_id(int boek_id) {
        this.boek_id = boek_id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
}