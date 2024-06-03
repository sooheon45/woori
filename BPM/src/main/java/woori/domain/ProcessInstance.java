package woori.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import woori.BpmApplication;
import woori.domain.InstanceStarted;

@Entity
@Table(name = "ProcessInstance_table")
@Data
//<<< DDD / Aggregate Root
public class ProcessInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String currentStep;

    @PostPersist
    public void onPostPersist() {
        InstanceStarted instanceStarted = new InstanceStarted(this);
        instanceStarted.publishAfterCommit();
    }

    public static ProcessInstanceRepository repository() {
        ProcessInstanceRepository processInstanceRepository = BpmApplication.applicationContext.getBean(
            ProcessInstanceRepository.class
        );
        return processInstanceRepository;
    }
}
//>>> DDD / Aggregate Root
