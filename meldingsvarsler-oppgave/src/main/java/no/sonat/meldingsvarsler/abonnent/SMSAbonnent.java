package no.sonat.meldingsvarsler.abonnent;

public class SMSAbonnent {
    private final String navn;
    private final String telefonnummer;

    public SMSAbonnent(String navn, String telefonnummer) {
        this.navn = navn;
        this.telefonnummer = telefonnummer;
    }

    public String navn() {
        return navn;
    }

    public Boolean erAktiv() {
        return true;
    }

    public String telefonnummer() {
        return telefonnummer;
    }
}
