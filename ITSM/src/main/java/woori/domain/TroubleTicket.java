package woori.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import woori.ItsmApplication;
import woori.domain.TroubleTicketIssued;

@Entity
@Table(name = "TroubleTicket_table")
@Data
//<<< DDD / Aggregate Root
public class TroubleTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String troubleType;

    private String description;

    private String status;

    @PostPersist
    public void onPostPersist() {
        TroubleTicketIssued troubleTicketIssued = new TroubleTicketIssued(this);
        troubleTicketIssued.publishAfterCommit();
    }

    public static TroubleTicketRepository repository() {
        TroubleTicketRepository troubleTicketRepository = ItsmApplication.applicationContext.getBean(
            TroubleTicketRepository.class
        );
        return troubleTicketRepository;
    }

    //<<< Clean Arch / Port Method
    public void complete() {
        //implement business logic here:

        TroubleTicketCompleted troubleTicketCompleted = new TroubleTicketCompleted(
            this
        );
        troubleTicketCompleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
