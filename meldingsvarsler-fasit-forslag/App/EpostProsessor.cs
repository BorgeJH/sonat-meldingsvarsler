using System;

namespace App
{
    public class EpostProsessor : IMeldingProsessor
    {
        public bool HaandtererUtsendingAv(IMelding melding)
        {
            return melding is EpostMelding;
        }

        public void SendMelding(IAbonnent abonnent, IMelding melding)
        {
            SendEpost((EpostAbonnent) abonnent, (EpostMelding) melding);
        }

        public void SendEpost(EpostAbonnent epostAbonnent, EpostMelding epostMelding)
        {
            Console.Out.WriteLine("Sender Epost til "
                                + epostAbonnent.EpostAdresse
                                + "(" + epostAbonnent.Navn + ")"
                                + " => " + epostMelding.Tittel
                                + " => " + epostMelding.Melding);
        }
    }
}