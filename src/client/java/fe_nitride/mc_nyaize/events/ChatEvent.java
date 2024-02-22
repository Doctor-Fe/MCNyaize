package fe_nitride.mc_nyaize.events;

import fe_nitride.mc_nyaize.MCNyaizeClient;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents.ModifyChat;

public class ChatEvent implements ModifyChat {

    @Override
    public String modifySendChatMessage(String message) {
        MCNyaizeClient.LOGGER.trace("before: {}", message);
        StringBuilder new_text = new StringBuilder();
        int idx = 0;
        while (idx < message.length()) {
            char c = message.charAt(idx);
            if (Character.toLowerCase(c) == 'e' && idx + 8 <= message.length()) {
                if (message.substring(idx, idx + 8).toLowerCase().equals("everyone")) {
                    new_text.append(message.substring(idx, idx + 5));
                    if (message.substring(idx + 5, idx + 8).equals("ONE")) {
                        new_text.append("NYAN");
                    } else {
                        new_text.append("nyan");
                    }
                    idx += 8;
                    continue;
                }
            }
            if (Character.toLowerCase(c) == 'm' && idx + 7 <= message.length()) {
                if (message.substring(idx, idx + 7).toLowerCase().equals("morning")) {
                    new_text.append(message.substring(idx, idx + 4));
                    if (message.substring(idx + 4, idx + 7).equals("ING")) {
                        new_text.append("YAN");
                    } else {
                        new_text.append("yan");
                    }
                    idx += 7;
                    continue;
                }
            }
            if (Character.toLowerCase(c) == 'n') {
                new_text.append(c);
                if (idx + 1 >= message.length()) {
                    break;
                }
                char c2 = message.charAt(idx + 1);
                if (c2 == 'a') {
                    new_text.append("ya");
                    idx += 1;
                } else if (c2 == 'A') {
                    new_text.append("YA");
                    idx += 1;
                }
            } else if (c == 'な') {
                new_text.append("にゃ");
            } else if (c == 'ナ') {
                new_text.append("ニャ");
            } else if (c == 'ﾅ') {
                new_text.append("ﾆｬ");
            } else {
                new_text.append(c);
            }
            idx += 1;
        }
        MCNyaizeClient.LOGGER.trace("after: {}", new_text.toString());
        return new_text.toString();
    }
    
}
