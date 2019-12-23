package com.example.vlsubot_1_0.controller.common;

import com.example.vlsubot_1_0.model.commonObject.requestObject.CatalogIdRequest;
import com.example.vlsubot_1_0.model.commonObject.responseObject.CatalogIdResponse;
import com.example.vlsubot_1_0.model.entity.Institute;
import com.example.vlsubot_1_0.service.CatalogService;
import com.example.vlsubot_1_0.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/catalog")
public class CatalogRestController {

    private InstituteService instituteService;
    private CatalogService catalogService;


    @Autowired
    public CatalogRestController(InstituteService instituteService, CatalogService catalogService) {
        this.instituteService = instituteService;
        this.catalogService = catalogService;
    }

    @GetMapping("/institutes")
    public List<Institute> getAllInstitutes() {
        return instituteService.getAll();
    }

    @PostMapping("/common")
    public CatalogIdResponse getCommon(@RequestBody CatalogIdRequest request) {
        return catalogService.getCommonInfo(request);
    }
}
