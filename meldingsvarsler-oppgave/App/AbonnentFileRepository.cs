using System.Collections.Generic;
using System.IO;
using System.Text;

namespace App {
    public class AbonnentFileRepository
    {
        public List<SmsAbonnent> HentAbonnenter()
        {
            var abonnenter = new List<SmsAbonnent>();

            var fileStream = File.OpenRead("abonnenter.csv");
            var reader = new StreamReader(fileStream);
            string line;
            while ((line = reader.ReadLine()) != null)
            {
                var values = line.Split(',');
                var smsAbonnent = new SmsAbonnent(values[0], values[1]);
                abonnenter.Add(smsAbonnent);
            }

            return abonnenter;
        }

        public void LeggTilAbonnent(SmsAbonnent smsAbonnent)
        {
            var fileStream = File.OpenWrite("abonnenter.csv");
            var fileWriter = new StreamWriter(fileStream);
            var sb = new StringBuilder();
            sb.Append(smsAbonnent.Navn + "," + smsAbonnent.TelefonNummer);
            fileWriter.Write(sb.ToString());
        }
    }
}