package no.sonat.meldingsvarsler.epost;

import no.sonat.meldingsvarsler.Abonnent;
import no.sonat.meldingsvarsler.Melding;
import no.sonat.meldingsvarsler.MeldingProsessor;

public class EpostProsessor implements MeldingProsessor {
    @Override
    public void sendMelding(Abonnent abonnent, Melding melding) {
        EpostAbonnent epostAbonnent = (EpostAbonnent) abonnent;
        EpostMelding epostMelding = (EpostMelding) melding;
        System.out.println("Sender Epost til "
                + epostAbonnent.epostAdresse()
                + "(" + epostAbonnent.navn() + ")"
                + " => " + epostMelding.epostTittel()
                + " : " + epostMelding.epostMelding());
    }
}
