package com.solvd.laba.api.jsonfakeapi.controller;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;


@Endpoint(url = "${config.api_base_url}/posts/${postId}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/jsonfakeapi/get_single_post_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)


public class GetPost extends AbstractApiMethodV2 {

    public GetPost(int postId) {

        replaceUrlPlaceholder("postId", String.valueOf(postId));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
