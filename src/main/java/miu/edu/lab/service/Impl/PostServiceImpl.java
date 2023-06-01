package miu.edu.lab.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.Post;
import miu.edu.lab.repo.Impl.PostRepoImpl;
import miu.edu.lab.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
