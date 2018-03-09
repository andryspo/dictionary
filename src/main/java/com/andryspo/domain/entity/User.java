package com.andryspo.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Base {

    @Column(name = "login", unique = true)
    @NotNull
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<WordGroup> wordGroups = new ArrayList<>();

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<WordGroup> getWordGroups() {
        return wordGroups;
    }

    public void setWordGroups(List<WordGroup> wordGroups) {
        this.wordGroups = wordGroups;
    }
}
