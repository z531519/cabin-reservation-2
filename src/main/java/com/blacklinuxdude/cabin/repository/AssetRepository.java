package com.blacklinuxdude.cabin.repository;

import com.blacklinuxdude.cabin.model.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "assets", path = "assets")
public interface AssetRepository extends CrudRepository<Asset, String> {
}
