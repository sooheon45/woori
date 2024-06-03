package woori.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import woori.domain.*;
import woori.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class InstanceStarted extends AbstractEvent {

    private Long id;
    private String currentStep;

    public InstanceStarted(ProcessInstance aggregate) {
        super(aggregate);
    }

    public InstanceStarted() {
        super();
    }
}
//>>> DDD / Domain Event
