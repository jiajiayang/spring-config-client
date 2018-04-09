package com.example.springconfigclient.rest;

import lombok.Data;

@Data
public class NodeConfig {
    private String id;
    private String enterpriseId;
    private String node;
    private String serverName;
    private String innerIp;
    private String outerIp;
    private String provider;
}
