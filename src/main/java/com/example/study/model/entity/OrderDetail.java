package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // order_detail
//lombok의 상호참조때문에, ToString으로 제외시켜준다.
@ToString(exclude = {"user","item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    // N : 1
    //객체로 받아야함.
    @ManyToOne
    private User user;

    //N : 1
    @ManyToOne
    private Item item;

}
