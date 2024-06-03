package woori.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import woori.config.kafka.KafkaProcessor;
import woori.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ProcessInstanceRepository processInstanceRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TroubleTicketIssued'"
    )
    public void wheneverTroubleTicketIssued_UpdateStatus(
        @Payload TroubleTicketIssued troubleTicketIssued
    ) {
        TroubleTicketIssued event = troubleTicketIssued;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + troubleTicketIssued + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TroubleTicketCompleted'"
    )
    public void wheneverTroubleTicketCompleted_UpdateStatus(
        @Payload TroubleTicketCompleted troubleTicketCompleted
    ) {
        TroubleTicketCompleted event = troubleTicketCompleted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " +
            troubleTicketCompleted +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TroubleTicketIssued'"
    )
    public void wheneverTroubleTicketIssued_StartProcessInstance(
        @Payload TroubleTicketIssued troubleTicketIssued
    ) {
        TroubleTicketIssued event = troubleTicketIssued;
        System.out.println(
            "\n\n##### listener StartProcessInstance : " +
            troubleTicketIssued +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
