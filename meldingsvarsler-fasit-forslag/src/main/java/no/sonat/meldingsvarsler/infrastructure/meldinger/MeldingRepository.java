package no.sonat.meldingsvarsler.infrastructure.meldinger;

import no.sonat.meldingsvarsler.meldinger.Melding;

import java.util.List;

public interface MeldingRepository {
    List<Melding> hentMeldinger();
}
