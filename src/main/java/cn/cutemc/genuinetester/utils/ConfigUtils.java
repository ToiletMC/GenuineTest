package cn.cutemc.genuinetester.utils;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ConfigUtils {

    public static List<String> readCommandFile(JavaPlugin plugin) throws IOException {
        //获取插件文件夹
        File dataFolder = plugin.getDataFolder();

        //获取指令文件对象
        File commandFile = new File(dataFolder,"command.txt");

        //判断是否不存在
        if (!commandFile.exists()) {
            //新建文件
            commandFile.createNewFile();
            return null;
        }

        //读取文件
        String commandsText = Files.readString(commandFile.toPath());

        //切分指令
        List<String> commands = List.of(commandsText.split("\n"));

        return commands;
    }
}
