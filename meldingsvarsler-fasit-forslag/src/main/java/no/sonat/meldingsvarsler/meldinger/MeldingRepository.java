package no.sonat.meldingsvarsler.meldinger;

import no.sonat.meldingsvarsler.Melding;

import java.util.List;

public interface MeldingRepository {
    List<Melding> hentMeldinger();
}
