package no.sonat.meldingsvarsler;

import java.io.IOException;
import java.util.List;

public interface AbonnentRepository {
    void leggTilAbonnent(Abonnent abonnent);
    List<Abonnent> hentAbonnenter();
}
