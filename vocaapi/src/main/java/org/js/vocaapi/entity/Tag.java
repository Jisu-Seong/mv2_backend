package org.js.vocaapi.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private String tagname;

    @CreationTimestamp
    private LocalDateTime createTimeStamp;

    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;

    private boolean isModified;

    public void changeTagName(String tagname) {
        this.tagname = tagname;
    }

    public void changeIsModified(boolean isModified) {
        this.isModified = isModified;
    }

    @OneToMany(mappedBy = "tag", cascade = CascadeType.REMOVE)
    private List<VocaTagRelation> vocaTagRelations;

    @ManyToOne
    @JoinColumn(name = "email")
    private Member member;

    @Builder
    public Tag(String tagname, Member member) {
        this.member = member;
        this.tagname = tagname;
    }
}
