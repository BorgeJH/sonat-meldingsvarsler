package no.sonat.meldingsvarsler;

import org.junit.jupiter.api.Test;
import java.io.IOException;

class SMSVarslerTest {

    @Test
    public void sendSmsMeldingerTest() throws IOException {
        MeldingSender smsVarsler = new MeldingSender();
        smsVarsler.hentSmsAbonnenter();
        String smsMelding = "Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!";
        smsVarsler.sendSmsMelding(smsMelding);
    }

    @Test
    public void sendEpostMeldingerTest() throws IOException {
        MeldingSender smsVarsler = new MeldingSender();
        smsVarsler.hentEpostAbonnenter();
        String epostTittel = "Tilbud";
        String epostMelding = "Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!";
        smsVarsler.sendEpostMelding(epostTittel, epostMelding);
    }

    @Test
    public void statistikk() {
        MeldingSender smsVarsler = new MeldingSender();
        smsVarsler.hentSmsAbonnenter();
        smsVarsler.hentEpostAbonnenter();

        System.out.println("SMS Abonnenter : " + smsVarsler.smsAbonnenter.entrySet().size());
        System.out.println("Epost Abonnenter : " + smsVarsler.epostAbonnenter.entrySet().size());
    }
}