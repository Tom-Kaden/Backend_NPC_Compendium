package de.tekay.npc_compendium;

import de.tekay.npc_compendium.entity.Npc;
import de.tekay.npc_compendium.repository.NpcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabasePopulator implements CommandLineRunner {

    private final NpcRepository npcRepository;

    public DatabasePopulator(@Autowired NpcRepository npcRepository){
        this.npcRepository = npcRepository;
    }

    @Override
    public void run(String... args) {
        Npc npcOne = new Npc();
        npcOne.setAlive(true);
        npcOne.setBelonging("Weststern");
        npcOne.setDescription("Logenleitung - Purpurloge");
        npcOne.setName("Captain Meriel Adora Winfrey");
        npcOne.setRace("Halbelf");
        npcOne.setShopKeeper(false);
        npcOne.setShopLocation("-");

        Npc npcTwo = new Npc();
        npcTwo.setAlive(true);
        npcTwo.setBelonging("Weststern");
        npcTwo.setDescription("Logenleitung - Purpurloge");
        npcTwo.setName("Captain Meriel Adora Winfrey");
        npcTwo.setRace("Halbelf");
        npcTwo.setShopKeeper(false);
        npcTwo.setShopLocation("-");

        Npc npcThree = new Npc();
        npcThree.setAlive(true);
        npcThree.setBelonging("Weststern");
        npcThree.setDescription("Logenleitung - Purpurloge");
        npcThree.setName("Captain Meriel Adora Winfrey");
        npcThree.setRace("Halbelf");
        npcThree.setShopKeeper(false);
        npcThree.setShopLocation("-");

        List<Npc> npcList = new ArrayList<>();
        npcList.add(npcOne);
        npcList.add(npcTwo);
        npcList.add(npcThree);

        npcRepository.saveAll(npcList);
    }
}
