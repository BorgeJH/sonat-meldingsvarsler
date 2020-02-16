package no.sonat.meldingsvarsler.infrastructure.meldinger;

import no.sonat.meldingsvarsler.meldinger.Melding;

import java.util.Collections;
import java.util.List;

public class JdbcMeldingRepository implements MeldingRepository, MeldingRepositoryWriter {
    @Override
    public List<Melding> hentMeldinger(){
        // Les meldinger fra database
        return Collections.emptyList();
    }

    @Override
    public void leggTilMelding(Melding melding) {
        // Legg til melding i database
    }
}
