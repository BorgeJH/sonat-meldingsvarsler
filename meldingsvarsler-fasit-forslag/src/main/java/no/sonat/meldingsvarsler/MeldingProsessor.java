package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.abonnent.Abonnent;

public interface MeldingProsessor {
    boolean haandtererUtsendingAv(Melding melding);
    void sendMelding(Abonnent abonnent, Melding melding);
}
