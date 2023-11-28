
package Model;

import java.util.Date;

/**
 *
 * @author Cliente
 */
public class Period {
    private int id;
    private String name;
    private Date star_date;
    private Date end_date;

    public Period(String name, Date star_date, Date end_date) {
        this.name = name;
        this.star_date = star_date;
        this.end_date = end_date;
    }

    public Period(int id, String name, Date star_date, Date end_date) {
        this.id = id;
        this.name = name;
        this.star_date = star_date;
        this.end_date = end_date;
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

    public Date getStar_date() {
        return star_date;
    }

    public void setStar_date(Date star_date) {
        this.star_date = star_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    } 
}
