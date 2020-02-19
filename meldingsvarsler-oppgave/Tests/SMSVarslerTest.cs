using App;
using Xunit;

namespace Tests {
    public class SmsVarslerTest
    {
        [Fact]
        public void SendMeldingerTest()
        {
            var smsVarsler = new MeldingSender();
            smsVarsler.HentAbonnenter();
            var smsMelding = new SmsMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!");
            smsVarsler.SendMelding(smsMelding);
        }

        [Fact]
        public void Statistikk()
        {
            // Skriv ut antall abonnenter per melding
        }
    }
}