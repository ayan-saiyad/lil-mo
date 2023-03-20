package me.ayansaiyad.listener;


import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;
import java.util.List;

public class Commands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        MessageChannel channel = event.getChannel();
        if (message.startsWith("!")) {
            String[] line = message.substring(1).split(" ");
            String command = line[0];
            String[] args = new String[line.length - 1];
            System.arraycopy(line, 1, args, 0, args.length);
            switch (command) {
                case "avatar" -> {
                    if(args.length == 0) {
                        event.getChannel().sendMessage(event.getAuthor().getAvatarUrl()).queue();
                    }
                    else {
                        // Find the user with the specified username
                        List<User> users = event.getJDA().getUsersByName(args[0], true);
                        if (users.size() == 1) {
                            // Create the message with the avatar URL
                            event.getChannel().sendMessage(users.get(0).getAvatarUrl()).queue();
                        }
                    }
                }

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
