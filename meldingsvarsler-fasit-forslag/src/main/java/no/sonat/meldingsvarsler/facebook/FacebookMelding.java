package no.sonat.meldingsvarsler.facebook;

import no.sonat.meldingsvarsler.Melding;

public class FacebookMelding implements Melding {
    static final String MELDINGSTYPE = "FACEBOOK";

    private final String tekst;

    public FacebookMelding(String tekst) {
        this.tekst = tekst;
    }

    @Override
    public String meldingstype() {
        return MELDINGSTYPE;
    }

    public String melding() {
        return tekst;
    }
}
