package sample;

public class MiesięcznyZarobek {

    private String miesiac;
    private String zarobki;

    MiesięcznyZarobek(String miesiac, String zarobki){
        this.miesiac = miesiac;
        this.zarobki = zarobki;
    }

    public String getMiesiac() {
        return miesiac;
    }

    public String getZarobki() {
        return zarobki;
    }

    public Number getNumberZarobki(){
        return Double.parseDouble(zarobki);
    }
}
