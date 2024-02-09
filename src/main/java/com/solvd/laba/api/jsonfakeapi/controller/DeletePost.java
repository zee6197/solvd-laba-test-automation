package com.solvd.laba.api.jsonfakeapi.controller;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.api_base_url}/posts/${postId}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/jsonfakeapi/delete_post_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)

public class DeletePost extends AbstractApiMethodV2 {

    public DeletePost(Integer postId) {

        replaceUrlPlaceholder("postId", String.valueOf(postId));

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
