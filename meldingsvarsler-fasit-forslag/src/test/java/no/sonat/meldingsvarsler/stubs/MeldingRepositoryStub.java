package no.sonat.meldingsvarsler.stubs;

import no.sonat.meldingsvarsler.meldinger.Melding;
import no.sonat.meldingsvarsler.meldinger.epost.EpostMelding;
import no.sonat.meldingsvarsler.meldinger.facebook.FacebookMelding;
import no.sonat.meldingsvarsler.infrastructure.meldinger.MeldingRepository;
import no.sonat.meldingsvarsler.infrastructure.meldinger.MeldingRepositoryWriter;
import no.sonat.meldingsvarsler.meldinger.sms.SMSMelding;

import java.util.ArrayList;
import java.util.List;

public class MeldingRepositoryStub implements MeldingRepository, MeldingRepositoryWriter {
    final List<Melding> meldinger = new ArrayList<>();
    @Override
    public List<Melding> hentMeldinger(){
        meldinger.add(new SMSMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!"));
        meldinger.add(new EpostMelding("Løp og kjøp. Førstemann til mølla!!",
                "Vårens kleskolleksjon har kommet. "));
        meldinger.add(new FacebookMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!! Del på Facebook."));
        return meldinger;
    }

    @Override
    public void leggTilMelding(Melding melding) {

    }
}
