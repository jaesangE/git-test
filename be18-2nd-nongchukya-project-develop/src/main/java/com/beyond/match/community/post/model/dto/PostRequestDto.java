package com.beyond.match.community.post.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class PostRequestDto {
    private final String title;

    private final String content;

    private final int categoryId;
}
