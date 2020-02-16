package no.sonat.meldingsvarsler.infrastructure.abonnent;

import no.sonat.meldingsvarsler.meldinger.Melding;

public interface Abonnent {
    String navn();
    Boolean erAktiv();
    boolean abonnererPaa(Melding melding);

}
