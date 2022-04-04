package de.tekay.npc_compendium.controller;

import de.tekay.npc_compendium.dto.CreateNpcDto;
import de.tekay.npc_compendium.dto.UpdateNpcDto;
import de.tekay.npc_compendium.entity.Npc;
import de.tekay.npc_compendium.logging.TrackExecutionTime;
import de.tekay.npc_compendium.service.NpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/npcs")
@CrossOrigin(origins = "http://localhost:4200")
public class NpcController {

    private final NpcService npcService;

    @Autowired
    public NpcController(NpcService npcService) {
        this.npcService = npcService;
    }

    @TrackExecutionTime
    @PostMapping
    public ResponseEntity<Npc> create(@RequestBody CreateNpcDto npc) {
        System.out.println("NPC Image in NPCController: " + npc.getImage());
        return new ResponseEntity<>(npcService.create(npc), HttpStatus.CREATED);
    }

    @TrackExecutionTime
    @PutMapping
    public ResponseEntity<Npc> updateWithImage(@Valid @RequestBody UpdateNpcDto npc) {
        return new ResponseEntity<>(npcService.update(npc), HttpStatus.ACCEPTED);
    }

    @TrackExecutionTime
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNpc(@PathVariable Long id) {
        npcService.deleteNpc(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @TrackExecutionTime
    @GetMapping
    public ResponseEntity<List<Npc>> getNpcs() {
        return new ResponseEntity<>(npcService.allNpcs(), HttpStatus.ACCEPTED);
    }

    @TrackExecutionTime
    @GetMapping("/{id}")
    public ResponseEntity<Npc> getNpcById(@PathVariable Long id) {
        return new ResponseEntity<>(npcService.readNpc(id), HttpStatus.ACCEPTED);
    }

    @TrackExecutionTime
    @GetMapping("/alive")
    public ResponseEntity<List<Npc>> getAliveNpcs() {
        return new ResponseEntity<>(npcService.readAliveNpcs(), HttpStatus.ACCEPTED);
    }

    @TrackExecutionTime
    @GetMapping("/dead")
    public ResponseEntity<List<Npc>> getDeadNpcs() {
        return new ResponseEntity<>(npcService.readDeadNpcs(), HttpStatus.ACCEPTED);
    }

    @TrackExecutionTime
    @GetMapping("/shopkeeper")
    public ResponseEntity<List<Npc>> getShopkeeper() {
        return new ResponseEntity<>(npcService.readShopkeeper(), HttpStatus.ACCEPTED);
    }
}