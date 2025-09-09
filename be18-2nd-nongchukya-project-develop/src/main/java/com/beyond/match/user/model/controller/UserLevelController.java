package com.beyond.match.user.model.controller;

import com.beyond.match.common.model.dto.BaseResponseDto;
import com.beyond.match.user.model.dto.UserLevelRequestDto;
import com.beyond.match.user.model.dto.UserLevelResponseDto;
import com.beyond.match.user.model.service.UserLevelService;
import com.beyond.match.user.model.vo.UserLevel;
import com.beyond.match.jwt.auth.model.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/mypage/levels")
@RequiredArgsConstructor
public class UserLevelController {

    private final UserLevelService userLevelService;

    // 1) 조회
    @GetMapping
    public BaseResponseDto<UserLevelResponseDto> getLevels(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            List<UserLevelResponseDto> levels = userLevelService.getUserLevels(userDetails.getUser())
                    .stream()
                    .map(UserLevelResponseDto::from)
                    .collect(Collectors.toList());

            // 조회 결과가 없으면 빈 리스트 반환
            if (levels.isEmpty()) {
                return new BaseResponseDto<>(HttpStatus.NO_CONTENT, Collections.emptyList());
            }

            return new BaseResponseDto<>(HttpStatus.OK, levels);

        } catch (Exception e) {
            // 예외 발생 시
            return new BaseResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR, Collections.emptyList());
        }
    }

    // 2) 수정/등록
    @PostMapping
    public BaseResponseDto<UserLevelResponseDto> updateLevel(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                             @RequestBody UserLevelRequestDto request) {
        UserLevel updated = userLevelService.updateUserLevel(
                userDetails.getUser(),
                request.getSportName(),
                request.getLevelId(),
                request.getInterest()
        );

        return new BaseResponseDto<>(HttpStatus.OK, UserLevelResponseDto.from(updated));
    }
}