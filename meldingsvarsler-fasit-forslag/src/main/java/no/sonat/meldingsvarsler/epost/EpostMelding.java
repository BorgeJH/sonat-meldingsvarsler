package no.sonat.meldingsvarsler.epost;

import no.sonat.meldingsvarsler.Melding;

public class EpostMelding implements Melding {
    private String epostMelding;
    private String epostTittel;

    EpostMelding(String epostMelding) {
        this.epostMelding = epostMelding;
    }

    @Override
    public String meldingstype() {
        return "EPOST";
    }

    public String epostMelding() {
        return epostMelding;
    }

    public String epostTittel() {
        return epostTittel;
    }
}
