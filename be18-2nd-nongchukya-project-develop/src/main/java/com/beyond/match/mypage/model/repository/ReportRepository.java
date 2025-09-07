package com.beyond.match.mypage.model.repository;


import com.beyond.match.mypage.model.entity.Report;
import com.beyond.match.user.model.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    // 필요하면 추가적인 쿼리 메서드 작성 가능
    List<Report> findByReporter(User reporter);

    List<Report> findByTargetUser(User targetUser);
}