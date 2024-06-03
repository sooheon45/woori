package woori.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import woori.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/troubleTickets")
@Transactional
public class TroubleTicketController {

    @Autowired
    TroubleTicketRepository troubleTicketRepository;

    @RequestMapping(
        value = "troubleTickets/{id}/complete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public TroubleTicket complete(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /troubleTicket/complete  called #####");
        Optional<TroubleTicket> optionalTroubleTicket = troubleTicketRepository.findById(
            id
        );

        optionalTroubleTicket.orElseThrow(() -> new Exception("No Entity Found")
        );
        TroubleTicket troubleTicket = optionalTroubleTicket.get();
        troubleTicket.complete();

        troubleTicketRepository.save(troubleTicket);
        return troubleTicket;
    }
}
//>>> Clean Arch / Inbound Adaptor
