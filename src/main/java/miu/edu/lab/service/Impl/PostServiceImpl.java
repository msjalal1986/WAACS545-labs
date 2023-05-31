package miu.edu.lab.service.Impl;

import lombok.RequiredArgsConstructor;
import miu.edu.lab.repo.PostRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl {
    private final PostRepo postRepo;

}
