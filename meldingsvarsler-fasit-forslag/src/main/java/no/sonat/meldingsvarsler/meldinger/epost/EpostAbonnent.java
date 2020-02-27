package no.sonat.meldingsvarsler.meldinger.epost;

import no.sonat.meldingsvarsler.infrastructure.abonnent.BasisAbonnent;
import no.sonat.meldingsvarsler.meldinger.Melding;

/*
Single Responsibility Principle
Håndterer kun abonnenter av EpostAbonnent
 */
public class EpostAbonnent extends BasisAbonnent {
    private final String epostAdresse;

    public EpostAbonnent(String navn, String epostAdresse) {
        super(navn);
        this.epostAdresse = epostAdresse;
        valider();
    }

    @Override
    public boolean abonnererPaa(Melding melding) {
        return melding instanceof EpostMelding;
    }

    public String epostAdresse() {
        return epostAdresse;
    }

    private void valider()  {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!epostAdresse.matches(regex)) {
            throw new RuntimeException("Epost adressen er feil " + epostAdresse);
        }
    }
}
