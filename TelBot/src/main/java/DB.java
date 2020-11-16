import java.sql.*;
import java.util.*;

public class DB
{
    private final Connection connection;

    public DB(Connection connection) {
        this.connection = connection;
    }

    public List<Users> getAllUsers()
    {
        try (Statement statement = this.connection.createStatement()) {
            List<Users> users = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT id, name, subscribe, city FROM users");
            while (resultSet.next()) {
                users.add(new Users(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("subscribe"),
                        resultSet.getString("city")));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void addUser(Users user)
    {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO users(`id`, `name`, `subscribe`, `city`) " +
                        "VALUES(?, ?, ?, ?)")) {
            statement.setObject(1, user.getId());
            statement.setObject(2, user.getFirstName());
            statement.setObject(3, user.isIssubscribe());
            statement.setObject(4, user.getCity());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id)
    {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM users WHERE id = ?")) {
            statement.setObject(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
