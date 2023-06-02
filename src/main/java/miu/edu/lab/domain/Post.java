package miu.edu.lab.domain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String author;
    private Date createdDate;

    @ManyToOne

    @JsonBackReference
    private User user;


    public Post(int id, String title, String content, String author) {
        this.id=id;
        this.title=title;
        this.content=content;
        this.author=author;
    }
}
