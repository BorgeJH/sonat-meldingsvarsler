package no.sonat.meldingsvarsler.meldinger;

import no.sonat.meldingsvarsler.Melding;
import no.sonat.meldingsvarsler.epost.EpostMelding;
import no.sonat.meldingsvarsler.facebook.FacebookMelding;
import no.sonat.meldingsvarsler.sms.SMSMelding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcMeldingRepository implements MeldingRepository, MeldingRepositoryWriter {
    @Override
    public List<Melding> hentMeldinger(){
        // Les meldinger fra database
        return Collections.emptyList();
    }

    @Override
    public void leggTilMelding(Melding melding) {
        // Legg til melding i database
    }
}
