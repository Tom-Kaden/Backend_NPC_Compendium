package de.tekay.npc_compendium.dto;

import de.tekay.npc_compendium.entity.Npc;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateNpcDto extends Npc {

    private Long id;
    private String name;
    private String shopLocation;
    private String belonging;
    private String race;
    private String description;
    private Boolean shopKeeper;
    private Boolean alive;
//    private Blob picture;

}
