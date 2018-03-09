package com.andryspo.domain.dto.group;

public class GroupDataDto {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GroupDataDto() {
    }

    public GroupDataDto(String title) {
        this.title = title;
    }
}
