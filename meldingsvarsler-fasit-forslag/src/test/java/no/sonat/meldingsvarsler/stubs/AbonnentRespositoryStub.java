package no.sonat.meldingsvarsler.stubs;

import no.sonat.meldingsvarsler.infrastructure.abonnent.Abonnent;
import no.sonat.meldingsvarsler.infrastructure.abonnent.AbonnentRepositoryReader;
import no.sonat.meldingsvarsler.infrastructure.abonnent.AbonnentRepositoryStatistikk;
import no.sonat.meldingsvarsler.infrastructure.abonnent.AbonnentRepositoryWriter;
import no.sonat.meldingsvarsler.meldinger.Melding;

import java.util.ArrayList;
import java.util.List;

public class AbonnentRespositoryStub implements AbonnentRepositoryReader, AbonnentRepositoryWriter,
        AbonnentRepositoryStatistikk {
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

    @Override
    public long totaltAntallAbonnenter() {
        return abonnenter.size();
    }

    @Override
    public long antallAbonnererPaa(Class clazz) {
        return abonnenter.stream()
                .filter(m -> m.getClass().getName().equals(clazz.getName()))
                .count();
    }
}
