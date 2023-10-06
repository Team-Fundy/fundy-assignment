package com.example.fundyassignment.service.dto;

import com.example.fundyassignment.repository.Post;
import com.example.fundyassignment.repository.PostRepository;
import com.example.fundyassignment.repository.User;
import com.example.fundyassignment.service.PostService;
import com.example.fundyassignment.service.dto.request.PostSaveServiceRequest;
import com.example.fundyassignment.service.dto.response.PostInfoServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {
    private final PostRepository postRepository;

    @Override
    public long savePost(PostSaveServiceRequest request){
        Post post = postRepository.save(Post.builder()
                .title(request.getTitle())
                .text(request.getText())
                .author(request.getText())
                .build());
        return post.getId();
    }

    @Override
    public PostInfoServiceResponse findById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("no Post"));

        return PostInfoServiceResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .text(post.getText())
                .nickname(post.getNickname())
                .build();
    }
    @Override
    public PostInfoServiceResponse findByNickname(String nickname) {
        Post post = postRepository.findByNickname(nickname).orElseThrow(() -> new RuntimeException("no Post"));
        User user = new User();
        return PostInfoServiceResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .text(post.getText())
                .nickname(post.getNickname())
                .build();
    }






}
