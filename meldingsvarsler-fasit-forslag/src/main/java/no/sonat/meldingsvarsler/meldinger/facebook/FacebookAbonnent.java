package no.sonat.meldingsvarsler.meldinger.facebook;

import no.sonat.meldingsvarsler.infrastructure.abonnent.BasisAbonnent;
import no.sonat.meldingsvarsler.meldinger.Melding;

/*
Single Responsibility Principle
Håndterer kun abonnenter av FacebookAbonnent
 */
public class FacebookAbonnent extends BasisAbonnent {
    private final String brukernavn;

    public FacebookAbonnent(String navn, String brukernavn) {
        super(navn);
        this.brukernavn = brukernavn;
    }

    @Override
    public boolean abonnererPaa(Melding melding) {
        return melding instanceof FacebookMelding;
    }

    public String brukernavn() {
        return brukernavn;
    }
}
