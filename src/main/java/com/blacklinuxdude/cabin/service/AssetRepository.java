package com.blacklinuxdude.cabin.service;

import com.blacklinuxdude.cabin.model.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "assets", path = "assets")
public interface AssetRepository extends MongoRepository<Asset, String> {
}
