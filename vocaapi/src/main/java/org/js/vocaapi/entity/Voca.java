package org.js.vocaapi.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
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

    public void changeUpdateAt() {
        this.updateTimeStamp = LocalDateTime.now();
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

    // @ManyToMany
    // @JoinTable(name = "relation", joinColumns = @JoinColumn(name = "vid"), inverseJoinColumns = @JoinColumn(name = "tid"))
    // private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "rid")
    private VocaTagRelation vocaTagRelation;

    @OneToMany(mappedBy = "voca", cascade = CascadeType.REMOVE)
    private List<Meaning> meanings = new ArrayList<>();
    
    @OneToMany(mappedBy = "voca", cascade = CascadeType.REMOVE)
    private List<Sentence> sentences = new ArrayList<>();

    @Builder
    public Voca(String vocaname, boolean isMarked, Member member, Folder folder, List<Meaning> meanings, List<Sentence> sentences) {
        this.member = member;
        this.folder = folder;
        this.vocaname = vocaname;
        this.createTimeStamp = LocalDateTime.now();
        this.meanings = meanings;
        this.sentences = sentences;
    }
}
