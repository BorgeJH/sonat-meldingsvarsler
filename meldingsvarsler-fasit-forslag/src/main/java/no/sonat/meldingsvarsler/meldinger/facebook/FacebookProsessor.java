package no.sonat.meldingsvarsler.meldinger.facebook;

import no.sonat.meldingsvarsler.infrastructure.abonnent.Abonnent;
import no.sonat.meldingsvarsler.meldinger.Melding;
import no.sonat.meldingsvarsler.meldinger.MeldingProsessor;

public class FacebookProsessor implements MeldingProsessor {
    @Override
    public boolean haandtererUtsendingAv(Melding melding) {
        return melding instanceof FacebookMelding;
    }

    @Override
    public void sendMelding(Abonnent abonnent, Melding melding) {
        sendFaceMelding(((FacebookAbonnent) abonnent), (FacebookMelding) melding);
    }

    public void sendFaceMelding(FacebookAbonnent facebookAbonnent, FacebookMelding facebookMelding) {
        System.out.println("Sender Facebook melding til "
                + facebookAbonnent.navn()
                + " => " + facebookMelding.melding());
    }
}
