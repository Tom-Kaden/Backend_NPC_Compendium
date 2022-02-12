package de.tekay.npc_compendium.service;

import de.tekay.npc_compendium.dto.CreateNpcDto;
import de.tekay.npc_compendium.dto.UpdateNpcDto;
import de.tekay.npc_compendium.entity.Npc;
import de.tekay.npc_compendium.repository.NpcRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class NpcService implements NpcServiceInterface {

    @Autowired
    private NpcRepository npcRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Npc create(CreateNpcDto npc) {
        return npcRepository.save(modelMapper.map(npc, Npc.class));
    }

    @Override
    public Npc update(UpdateNpcDto npc) {
        Npc old = npcRepository.findById(npc.getId()).orElseThrow(
                () -> new EntityNotFoundException("ID NOT FOUND!")
        );
        modelMapper.map(npc, old);
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
