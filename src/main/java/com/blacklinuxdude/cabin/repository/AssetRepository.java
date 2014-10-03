package com.blacklinuxdude.cabin.repository;

import com.blacklinuxdude.cabin.model.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "assets", path = "assets")
@Repository
public interface AssetRepository extends CrudRepository<Asset, String> {
}
