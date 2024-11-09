package org.js.vocaapi.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class VocaTagRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    @ManyToOne
    @JoinColumn(name = "vid")
    private Voca voca;

    @ManyToOne
    @JoinColumn(name = "tid")
    private Tag tag;

    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;

}
