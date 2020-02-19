namespace App {
    public interface IMeldingProsessor
    {
        bool HaandtererUtsendingAv(IMelding melding);
        void SendMelding(IAbonnent abonnent, IMelding melding);
    }
}