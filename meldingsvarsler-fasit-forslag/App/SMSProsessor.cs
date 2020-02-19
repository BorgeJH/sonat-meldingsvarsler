using System;

namespace App
{
    public class SmsProsessor : IMeldingProsessor
    {
        public bool HaandtererUtsendingAv(IMelding melding)
        {
            return melding is SmsMelding;
        }

        public void SendMelding(IAbonnent abonnent, IMelding melding)
        {
            SendSms((SmsAbonnent) abonnent, (SmsMelding) melding);
        }

        public void SendSms(SmsAbonnent smsAbonnent, SmsMelding smsMelding)
        {
            Console.Out.WriteLine("Sender SMS til "
                                + smsAbonnent.TelefonNummer
                                + " (" + smsAbonnent.Navn + ")"
                                + " => " + smsMelding.Melding
            );
        }
    }
}