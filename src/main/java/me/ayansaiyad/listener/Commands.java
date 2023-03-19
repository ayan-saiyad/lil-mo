package me.ayansaiyad.listener;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;

public class Commands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.startsWith("!")) {
            String[] line = message.substring(1).split(" ");
            String command = line[0];
            String[] args = new String[line.length - 1];
            System.arraycopy(line, 1, args, 0, args.length);

            switch (command) {
                case "avatar" -> event.getChannel().sendMessage(event.getAuthor().getAvatarUrl()).queue();

                case "ping" -> event.getChannel().sendMessage("Pong!").queue();

                case "echo" -> {
                    event.getChannel().sendMessage(String.join(" ", args)).queue();
                    System.out.println(String.join(" ", args));
                }

                case "help" -> event.getChannel().sendMessage("```!ping\n!echo <text>\n!avatar <user>```").queue();

                default -> event.getChannel().sendMessage("Invalid command. Use !help to see a list of commands.").queue();
            }
        }
    }
}
