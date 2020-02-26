package no.sonat.meldingsvarsler.meldinger.epost;

import no.sonat.meldingsvarsler.meldinger.Melding;
import no.sonat.meldingsvarsler.meldinger.MeldingProsessor;

public class EpostProsessor implements MeldingProsessor<EpostMelding, EpostAbonnent> {
    @Override
    public boolean haandtererUtsendingAv(Melding melding) {
        return melding instanceof EpostMelding;
    }

    @Override
    public void sendMelding(EpostAbonnent epostAbonnent, EpostMelding epostMelding) {
        sendEpost(epostAbonnent, epostMelding);
    }
    public void sendEpost(EpostAbonnent epostAbonnent, EpostMelding epostMelding) {
        System.out.println("Sender Epost til "
                + epostAbonnent.epostAdresse()
                + "(" + epostAbonnent.navn() + ")"
                + " => " + epostMelding.epostTittel()
                + " => " + epostMelding.epostMelding());
    }
}
