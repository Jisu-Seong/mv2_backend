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
public class Folder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fid;

    @NotNull
    private String foldername;

    @CreationTimestamp
    private LocalDateTime createTimeStamp;

    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;

    private boolean isModified;

    @ManyToOne
    @JoinColumn(name = "email") 
        private Member member;
    
    @OneToMany(mappedBy = "folder", cascade = CascadeType.REMOVE)
    private List<Voca> vocas;

    public void changeFolderName(String foldername) {
        this.foldername = foldername;
    }

    public void changeIsModified(boolean isModified) {
        this.isModified = isModified;
    }

    @Builder
    public Folder(String foldername, Member member) {
        this.member = member;
        this.foldername = foldername;
    }

}
