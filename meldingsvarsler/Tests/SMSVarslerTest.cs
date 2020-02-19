using System.Collections.Generic;
using App;
using Xunit;

namespace Tests {
    public class SmsVarslerTest 
    {
        [Fact]
        public void SendMeldingerTest() 
        {
            var smsVarsler = new SmsVarsler();
            smsVarsler.LeggTilAbonnenter(new List<string> {"90965253","77626276","77788112"});
            smsVarsler.LagreAbonnenter();
            smsVarsler.HentAbonnenter();
            smsVarsler.SendMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!");
        }
    }
}