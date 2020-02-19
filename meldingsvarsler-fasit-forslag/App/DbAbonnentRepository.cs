using System;
using System.Collections.Generic;

namespace App
{
    public class DbAbonnentRepository : IAbonnentRepositoryReader, 
                                        IAbonnentRepositoryWriter,
                                        IAbonnentRepositoryStatistikk
    {
        public void LeggTilAbonnent(IAbonnent abonnent)
        {
            // Legg til abonnent i database
        }


        public List<IAbonnent> HentAbonnenter()
        {
            // Hent alle abonnenter fra database
            return new List<IAbonnent>();
        }


        public long TotaltAntallAbonnenter()
        {
            return 0;
        }

        public long AntallAbonnererPaa(Type type)
        {
            return 0;
        }
    }
}