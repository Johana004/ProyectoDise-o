
package Model;

import java.security.Timestamp;

/**
 *
 * @author Cliente
 */
public class Votes {
    private int id;
    private int voter_id;
    private int candidate_id;
    private Timestamp date_vote;

    public Votes(int voter_id, int candidate_id, Timestamp date_vote) {
        this.voter_id = voter_id;
        this.candidate_id = candidate_id;
        this.date_vote = date_vote;
    }

    
    
    public Votes(int id, int voter_id, int candidate_id, Timestamp date_vote) {
        this.id = id;
        this.voter_id = voter_id;
        this.candidate_id = candidate_id;
        this.date_vote = date_vote;
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
     * @return the voter_id
     */
    public int getVoter_id() {
        return voter_id;
    }

    /**
     * @param voter_id the voter_id to set
     */
    public void setVoter_id(int voter_id) {
        this.voter_id = voter_id;
    }

    /**
     * @return the candidate_id
     */
    public int getCandidate_id() {
        return candidate_id;
    }

    /**
     * @param candidate_id the candidate_id to set
     */
    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    /**
     * @return the date_vote
     */
    public Timestamp getDate_vote() {
        return date_vote;
    }

    /**
     * @param date_vote the date_vote to set
     */
    public void setDate_vote(Timestamp date_vote) {
        this.date_vote = date_vote;
    }
    
    
    
    
}
