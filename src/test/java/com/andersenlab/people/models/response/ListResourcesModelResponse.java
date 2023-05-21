package com.andersenlab.people.models.response;
import com.andersenlab.people.models.ResourceModel;
import com.andersenlab.people.models.SupportModel;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ListResourcesModelResponse {
    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private ArrayList<ResourceModel> data;
    private SupportModel support;
}
