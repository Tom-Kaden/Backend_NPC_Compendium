package de.tekay.npc_compendium.dto;

import lombok.Data;

@Data
public class CreateNpcDto {

    private String name;
    private String belonging;
    private String race;
    private String description;
    private String shopLocation;
    private Boolean shopKeeper;
    private Boolean alive;
}
