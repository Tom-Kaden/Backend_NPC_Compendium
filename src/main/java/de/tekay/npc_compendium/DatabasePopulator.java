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
        npcOne.setName("Captain Meriel Adora Winfrey");
        npcOne.setRace("Halbelf");
        npcOne.setBelonging("Weststern");
        npcOne.setDescription("Logenleitung der Purpurloge - " +
                "Ehemaliges Mitglied der Alten Garde");
        npcOne.setShopKeeper(false);
        npcOne.setShopLocation("-");
        npcOne.setAlive(true);

        Npc npcTwo = new Npc();
        npcTwo.setName("Jedermann");
        npcTwo.setRace("Unbekannt");
        npcTwo.setBelonging("Unbekannt");
        npcTwo.setDescription("Ladenbesitzer in anderer Plane. " +
                "Hilft dem Weststern scheinbar seit einiger Zeit");
        npcTwo.setShopKeeper(true);
        npcTwo.setShopLocation("Unbekannt");
        npcTwo.setAlive(true);

        Npc npcThree = new Npc();
        npcThree.setName("Brock Sougough");
        npcThree.setRace("Halbork");
        npcThree.setBelonging("Weststern & Min'Aran");
        npcThree.setDescription("Tavernenbesitzer Zum Adler in Min'Aran - " +
                "Ehemaliges Mitglied der Alten Garde");
        npcThree.setShopKeeper(false);
        npcThree.setShopLocation("-");
        npcThree.setAlive(true);

        List<Npc> npcList = new ArrayList<>();
        npcList.add(npcOne);
        npcList.add(npcTwo);
        npcList.add(npcThree);

        npcRepository.saveAll(npcList);
    }
}
