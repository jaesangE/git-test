package com.beyond.match.user.model.service;

import com.beyond.match.user.model.repository.SportRepository;
import com.beyond.match.user.model.repository.UserLevelRepository;
import com.beyond.match.user.model.vo.Sport;
import com.beyond.match.user.model.vo.User;
import com.beyond.match.user.model.vo.UserLevel;
import com.beyond.match.user.model.vo.UserLevelId;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserLevelService {

    private final UserLevelRepository userLevelRepository;
    private final SportRepository sportRepository;

    // 조회
    public List<UserLevel> getUserLevels(User user) {
        return userLevelRepository.findByUser(user);
    }

    // 수정/등록
    @Transactional
    public UserLevel updateUserLevel(User user, String sportName, Integer levelId, Boolean interest) {
        Sport sport = sportRepository.findByName(sportName)
                .orElseThrow(() -> new EntityNotFoundException("해당 운동이 존재하지 않습니다."));

        UserLevel userLevel = userLevelRepository.findByUserAndSport(user, sport)
                .orElseGet(() -> {
                    UserLevel ul = new UserLevel();
                    ul.setId(new UserLevelId(user.getUserId(), sport.getId()));
                    ul.setUser(user);
                    ul.setSport(sport);
                    return ul;
                });

        // 레벨 PK 연결
        userLevel.setLevel(new com.beyond.match.user.model.vo.Level());
        userLevel.getLevel().setId(levelId);

        // 관심 운동 여부
        userLevel.setInterest(interest != null ? interest : false);

        return userLevelRepository.save(userLevel);
    }
}
