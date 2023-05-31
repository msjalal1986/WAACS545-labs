package miu.edu.lab.repo;

import miu.edu.lab.domain.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAllPosts();

}
