using System.Collections.Generic;

namespace App {
    public class DbMeldingRepository : IMeldingRepository, IMeldingRepositoryWriter
    {
        public List<IMelding> HentMeldinger()
        {
            // Les meldinger fra database
            return new List<IMelding>();
        }


        public void LeggTilMelding(IMelding melding)
        {
            // Legg til melding i database
        }
    }
}