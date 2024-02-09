package com.solvd.laba.api.jsonfakeapi.controller;


import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;


@Endpoint(url = "${config.api_base_url}/posts", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/jsonfakeapi/add_new_post_request.json")
@ResponseTemplatePath(path = "api/jsonfakeapi/add_new_post_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)


public class CreatePost extends AbstractApiMethodV2 {

    public CreatePost() {

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
