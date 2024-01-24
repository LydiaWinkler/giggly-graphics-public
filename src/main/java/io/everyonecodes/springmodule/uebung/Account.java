//package io.everyonecodes.springmodule.uebung;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Account {
//    @Id
//    @GeneratedValue()
//    private long id;
//
//    private String username;
//
//    @Column(unique = true)
//    private String email;
//
//    @OneToMany(targetEntity = Post.class)
//    private List<Post> posts;
//}
