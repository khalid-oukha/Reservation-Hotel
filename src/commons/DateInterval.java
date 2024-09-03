package commons;

import java.time.LocalDate;

public class DateInterval {
    private LocalDate startDate;
    private LocalDate endDate;

    public DateInterval(LocalDate startDate, LocalDate endDate) {

        if (startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Start date cannot be before today");
        }

        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        if (endDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("End date cannot be before today");
        }

        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (startDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Start date cannot be before today");
        }
        if (startDate.isAfter(this.endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate.isBefore(this.startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        this.endDate = endDate;
    }
}