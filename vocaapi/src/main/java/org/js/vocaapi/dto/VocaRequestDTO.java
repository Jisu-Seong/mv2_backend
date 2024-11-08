package org.js.vocaapi.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VocaRequestDTO {
    private Long vid;
    private Long fid;

    @NotBlank
    private String vocaname;
    private boolean isMarked;
    private LocalDateTime createTimeStamp;
    private LocalDateTime updateTimeStamp;
    private boolean isModified;


}