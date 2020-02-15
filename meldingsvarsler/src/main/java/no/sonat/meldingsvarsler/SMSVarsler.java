package no.sonat.meldingsvarsler;

import java.util.List;

public class SMSVarsler {
    private List<String> abonnenter;
    private String melding;
    public void addAbonnenter(List<String> abonnenter){
        this.abonnenter = abonnenter;
    }
    public void sendMelding(final String melding) {
        abonnenter.forEach(abonnent -> sendSMS(abonnent, melding));
    }

    private void sendSMS(String abonnent, String melding) {
    }
}
