package com.beyond.match.mypage.model.dto;

import com.beyond.match.mypage.model.entity.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReportResponseDto {
    private int reportId;
    private int reporterId;
    private int targetUserId;
    private String reason;
    private String description;
    private String evidenceUrl;
    private String status;

    public static ReportResponseDto from(Report report) {
        return new ReportResponseDto(
                report.getReportId(),
                report.getReporter().getUserId(),
                report.getTargetUser().getUserId(),
                report.getReason(),
                report.getDescription(),
                report.getEvidenceUrl(),
                report.getStatus()
        );
    }
}