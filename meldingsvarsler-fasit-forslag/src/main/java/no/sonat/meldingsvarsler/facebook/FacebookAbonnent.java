package no.sonat.meldingsvarsler.facebook;

import no.sonat.meldingsvarsler.Abonnent;

public class FacebookAbonnent implements Abonnent {
    private String navn;
    private String brukernavn;

    FacebookAbonnent(String navn, String brukernavn) {
        this.brukernavn = brukernavn;
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

    public String brukernavn() {
        return brukernavn;
    }
}
