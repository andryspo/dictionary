package com.andryspo.controller;

import com.andryspo.domain.dto.group.GroupDataDto;
import com.andryspo.domain.dto.group.GroupResponseDto;
import com.andryspo.domain.entity.WordGroup;
import com.andryspo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/add")
    public void addGroup(@RequestBody GroupDataDto group) {
        groupService.addGroup(group);
    }

    @GetMapping("/getGroups")
    public List<GroupResponseDto> getGroups(){
        return groupService.getGroups();
    }
}
