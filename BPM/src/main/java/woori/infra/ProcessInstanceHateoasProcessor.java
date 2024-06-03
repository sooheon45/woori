package woori.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import woori.domain.*;

@Component
public class ProcessInstanceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ProcessInstance>> {

    @Override
    public EntityModel<ProcessInstance> process(
        EntityModel<ProcessInstance> model
    ) {
        return model;
    }
}
