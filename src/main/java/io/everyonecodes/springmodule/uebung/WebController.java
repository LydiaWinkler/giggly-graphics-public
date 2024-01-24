//package io.everyonecodes.springmodule.uebung;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class WebController {
//    private final PostService service;
//
//    public WebController(PostService service) {
//        this.service = service;
//    }
//
////    @GetMapping("/")
////    String index() {
////        return "index";
////    }
//
//    @GetMapping("/")
//    ModelAndView index() {
//        ModelAndView mav = new ModelAndView("index");
//        mav.addObject("posts", service.findAllPublished());
//        return mav;
//    }
//
//    @GetMapping("/post/{id}")
//    ModelAndView singlePost(@PathVariable long id) {
//        ModelAndView mav = new ModelAndView("singlePost");
//        mav.addObject("post", service.singlePost(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found")));
//        return mav;
//    }
//
//}
