package no.sonat.meldingsvarsler;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JdbcAbonnentRepository implements AbonnentRepository {
    @Override
    public void leggTilAbonnent(Abonnent abonnent){
        // Legg til abonnent i database
    }

    @Override
    public List<Abonnent> hentAbonnenter() {
        return Collections.emptyList();
    }

}
