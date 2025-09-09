package com.beyond.match.user.model.repository;

import com.beyond.match.user.model.vo.Sport;
import com.beyond.match.user.model.vo.User;
import com.beyond.match.user.model.vo.UserLevel;
import com.beyond.match.user.model.vo.UserLevelId;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserLevelRepository extends JpaRepository<UserLevel, UserLevelId> {
    List<UserLevel> findByUser(User user);
    Optional<UserLevel> findByUserAndSport(User user, Sport sport);

}