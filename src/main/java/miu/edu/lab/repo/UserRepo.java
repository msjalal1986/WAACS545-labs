package miu.edu.lab.repo;

import miu.edu.lab.domain.Post;
import miu.edu.lab.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM users u WHERE u.id IN (SELECT p.user_id FROM posts p GROUP BY p.user_id HAVING count(*) > :count)", nativeQuery = true)
    public List<User> findUsersWithPosts(int count);

    User findByEmail(String email);

}
