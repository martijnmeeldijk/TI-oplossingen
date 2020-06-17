package domain;

public interface IsBetaalbaar {

    double getBedrag(int maand, int jaar);
    int getMaand();
    int getJaar();
}
