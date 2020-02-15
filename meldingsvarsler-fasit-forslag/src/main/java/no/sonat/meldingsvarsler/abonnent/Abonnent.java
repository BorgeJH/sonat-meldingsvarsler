package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.sms.SMSMelding;

public interface Abonnent {
    String navn();
    Boolean erAktiv();
    public boolean abonnererPaa(Melding melding);

}
