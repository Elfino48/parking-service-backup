package service;

import dao.OrderRepository;
import dao.ParkingRepository;
import dao.ParkingSeatRepository;
import models.Order;
import models.Parking;
import models.ParkingSeat;

import java.sql.SQLException;

public class ParkingService {

 //   void addPlace(Long carId, Long parkingId);

    public static void createParking(int numOfSeats,  String placement,
                       int price, String id){


        Parking park = new Parking(numOfSeats, placement, price, id);

        ParkingRepository.save(park);

        ParkingSeatRepository.createTable(park.getId());
        OrderRepository.createTable(park.getId());

        for ( ParkingSeat seat : park.getSeats() ) {

            ParkingSeatRepository.save(seat);

        }

    };

    public static void reserveSeat(String parkingID, int parkingSeatID,
                                   String startDate, String endDate,
                                   String firstName, String secondName,
                                   String telNum) throws SQLException {


        Order order = new Order(
                firstName, secondName,
                telNum, startDate,
                endDate, parkingSeatID
                );

        if (!ParkingSeat.checkDate(order.getStartDate(), order.getEndDate(),
                parkingID, parkingSeatID)){

            System.out.println("Занято, блядь!");
            return;

        }


        OrderRepository.save(order, parkingID);


    }

   // void updateParking(Long parkingId, BigDecimal costPerHour);

    void getAllParkings(){};
}
