package de.tekay.npc_compendium.dto;

import de.tekay.npc_compendium.entity.Npc;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class UpdateNpcDto extends Npc {

    private Long id;
    @Column(length = 10000000)
    private String image;
    private String name;
    private String race;
    private String belonging;
    private String description;
    private Boolean shopKeeper;
    private String shopLocation;
    private Boolean alive;

}