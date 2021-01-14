package com.example.demo.DTOs;

import com.example.demo.Entities.BoardGame;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtensionDTO {

    private int id;
    private String extensionname;
    private String extdescription;
    private int extpublishyear;
    private String extImageLink;
    private BoardGame boardgame;
}
