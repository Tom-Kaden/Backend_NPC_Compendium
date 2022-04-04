package de.tekay.npc_compendium.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Arrays;

@Getter
@Setter
public class CreateNpcDto {

    @Column(length = 10000000)
    private String image;
    private String name;
    private String race;
    private String belonging;
    private String description;
    private Boolean shopKeeper;
    private String shopLocation;
    private Boolean alive;

    @Override
    public String toString() {
        return "CreateNpcDto{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", belonging='" + belonging + '\'' +
                ", description='" + description + '\'' +
                ", shopKeeper=" + shopKeeper +
                ", shopLocation='" + shopLocation + '\'' +
                ", alive=" + alive +
                '}';
    }
}