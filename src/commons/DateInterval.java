package commons;

import java.time.LocalDate;

public class DateInterval {
    private LocalDate startDate;
    private LocalDate endDate;

    public DateInterval(LocalDate startDate, LocalDate endDate) {
        if (startDate.isBefore(endDate) && startDate.isAfter(LocalDate.now())) {
            this.startDate = startDate;
            this.endDate = endDate;
        } else {
            throw new IllegalArgumentException("invalid date range");
        }

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
