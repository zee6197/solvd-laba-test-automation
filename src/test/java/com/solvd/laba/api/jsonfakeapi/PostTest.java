package com.solvd.laba.api.jsonfakeapi;

import com.solvd.laba.api.jsonfakeapi.controller.CreatePost;
import com.solvd.laba.api.jsonfakeapi.controller.DeletePost;
import com.solvd.laba.api.jsonfakeapi.controller.GetPost;
import com.solvd.laba.api.jsonfakeapi.controller.UpdatePost;
import com.solvd.laba.api.jsonfakeapi.domain.Post;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostTest {

    @DataProvider(name = "postDataProvider")
    public Object[][] providePostData() {
        return new Object[][]{
                {1, 6, "This is my first post", "Hello Zee"},
                {1, 9, "This is my second post", "I am practicing Api testing"},
                {1, 10, "This is my third post", "I am getting better at it"},
                {1, 8, "This is my fourth post", "I am practicing Api testing"},
                {1, 7, "This is my fifth post", "I am practicing Api testing again"},
                {1, 5, "This is my sixth post", "Thank you reading! Good Bye!"},
        };
    }

    @DataProvider(name = "deletePostDataProvider")
    public Object[][] deletePostData() {
        return new Object[][]{
                {1},
        };
    }

    @DataProvider(name = "getPostDataProvider")
    public Object[][] getPostProvider() {
        return new Object[][]{
                {1},
        };
    }

    @DataProvider(name = "updatePostDataProvider")
    public Object[][] provideUpdatePostData() {
        return new Object[][]{
                {1},

        };
    }

    @Test(description = "Create a new post", dataProvider = "postDataProvider")
    public void createNewPostTest(Integer postId, Integer score, String title, String body) {
        Post post = new Post();
        post.setId(postId);
        post.setScore(score);
        post.setTitle(title);
        post.setBody(body);
        CreatePost createPostMethod = new CreatePost();
        createPostMethod.addProperty("userId", post.getId().toString());
        createPostMethod.addProperty("score", post.getScore().toString());
        createPostMethod.addProperty("title", post.getTitle());
        createPostMethod.addProperty("body", post.getBody());
        createPostMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        createPostMethod.callAPI();
        createPostMethod.validateResponse();
    }

    @Test(description = "Delete a post by ID", dataProvider = "deletePostDataProvider")
    public void deletePostTest(Integer userId) {
        Post post = new Post();
        post.setId(userId);
        DeletePost deletePostMethod = new DeletePost(userId);
        deletePostMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        deletePostMethod.callAPI();
        deletePostMethod.validateResponse();
    }

    @Test(description = "Get a single post by ID", dataProvider = "getPostDataProvider")
    public void verifyGetSinglePostById(Integer id) {

        GetPost getPostMethod = new GetPost(id);
        getPostMethod.callAPI();
        getPostMethod.validateResponse();
    }

    @Test(description = "Update a post by ID", dataProvider = "updatePostDataProvider")
    public void testUpdatePost(Integer id) {

        UpdatePost updatePostMethod = new UpdatePost(id);
        updatePostMethod.callAPI();
        updatePostMethod.validateResponse();
    }
}
