//package io.everyonecodes.springmodule.uebung;
//
//import jakarta.persistence.*;
//import lombok.*;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Post {
//    @Id
//    @GeneratedValue()
//    private long id;
//    @Basic(optional = false)
//    @Column(name = "Title", columnDefinition = "TEXT")
//    private String title;
//    @Basic(optional = false)
//    @Column(name = "Content", columnDefinition = "TEXT")
//    private String content;
//    private LocalDateTime publishedOn;
//
//    public Post(String title, String content, LocalDateTime publishedOn) {
//        this.title = title;
//        this.content = content;
//        this.publishedOn = publishedOn;
//    }
//}
