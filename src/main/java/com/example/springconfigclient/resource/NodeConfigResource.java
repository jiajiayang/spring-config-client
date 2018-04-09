package com.example.springconfigclient.resource;

import com.example.springconfigclient.rest.NodeConfig;
import com.example.springconfigclient.rest.NodeConfigClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@RefreshScope
public class NodeConfigResource {

    @Value("${db_url}")
    private String dbUrl;

    @Autowired
    private NodeConfigClient nodeConfigClient;

    @GetMapping(path = "/{enterpriseId}/node/config")
    @ResponseBody
    public List<NodeConfig> findByEnterpriseId(@PathVariable("enterpriseId") String enterpriseId) {

        log.info("db url:{}", dbUrl);
        List<NodeConfig> nodeConfigs = nodeConfigClient.findByEnterpriseId(enterpriseId);
        log.info("find by enterpriseId:{}, result:{}", enterpriseId, nodeConfigs);
        return nodeConfigs;
    }
}
