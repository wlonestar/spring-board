package com.wjl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private Integer id;
    private String username;
    private String comment;
    private Date time;
    private String photo;

}
