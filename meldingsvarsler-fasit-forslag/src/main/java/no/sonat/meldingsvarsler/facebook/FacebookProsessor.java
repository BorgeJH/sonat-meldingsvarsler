package no.sonat.meldingsvarsler.facebook;

import no.sonat.meldingsvarsler.Abonnent;
import no.sonat.meldingsvarsler.Melding;
import no.sonat.meldingsvarsler.MeldingProsessor;

public class FacebookProsessor implements MeldingProsessor {
    @Override
    public void sendMelding(Abonnent abonnent, Melding melding) {
        FacebookAbonnent facebookAbonnent = (FacebookAbonnent) abonnent;
        FacebookMelding facebookMelding = (FacebookMelding) melding;
        System.out.println("Sender Faceebook melding til "
                + ((FacebookAbonnent) abonnent).navn()
                + " => " + ((FacebookMelding) melding).facebookMelding);
    }
}
