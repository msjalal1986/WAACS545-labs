package miu.edu.lab.repo.Impl;

import miu.edu.lab.domain.Post;
import miu.edu.lab.repo.PostRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PostRepoImpl implements PostRepo {

    private static List<Post> postsList;

    static {
        postsList = new ArrayList<Post>();
        Post p1= new Post(1, "Post1", "This is 1st content", "Md Shah Jalal Mazumder");
        Post p2=new Post(2, "Post2", "This is 2nd content", "Md Abul Hashem Mazumder");
        postsList.add(p1);
        postsList.add(p2);

    }

    @Override
    public List<Post> findAllPosts() {
        return postsList;
    }

}
