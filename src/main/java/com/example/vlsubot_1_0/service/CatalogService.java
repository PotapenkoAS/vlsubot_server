package com.example.vlsubot_1_0.service;

import com.example.vlsubot_1_0.model.commonObject.requestObject.CatalogIdRequest;
import com.example.vlsubot_1_0.model.commonObject.responseObject.CatalogIdResponse;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {

    private GroupService groupService;
    private DepartmentService departmentService;
    private InstituteService instituteService;

    public CatalogService(GroupService groupService, DepartmentService departmentService, InstituteService instituteService) {
        this.groupService = groupService;
        this.departmentService = departmentService;
        this.instituteService = instituteService;
    }

    public CatalogIdResponse getCommonInfo(CatalogIdRequest request){
        return new CatalogIdResponse(
                groupService.getById(request.getGroupId()),
                departmentService.getById(request.getDepartmentId()),
                instituteService.getById(request.getInstituteId()));
    }
}
