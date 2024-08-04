package fe_nitride.mc_nyaize.events;

import fe_nitride.mc_nyaize.MCNyaizeClient;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ServerInfo;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents.Join;

public class ServerJoinEvent implements Join {
    @Override
    public void onPlayReady(ClientPlayNetworkHandler handler, PacketSender sender, MinecraftClient client) {
        ServerInfo info = handler.getServerInfo();
        MCNyaizeClient.isEnabled = info == null || !MCNyaizeClient.disabledServerList.contains(info.address);
        if (!MCNyaizeClient.isEnabled) {
            MCNyaizeClient.LOGGER.info("While connected to {}, your all chats will be sent as it is.", info.address);
        }
    }
}
