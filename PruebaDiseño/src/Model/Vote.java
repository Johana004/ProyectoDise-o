
package Model;

import java.security.Timestamp;
import java.util.Date;

/**
 *
 * @author Cliente
 */
public class Vote {
    private int id;
    private int voter_id;
    private int candidate_id;
    private Date date_vote;

    public Vote() {
    }

    public Vote(int voter_id, int candidate_id, Date date_vote) {
        this.voter_id = voter_id;
        this.candidate_id = candidate_id;
        this.date_vote = date_vote;
    }

    
    public Vote(int id, int voter_id, int candidate_id, Date date_vote) {
        this.id = id;
        this.voter_id = voter_id;
        this.candidate_id = candidate_id;
        this.date_vote = date_vote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoter_id() {
        return voter_id;
    }

    public void setVoter_id(int voter_id) {
        this.voter_id = voter_id;
    }

    public int getCandidate_id() {
        return candidate_id;
    }

    public void setCandidate_id(int candidate_id) {
        this.candidate_id = candidate_id;
    }

    public Date getDate_vote() {
        return date_vote;
    }

    public void setDate_vote(Date date_vote) {
        this.date_vote = date_vote;
    }
    
    
    
    
}
