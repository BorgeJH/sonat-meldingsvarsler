package no.sonat.meldingsvarsler.meldinger.sms;

public class SMSMelding{

    final String tekstmelding;

    public SMSMelding(String tekstMelding) {
        this.tekstmelding = tekstMelding;
    }

    public String melding() {
        return tekstmelding;
    }
}
