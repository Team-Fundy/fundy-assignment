package com.example.fundyassignment.service;

import com.example.fundyassignment.repository.Post;
import com.example.fundyassignment.repository.PostRepository;
import com.example.fundyassignment.repository.User;
import com.example.fundyassignment.repository.UserRepository;
import com.example.fundyassignment.service.PostService;
import com.example.fundyassignment.service.dto.request.PostSaveServiceRequest;
import com.example.fundyassignment.service.dto.response.PostInfoServiceResponse;
import com.example.fundyassignment.service.dto.response.UserInfoServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Override
    public long savePost(PostSaveServiceRequest request){

        User user = userRepository.findById(request.getUserid()).orElseThrow(() -> new RuntimeException("No User Id"));

        if(!user.getAuthority().equals("C")) {
            throw new RuntimeException(String.valueOf(user.getAuthority()));
        }


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
                .userid(post.getId())
                .build();
    }
    @Override
    public PostInfoServiceResponse findByNickname(String nickname) {
        Post post = postRepository.findByNickname(nickname).orElseThrow(() -> new RuntimeException("no Post"));
        return PostInfoServiceResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .text(post.getText())
                .userid(post.getId())
                .build();
    }






}
