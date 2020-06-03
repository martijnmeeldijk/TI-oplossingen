package domain;

import java.time.LocalDate;

public interface HeeftVervaldatum {
    LocalDate geefVervaldatum();
    boolean isVervallen();
}
