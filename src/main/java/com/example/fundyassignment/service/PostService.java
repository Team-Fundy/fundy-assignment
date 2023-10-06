package com.example.fundyassignment.service;

import com.example.fundyassignment.service.dto.request.PostSaveServiceRequest;
import com.example.fundyassignment.service.dto.response.PostInfoServiceResponse;

public interface PostService {
    public long savePost(PostSaveServiceRequest request);
    public PostInfoServiceResponse findById(long id);
    public PostInfoServiceResponse findByNickname(String nickname);
}
