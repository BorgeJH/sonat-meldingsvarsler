package no.sonat.meldingsvarsler;

import java.io.*;
import java.util.*;

public class MeldingSender {
    public Map<String, String> smsAbonnenter = new HashMap<>();
    public Map<String, String> epostAbonnenter = new HashMap<>();

    public void sendSmsMelding(String melding) {
        smsAbonnenter.entrySet().
            forEach(abonnent -> sendSms(abonnent.getKey() , abonnent.getValue(), melding));
    }

    public void sendEpostMelding(String epostTittel, String epostTekst) {
        epostAbonnenter.entrySet()
                .forEach(abonnent -> sendEpost(abonnent.getKey(), abonnent.getValue(), epostTittel, epostTekst));
    }

    public void hentEpostAbonnenter() {
        epostAbonnenter.clear();
        File file = new File("epostabonnenter.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuffer buffer = new StringBuffer();
            while((line = reader.readLine()) != null) {
                List<String> values = Arrays.asList(line.toString().split(","));
                epostAbonnenter.put(values.get(0),values.get(1));

            }
        } catch (IOException e) {
        }

    }

    public void hentSmsAbonnenter() {
        smsAbonnenter.clear();
        File file = new File("smsabonnenter.csv");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuffer buffer = new StringBuffer();
            while((line = reader.readLine()) != null) {
                List<String> values = Arrays.asList(line.toString().split(","));
                smsAbonnenter.put(values.get(0),values.get(1));

            }
        } catch (IOException e) {
        }
    }

    public void leggTilSmsAbonnent(String navn, String telefonnummer) {
        smsAbonnenter.put(navn, telefonnummer);
    }

    public void leggTilEpostAbonnent(String epost, String navn) {
        epostAbonnenter.put(epost, navn);
    }

    public void lagreSmsAbonnenter() {
        File file = new File("smsabonnenter.csv");
        FileWriter fileWriter = null;
        try {
            StringBuffer sb = new StringBuffer();
            smsAbonnenter.entrySet()
                    .forEach(abonnent -> sb.append(abonnent.getKey() +"," +  abonnent.getValue()));

            fileWriter = new FileWriter(file);
            fileWriter.append(sb.toString());
        } catch (IOException e) {
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void lagreEpostAbonnenter() {
        File file = new File("epostabonnenter.csv");
        FileWriter fileWriter = null;
        try {
            StringBuffer sb = new StringBuffer();
            epostAbonnenter.entrySet()
                    .forEach(abonnent -> sb.append(abonnent.getKey() +"," +  abonnent.getValue()));

            fileWriter = new FileWriter(file);
            fileWriter.append(sb.toString());
        } catch (IOException e) {
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendSms(String navn, String telefonnummer, String tekstmelding) {
        System.out.println("Sender SMS til "
                + telefonnummer
                + "(" + navn + ")"
                + " => " + tekstmelding
        );
    }

    private void sendEpost(String epostAdresse, String navn, String eposttittel, String epostmelding) {
        System.out.println("Sender Epost til "
                + epostAdresse
                + "(" + navn + ")"
                + " => " + eposttittel
                + " => " + epostmelding);
    }
}
