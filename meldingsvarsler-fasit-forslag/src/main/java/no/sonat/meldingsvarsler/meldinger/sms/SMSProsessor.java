package no.sonat.meldingsvarsler.meldinger.sms;

import no.sonat.meldingsvarsler.infrastructure.abonnent.Abonnent;
import no.sonat.meldingsvarsler.meldinger.Melding;
import no.sonat.meldingsvarsler.meldinger.MeldingProsessor;

public class SMSProsessor implements MeldingProsessor {

    @Override
    public boolean haandtererUtsendingAv(Melding melding) {
        return melding instanceof SMSMelding;
    }

    @Override
    public void sendMelding(Abonnent abonnent, Melding melding) {
        sendSms((SMSAbonnent) abonnent, (SMSMelding) melding);
    }

    public void sendSms(SMSAbonnent smsAbonnentt, SMSMelding smsMelding) {
        System.out.println("Sender SMS til "
                + smsAbonnentt.telefonnummer()
                + " => " + smsMelding.tekstmelding
        );
    }
}

