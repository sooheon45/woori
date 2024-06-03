package woori.domain;

import java.util.*;
import lombok.*;
import woori.domain.*;
import woori.infra.AbstractEvent;

@Data
@ToString
public class TroubleTicketCompleted extends AbstractEvent {

    private Long id;
    private String troubleType;
    private String description;
}
