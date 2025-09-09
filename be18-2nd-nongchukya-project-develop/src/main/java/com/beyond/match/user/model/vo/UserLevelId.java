package com.beyond.match.user.model.vo;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class UserLevelId implements Serializable {

    private Integer userId;

    private Integer sportId;

    public UserLevelId() {}

    public UserLevelId(Integer userId, Integer sportId) {
        this.userId = userId;
        this.sportId = sportId;
    }
}