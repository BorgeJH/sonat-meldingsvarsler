package no.sonat.meldingsvarsler.epost;

import no.sonat.meldingsvarsler.abonnent.Abonnent;
import no.sonat.meldingsvarsler.Melding;
import no.sonat.meldingsvarsler.MeldingProsessor;

public class EpostProsessor implements MeldingProsessor {
    @Override
    public boolean haandtererUtsendingAv(Melding melding) {
        return melding instanceof EpostMelding;
    }

    @Override
    public void sendMelding(Abonnent abonnent, Melding melding) {
        sendEpost(((EpostAbonnent) abonnent), (EpostMelding) melding);
    }
    public void sendEpost(EpostAbonnent epostAbonnent, EpostMelding epostMelding) {
        System.out.println("Sender Epost til "
                + epostAbonnent.epostAdresse()
                + "(" + epostAbonnent.navn() + ")"
                + " => " + epostMelding.epostTittel()
                + " => " + epostMelding.epostMelding());
    }
}
