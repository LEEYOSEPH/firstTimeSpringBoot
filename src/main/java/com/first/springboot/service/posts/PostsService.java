package com.first.springboot.service.posts;


import com.first.springboot.domain.posts.PostRepository;
import com.first.springboot.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return  postRepository.save(requestDto.toEntity()).getId();
    }



}
