package miu.edu.lab.service.Impl;

import miu.edu.lab.domain.User;
import miu.edu.lab.dto.UserDto;
import miu.edu.lab.dto.PostDto;
import miu.edu.lab.repo.UserRepo;
import miu.edu.lab.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    private ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<UserDto> findAll() {

        var users = userRepo.findAll();

        var usersDto = new ArrayList<UserDto>();

        users.forEach(u -> usersDto.add(modelMapper.map(u, UserDto.class)));

        return usersDto;
    }

    @Override
    public UserDto findById(int id) {
        var user = userRepo.findById((long) id);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<PostDto> findPostsById(int id) {
        var posts =  userRepo
                .findById((long) id)
                .get()
                .getPosts();

        return  posts.stream()
                .map(p -> modelMapper.map(p, PostDto.class))
                .toList();
    }

    @Override
    public void save(UserDto userDto) {
        var newUser = modelMapper.map(userDto, User.class);
        userRepo.save(newUser);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById((long) id);
    }

    public List<UserDto> findUsersByPostsCountGreaterThan(int count) {
        //TODO need to fix bug
        var users = userRepo.findUsersWithPosts(count);
        if(users != null) {
            return users.stream()
                    .map(u -> modelMapper.map(u, UserDto.class))
                    .toList();
        }
        else {
            return new ArrayList<UserDto>();
        }
    }
}
