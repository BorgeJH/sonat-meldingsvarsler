using System.Collections.Generic;
using System.Linq;

namespace App {
    public class MeldingSender
    {
        readonly IMeldingRepository meldingRepository;
        readonly IAbonnentRepositoryReader abonnentRepository;
        readonly List<IMeldingProsessor> meldingProsessorer;

        /* Inversion Of Control : abonnentRespository, meldingRepository, meldingProsessors */
        public MeldingSender(IMeldingRepository meldingRepository,
                             IAbonnentRepositoryReader abonnentRepository,
                             List<IMeldingProsessor> meldingProsessorer)
        {
            this.abonnentRepository = abonnentRepository;
            this.meldingProsessorer = meldingProsessorer;
            this.meldingRepository = meldingRepository;
        }

        public void SendMeldinger()
        {
            meldingRepository.HentMeldinger().ForEach(melding =>
            {
                meldingProsessorer.Where(meldingProsessor => meldingProsessor.HaandtererUtsendingAv(melding))
                                  .ToList()
                                  .ForEach(meldingProsessor =>
                                  {
                                      abonnentRepository.HentAbonnenter()
                                                        .Where(abonnent => abonnent.AbonnererPaa(melding))
                                                        .ToList()
                                                        .ForEach(abonnent =>
                                                                     meldingProsessor.SendMelding(abonnent, melding));
                                  });
            });
        }
    }
}