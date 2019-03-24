package com.holeman.blogbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public Page<Post> getPostList(//@RequestParam(name="page", required=false) int page,
                                  @PageableDefault Pageable pageable,
                                  @RequestParam(name="tag", required=false) String tag){
        //postService.getPostList(pageable, tag);
        return postService.getPostList(pageable, tag);
    }
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id){

        return postService.getPostById(id);
    }
    @PostMapping
    public Post savePost(@RequestBody Post post){

        return postService.savePost(post);
    }

    @PatchMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post){

        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }
}
