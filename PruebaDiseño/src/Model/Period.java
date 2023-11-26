/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
     * @return the star_date
     */
    public Date getStar_date() {
        return star_date;
    }

    /**
     * @param star_date the star_date to set
     */
    public void setStar_date(Date star_date) {
        this.star_date = star_date;
    }

    /**
     * @return the end_date
     */
    public Date getEnd_date() {
        return end_date;
    }

    /**
     * @param end_date the end_date to set
     */
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
    
    
    
    
    
    
}
