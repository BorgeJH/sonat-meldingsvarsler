package no.sonat.meldingsvarsler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SMSVarsler {
    private List<SMSAbonnent> abonnenter;

    public void hentAbonnenter() {
        File file = new File("abonnenter.csv");
        List<SMSAbonnent> abonnenter = new ArrayList<>();
        try (
            BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuffer buffer = new StringBuffer();
            while((line = reader.readLine()) != null) {
                List<String> values = Arrays.asList(line.toString().split(","));
                SMSAbonnent smsAbonnent = new SMSAbonnent(values.get(0), values.get(1));
                abonnenter.add(smsAbonnent);

            }
        } catch (IOException e) {
        }
        this.abonnenter = abonnenter;
    }

    public void leggTilAbonnent(SMSAbonnent smsAbonnent) throws IOException {
        File file = new File("abonnenter.csv");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            StringBuffer sb = new StringBuffer();
            abonnenter.stream()
                    .map(abonnent -> abonnent.navn()+"," + abonnent.telefonnummer())
                    .forEach(linje -> sb.append(linje));

            fileWriter.write(sb.toString());
        } catch (IOException e) {
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMelding(SMSMelding melding) {
        abonnenter.forEach(abonnent -> sendSms(abonnent, melding));
    }

    private void sendSms(SMSAbonnent abonnent, SMSMelding melding) {
        System.out.println("TLF: " + abonnent.navn() + " (" + abonnent.telefonnummer() +") => " + melding.tekstmelding);
    }

}
