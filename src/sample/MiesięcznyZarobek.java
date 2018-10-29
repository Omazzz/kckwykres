package sample;

public class MiesięcznyZarobek {

    private String month;
    private String zarobki;

    MiesięcznyZarobek(String miesiac, String zarobki){
        this.month = miesiac;
        this.zarobki = zarobki;
    }

    public String getMiesiac() {
        return month;
    }

    public String getZarobki() {
        return zarobki;
    }

    public Number getNumberZarobki(){
        return Double.parseDouble(zarobki);
    }
}
