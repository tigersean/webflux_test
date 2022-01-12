package com.example.webflux_test.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author HelloWood
 * @date 2019-01-08 14:20
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("POST")
public class Post {

    @Id
    private Long id;

    private String title;

    private String content;

}
