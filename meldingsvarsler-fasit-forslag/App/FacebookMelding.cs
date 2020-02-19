namespace App {
    public class FacebookMelding : IMelding
    {
        public FacebookMelding(string tekst)
        {
            Melding = tekst;
        }

        public string Melding { get; }
    }
}