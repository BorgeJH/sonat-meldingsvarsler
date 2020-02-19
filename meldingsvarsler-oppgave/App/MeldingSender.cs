using System.Collections.Generic;

namespace App {
    public class MeldingSender
    {
        List<SmsAbonnent> abonnenter;

        public void HentAbonnenter()
        {
            abonnenter = new AbonnentFileRepository().HentAbonnenter();
        }

        public void LeggTilAbonnent(SmsAbonnent smsAbonnent)
        {
            new AbonnentFileRepository().LeggTilAbonnent(smsAbonnent);
        }

        public void SendMelding(SmsMelding melding)
        {
            abonnenter.ForEach(abonnent => SendSms(abonnent, melding));
        }

        void SendSms(SmsAbonnent abonnent, SmsMelding melding)
        {
            new SmsProsessor().SendSms(abonnent, melding);
        }
    }
}