package no.sonat.meldingsvarsler.infrastructure.abonnent;

import no.sonat.meldingsvarsler.meldinger.Melding;

import java.util.Collections;
import java.util.List;

public class JdbcAbonnentRepository implements AbonnentRepositoryReader, AbonnentRepositoryWriter, AbonnentRepositoryStatistikk {
    @Override
    public void leggTilAbonnent(Abonnent abonnent){
        // Legg til abonnent i database
    }

    @Override
    public List<Abonnent> hentAbonnenter() {
        // Hent alle abbonenter fra database
        return Collections.emptyList();
    }

    @Override
    public long totaltAntallAbonnenter() {
        return 0;
    }

    @Override
    public long antallAbonnererPaa(Class abonnentClazz) {
        return 0;
    }
}
