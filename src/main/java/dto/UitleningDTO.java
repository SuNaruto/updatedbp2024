package dto;

import java.util.Date;

public class UitleningDTO {

    private int uitlening_id;
    private BoekDTO boek;
    private LidDTO lid;
    private Date uitgeleendOp;
    private Date teruggebrachtOp;

     public int getUitlening_id() {
         return uitlening_id;
     }

     public void setUitlening_id(int uitlening_id) {
         this.uitlening_id = uitlening_id;
     }

     public BoekDTO getBoek() {
         return boek;
     }

     public void setBoek(BoekDTO boek) {
         this.boek = boek;
     }

     public Date getUitgeleendOp() {
         return uitgeleendOp;
     }

     public void setUitgeleendOp(Date uitgeleendOp) {
         this.uitgeleendOp = uitgeleendOp;
     }

     public Date getTeruggebrachtOp() {
         return teruggebrachtOp;
     }

     public void setTeruggebrachtOp(Date teruggebrachtOp) {
         this.teruggebrachtOp = teruggebrachtOp;
     }

    public LidDTO getLid() {
        return lid;
    }

    public void setLid(LidDTO lid) {
        this.lid = lid;
    }
}