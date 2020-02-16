package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.epost.EpostMelding;
import no.sonat.meldingsvarsler.facebook.FacebookMelding;
import no.sonat.meldingsvarsler.meldinger.MeldingRepository;
import no.sonat.meldingsvarsler.meldinger.MeldingRepositoryWriter;
import no.sonat.meldingsvarsler.sms.SMSMelding;

import java.util.ArrayList;
import java.util.List;

public class MeldingRepositoryStub implements MeldingRepository, MeldingRepositoryWriter {
    List<Melding> meldinger = new ArrayList<>();
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
