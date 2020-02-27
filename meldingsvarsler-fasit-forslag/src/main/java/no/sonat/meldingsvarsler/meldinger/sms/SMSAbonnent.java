package no.sonat.meldingsvarsler.meldinger.sms;

import no.sonat.meldingsvarsler.infrastructure.abonnent.BasisAbonnent;
import no.sonat.meldingsvarsler.meldinger.Melding;

/*
Single Responsibility Principle
Håndterer kun abonnenter av SMSAbonnent
 */
public class SMSAbonnent extends BasisAbonnent {
    private final String telefonnummer;

    public SMSAbonnent(String navn, String telefonnummer) {
        super(navn);
        this.telefonnummer = telefonnummer;
        valider();
    }

    @Override
    public boolean abonnererPaa(Melding melding) {
        return melding instanceof SMSMelding;
    }

    public String telefonnummer() {
        return telefonnummer;
    }

    private void valider() {
        String regex = "\\d{8}";
        if (!this.telefonnummer.replace(" ","").matches(regex)) {
            throw new RuntimeException("Telefonummeret er feil " + this.telefonnummer);
        }
    }
}
