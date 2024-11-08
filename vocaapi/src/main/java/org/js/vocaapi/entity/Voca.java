package org.js.vocaapi.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
public class Voca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vid;

    @NotNull
    private String vocaname;

    private boolean isMarked;

    @CreationTimestamp
    private LocalDateTime createTimeStamp;

    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;

    private boolean isModified;

    public void changeVocaname(String vocaname) {
        this.vocaname = vocaname;
    }

    public void changeMark(boolean isMarked) {
        this.isMarked = isMarked;
    }

    public void changeIsModified(boolean isModified) {
        this.isModified = isModified;
    }

    @ManyToOne
    @JoinColumn(name = "email")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "fid")
    private Folder folder;

    @OneToMany(mappedBy = "voca", cascade = CascadeType.REMOVE)
    private List<VocaTagRelation> vocaTagRelations;

    @OneToMany(mappedBy = "voca", cascade = CascadeType.REMOVE)
    private List<Meaning> meanings = new ArrayList<>();
    
    @OneToMany(mappedBy = "voca", cascade = CascadeType.REMOVE)
    private List<Sentence> sentences = new ArrayList<>();

    @Builder
    public Voca(String vocaname, boolean isMarked, Member member, Folder folder, List<Meaning> meanings, List<Sentence> sentences) {
        this.member = member;
        this.folder = folder;
        this.vocaname = vocaname;
        this.meanings = meanings;
        this.sentences = sentences;
    }
}
