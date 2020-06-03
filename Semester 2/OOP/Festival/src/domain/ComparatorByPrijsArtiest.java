package domain;

import java.util.Comparator;

public class ComparatorByPrijsArtiest implements Comparator<Optreden> {
    @Override
    public int compare(Optreden o1, Optreden o2) {
        return (int)Math.round(o1.getArtiest().getLoon() - o2.getArtiest().getLoon());
    }


}
