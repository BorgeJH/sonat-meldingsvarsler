namespace App
{
    public class SmsAbonnent
    {
        public SmsAbonnent(string navn, string telefonNummer)
        {
            Navn = navn;
            TelefonNummer = telefonNummer;
        }

        public string Navn { get; }

        public bool ErAktiv => true;

        public string TelefonNummer { get; }
    }
}