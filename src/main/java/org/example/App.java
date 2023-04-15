package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        String url="jdbc:postgresql://localhost:5432/Cars CRUD";

        String username="postgres";
        String password="1234";
        Connection con= DriverManager.getConnection(url,username,password);

        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT*FROM cars");


        CarsJDBC f=new CarsJDBC(url,username,password);
        Cars cars=new Cars();
        cars.setId(20);
        cars.setCars_id(15);
        cars.setCars_mark("Audi");
        cars.setCars_model("A5");
        cars.setCars_vincode(526396);
        cars.setCars_price(45000);

           f.addCars(cars);



        while (rs.next()) {
            int id=rs.getInt("cars_id");
            String mark=rs.getString("cars_mark");
            String model=rs.getString("cars_model");
            int vincode=rs.getInt("cars_vincode");
            int price=rs.getInt("cars_price");
            System.out.println("ID"+id+"Marks"+mark+"Model"+model+"Vincode"+vincode+"Price"+price);
        }


    }
}
