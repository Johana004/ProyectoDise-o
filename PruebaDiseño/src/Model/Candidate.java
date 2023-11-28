
package Model;


public class Candidate {
    private int id, id_number, age, votes;
    private String name, last_name, second_name,photo, politic_party;

    
      public Candidate(int id, int id_number, int age, int votes, String name, String last_name, String second_name, String photo, String politic_party) {
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
    public Candidate(int id_number, int age, int votes, String name, String last_name, String second_name, String photo, String politic_party) {
        this.id_number = id_number;
        this.age = age;
        this.votes = votes;
        this.name = name;
        this.last_name = last_name;
        this.second_name = second_name;
        this.photo = photo;
        this.politic_party = politic_party;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getVotes() {
        return votes;
    }
    
    public void setVotes(int votes) {
        this.votes = votes;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPolitic_party() {
        return politic_party;
    }

    public void setPolitic_party(String politic_party) {
        this.politic_party = politic_party;
    }  
}
