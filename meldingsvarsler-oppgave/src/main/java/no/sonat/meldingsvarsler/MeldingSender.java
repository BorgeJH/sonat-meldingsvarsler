package no.sonat.meldingsvarsler;

import no.sonat.meldingsvarsler.meldinger.sms.SMSAbonnent;
import no.sonat.meldingsvarsler.intrastructure.AbonnentFileRepository;
import no.sonat.meldingsvarsler.meldinger.sms.SMSMelding;
import no.sonat.meldingsvarsler.meldinger.sms.SMSProsessor;

import java.io.*;
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
        new SMSProsessor().sendSms(abonnent, melding);
    }

}
