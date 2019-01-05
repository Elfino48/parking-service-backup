package dao;

import models.Order;

import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;

public class OrderRepository {

    public static void save(Order order, String parkingID){

        final String url = "jdbc:mysql://localhost:3306/parkingservice?useSSL=false&serverTimezone=UTC";
        final String user = "root";
        final String password = "0000";

        Connection con = null;
        Statement stmt = null;

        String query = "INSERT INTO parking_service.p" + parkingID + "_orders (startDate, endDate," +
                "name, second_name, tel_num, parking_seat_id) " +
                "VALUES ('" + order.getStartDate() + "', '" + order.getEndDate() + "'," +
                "'" + order.getName() + "', '" + order.getSecondName() + "'," +
                "'" + order.getTelNum() + "', '" + order.getParkingSeatID() + "');";
        System.out.println(query);

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        }

    }

    public static void createTable(String parking_id){

        final String url = "jdbc:mysql://localhost:3306/parkingservice?useSSL=false&serverTimezone=UTC";
        final String user = "root";
        final String password = "0000";

        Connection con = null;
        Statement stmt = null;

        String query = "CREATE TABLE parking_service.p" + parking_id + "_orders" +
                "(startDate VARCHAR(45), \n" +
                " endDate VARCHAR(45), \n" +
                " name VARCHAR(45), \n" +
                " second_name VARCHAR(45), \n" +
                " tel_num VARCHAR(45), \n" +
                " parking_seat_id INT(5)" +
                ");";

        System.out.println(query);

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        }

    }

    public static ArrayList<Order> getOrders(String parking_id, int parking_seat_id) throws SQLException {

        final String url = "jdbc:mysql://localhost:3306/parking_service?useSSL=false&serverTimezone=UTC";
        final String user = "root";
        final String password = "0000";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Order> orders = new ArrayList<>();

        String query = "select startDate, endDate, " +
                "name, second_name, tel_num, parking_seat_id from " +
                "p" + parking_id + "_orders " +
                "WHERE parking_seat_id = " + parking_seat_id;

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                String startDate = rs.getString(1);
                String endDate = rs.getString(2);
                byte[] dataName = rs.getBytes(3);
                String name = new String(dataName, StandardCharsets.UTF_8);
                String second_name = rs.getString(4);
                String tel_num = rs.getString(5);
                System.out.println(name);
                Order order = new Order(name, second_name, tel_num,
                        startDate, endDate, parking_seat_id);
                orders.add(order);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        }


        return orders;
    }




}
