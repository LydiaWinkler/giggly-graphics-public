//package io.everyonecodes.springmodule;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class PostRepository {
//
//    private List<Post> posts = new ArrayList<>(List.of(
//            new Post("This is the first text", "Title 1", LocalDateTime.of(2019, 03, 28, 14, 33, 48, 640000)),
//            new Post("This is the second text", "Title 2",LocalDateTime.of(2024, 03, 28, 14, 33, 48, 640000))
//    ));
//    private long currentId = 2;
//
//    public List<Post> findAll() {
//        return posts;
//    }
//
//    public Optional<Post> singlePost(long id) {
//        return posts.stream()
//                .filter(e -> e.getId() == id)
//                .findFirst();
//    }
//
//    public void deletePost(long id) {
//        posts.remove((int) id);
//    }
//
//    public Post save(Post post) {
//        posts.stream()
//                .filter(e -> e.getId() == post.getId())
//                .findFirst()
//                .ifPresentOrElse(e -> {
//                    e.setTitle(post.getTitle());
//                    e.setContent(post.getContent());
//                }, () -> {
//                    posts.add(new Post(currentId, post.getContent(), post.getTitle(), post.getPublishedOn()));
//                    currentId++;
//                });
//
//        return posts.stream()
//                .filter(e -> e.getId() == post.getId())
//                .findFirst()
//                .get();
//
//
////        posts.stream()
////                .filter(e -> e.getId() == post.getId())
////                .findFirst()
////                .map(e -> {
////                    e.setTitle(post.getTitle());
////                    e.setContent(post.getContent());
////                    return e;
////                })
////                .
//    }
//
//    public List<Post> findAllPublished() {
//        return posts.stream()
//                .filter(e -> e.getPublishedOn().isBefore(LocalDateTime.now()))
//                .toList();
//    }
//}
