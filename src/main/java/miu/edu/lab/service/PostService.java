package miu.edu.lab.service;

import miu.edu.lab.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAll();
    List<PostDto> findAllV2();
    public PostDto findPostById(int id);
    public boolean deletePostById(int id);
    public boolean addPost(PostDto postDto);

    boolean updatePost(PostDto postDto);


}
