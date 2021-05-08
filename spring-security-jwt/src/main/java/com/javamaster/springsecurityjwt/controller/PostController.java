package com.javamaster.springsecurityjwt.controller;

import com.google.gson.Gson;
import com.javamaster.springsecurityjwt.dao.PostRequest;
import com.javamaster.springsecurityjwt.entity.PostEntity;
import com.javamaster.springsecurityjwt.service.PostService;
import com.javamaster.springsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/post/")
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService,UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("create")
    public String create(@RequestBody PostRequest request){
        PostEntity post = new PostEntity();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setStatus("ACTIVE");
        post.setAuthor(userService.findByLogin(request.getAuthorLogin()));
        try {
            postService.createPost(post);
        } catch (Exception exception) {
            return "false";
        }
        return "ok";
    }

    @GetMapping("getAll")
    public String getAllActive(){
        List<PostEntity> list = postService.getActivePosts();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @PostMapping("delete")
    public String delete(@RequestBody PostRequest request){
        postService.deletePost(postService.getByTitle(request.getTitle()));
        return "ok";
    }

    @PostMapping("update")
    public String update(@RequestBody PostRequest request){
        PostEntity post = postService.getByTitle(request.getTitle());
        post.setContent(request.getContent());
        try {
            postService.updatePost(post);
        } catch (Exception exception) {
            return "false";
        }
        return "ok";
    }
}
