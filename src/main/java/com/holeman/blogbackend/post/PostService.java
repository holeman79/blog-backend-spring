package com.holeman.blogbackend.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Page<Post> getPostList(Pageable pageable, String tag){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        if(tag == null) return postRepository.findAll(pageable);
        return postRepository.findByTagsIgnoreCaseContaining(pageable, tag);
    }
    public Post getPostById(Long id){
        return postRepository.findById(id).get();
    }

    public Post savePost(Post post){
        Post savedPost = postRepository.save(post);
        return savedPost;
    }

    public Post updatePost(Long id, Post post){
        Post beforePost = postRepository.findById(id).get();
        beforePost.setTitle(post.getTitle());
        beforePost.setBody(post.getBody());
        beforePost.setTags(post.getTags());

        return postRepository.save(beforePost);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
