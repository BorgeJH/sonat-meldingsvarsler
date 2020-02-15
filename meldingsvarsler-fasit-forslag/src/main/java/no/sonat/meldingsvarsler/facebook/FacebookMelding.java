package no.sonat.meldingsvarsler.facebook;

import no.sonat.meldingsvarsler.Melding;

public class FacebookMelding implements Melding {
    String facebookMelding;

    FacebookMelding(String facebookMelding) {
        this.facebookMelding = facebookMelding;
    }

    @Override
    public String meldingstype() {
        return "SMS";
    }

    public String melding() {
        return facebookMelding;
    }
}
