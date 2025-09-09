package com.beyond.match.user.model.dto;

import com.beyond.match.user.model.vo.UserLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLevelResponseDto {
    private String sportName;
    private String levelName;
    private String levelDescription;
    private Boolean interest;
    private String updateTime;

    public static UserLevelResponseDto from(UserLevel userLevel) {
        return new UserLevelResponseDto(
                userLevel.getSport().getName(),
                userLevel.getLevel().getName(),
                userLevel.getLevel().getDescription(),
                userLevel.getInterest(),
                userLevel.getUpdatedAt().toString()
        );
    }
}