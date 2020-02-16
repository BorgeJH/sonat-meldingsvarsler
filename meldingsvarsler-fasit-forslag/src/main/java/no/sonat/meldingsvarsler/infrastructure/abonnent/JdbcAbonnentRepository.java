package no.sonat.meldingsvarsler.infrastructure.abonnent;

import java.util.Collections;
import java.util.List;

public class JdbcAbonnentRepository implements AbonnentRepositoryReader, AbonnentRepositoryWriter {
    @Override
    public void leggTilAbonnent(Abonnent abonnent){
        // Legg til abonnent i database
    }

    @Override
    public List<Abonnent> hentAbonnenter() {
        return Collections.emptyList();
    }

}
