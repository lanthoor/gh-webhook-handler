package in.anthoor.gh.ghwebhookhandler.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
@Entity
public class Event {

    @Id
    private Long id;
    private String org;
    private String repo;
    private String eventType;
    private Timestamp timestamp;
}
