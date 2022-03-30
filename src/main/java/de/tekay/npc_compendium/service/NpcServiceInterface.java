package de.tekay.npc_compendium.service;

import de.tekay.npc_compendium.dto.CreateNpcDto;
import de.tekay.npc_compendium.dto.UpdateNpcDto;
import de.tekay.npc_compendium.entity.Npc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NpcServiceInterface {

    Npc create(CreateNpcDto npcDto);
    Npc update(UpdateNpcDto npcDto);
    void deleteNpc(Long id);
    Npc readNpc(Long id);
    List<Npc> allNpcs();
    List<Npc> readAliveNpcs();
    List<Npc> readDeadNpcs();
    List<Npc> readShopkeeper();

}