namespace App {
    public class FacebookAbonnent : IAbonnent
    {
        public FacebookAbonnent(string navn, string brukernavn)
        {
            Brukernavn = brukernavn;
            Navn = navn;
        }

        public string Navn { get; }

        public bool ErAktiv => true;

        public string Brukernavn { get; }

        public bool AbonnererPaa(IMelding melding)
        {
            return melding is FacebookMelding;
        }
    }
}