package no.sonat.meldingsvarsler.intrastructure;

import no.sonat.meldingsvarsler.abonnent.SMSAbonnent;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbonnentFileRepository {
    public List<SMSAbonnent> hentAbonnenter() {
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
        return abonnenter;
    }

    public void leggTilAbonnent(SMSAbonnent smsAbonnent) throws IOException {
        File file = new File("abonnenter.csv");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            StringBuffer sb = new StringBuffer();
            sb.append(smsAbonnent.navn()+"," + smsAbonnent.telefonnummer());
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

}
