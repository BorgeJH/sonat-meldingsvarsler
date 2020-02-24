package no.sonat.meldingsvarsler.meldinger.epost;

import no.sonat.meldingsvarsler.infrastructure.abonnent.BasisAbonnent;
import no.sonat.meldingsvarsler.meldinger.Melding;

public class EpostAbonnent extends BasisAbonnent {
    private final String epostAdresse;

    public EpostAbonnent(String navn, String epostAdresse) {
        super(navn);
        this.epostAdresse = epostAdresse;
    }

    @Override
    public boolean abonnererPaa(Melding melding) {
        return melding instanceof EpostMelding;
    }

    public String epostAdresse() {
        return epostAdresse;
    }
}
