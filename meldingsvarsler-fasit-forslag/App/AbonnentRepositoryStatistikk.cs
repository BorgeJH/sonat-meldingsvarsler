using System;

namespace App {
    public interface IAbonnentRepositoryStatistikk {
        long TotaltAntallAbonnenter();
        long AntallAbonnererPaa(Type type);
    }
}
