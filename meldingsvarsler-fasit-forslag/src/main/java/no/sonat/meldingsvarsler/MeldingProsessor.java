package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.abonnent.Abonnent;

public interface MeldingProsessor {
    boolean stoetterMeldingstype(Melding melding);
    void sendMelding(Abonnent abonnent, Melding melding);
}
