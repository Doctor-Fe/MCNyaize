package fe_nitride.mc_nyaize;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fe_nitride.mc_nyaize.config.Config;
import fe_nitride.mc_nyaize.events.ChatEvent;
import fe_nitride.mc_nyaize.events.ServerJoinEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class MCNyaizeClient implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("mc_nyaize");
	public static HashSet<String> disabledServerList = new HashSet<String>();
	public static boolean isEnabled = true;

	@Override
	public void onInitializeClient() {
		LOGGER.info("Client initialized.");
		ClientSendMessageEvents.MODIFY_CHAT.register(new ChatEvent());
		ClientPlayConnectionEvents.JOIN.register(new ServerJoinEvent());
		disabledServerList = Config.read();
	}
}
