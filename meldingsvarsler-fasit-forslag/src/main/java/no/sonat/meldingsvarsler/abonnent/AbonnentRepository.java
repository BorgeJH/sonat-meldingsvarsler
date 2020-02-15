package no.sonat.meldingsvarsler.abonnent;

import java.util.List;

public interface AbonnentRepository {
    void leggTilAbonnent(Abonnent abonnent);
    List<Abonnent> hentAbonnenter();
}
