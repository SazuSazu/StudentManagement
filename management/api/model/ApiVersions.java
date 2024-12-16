package com.example.management.api.model;

import com.example.management.api.ApiVersion;

public enum ApiVersions implements ApiVersion {

    V1("v1");

    final String ver;

    ApiVersions(String ver){
        this.ver = ver;
    }

    @Override
    public String getVer() {
        return ver;
    }
}
