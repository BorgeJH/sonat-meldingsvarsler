package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.abonnent.Abonnent;
import no.sonat.meldingsvarsler.abonnent.AbonnentRepository;

import java.util.List;

public class MeldingSender {
    private final AbonnentRepository abonnentRespository;
    private final List<MeldingProsessor> meldingProsessorer;

    public MeldingSender(AbonnentRepository abonnentRespository, List<MeldingProsessor> meldingProsessors) {
        this.abonnentRespository = abonnentRespository;
        this.meldingProsessorer = meldingProsessors;
    }

    public void sendMelding(Melding melding) {
        abonnentRespository.hentAbonnenter().stream()
                .filter(abonnent -> abonnent.abonnererPaa( melding))
                .forEach(abonnent -> sendMelding(abonnent, melding));
    }

    private void sendMelding(Abonnent abonnent, Melding melding) {
        meldingProsessorer.stream()
                .filter(meldingProsessor -> meldingProsessor.stoetterMeldingstype(melding))
                .forEach(meldingProsessor -> meldingProsessor.sendMelding(abonnent, melding));
    }

}
