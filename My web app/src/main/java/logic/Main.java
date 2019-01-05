package logic;

import service.ParkingService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Main{

    public static void reserve() throws SQLException {

        ParkingService.reserveSeat(
                "1019", 23,
                "27122018", "30122018",
                "Elmar", "Kenherli",
                "+380730380807"
        );

    }

    public static void createPark() throws SQLException {


        ParkingService.createParking(
                32, "San Diego",
                150, "1019"
        );

        /*ParkingService.reserveSeat(
                "1019", 23,
                "27122018", "30122018",
                "Elmar", "Kenherli",
                "+380730380807"
        );*/

    }

    public static void main(String[] args) throws SQLException {

        /**/




        /*kievPark.reserveSeat(22, "Elmar", "Kenherli",
                "+380937816790", "21122018", "30122018" );

        kievPark.reserveSeat(22, "Zhora", "Zdorchak",
                "+380937816790", "21122018", "30122018");

        kievPark.reserveSeat(22, "Zhora", "Zdorchak",
                "+380937816790", "01012019", "01022019");

        kievPark.reserveSeat(22, "Zhora", "Zdorchak",
                "+380937816790", "20122018", "21122018");
        */

    }

}