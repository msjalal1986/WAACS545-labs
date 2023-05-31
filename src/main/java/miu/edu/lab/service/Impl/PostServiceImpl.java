package miu.edu.lab.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab.domain.Post;
import miu.edu.lab.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {


    @Override
    public List<Post> findAllPosts() {
        return null;
    }
}
