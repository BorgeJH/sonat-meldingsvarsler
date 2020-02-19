using System;
using System.Collections.Generic;
using System.Linq;
using App;

public class AbonnentRepositoryStub : IAbonnentRepositoryReader,
                                       IAbonnentRepositoryWriter,
                                       IAbonnentRepositoryStatistikk
{
    readonly List<IAbonnent> abonnenter;

    public AbonnentRepositoryStub()
    {
        abonnenter = new List<IAbonnent>();
    }

    public void LeggTilAbonnent(IAbonnent abonnent)
    {
        abonnenter.Add(abonnent);
    }

    public List<IAbonnent> HentAbonnenter()
    {
        return abonnenter;
    }

    public long TotaltAntallAbonnenter()
    {
        return abonnenter.Count;
    }

    public long AntallAbonnererPaa(Type type)
    {
        return abonnenter
            .Count(m => m.GetType() == type);
    }
}