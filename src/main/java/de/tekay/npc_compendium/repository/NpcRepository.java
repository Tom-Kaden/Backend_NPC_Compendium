package de.tekay.npc_compendium.repository;

import de.tekay.npc_compendium.entity.Npc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NpcRepository extends CrudRepository<Npc, Long> {

    List<Npc> findByAliveTrue();
    List<Npc> findByAliveFalse();
    List<Npc> findByShopKeeperTrue();
}
