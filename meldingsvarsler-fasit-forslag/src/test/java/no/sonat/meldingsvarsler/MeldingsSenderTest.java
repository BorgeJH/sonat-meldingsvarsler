package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.epost.EpostAbonnent;
import no.sonat.meldingsvarsler.epost.EpostMelding;
import no.sonat.meldingsvarsler.epost.EpostProsessor;
import no.sonat.meldingsvarsler.facebook.FacebookAbonnent;
import no.sonat.meldingsvarsler.facebook.FacebookMelding;
import no.sonat.meldingsvarsler.facebook.FacebookProsessor;
import no.sonat.meldingsvarsler.sms.SMSAbonnent;
import no.sonat.meldingsvarsler.sms.SMSMelding;
import no.sonat.meldingsvarsler.sms.SMSProsessor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MeldingsSenderTest {
    final AbonnentRespositoryStub abonnentRespositoryStub = new AbonnentRespositoryStub();
    final List<MeldingProsessor> meldingProsessorer = new ArrayList<>();

    @BeforeEach
    void initEach() {
        meldingProsessorer.add(new EpostProsessor());
        meldingProsessorer.add(new FacebookProsessor());
        meldingProsessorer.add(new SMSProsessor());

        abonnentRespositoryStub.leggTilAbonnent(new SMSAbonnent("Per Hansen", "90965253"));
        abonnentRespositoryStub.leggTilAbonnent(new SMSAbonnent("Mohammed Normann", "77881111"));
        abonnentRespositoryStub.leggTilAbonnent(new SMSAbonnent("Per Abdullah", "77881111"));
        abonnentRespositoryStub.leggTilAbonnent(new SMSAbonnent("Knut Pettersen", "7766555"));
        abonnentRespositoryStub.leggTilAbonnent(new EpostAbonnent("Per Hansen", "per@epost.no"));
        abonnentRespositoryStub.leggTilAbonnent(new EpostAbonnent("Kari Normann", "kari.normann@epost.no"));
        abonnentRespositoryStub.leggTilAbonnent(new FacebookAbonnent("Per Hansen", "per@eepost.no"));
    }

    @Test
    public void sendMeldingerTest() {

        MeldingSender meldingSender = new MeldingSender(abonnentRespositoryStub, meldingProsessorer);

        meldingSender.sendMelding(
                new SMSMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!"));

        meldingSender.sendMelding(
                new EpostMelding("Løp og kjøp. Førstemann til mølla!!",
                        "Vårens kleskolleksjon har kommet. "));
        meldingSender.sendMelding(
                new FacebookMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!! Del på Facebook.")
        );

    }
}