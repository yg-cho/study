package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String content;

    // 1 : N

    // LAZY = 지연로딩, EAGER = 즉시로딩
    // LAZY = SELECT * FROM item where id = ?
    // 연관관계가 설정된 테이블에 대해서 검색 하지 않겠다.
    // EAGER Default = 1:1 / ManyToOne 일때 추천하는 방식.
    // 모든테이블에 대해 join 하여 검색
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
