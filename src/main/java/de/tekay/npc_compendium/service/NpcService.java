package de.tekay.npc_compendium.service;

import de.tekay.npc_compendium.dto.CreateNpcDto;
import de.tekay.npc_compendium.dto.UpdateNpcDto;
import de.tekay.npc_compendium.entity.Npc;
import de.tekay.npc_compendium.repository.NpcRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Service
public class NpcService implements NpcServiceInterface {

    @Autowired
    private NpcRepository npcRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Npc create(CreateNpcDto npc) {
        System.out.println("NPC Image in NPCService: " + Arrays.toString(npc.getImage()));
        System.out.println("NPC Image in ModelMapper: " + modelMapper.map(npc, Npc.class).toString());
        return npcRepository.save(modelMapper.map(npc, Npc.class));
    }

    @Override
    public Npc update(UpdateNpcDto npcDto) {
        Npc old = npcRepository.findById(npcDto.getId()).orElseThrow(
                () -> new EntityNotFoundException("ID NOT FOUND!")
        );
        modelMapper.map(npcDto, old);
        return npcRepository.save(old);
    }

    @Override
    public void deleteNpc(Long id) {
        npcRepository.deleteById(id);
    }

    @Override
    public Npc readNpc(Long id) {
        return npcRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID NOT FOUND!")
        );
    }

    @Override
    public List<Npc> allNpcs() {
        return (List<Npc>) npcRepository.findAll();
    }

    @Override
    public List<Npc> readAliveNpcs() {
        return npcRepository.findByAliveTrue();
    }

    @Override
    public List<Npc> readDeadNpcs() {
        return npcRepository.findByAliveFalse();
    }

    @Override
    public List<Npc> readShopkeeper() {
        return npcRepository.findByShopKeeperTrue();
    }
}
