package woori.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import woori.domain.*;

@Component
public class TroubleTicketHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<TroubleTicket>> {

    @Override
    public EntityModel<TroubleTicket> process(
        EntityModel<TroubleTicket> model
    ) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/complete")
                .withRel("complete")
        );

        return model;
    }
}
