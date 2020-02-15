package no.sonat.meldingsvarsler.epost;

import no.sonat.meldingsvarsler.Melding;

public class EpostMelding implements Melding {
    static final String MELDINGSTYPE = "EPOST";

    private final String epostTeskst;
    private final String epostTittel;

    public EpostMelding(String epostTeskst, String epostTittel) {
        this.epostTeskst = epostTeskst;
        this.epostTittel = epostTittel;
    }

    @Override
    public String meldingstype() {
        return MELDINGSTYPE;
    }

    public String epostMelding() {
        return epostTeskst;
    }

    public String epostTittel() {
        return epostTittel;
    }
}
