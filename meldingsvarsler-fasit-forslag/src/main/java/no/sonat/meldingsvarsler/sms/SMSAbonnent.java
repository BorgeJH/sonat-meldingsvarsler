package no.sonat.meldingsvarsler.sms;

import no.sonat.meldingsvarsler.abonnent.Abonnent;
import no.sonat.meldingsvarsler.Melding;

public class SMSAbonnent implements Abonnent {
    private final String navn;
    private final String telefonnummer;

    public SMSAbonnent(String navn, String telefonnummer) {
        this.navn = navn;
        this.telefonnummer = telefonnummer;
    }

    @Override
    public boolean abonnererPaa(Melding melding) {
        return melding instanceof SMSMelding;
    }

    @Override
    public String navn() {
        return navn;
    }

    @Override
    public Boolean erAktiv() {
        return true;
    }

    public String telefonnummer() {
        return telefonnummer;
    }
}
