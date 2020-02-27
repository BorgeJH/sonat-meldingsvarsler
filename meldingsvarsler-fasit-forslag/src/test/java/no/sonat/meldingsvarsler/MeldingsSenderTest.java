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
import no.sonat.meldingsvarsler.stubs.AbonnentRepositoryStub;
import no.sonat.meldingsvarsler.stubs.MeldingRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MeldingsSenderTest {
    final MeldingRepositoryStub meldingRepositoryStub = new MeldingRepositoryStub();
    final AbonnentRepositoryStub abonnentRepositoryStub = new AbonnentRepositoryStub();

    final MeldingRepository meldingRepositoryReader = meldingRepositoryStub;
    final AbonnentRepositoryReader abonnentRepositoryReader = abonnentRepositoryStub;
    final AbonnentRepositoryStatistikk abonnentRepositoryStatistikk = abonnentRepositoryStub;
    final List<MeldingProsessor> meldingProsessorer = new ArrayList<>();
    final MeldingSender meldingSender = new MeldingSender(meldingRepositoryReader, abonnentRepositoryReader, meldingProsessorer);
    final AbonnentRepositoryWriter abonnentRepositoryWriter = abonnentRepositoryStub;
    final MeldingRepositoryWriter meldingRepositoryWriter = meldingRepositoryStub;

    @BeforeEach
    void initEach() {
        meldingProsessorer.add(new EpostProsessor());
        meldingProsessorer.add(new FacebookProsessor());
        meldingProsessorer.add(new SMSProsessor());

        meldingRepositoryWriter.leggTilMelding(new SMSMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!"));
        meldingRepositoryWriter.leggTilMelding(new EpostMelding("Løp og kjøp. Førstemann til mølla!!",
                "Vårens kleskolleksjon har kommet. "));
        meldingRepositoryWriter.leggTilMelding(new FacebookMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!! Del på Facebook."));

        abonnentRepositoryWriter.leggTilAbonnent(new SMSAbonnent("Per Hansen", "909 65 253"));
        abonnentRepositoryWriter.leggTilAbonnent(new SMSAbonnent("Mohammed Normann", "77881111"));
        abonnentRepositoryWriter.leggTilAbonnent(new SMSAbonnent("Per Abdullah", "77881111"));
        abonnentRepositoryWriter.leggTilAbonnent(new SMSAbonnent("Knut Pettersen", "77665551"));
        abonnentRepositoryWriter.leggTilAbonnent(new EpostAbonnent("Per Hansen", "per@epost.no"));
        abonnentRepositoryWriter.leggTilAbonnent(new EpostAbonnent("Kari Normann", "kari.normann@epost.no"));
        abonnentRepositoryWriter.leggTilAbonnent(new FacebookAbonnent("Per Knutsen", "per.knutsen@epost.no"));
    }

    @Test
    public void sendMeldinger() {
        meldingSender.sendMeldinger();
    }

    @Test
    public void visStatistikk(){
        abonnentRepositoryReader.hentAbonnenter().stream()
                .map(abonnent -> abonnent.getClass())
                .distinct()
                .forEach(aClass ->
                    System.out.println(aClass.getSimpleName() + ":" + abonnentRepositoryStatistikk.antallAbonnererPaa(aClass)
                ));
    }
}