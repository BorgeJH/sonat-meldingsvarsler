namespace App {
    public class SmsMelding : IMelding
    {
        public SmsMelding(string tekstMelding)
        {
            Melding = tekstMelding;
        }

        public string Melding { get; }
    }
}