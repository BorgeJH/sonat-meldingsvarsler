package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.abonnent.Abonnent;
import no.sonat.meldingsvarsler.abonnent.AbonnentRepositoryReader;
import no.sonat.meldingsvarsler.abonnent.AbonnentRepositoryWriter;

import java.util.ArrayList;
import java.util.List;

public class AbonnentRespositoryStub implements AbonnentRepositoryReader, AbonnentRepositoryWriter {
    private final List<Abonnent> abonnenter;

    public AbonnentRespositoryStub() {
        abonnenter = new ArrayList<>();
    }

    @Override
    public void leggTilAbonnent(Abonnent abonnent) {
        abonnenter.add(abonnent);
    }

    @Override
    public List<Abonnent> hentAbonnenter() {
        return abonnenter;
    }
}
