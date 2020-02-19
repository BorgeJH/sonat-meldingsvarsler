using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

namespace App {
    public class SmsVarsler 
    {
        List<string> abonnenter;
        string melding;

        public void LeggTilAbonnenter(List<string> abonnenter){
            this.abonnenter = abonnenter;
        }

        public void LeggTilAbonnent(string abonnent){
            abonnenter.Add(abonnent);
        }

        public void SendMelding(string melding) {
            abonnenter.ForEach(abonnent => SendSms(abonnent, melding));
        }

        void SendSms(string abonnent, string melding) {
            Console.Out.WriteLine("TLF: " + abonnent + " " + melding);
        }

        public void HentAbonnenter() 
        {
            var fileStream = File.OpenRead("abonnenter.csv");
            var reader = new StreamReader(fileStream);
            string line;
            var buffer = new StringBuilder();
            while((line = reader.ReadLine()) != null)
            {
                if (buffer.Length > 0) buffer.Append(",");
                buffer.Append(line);
            }

            abonnenter = buffer.ToString().Split(',').ToList();
        }

        public void LagreAbonnenter()
        {
            var fileStream = File.OpenWrite("abonnenter.csv");
            var fileWriter = new StreamWriter(fileStream);
            fileWriter.Write(string.Join(",", abonnenter));
            fileWriter.Close();
        }
    }
}
