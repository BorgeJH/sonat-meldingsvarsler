using System.Collections.Generic;
using App;

public class MeldingRepositoryStub : IMeldingRepository,
                                     IMeldingRepositoryWriter
{
    readonly List<IMelding> meldinger = new List<IMelding>();

    public List<IMelding> HentMeldinger()
    {
        meldinger.Add(new SmsMelding("Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!!"));
        meldinger.Add(new EpostMelding("Løp og kjøp. Førstemann til mølla!!",
                                       "Vårens kleskolleksjon har kommet. "));
        meldinger.Add(
            new FacebookMelding(
                "Vårens kleskolleksjon har kommet. Løp og kjøp. Førstemann til mølla!! Del på Facebook."));
        return meldinger;
    }

    public void LeggTilMelding(IMelding melding) { }
}