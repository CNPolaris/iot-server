package com.polaris.model.iot;

import java.util.List;

import lombok.Data;

@Data
public class GetTaskListResponse {
    private Long total;
    private Integer size;
    private List<TaskResponseBean> list;
}