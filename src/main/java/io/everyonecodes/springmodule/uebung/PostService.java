//package io.everyonecodes.springmodule.uebung;
//
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PostService {
//    private final PostRepository repository;
//
//    public PostService(PostRepository repository) {
//        this.repository = repository;
//    }
//
//    public List<Post> findAll() {
//        return repository.findAll();
//    }
//
//    public Optional<Post> singlePost(long id) {
//        return repository.findById(id);
//    }
//
//    public void deletePost(long id) {
//        repository.deleteById(id);
//    }
//
//    public Post save(Post post) {
//        return repository.save(post);
//    }
//
//    public List<Post> findAllPublished() {
//        return repository.findByPublishedOnBeforeOrderByPublishedOn(LocalDateTime.now());
//    }
//}
