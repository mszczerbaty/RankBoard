package com.example.demo.Entities;

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
    private String extdescription;
    private int extpublishyear;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardgame_id")
    private BoardGame boardgame;

    public Extension(String extensionname, String extdescription, int extpublishyear) {
        this.extensionname = extensionname;
        this.extdescription = extdescription;
        this.extpublishyear = extpublishyear;
    }

    @Override
    public String toString() {
        return "Extension{" +
                "id=" + id +
                ", extensionname='" + extensionname + '\'' +
                ", extdescription='" + extdescription + '\'' +
                ", extpublishyear=" + extpublishyear +
                '}';
    }
}
