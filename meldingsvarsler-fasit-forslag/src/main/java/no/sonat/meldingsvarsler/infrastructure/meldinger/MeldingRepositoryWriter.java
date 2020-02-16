package no.sonat.meldingsvarsler.infrastructure.meldinger;

import no.sonat.meldingsvarsler.meldinger.Melding;

public interface MeldingRepositoryWriter {
    void leggTilMelding(Melding melding);
}
