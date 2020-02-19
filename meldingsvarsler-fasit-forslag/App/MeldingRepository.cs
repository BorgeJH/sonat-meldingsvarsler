using System.Collections.Generic;

namespace App {
    public interface IMeldingRepository
    {
        List<IMelding> HentMeldinger();
    }
}