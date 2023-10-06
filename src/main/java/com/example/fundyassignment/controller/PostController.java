package com.example.fundyassignment.controller;


import com.example.fundyassignment.controller.dto.request.SavePostRequest;
import com.example.fundyassignment.service.PostService;
import com.example.fundyassignment.service.UserService;
import com.example.fundyassignment.service.dto.request.PostSaveServiceRequest;
import com.example.fundyassignment.service.dto.response.PostInfoServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @PostMapping
    public final long savePost(@RequestBody SavePostRequest request){
        return postService.savePost(PostSaveServiceRequest.builder()
                .title(request.getTitle())
                .text(request.getText())
                .nickname(request.getNickname())
                .build());
    }

    @GetMapping("/{nickname}")
    public final PostInfoServiceResponse getPostByNickname(@PathVariable(name = "nickname") String nickname){
        return postService.findByNickname(nickname);
    }


}
