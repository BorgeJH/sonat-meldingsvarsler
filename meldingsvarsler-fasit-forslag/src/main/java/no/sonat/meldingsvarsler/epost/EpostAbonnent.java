package no.sonat.meldingsvarsler.epost;

import no.sonat.meldingsvarsler.abonnent.Abonnent;
import no.sonat.meldingsvarsler.Melding;

public class EpostAbonnent implements Abonnent {
    private final String navn;
    private final String epostAdresse;

    public EpostAbonnent(String navn, String epostAdresse) {
        this.epostAdresse = epostAdresse;
        this.navn = navn;
    }

    @Override
    public boolean abonnererPaa(Melding melding) {
        return melding instanceof EpostMelding;
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
