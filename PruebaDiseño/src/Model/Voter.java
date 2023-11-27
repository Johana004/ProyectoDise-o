
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
     * @return the ID_number
     */
    public int getID_number() {
        return ID_number;
    }

    /**
     * @param ID_number the ID_number to set
     */
    public void setID_number(int ID_number) {
        this.ID_number = ID_number;
    }

  
    
}
