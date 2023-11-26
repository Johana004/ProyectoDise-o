
package Model;

/**
 *
 * @author johana
 */
public class Users {
     private int id;
    private String name;
    private String last_name;
    private String second_name;
    private int id_number;
    private int age;
    private String address;
    private String password;

    public Users(String name, String last_name, String second_name, int id_number, int age, String address, String password) {
        this.name = name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.id_number = id_number;
        this.age = age;
        this.address = address;
        this.password = password;
    }

    
    public Users(int id, String name, String last_name, String second_name, int id_number, int age, String address, String password) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.id_number = id_number;
        this.age = age;
        this.address = address;
        this.password = password;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the secund_name
     */
    public String getSecond_name() {
        return second_name;
    }

    /**
     * @param second_name the secund_name to set
     */
    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    /**
     * @return the id_number
     */
    public int getId_number() {
        return id_number;
    }

    /**
     * @param id_number the id_number to set
     */
    public void setId_number(int id_number) {
        this.id_number = id_number;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
   
    
    
}
