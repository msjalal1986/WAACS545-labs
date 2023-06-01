package miu.edu.lab.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.Post;
import miu.edu.lab.repo.Impl.PostRepoImpl;
import miu.edu.lab.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

@Autowired
private PostRepoImpl postRepoImpl;

   // @Override
    public List<Post> findAllPosts() {
        System.out.println("Set from Service");
        return postRepoImpl.findPosts();
    }

    public List<Post> findAllPostsV2() {
        var posts = postRepoImpl.findAllPosts();
        return posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .map(p -> new Post(p.getId(), p.getTitle() + " v2", p.getContent(), p.getAuthor()))
                .collect(Collectors.toList());
    }

    @Override
    public Post findPostById(int id) {
        return modelMapper.map( postRepoImpl.findPostById(id), Post.class);
    }

    @Override
    public boolean deletePostById(int id) {
        return postRepoImpl.deletePostById(id);
    }

    @Override
    public boolean addPost(Post post) {
        var newPost = modelMapper.map(post, Post.class);
        var id = postRepoImpl.findAllPosts().size() + 1;

        newPost.setId(id);
        newPost.setCreatedDate(new Date());

        return postRepoImpl.addPost(newPost);
    }
}
