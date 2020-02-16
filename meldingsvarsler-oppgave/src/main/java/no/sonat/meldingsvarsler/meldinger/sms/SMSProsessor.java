package no.sonat.meldingsvarsler.meldinger.sms;

public class SMSProsessor {

    public void sendSms(SMSAbonnent smsAbonnent, SMSMelding smsMelding) {
        System.out.println("Sender SMS til "
                + smsAbonnent.telefonnummer()
                + "(" + smsAbonnent.navn() + ")"
                + " => " + smsMelding.tekstmelding
        );
    }
}

