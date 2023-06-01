package miu.edu.lab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Review {
    private int id;
    private String comment;
    private int starCount;
    private List<Review> list;
}
