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
public class Meaning {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nid;

    private String meaningText;

    private String className;

    private Long orderNo;

    @CreationTimestamp
    private LocalDateTime createTimeStamp;

    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;

    private boolean isModified;

    @ManyToOne
    @JoinColumn(name = "vid")
    private Voca voca;

    public void changeMeaningText(String text) {
        this.meaningText = text;
    }

    public void changeClassName(String className) {
        this.className = className;
    }

    public void changeOrderNo(Long no) {
        this.orderNo = no;
    }

    public void changeUpdateAt() {
        this.updateTimeStamp = LocalDateTime.now();
    }

    public void changeIsModified(boolean isModified) {
        this.isModified = isModified;
    }

    @Builder
    public Meaning(String meaningText, String className, Voca voca) {
        this.meaningText = meaningText;
        this.className = className;
        this.voca = voca;
        this.createTimeStamp = LocalDateTime.now();
    }
}
