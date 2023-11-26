
package Model;


public class candidates {
    private int id, id_number, age, votes;
    private String name, last_name, second_name,photo, politic_party;

    public candidates(int id_number, int age, int votes, String name, String last_name, String second_name, String photo, String politic_party) {
        this.id_number = id_number;
        this.age = age;
        this.votes = votes;
        this.name = name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.photo = photo;
        this.politic_party = politic_party;
    }

    public candidates(int id, int id_number, int age, int votes, String name, String last_name, String second_name, String photo, String politic_party) {
        this.id = id;
        this.id_number = id_number;
        this.age = age;
        this.votes = votes;
        this.name = name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.photo = photo;
        this.politic_party = politic_party;
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
     * @return the votes
     */
    public int getVotes() {
        return votes;
    }

    /**
     * @param votes the votes to set
     */
    public void setVotes(int votes) {
        this.votes = votes;
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
     * @return the second_name
     */
    public String getSecond_name() {
        return second_name;
    }

    /**
     * @param second_name the second_name to set
     */
    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the politic_party
     */
    public String getPolitic_party() {
        return politic_party;
    }

    /**
     * @param politic_party the politic_party to set
     */
    public void setPolitic_party(String politic_party) {
        this.politic_party = politic_party;
    }
  

    
    
    
}
