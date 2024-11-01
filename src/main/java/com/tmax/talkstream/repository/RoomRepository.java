package com.tmax.talkstream.repository;

import com.tmax.talkstream.model.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository  extends JpaRepository<Room, Long> {
    @NonNull
    Page<Room> findAll(@NonNull Pageable pageable);
}