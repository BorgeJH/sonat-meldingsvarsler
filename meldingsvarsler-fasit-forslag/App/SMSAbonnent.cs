namespace App {
    public class SmsAbonnent : IAbonnent
    {
        public SmsAbonnent(string navn, string telefonNummer)
        {
            Navn = navn;
            TelefonNummer = telefonNummer;
        }


        public bool AbonnererPaa(IMelding melding)
        {
            return melding is SmsMelding;
        }


        public string Navn { get; }

        public bool ErAktiv => true;

        public string TelefonNummer { get; }
    }
}