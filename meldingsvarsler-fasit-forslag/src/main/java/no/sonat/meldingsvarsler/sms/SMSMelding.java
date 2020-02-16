package no.sonat.meldingsvarsler.sms;

import no.sonat.meldingsvarsler.Melding;

public class SMSMelding implements Melding {

    final String tekstmelding;

    public SMSMelding(String tekstMelding) {
        this.tekstmelding = tekstMelding;
    }

    public String melding() {
        return tekstmelding;
    }
}
