package no.sonat.meldingsvarsler.abonnent;

import no.sonat.meldingsvarsler.Melding;

public interface Abonnent {
    String navn();
    Boolean erAktiv();
    boolean abonnererPaa(Melding melding);

}
