package no.sonat.meldingsvarsler.meldinger.facebook;

import no.sonat.meldingsvarsler.meldinger.Melding;
import no.sonat.meldingsvarsler.meldinger.MeldingProsessor;

public class FacebookProsessor implements MeldingProsessor<FacebookMelding, FacebookAbonnent> {
    @Override
    public boolean haandtererUtsendingAv(Melding melding) {
        return melding instanceof FacebookMelding;
    }

    @Override
    public void sendMelding(FacebookAbonnent facebookAbonnent, FacebookMelding facebookMelding) {
        sendFaceMelding( facebookAbonnent, facebookMelding);
    }

    public void sendFaceMelding(FacebookAbonnent facebookAbonnent, FacebookMelding facebookMelding) {
        System.out.println("Sender Facebook melding til "
                + facebookAbonnent.navn()
                + " => " + facebookMelding.melding());
    }
}
