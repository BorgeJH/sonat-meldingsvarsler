package no.sonat.meldingsvarsler.meldinger.facebook;

import no.sonat.meldingsvarsler.infrastructure.abonnent.Abonnent;
import no.sonat.meldingsvarsler.meldinger.Melding;

public class FacebookAbonnent implements Abonnent {
    private final String navn;
    private final String brukernavn;

    public FacebookAbonnent(String navn, String brukernavn) {
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

    @Override
    public boolean abonnererPaa(Melding melding) {
        return melding instanceof FacebookMelding;
    }

    public String brukernavn() {
        return brukernavn;
    }
}
