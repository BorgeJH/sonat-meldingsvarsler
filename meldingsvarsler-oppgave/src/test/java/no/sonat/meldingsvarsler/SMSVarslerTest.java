package no.sonat.meldingsvarsler;

import org.junit.jupiter.api.Test;
import java.io.IOException;

class SMSVarslerTest {

    @Test
    public void sendMeldingerTest() throws IOException {
        SMSVarsler smsVarsler = new SMSVarsler();
        smsVarsler.hentAbonnenter();
        SMSMelding smsMelding = new SMSMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!");
        smsVarsler.sendMelding(smsMelding);
    }
}