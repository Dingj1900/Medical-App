package com.techelevator.model;

import java.time.LocalDate;

public class TimePeriod {
    private int period_id;
    private LocalDate startDate;
    private LocalDate endDate;

    public TimePeriod(int period_id, LocalDate startDate, LocalDate endDate) {
        this.period_id = period_id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getPeriod_id() {
        return period_id;
    }

    public void setPeriod_id(int period_id) {
        this.period_id = period_id;
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
