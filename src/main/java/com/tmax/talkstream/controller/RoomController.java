package com.tmax.talkstream.controller;

import com.tmax.talkstream.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import static com.tmax.talkstream.dto.web.RoomWebDto.*;
import static com.tmax.talkstream.dto.service.RoomDto.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/talk/v1/live/rooms")
public class RoomController {
    private final RoomService roomService;

    @Operation(summary = "전체 채팅룸 조회 API")
    @GetMapping("/get-rooms")
    public Page<RoomWebRes> getRooms(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "15") int size,
            @RequestParam(value = "field", required = false) String field,
            @RequestParam(value = "sort", required = false, defaultValue = "ASC") Sort.Direction sort
    ) {
        return roomService.findAllPaging(
                GetReq.builder()
                        .page(page)
                        .size(size)
                        .field(field)
                        .sort(sort)
                        .build()
        );
    }
}
