package no.sonat.meldingsvarsler.epost;

import no.sonat.meldingsvarsler.Abonnent;

public class EpostAbonnent implements Abonnent {
    private String navn;
    private String epostAdresse;

    public EpostAbonnent(String navn, String epostAdresse) {
        this.epostAdresse = epostAdresse;
        this.navn = navn;
    }
    @Override
    public String navn() {
        return navn;
    }

    @Override
    public Boolean erAktiv() {
        return true;
    }

    public String epostAdresse() {
        return epostAdresse;
    }
}
