package fe_nitride.mc_nyaize.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

import fe_nitride.mc_nyaize.MCNyaizeClient;
import net.fabricmc.loader.api.FabricLoader;

public class Config {
    public static final String EXCEPTION = "mc_nyaize_exception.txt";

    public static HashSet<String> read() {
        Path path = FabricLoader.getInstance().getConfigDir().resolve(EXCEPTION);
        HashSet<String> set = new HashSet<>();
        if (Files.exists(path)) {
            try (FileReader reader = new FileReader(path.toFile())) {
                BufferedReader r = new BufferedReader(reader);
                while (r.ready()) {
                    String s = r.readLine();
                    if (!s.isBlank() && s.charAt(0) != '#') {
                        set.add(s.trim());
                    }
                }
                MCNyaizeClient.LOGGER.info("The config file was loaded successfully.");
            } catch (IOException e) {
                MCNyaizeClient.LOGGER.error("The config file wasn't loaded successfully.\n{}", e);
                set.clear();
            }
        } else {
            try {
                Files.createFile(path);
                MCNyaizeClient.LOGGER.info("The config file was created successfully.");
            } catch (IOException e) {
                MCNyaizeClient.LOGGER.warn("An error occured while creating config file.\n{}", e);
            }
        }
        return set;
    }
}
