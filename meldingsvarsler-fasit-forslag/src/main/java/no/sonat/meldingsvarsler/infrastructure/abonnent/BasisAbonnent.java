package no.sonat.meldingsvarsler.infrastructure.abonnent;

import no.sonat.meldingsvarsler.meldinger.Melding;
/*
Open Closed Principle
Vi kan endre implementasjonen av BasisAbonnent, og interfacet Abonnent uten at
klasser som extender BasisAbonnent trenger å vite om dette
 */
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
