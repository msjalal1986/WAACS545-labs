package miu.edu.lab.domain;

import java.util.Date;

public class Post {
    long id;
    String title;
    String content;
    String author;

    public Post(int id, String title, String content, String author) {
        this.id=id;
        this.title=title;
        this.content=content;
        this.author=author;
    }
}
