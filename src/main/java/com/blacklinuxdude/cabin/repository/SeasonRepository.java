package com.blacklinuxdude.cabin.repository;

import com.blacklinuxdude.cabin.model.Season;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "seasons", path = "seasons")
@Repository
public interface SeasonRepository extends CrudRepository<Season, String> {

}
