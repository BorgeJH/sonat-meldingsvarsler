package no.sonat.meldingsvarsler.meldinger.epost;

import no.sonat.meldingsvarsler.meldinger.Melding;

public class EpostMelding implements Melding {
    private final String epostTeskst;
    private final String epostTittel;

    public EpostMelding(String epostTeskst, String epostTittel) {
        this.epostTeskst = epostTeskst;
        this.epostTittel = epostTittel;
    }

    public String epostMelding() {
        return epostTeskst;
    }

    public String epostTittel() {
        return epostTittel;
    }
}
