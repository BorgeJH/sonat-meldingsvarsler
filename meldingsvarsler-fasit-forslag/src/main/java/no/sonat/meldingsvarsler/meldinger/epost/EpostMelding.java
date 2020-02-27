package no.sonat.meldingsvarsler.meldinger.epost;

import no.sonat.meldingsvarsler.meldinger.Melding;

public class EpostMelding implements Melding {
    private final String epostTekst;
    private final String epostTittel;

    public EpostMelding(String epostTeskst, String epostTittel) {
        this.epostTekst = epostTeskst;
        this.epostTittel = epostTittel;
    }

    public String epostMelding() {
        return epostTekst;
    }

    public String epostTittel() {
        return epostTittel;
    }
}
