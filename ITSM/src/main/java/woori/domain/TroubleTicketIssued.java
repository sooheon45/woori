package woori.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import woori.domain.*;
import woori.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TroubleTicketIssued extends AbstractEvent {

    private Long id;
    private String troubleType;
    private String description;

    public TroubleTicketIssued(TroubleTicket aggregate) {
        super(aggregate);
    }

    public TroubleTicketIssued() {
        super();
    }
}
//>>> DDD / Domain Event
