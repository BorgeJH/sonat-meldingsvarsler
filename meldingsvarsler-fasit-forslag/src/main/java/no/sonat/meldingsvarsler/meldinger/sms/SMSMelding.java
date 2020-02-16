package no.sonat.meldingsvarsler.meldinger.sms;

import no.sonat.meldingsvarsler.meldinger.Melding;

public class SMSMelding implements Melding {

    final String tekstmelding;

    public SMSMelding(String tekstMelding) {
        this.tekstmelding = tekstMelding;
    }

    public String melding() {
        return tekstmelding;
    }
}
