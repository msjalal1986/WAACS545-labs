package miu.edu.lab.repo;

import org.springframework.beans.factory.annotation.Autowired;

public interface ProductRepo {
@Autowired
    private static List<Post> postsList;
    @Override
    public List<Post> findAllPosts() {
        return postsList;
    }

    @Override
    public Post findPostById(int id) {
        return postsList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deletePostById(int id) {
        var prevCount = postsList.size();

        postsList = (ArrayList<Post>) postsList.stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());

        if (postsList.size() < prevCount)
            return true;
        else
            return false;
    }

    @Override
    public boolean addPost(Post post) {
        return postsList.add(post);
    }


    public boolean updatePost(Post updatedPost) {

        var oldPost = postsList.stream()
                .filter(post -> post.getId() == updatedPost.getId())
                .findFirst()
                .get();

        //update other properties
        updatedPost.setCreatedDate(oldPost.getCreatedDate());

        //remove old post
        var filteredList = postsList
                .stream()
                .filter(p -> p.getId() != oldPost.getId())
                .toList();

        //add updated post
        postsList = new ArrayList<>(filteredList);
        postsList.add(updatedPost);

        return   true;
    }

}
