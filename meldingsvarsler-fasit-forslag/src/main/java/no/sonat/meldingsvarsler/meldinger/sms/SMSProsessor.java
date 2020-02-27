package no.sonat.meldingsvarsler.meldinger.sms;

import no.sonat.meldingsvarsler.meldinger.Melding;
import no.sonat.meldingsvarsler.meldinger.MeldingProsessor;
/*
Single Responsibility Principle
Håndterer kun utsendelse av SMSMeldinger
 */
public class SMSProsessor implements MeldingProsessor<SMSMelding, SMSAbonnent> {

    @Override
    public boolean haandtererUtsendingAv(Melding melding) {
        return melding instanceof SMSMelding;
    }

    @Override
    public void sendMelding(SMSAbonnent smsAbonnent, SMSMelding smsMelding) {
        sendSms(smsAbonnent, smsMelding);
    }

    public void sendSms(SMSAbonnent smsAbonnent, SMSMelding smsMelding) {
        System.out.println("Sender SMS til "
                + smsAbonnent.telefonnummer()
                + " (" + smsAbonnent.navn() + ")"
                + " => " + smsMelding.tekstmelding
        );
    }
}

