package woori.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import woori.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "troubleTickets",
    path = "troubleTickets"
)
public interface TroubleTicketRepository
    extends PagingAndSortingRepository<TroubleTicket, Long> {}
