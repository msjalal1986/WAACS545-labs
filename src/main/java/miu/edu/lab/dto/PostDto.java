package miu.edu.lab.dto;


import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
    private int userId;
}
