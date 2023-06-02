package miu.edu.lab.service;

import miu.edu.lab.dto.CommentDto;
import miu.edu.lab.service.Impl.CommentServiceImpl;

import java.util.List;

public interface CommetService{
   List<CommentDto> findAll();
    CommentDto findById(int id);

    void save(CommentDto commentDto);

    void deleteById(int id);

}
