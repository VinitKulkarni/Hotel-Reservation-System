package com.bridgelabz.hotelreservationsystem.workshop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HotelMain {
    public static void main(String[] args) throws Exception{
        Hotel lakewood = new Hotel("Lakewood",3,110,80,90,80);
        Hotel bridgewood = new Hotel("Bridgewood",4,160,110,60,50);
        Hotel ridgewood = new Hotel("Ridgewood",5,220,100,150,40);

        //adding hotel objects in list
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(lakewood);
        hotelList.add(bridgewood);
        hotelList.add(ridgewood);


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the date range:");
        System.out.print("From:");
        LocalDate fromDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.print("To:");
        LocalDate toDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.print("Enter the customer type [regular or reward]:");
        final String customerTypeValue = sc.next();


        Hotel cheapestHotel = hotelList.stream()
                .min(Comparator.comparing(hotel -> hotel.getTotalRate(customerTypeValue, fromDate, toDate)))
                .orElse(null);

        System.out.println("Cheapest hotel is " + cheapestHotel.getHotelName() + " with a total rate of "
                + cheapestHotel.getTotalRate(customerTypeValue, fromDate, toDate) + "$");
    }
}
