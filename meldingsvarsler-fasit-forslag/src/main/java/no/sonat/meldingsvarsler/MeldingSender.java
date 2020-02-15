package no.sonat.meldingsvarsler;

import java.util.List;

public class SMSVarsler {
    private List<String> abonnenter;
    private String melding;

    public void sendMelding(List<Abonnent> abonnenter, Melding melding) {
        abonnenter.
                forEach(abonnent -> sendMelding(abonnent, melding));
    }

    private void sendSMelding(Abonnent abonnent, Melding melding) {
        System.out.println("TLF: " + abonnent + " " + melding);
    }

}
