package no.sonat.meldingsvarsler.infrastructure.abonnent;

import no.sonat.meldingsvarsler.meldinger.Melding;

public interface AbonnentRepositoryStatistikk {
    long totaltAntallAbonnenter();
    long antallAbonnererPaa(Class clazz);
}
