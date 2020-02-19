using System;

namespace App {
    public class SmsProsessor
    {
        public void SendSms(SmsAbonnent smsAbonnent, SmsMelding smsMelding)
        {
            Console.Out.WriteLine("Sender SMS til "
                                + smsAbonnent.TelefonNummer
                                + "(" + smsAbonnent.Navn + ")"
                                + " => " + smsMelding.Melding
            );
        }
    }
}