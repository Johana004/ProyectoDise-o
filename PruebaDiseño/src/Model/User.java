 
package Model;

/**
 *
 * @author johana
 */
public class User {
     private int id;
    private String name;
    private String last_name;
    private String second_name;
    private int id_number;
    private int age;
    private String address;
    private String password;

    public User(String name, String last_name, String second_name, int id_number, int age, String address, String password) {
        this.name = name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.id_number = id_number;
        this.age = age;
        this.address = address;
        this.password = password;
    }

    
    public User(int id, String name, String last_name, String second_name, int id_number, int age, String address, String password) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.id_number = id_number;
        this.age = age;
        this.address = address;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public int getId_number() {
        return id_number;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    } 
}
