using System.Collections.Generic;

namespace App {
    public interface IAbonnentRepositoryReader {
        List<IAbonnent> HentAbonnenter();
    }
}
