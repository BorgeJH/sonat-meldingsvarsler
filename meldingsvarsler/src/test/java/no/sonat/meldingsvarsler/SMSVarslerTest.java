package no.sonat.meldingsvarsler;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SMSVarslerTest {

    @Test
    public void sendMeldingerTest() throws IOException {
        SMSVarsler smsVarsler = new SMSVarsler();
        smsVarsler.leggTilbonnenter(Arrays.asList("90965253","77626276","77788112"));
        smsVarsler.lagreAbonnenter();
        smsVarsler.hentAbonnenter();
        smsVarsler.sendMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!");
    }
}