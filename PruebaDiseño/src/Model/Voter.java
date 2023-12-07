package Model;

/**
 *
 * @author Cliente
 */
public class Voter {
    private int id, ID_number, age;
    private String name, last_name, second_name, address, password;

    public Voter() {
    }

    public Voter(int id, String name, String last_name, String second_name, int ID_number, int age, String address, String password) {
        this.id = id;
        this.ID_number = ID_number;
        this.age = age;
        this.name = name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.address = address;
        this.password = password;
    }

    public Voter(String name, String last_name, String second_name,int ID_number, int age, String address, String password) {
        this.ID_number = ID_number;
        this.age = age;
        this.name = name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.address = address;
        this.password = password;
    }
  
    public Voter(int id, String name, int ID_number) {
        this.id = id;
        this.name = name;
        this.ID_number = ID_number;
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

    public int getID_number() {
        return ID_number;
    }

    public void setID_number(int ID_number) {
        this.ID_number = ID_number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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