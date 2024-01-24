//package io.everyonecodes.springmodule.uebung;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class PostController {
//
//    private final PostService service;
//
//    public PostController(PostService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/post")
//    public List<Post> findAll() {
//        return service.findAll();
//    }
//
//    @GetMapping("/post/{id}")
//    private Post singlePost(@PathVariable long id) {
//        return service.singlePost(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ("Page not found.")));
//    }
//
//    @PostMapping("/post")
//    private Post createAndAdd(@RequestBody Post post) {
//        return service.save(post);
//    }
//
//    @DeleteMapping("/post/{id}")
//    private void deletePost(@PathVariable Long id) {
//        service.deletePost(id);
//    }
//
//    @PutMapping("/post/{id}")
//    private Post updatePost(@RequestBody Post post) {
//        return service.save(post);
//    }
//}
