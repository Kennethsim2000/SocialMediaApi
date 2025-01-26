package com.example.Demo.vo;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class PostVo {

    private Long id;
    private LocalDateTime created_at;
    private String title;
    private String content;
    private String author;
}
