using System;

namespace App {
    public class FacebookProsessor : IMeldingProsessor {
    
        public bool HaandtererUtsendingAv(IMelding melding) {
            return melding is FacebookMelding;
        }

    
        public void SendMelding(IAbonnent abonnent, IMelding melding) {
            SendFaceMelding(((FacebookAbonnent) abonnent), (FacebookMelding) melding);
        }

        public void SendFaceMelding(FacebookAbonnent facebookAbonnent, FacebookMelding facebookMelding) {
            Console.Out.WriteLine("Sender Facebook melding til "
                                + facebookAbonnent.Navn
                                + " => " + facebookMelding.Melding);
        }
    }
}
