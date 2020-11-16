public class Users
{
    private Integer id;
    private String firstName;
    private boolean issubscribe;
    private String city;

    public Users(Integer id, String firstName, boolean issubscribe, String city)
    {
        this.id = id;
        this.firstName = firstName;
        this.issubscribe = issubscribe;
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", issubscribe=" + issubscribe +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isIssubscribe() {
        return issubscribe;
    }

    public void setIssubscribe(boolean issubscribe) {
        this.issubscribe = issubscribe;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
