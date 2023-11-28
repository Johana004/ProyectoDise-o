
package Model;

/**
 *
 * @author Cliente
 */
public class Voter {
    private int id;
    private String name;
    private int ID_number;

    public Voter(String name, int ID_number) {
        this.name = name;
        this.ID_number = ID_number;
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
}
