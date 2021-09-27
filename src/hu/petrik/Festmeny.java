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
        if (this.getElkelt()){
            System.out.println("A festmény már ekelt!");
        }
        else if (this.getLicitekSzama() == 0){
            this.legmagasabbLicit = 100;
            this.licitekSzama++;
            this.legutolsoLicitIdeje = LocalDateTime.now();
        }
        else if (this.getLicitekSzama() > 0){
            this.legmagasabbLicit *= 1.1;
            this.licitekSzama++;
            this.legutolsoLicitIdeje = LocalDateTime.now();
        }
        //plussz feadat nincs beleírva
    }

    public void licit(int mertek){
        if (this.getElkelt()){
            System.out.println("A festmény már ekelt!");
        }
        else if (this.getLicitekSzama() == 0){
            this.legmagasabbLicit = 100;
            this.licitekSzama++;
            this.legutolsoLicitIdeje = LocalDateTime.now();
        }
        else if (this.getLicitekSzama() > 0){
            if (mertek > 9 && mertek < 101){
                String alap = "1.";
                alap += Integer.toString(mertek);
                this.legmagasabbLicit *= Double.parseDouble(alap);
                this.licitekSzama++;
                this.legutolsoLicitIdeje = LocalDateTime.now();
            }
            else {
                System.out.println("10 és 100 közötti értéket adj meg!");
            }

        }
        //plussz feadat nincs beleírva
    }

    @Override
    public String toString() {
        if (this.getElkelt()){
            String elkeltSzoveg = this.getElkelt() ? "Elkelt" : "Nem kelt el";
            return "festo: " + this.cim + " (" + this.getStilus() + ")\n"+
            elkeltSzoveg + "\n" +
            this.getLegmagasabbLicit() + "$ - " + this.getLegutolsoLicitIdeje() + "(összesen: " + this.getLicitekSzama()
                    + " )db";
        }
        else {
            return "festo: " + this.cim + " (" + this.getStilus() + ")\n"+
                    this.getLegmagasabbLicit() + "$ - " + this.getLegutolsoLicitIdeje() + "(összesen: " + this.getLicitekSzama()
                    + " db)";
        }
    }
}
