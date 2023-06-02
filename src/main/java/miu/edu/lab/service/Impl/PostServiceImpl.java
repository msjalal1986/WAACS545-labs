package miu.edu.lab.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.Post;
import miu.edu.lab.dto.PostDto;
import miu.edu.lab.repo.Impl.PostRepoImpl;
import miu.edu.lab.repo.PostRepo;
import miu.edu.lab.repo.UserRepo;
import miu.edu.lab.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

@Autowired
private PostRepo postRepo;
@Autowired
private UserRepo userRepo;
@Autowired
private PostRepoImpl postRepoImpl;


    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PostDto> findAll() {
        var posts = postRepo.findAll();
        return posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .collect(Collectors.toList());
    }

    public List<PostDto> findAllV2() {
        var posts = postRepo.findAll();
        return posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .map(p -> new PostDto(p.getId(), p.getTitle() + " v2", p.getContent(), p.getAuthor(), p.getUserId()))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findPostById(int id) {
        return modelMapper.map( postRepo.findById((long) id), PostDto.class);
    }

    @Override
    public boolean deletePostById(int id) {
        postRepo.deleteById((long) id);
        return true;
    }

    @Override
    public boolean addPost(PostDto postDto) {
        var newPost = modelMapper.map(postDto, Post.class);
        var user = userRepo.findById((long) postDto.getUserId()).get();

        newPost.setUser(user);
        newPost.setCreatedDate(new Date());

        postRepo.save(newPost);

        return true;
    }

    @Override
    public boolean updatePost(PostDto postDto) {
        var post = modelMapper.map(postDto, Post.class);
        postRepo.save(post);
        return true;
    }
}

