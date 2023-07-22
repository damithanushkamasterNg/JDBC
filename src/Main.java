import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root",
                "Damith1995@3");

        Scanner input = new Scanner(System.in);

        System.out.print("Input Customer province : ");
        String province = input.nextLine();

        String sql = "SELECT * FROM Customer WHERE Province = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, province);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(3) + " " + resultSet.getDouble(5));
        }
    }

}