package no.sonat.meldingsvarsler.meldinger.sms;

import no.sonat.meldingsvarsler.infrastructure.abonnent.Abonnent;
import no.sonat.meldingsvarsler.infrastructure.abonnent.AbonnentBasis;
import no.sonat.meldingsvarsler.meldinger.Melding;

public class SMSAbonnent extends AbonnentBasis {
    private final String telefonnummer;

    public SMSAbonnent(String navn, String telefonnummer) {
        super(navn);
        this.telefonnummer = telefonnummer;
    }

    @Override
    public boolean abonnererPaa(Melding melding) {
        return melding instanceof SMSMelding;
    }

    public String telefonnummer() {
        return telefonnummer;
    }
}
