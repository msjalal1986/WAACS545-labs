package miu.edu.lab.service;

import miu.edu.lab.domain.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAllPosts();
    List<Post> findAllPostsV2();
    public Post findPostById(int id);
    public boolean deletePostById(int id);
    public boolean addPost(Post post);

    boolean updatePost(Post post);

}
