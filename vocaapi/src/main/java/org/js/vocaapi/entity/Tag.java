package org.js.vocaapi.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Tag {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;

    private String tagname;

    @CreationTimestamp
    private LocalDateTime createTimeStamp;

    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;

    private boolean isModified;

    public void changeTagName(String tagname) {
        this.tagname = tagname;
    }

    public void changeUpdateAt() {
        this.updateTimeStamp = LocalDateTime.now();
    }

    public void changeIsModified(boolean isModified) {
        this.isModified = isModified;
    }

    @ManyToOne
    @JoinColumn(name = "rid")
    private VocaTagRelation vocaTagRelation;

    @ManyToOne
    @JoinColumn(name = "email")
    private Member member;

    @Builder
    public Tag(String tagname, Member member) {
        this.member = member;
        this.tagname = tagname;
        this.createTimeStamp = LocalDateTime.now();
    }
}
