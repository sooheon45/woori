package woori.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import woori.domain.*;
import woori.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TroubleTicketCompleted extends AbstractEvent {

    private Long id;
    private String troubleType;
    private String description;

    public TroubleTicketCompleted(TroubleTicket aggregate) {
        super(aggregate);
    }

    public TroubleTicketCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
