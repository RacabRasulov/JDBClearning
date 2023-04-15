package org.example;

import java.sql.*;
import java.util.ArrayList;

public class CarsJDBC implements CarsDAO {

    private Connection connection;

    public CarsJDBC(String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(url, user, password);

    }


    @Override
    public void addCars(Cars cars) throws SQLException {
        String sql = "INSERT INTO public.cars(cars_id, cars_mark, cars_model, cars_vincode, cars_price) " +
                "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, cars.getcars_id());
        ps.setString(2, cars.getcars_mark());
        ps.setString(3, cars.getcars_model());
        ps.setInt(4, cars.getcars_vincode());
        ps.setInt(5, cars.getcars_price());

        ps.execute();

    }


    @Override
    public void removeCars(Cars Cars) throws SQLException {
        String sql = "delete from person where id = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, Cars.getcarid());
        ps.executeUpdate();
    }


    @Override
    public Cars getCars(Cars cars) throws SQLException {
        ArrayList<Cars> array = getAllCars();
        for (Cars person : array) {


            if (cars.getcars_mark().equals("cars_mark")) {
                return cars;
            }
        }
        return null;


    }


    @Override
    public ArrayList<Cars> getAllCars() throws SQLException {
        ArrayList<Cars> array = new ArrayList<Cars>();

        ResultSet result = this.connection.prepareStatement("select * from person").executeQuery();
        while (result.next()) {
            Cars person = new Cars();
            person.setCars_id(Integer.parseInt(result.getString("cars_id")));

            array.add(person);


            return null;
        }

        result.close();
        return array;
    }
}


