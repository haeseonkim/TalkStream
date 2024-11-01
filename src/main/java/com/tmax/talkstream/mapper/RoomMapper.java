package com.tmax.talkstream.mapper;

import com.tmax.talkstream.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static com.tmax.talkstream.dto.web.RoomWebDto.*;

@Mapper
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    // Get
    // Response
    // Entity -> WebDto
    RoomWebRes toRoomWebRes(Room room);
}
