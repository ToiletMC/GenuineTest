package cn.cutemc.genuinetester.utils;

import cn.cutemc.genuinetester.GenuineTester;
import cn.cutemc.genuinetester.yaml.PlayerList;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.util.ArrayList;

public class ServerUtils {

    /**
     * 保存所有玩家名单
     * @param plugin 插件对象
     * @return 返回UUIDList
     */
    public static ArrayList<String> savePlayerList(JavaPlugin plugin) throws IOException {
        OfflinePlayer[] players = plugin.getServer().getOfflinePlayers();

        //将玩家对象转为UUIDList
        ArrayList<String> UUIDList = new ArrayList<>();
        for (OfflinePlayer player : players) {
            UUIDList.add(player.getUniqueId().toString());
        }

        //新建yaml工具类并把UUIDList转为String在writer
        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        yaml.dump(UUIDList, writer);

        //获取插件配置文件文件夹
        File dataFolder = GenuineTester.plugin.getDataFolder();
        //新建list文件类型并判断文件是否存在
        File playerList = new File(dataFolder,"playerlist.yml");
        if (playerList.exists()) {
            //是，删除
            playerList.delete();
        }
        //写入UUID列表到文件
        Files.writeString(playerList.toPath(), writer.toString());

        return UUIDList;
    }
}
