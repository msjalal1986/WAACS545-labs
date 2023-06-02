package miu.edu.lab.repo;

import miu.edu.lab.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    //public String findAllPosts();

}
