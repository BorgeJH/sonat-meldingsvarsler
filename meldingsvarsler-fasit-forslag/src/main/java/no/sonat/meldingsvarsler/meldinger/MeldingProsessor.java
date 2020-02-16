package no.sonat.meldingsvarsler.meldinger;

import no.sonat.meldingsvarsler.infrastructure.abonnent.Abonnent;
import no.sonat.meldingsvarsler.meldinger.Melding;

public interface MeldingProsessor {
    boolean haandtererUtsendingAv(Melding melding);
    void sendMelding(Abonnent abonnent, Melding melding);
}
