package no.sonat.meldingsvarsler.sms;

import no.sonat.meldingsvarsler.Melding;

public class SMSMelding implements Melding {
    static String MELDINGSTYPE = "SMS";

    String tekstmelding;

    public SMSMelding(String tekstMelding) {
        this.tekstmelding = tekstMelding;
    }
    @Override
    public String meldingstype() {
        return MELDINGSTYPE;
    }

    public String melding() {
        return tekstmelding;
    }
}
