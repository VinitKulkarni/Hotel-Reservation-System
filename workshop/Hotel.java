package com.bridgelabz.hotelreservationsystem.workshop;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Hotel {
    String hotelName;
    int ratings;
    int weekDaysRateForRegularCustomer;
    int weekDaysRateForRewardsCustomer;
    int weekendRateForRegularCustomer;
    int weekendRateForRewardCustomer;

    public Hotel(String hotelName, int ratings, int weekDaysRateForRegularCustomer,
                 int weekDaysRateForRewardsCustomer, int weekendRateForRegularCustomer,
                 int weekendRateForRewardCustomer) {
        this.hotelName = hotelName;
        this.ratings = ratings;
        this.weekDaysRateForRegularCustomer = weekDaysRateForRegularCustomer;
        this.weekDaysRateForRewardsCustomer = weekDaysRateForRewardsCustomer;
        this.weekendRateForRegularCustomer = weekendRateForRegularCustomer;
        this.weekendRateForRewardCustomer = weekendRateForRewardCustomer;
    }


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public int getWeekDaysRateForRegularCustomer() {
        return weekDaysRateForRegularCustomer;
    }

    public void setWeekDaysRateForRegularCustomer(int weekDaysRateForRegularCustomer) {
        this.weekDaysRateForRegularCustomer = weekDaysRateForRegularCustomer;
    }

    public int getWeekDaysRateForRewardsCustomer() {
        return weekDaysRateForRewardsCustomer;
    }

    public void setWeekDaysRateForRewardsCustomer(int weekDaysRateForRewardsCustomer) {
        this.weekDaysRateForRewardsCustomer = weekDaysRateForRewardsCustomer;
    }

    public int getWeekendRateForRegularCustomer() {
        return weekendRateForRegularCustomer;
    }

    public void setWeekendRateForRegularCustomer(int weekendRateForRegularCustomer) {
        this.weekendRateForRegularCustomer = weekendRateForRegularCustomer;
    }

    public int getWeekendRateForRewardCustomer() {
        return weekendRateForRewardCustomer;
    }

    public void setWeekendRateForRewardCustomer(int weekendRateForRewardCustomer) {
        this.weekendRateForRewardCustomer = weekendRateForRewardCustomer;
    }


    public int getTotalRate(String customerType, LocalDate startDate, LocalDate endDate) {
        int totalRate = 0;
        LocalDate currentDate = startDate;
        while (currentDate.isBefore(endDate) || currentDate.isEqual(endDate)) {
            int currentRate;
            if (currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                currentRate = customerType.equals("regular") ? getWeekendRateForRegularCustomer() : getWeekendRateForRewardCustomer();
            } else {
                currentRate = customerType.equals("regular") ? getWeekDaysRateForRegularCustomer() : getWeekDaysRateForRewardsCustomer();
            }
            totalRate += currentRate;
            currentDate = currentDate.plusDays(1);
        }
        return totalRate;
    }
}
