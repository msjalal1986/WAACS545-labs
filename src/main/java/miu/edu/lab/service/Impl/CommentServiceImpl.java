package miu.edu.lab.service.Impl;

import miu.edu.lab.dto.CommentDto;
import miu.edu.lab.domain.Comment;
import miu.edu.lab.service.CommetService;
import miu.edu.lab.repo.CommentRepo;
import miu.edu.lab.repo.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommetService{
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private PostRepo postRepo;

    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<CommentDto> findAll() {
        var comments = commentRepo.findAll();
        var dtos = new ArrayList<CommentDto>();

        comments.forEach(c -> {
            var newDto = modelMapper.map(c, CommentDto.class);
            newDto.setPostId(c.getPost().getId());
            dtos.add(newDto);
        });

        return dtos;
    }

    @Override
    public CommentDto findById(int id) {
        return  modelMapper.map(
                commentRepo.findById((long) id).get(),
                CommentDto.class
        );
    }

    @Override
    public void save( CommentDto commentDto) {
        var newComment = modelMapper.map(commentDto, Comment.class);
        var post = postRepo.findById((long) commentDto.getPostId()).get();
        newComment.setPost(post);
        commentRepo.save(newComment);
    }

    @Override
    public void deleteById(int id) {
        commentRepo.deleteById((long) id);
    }

}
