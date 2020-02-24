package no.sonat.meldingsvarsler.infrastructure.abonnent;

import no.sonat.meldingsvarsler.meldinger.Melding;

public abstract class BasisAbonnent implements Abonnent {
    private final String navn;

    protected BasisAbonnent(String navn) {
        this.navn = navn;
    }

    public String navn() {
        return navn;
    }
    public Boolean erAktiv(){
        return true;
    };
    public boolean abonnererPaa(Melding melding) {
        return false;
    };

}
