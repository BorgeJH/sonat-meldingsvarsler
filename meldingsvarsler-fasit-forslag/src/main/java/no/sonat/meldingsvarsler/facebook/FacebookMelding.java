package no.sonat.meldingsvarsler.facebook;

import no.sonat.meldingsvarsler.Melding;

public class FacebookMelding implements Melding {
    private final String tekst;

    public FacebookMelding(String tekst) {
        this.tekst = tekst;
    }

    public String melding() {
        return tekst;
    }
}
