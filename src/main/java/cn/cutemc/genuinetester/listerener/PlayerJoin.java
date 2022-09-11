package cn.cutemc.genuinetester.listerener;

import cn.cutemc.genuinetester.GenuineTester;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.util.FileUtil;
import org.yaml.snakeyaml.Yaml;

public class PlayerJoin extends PlayerJoinEvent {
    public PlayerJoin(Player player, String joinMessage) {
        super(player, joinMessage);

        //获取玩家UUID
        String UUID = player.getUniqueId().toString();

        //判断List中是否含有玩家的UUID
        Boolean isFirstJoin = !GenuineTester.playerList.contains(UUID);

        if (!isFirstJoin) {
            return;
        }

        String text;
        //Read file resources/config.yml to text
        text = FileUtil.readToString(GenuineTester.plugin.getResource("config.yml"));

        //Parse text to object
        Yaml yaml = new Yaml();
        Object object = yaml.load(text);

        //convert object to JSON
        String json = GsonUtils.toJson(object);

        //save json to file resources/config.json
        FileUtil.write(GenuineTester.plugin.getResource("config.json"), json);




        
    }

    public void readFile() {

    }
}
