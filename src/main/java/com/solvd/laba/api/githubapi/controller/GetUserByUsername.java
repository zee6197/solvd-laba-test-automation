package com.solvd.laba.api.githubapi.controller;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${config.api_url}/users/${username}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/githubapi/get_user_rs.json")

public class GetUserByUsername extends AbstractApiMethodV2 {
    public GetUserByUsername(String username) {
        super(null,"api/githubapi/get_user_rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("username", username);

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
