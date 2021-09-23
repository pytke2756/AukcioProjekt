package hu.petrik;

import java.time.LocalDateTime;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama;
    private int legmagasabbLicit;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt;

    public Festmeny(String cim, String festo, String stilus){
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
        this.licitekSzama = 0;
        this.legmagasabbLicit = 0;
        this.elkelt = false;
    }

    public String getFesto() {
        return this.festo;
    }

    public String getStilus() {
        return this.stilus;
    }

    public int getLicitekSzama() {
        return this.licitekSzama;
    }

    public int getLegmagasabbLicit() {
        return this.legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return this.legutolsoLicitIdeje;
    }

    public boolean getElkelt(){
        return this.elkelt;
    }

    public void setElkelt(boolean elkelt) {
        this.elkelt = elkelt;
    }

    public void licit(){

    }

    public void licit(int mertek){

    }
}
