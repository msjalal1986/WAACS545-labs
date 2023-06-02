package miu.edu.lab.service;

import miu.edu.lab.dto.PostDto;
import miu.edu.lab.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(int id);

    List<PostDto> findPostsById(int id);

    void save(UserDto userDto);

    void deleteById(int id);

    public List<UserDto> findUsersByPostsCountGreaterThan(int count);

}
