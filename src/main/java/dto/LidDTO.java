package dto;

import java.util.List;

public class LidDTO {

    private int lid_id;
    private String naam;
    private String adres;
    private String telefoonnummer;
    private List<UitleningDTO> uitleningen;

    public int getLid_id() {
        return lid_id;
    }

    public void setLid_id(int lid_id) {
        this.lid_id = lid_id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public List<UitleningDTO> getUitleningen() {
        return uitleningen;
    }

    public void setUitleningen(List<UitleningDTO> uitleningen) {
        this.uitleningen = uitleningen;
    }
}
