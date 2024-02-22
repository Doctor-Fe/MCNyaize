package fe_nitride.mc_nyaize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fe_nitride.mc_nyaize.events.ChatEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;

public class MCNyaizeClient implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("mc_nyaize");

	@Override
	public void onInitializeClient() {
		LOGGER.info("Client initialized.");
		ClientSendMessageEvents.MODIFY_CHAT.register(new ChatEvent());
	}
}
