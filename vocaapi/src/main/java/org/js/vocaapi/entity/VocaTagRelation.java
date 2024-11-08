package org.js.vocaapi.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
