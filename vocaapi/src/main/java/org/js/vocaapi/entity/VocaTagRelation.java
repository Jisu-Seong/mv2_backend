package org.js.vocaapi.entity;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "vocaTagRelation")
    private List<Voca> vocas = new ArrayList<>();

    @OneToMany(mappedBy = "vocaTagRelation")
    private List<Tag> tags = new ArrayList<>();

}
