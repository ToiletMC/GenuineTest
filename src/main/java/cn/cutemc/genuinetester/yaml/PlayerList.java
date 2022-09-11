package cn.cutemc.genuinetester.yaml;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.OfflinePlayer;

@Getter
@Setter
public class PlayerList {

    private OfflinePlayer[] players;

    public PlayerList setPlayers(OfflinePlayer[] playerList) {
        players = playerList;
        return this;
    }

}
