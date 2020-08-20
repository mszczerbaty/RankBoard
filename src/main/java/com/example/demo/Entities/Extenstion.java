package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Extenstion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String extenstionname;
    private String extdescription;
    private int extpublishyear;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardgame_id")
    private BoardGame boardgame;

    public Extenstion(String extenstionname, String extdescription, int extpublishyear) {
        this.extenstionname = extenstionname;
        this.extdescription = extdescription;
        this.extpublishyear = extpublishyear;
    }

    @Override
    public String toString() {
        return "Extenstion{" +
                "id=" + id +
                ", extenstionname='" + extenstionname + '\'' +
                ", extdescription='" + extdescription + '\'' +
                ", extpublishyear=" + extpublishyear +
                '}';
    }
}
