package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.infrastructure.abonnent.AbonnentRepositoryReader;
import no.sonat.meldingsvarsler.infrastructure.abonnent.AbonnentRepositoryStatistikk;
import no.sonat.meldingsvarsler.infrastructure.abonnent.AbonnentRepositoryWriter;
import no.sonat.meldingsvarsler.meldinger.MeldingProsessor;
import no.sonat.meldingsvarsler.meldinger.epost.EpostAbonnent;
import no.sonat.meldingsvarsler.meldinger.epost.EpostMelding;
import no.sonat.meldingsvarsler.meldinger.epost.EpostProsessor;
import no.sonat.meldingsvarsler.meldinger.facebook.FacebookAbonnent;
import no.sonat.meldingsvarsler.meldinger.facebook.FacebookMelding;
import no.sonat.meldingsvarsler.meldinger.facebook.FacebookProsessor;
import no.sonat.meldingsvarsler.infrastructure.meldinger.MeldingRepository;
import no.sonat.meldingsvarsler.infrastructure.meldinger.MeldingRepositoryWriter;
import no.sonat.meldingsvarsler.meldinger.sms.SMSAbonnent;
import no.sonat.meldingsvarsler.meldinger.sms.SMSMelding;
import no.sonat.meldingsvarsler.meldinger.sms.SMSProsessor;
import no.sonat.meldingsvarsler.stubs.AbonnentRespositoryStub;
import no.sonat.meldingsvarsler.stubs.MeldingRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MeldingsSenderTest {
    final MeldingRepositoryStub meldingRespositoryStub = new MeldingRepositoryStub();
    final AbonnentRespositoryStub abonnentRespositoryStub = new AbonnentRespositoryStub();

    final MeldingRepository meldingRepositoryReader = meldingRespositoryStub;
    final AbonnentRepositoryReader abonnentRespositoryReader = abonnentRespositoryStub;
    final AbonnentRepositoryStatistikk abonnentRepositoryStatistikk = abonnentRespositoryStub;
    final List<MeldingProsessor> meldingProsessorer = new ArrayList<>();
    final MeldingSender meldingSender = new MeldingSender(meldingRepositoryReader, abonnentRespositoryReader, meldingProsessorer);

    @BeforeEach
    void initEach() {
        final AbonnentRepositoryWriter abonnentRespositoryWriter = abonnentRespositoryStub;
        final MeldingRepositoryWriter meldingRespositoryWriter = meldingRespositoryStub;

        meldingProsessorer.add(new EpostProsessor());
        meldingProsessorer.add(new FacebookProsessor());
        meldingProsessorer.add(new SMSProsessor());

        meldingRespositoryWriter.leggTilMelding(new SMSMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!"));
        meldingRespositoryWriter.leggTilMelding(new EpostMelding("Løp og kjøp. Førstemann til mølla!!",
                "Vårens kleskolleksjon har kommet. "));
        meldingRespositoryWriter.leggTilMelding(new FacebookMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!! Del på Facebook."));

        abonnentRespositoryWriter.leggTilAbonnent(new SMSAbonnent("Per Hansen", "90965253"));
        abonnentRespositoryWriter.leggTilAbonnent(new SMSAbonnent("Mohammed Normann", "77881111"));
        abonnentRespositoryWriter.leggTilAbonnent(new SMSAbonnent("Per Abdullah", "77881111"));
        abonnentRespositoryWriter.leggTilAbonnent(new SMSAbonnent("Knut Pettersen", "7766555"));
        abonnentRespositoryWriter.leggTilAbonnent(new EpostAbonnent("Per Hansen", "per@epost.no"));
        abonnentRespositoryWriter.leggTilAbonnent(new EpostAbonnent("Kari Normann", "kari.normann@epost.no"));
        abonnentRespositoryWriter.leggTilAbonnent(new FacebookAbonnent("Per Hansen", "per@eepost.no"));
    }

    @Test
    public void sendMeldingerTest() {
        meldingSender.sendMeldinger();
    }

    @Test
    public void statistikk(){
        abonnentRespositoryReader.hentAbonnenter().stream()
                .map(abonnent -> abonnent.getClass())
                .distinct()
                .forEach(aClass ->
                    System.out.println(aClass.getSimpleName() + ":" + abonnentRepositoryStatistikk.antallAbonnererPaa(aClass)
                ));
    }
}