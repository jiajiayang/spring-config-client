package com.example.springconfigclient.rest;

import com.example.springconfigclient.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(value = "locator", path = "/api/rest/internal/v1/en", configuration = FeignConfig.class)
public interface NodeConfigClient {

    @RequestMapping(value = "/locator/{enterpriseId}/node/config", method = RequestMethod.GET)
    List<NodeConfig> findByEnterpriseId(@PathVariable(value = "enterpriseId") String enterpriseId);
}
