namespace App {
    public class EpostMelding : IMelding
    {
        public EpostMelding(string tekst, string tittel)
        {
            Melding = tekst;
            Tittel = tittel;
        }

        public string Melding { get; }

        public string Tittel { get; }
    }
}