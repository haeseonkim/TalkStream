package com.tmax.talkstream.dto.service;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Sort;

public class RoomDto {

    private RoomDto() {
        throw new IllegalStateException("Dto group class");
    }

    @Getter
    @Builder
    public static class GetReq {
        private String roomId;
        private int page;
        private int size;
        private String field;
        private Sort.Direction sort;
    }
}
