package no.sonat.meldingsvarsler;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SMSVarsler {
    private List<String> abonnenter;
    private String melding;
    public void leggTilbonnenter(List<String> abonnenter){
        this.abonnenter = abonnenter;
    }

    public void leggTilAbonnent(String abonnent){
        this.abonnenter.add(abonnent);
    }

    public void sendMelding(final String melding) {
        abonnenter.forEach(abonnent -> sendSms(abonnent, melding));
    }

    private void sendSms(String abonnent, String melding) {
        System.out.println("TLF: " + abonnent + " " + melding);
    }

    public void hentAbonnenter() {
        File file = new File("abonnenter.csv");
        try (
            BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuffer buffer = new StringBuffer();
            while((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            this.abonnenter = Arrays.asList(buffer.toString().split(","));
        } catch (IOException e) {
        }
    }

    public void lagreAbonnenter() throws IOException {
        File file = new File("abonnenter.csv");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(abonnenter.stream().collect(Collectors.joining(",")));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
