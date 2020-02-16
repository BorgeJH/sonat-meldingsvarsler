package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.abonnent.SMSAbonnent;
import no.sonat.meldingsvarsler.intrastructure.AbonnentFileRepository;
import no.sonat.meldingsvarsler.meldinger.sms.SMSMelding;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeldingSender {
    private List<SMSAbonnent> abonnenter;

    public void hentAbonnenter() {
        abonnenter = new AbonnentFileRepository().hentAbonnenter();
    }

    public void leggTilAbonnent(SMSAbonnent smsAbonnent) throws IOException {
        new AbonnentFileRepository().leggTilAbonnent(smsAbonnent);
    }

    public void sendMelding(SMSMelding melding) {
        abonnenter.forEach(abonnent -> sendSms(abonnent, melding));
    }

    private void sendSms(SMSAbonnent abonnent, SMSMelding melding) {
        System.out.println("TLF: " + abonnent.navn() + " (" + abonnent.telefonnummer() +") => " + melding.melding());
    }

}
