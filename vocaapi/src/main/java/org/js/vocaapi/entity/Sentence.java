package org.js.vocaapi.entity;

import java.time.LocalDateTime;

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
public class Sentence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    private String sentenceText;

    private Long orderNo;

    @CreationTimestamp
    private LocalDateTime createTimeStamp;

    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;

    private boolean isModified;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vid")
    private Voca voca;

    public void changeSentenceText(String text) {
        this.sentenceText = text;
    }

    public void changeOrderNo(Long no) {
        this.orderNo = no;
    }

    public void changeIsModified(boolean isModified) {
        this.isModified = isModified;
    }

    @Builder
    public Sentence(String sentenceText, Long orderNo, Voca voca) {
        this.sentenceText = sentenceText;
        this.orderNo = orderNo;
        this.voca = voca;
    }
}
