package com.tmax.talkstream.dto.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tmax.talkstream.mapper.RoomMapper;
import com.tmax.talkstream.model.Room;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

public class RoomWebDto {

    private RoomWebDto() {
        throw new IllegalStateException("Dto group class");
    }

    @Builder
    @Data
    public static class RoomWebRes {
        private Long roomId;
        private String roomName;
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "UTC")
        private ZonedDateTime createdAt;

        public static RoomWebRes of(Room room) {
            return RoomMapper.INSTANCE.toRoomWebRes(room);
        }
    }
}
