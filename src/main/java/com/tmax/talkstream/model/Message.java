package com.tmax.talkstream.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long msgId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId", referencedColumnName = "roomId", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId", referencedColumnName = "userId", nullable = false)
    private User sender;

    @NotNull
    @Column(length = 50, nullable = false)
    private String senderName;

    @NotNull
    @Column(length = 15000, updatable = false, nullable = false)
    private String content;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;
}
