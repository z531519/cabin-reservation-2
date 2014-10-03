package com.blacklinuxdude.cabin.repository;

import com.blacklinuxdude.cabin.model.ReservationBid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "bids", path = "bids")
@Repository
public interface ReservationBidRepository extends CrudRepository<ReservationBid, Long> {
}
