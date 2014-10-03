package com.blacklinuxdude.cabin.resource

import com.blacklinuxdude.cabin.model.Asset
import com.blacklinuxdude.cabin.model.Employee
import com.blacklinuxdude.cabin.repository.AssetRepository
import com.blacklinuxdude.cabin.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by kdeleon on 10/2/14.
 */
@RestController
@RequestMapping("/assets")
class AssetResourceController {

    @Autowired
    AssetRepository assetRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Asset> getAssets() {
        return assetRepository.findAll()
    }

    @ResponseBody
    @RequestMapping( value = "/{id}", method = RequestMethod.POST)
    public Asset updateAssert(@PathVariable('id') String id, @RequestBody Asset asset) {
        assetRepository.save(asset);
        return asset;
    }

    @ResponseBody
    @RequestMapping( method = RequestMethod.POST)
    public Asset updateEmployee(@RequestBody Asset asset) {
        assetRepository.save(asset);
        return asset;
    }


}
