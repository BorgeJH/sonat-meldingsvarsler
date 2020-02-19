namespace App {
    public class EpostAbonnent : IAbonnent
    {
        public EpostAbonnent(string navn, string epostAdresse)
        {
            EpostAdresse = epostAdresse;
            Navn = navn;
        }

        public bool AbonnererPaa(IMelding melding)
        {
            return melding is EpostMelding;
        }

        public string Navn { get; }

        public bool ErAktiv => true;

        public string EpostAdresse { get; }
    }
}