package no.sonat.meldingsvarsler.meldinger;

import no.sonat.meldingsvarsler.infrastructure.abonnent.Abonnent;
import no.sonat.meldingsvarsler.meldinger.Melding;

public interface MeldingProsessor<M extends Melding, A extends Abonnent> {
    boolean haandtererUtsendingAv(Melding melding);
    void sendMelding(A abonnent, M melding);
}
