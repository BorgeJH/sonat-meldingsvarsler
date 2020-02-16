package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.meldinger.sms.SMSMelding;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class SMSVarslerTest {

    @Test
    public void sendMeldingerTest() throws IOException {
        MeldingSender smsVarsler = new MeldingSender();
        smsVarsler.hentAbonnenter();
        SMSMelding smsMelding = new SMSMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!");
        smsVarsler.sendMelding(smsMelding);
    }
}