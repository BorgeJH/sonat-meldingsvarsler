namespace App {
    public interface IAbonnent {
        string Navn { get; }
        bool ErAktiv { get; }
        bool AbonnererPaa(IMelding melding);

    }
}
