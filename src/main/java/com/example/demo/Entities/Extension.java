package com.example.demo.Entities;

import com.example.demo.Entities.BoardGame;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "extensions")
public class Extension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String extensionname;
    @Lob
    private String extdescription;
    private int extpublishyear;
    @Lob
    private String extImageLink;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "boardgame_id")
    private BoardGame boardgame;

    @Override
    public String toString() {
        return "Extension{" +
                "id=" + id +
                ", extensionname='" + extensionname + '\'' +
                ", extdescription='" + extdescription + '\'' +
                ", extpublishyear=" + extpublishyear +
                ", extImageLink='" + extImageLink + '\'' +
                '}';
    }
}
