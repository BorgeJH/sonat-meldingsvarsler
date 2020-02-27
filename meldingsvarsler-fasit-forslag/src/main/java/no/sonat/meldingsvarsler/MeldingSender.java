package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.infrastructure.abonnent.AbonnentRepositoryReader;
import no.sonat.meldingsvarsler.infrastructure.meldinger.MeldingRepository;
import no.sonat.meldingsvarsler.meldinger.MeldingProsessor;

import java.util.List;

public class MeldingSender {
    private final MeldingRepository meldingRepository;
    private final AbonnentRepositoryReader abonnentRespository;
    private final List<MeldingProsessor> meldingProsessorer;

    /*
    Dependency Inversion Principle :
    abonnentRespository, meldingRepository, meldingProsessors
    */
    public MeldingSender(MeldingRepository meldingRepository,
            AbonnentRepositoryReader abonnentRespository,
            List<MeldingProsessor> meldingProsessors) {
        this.abonnentRespository = abonnentRespository;
        this.meldingProsessorer = meldingProsessors;
        this.meldingRepository = meldingRepository;
    }

    public void sendMeldinger() {
        meldingRepository.hentMeldinger().forEach(melding -> {
            meldingProsessorer.stream()
                .filter(meldingProsessor -> meldingProsessor.haandtererUtsendingAv(melding))
                .forEach(meldingProsessor -> {
                    abonnentRespository.hentAbonnenter().stream()
                            .filter(abonnent -> abonnent.abonnererPaa(melding))
                            .forEach(abonnent -> meldingProsessor.sendMelding(abonnent, melding));
                });
        });
    }
}
