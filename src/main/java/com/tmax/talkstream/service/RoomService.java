package com.tmax.talkstream.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tmax.talkstream.repository.RoomRepository;
import com.tmax.talkstream.model.Room;

import static com.tmax.talkstream.dto.web.RoomWebDto.RoomWebRes;
import static com.tmax.talkstream.dto.service.RoomDto.GetReq;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository repo;

    @Transactional(readOnly = true)
    public Page<RoomWebRes> findAllPaging(GetReq req) {
        Sort sort = req.getField() != null ? Sort.by(req.getSort(), req.getField())
                : Sort.by(Sort.Direction.DESC, "roomId");

        PageRequest pr = PageRequest.of(req.getPage(), req.getSize(), sort);

        Page<Room> rooms = repo.findAll(pr);

        return new PageImpl<>(
                rooms.getContent()
                        .stream()
                        .map(RoomWebRes::of)
                        .toList(),
                pr,
                rooms.getTotalElements()
        );
    }
}
