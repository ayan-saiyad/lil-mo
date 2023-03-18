package me.ayansaiyad.listener;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        String user = event.getAuthor().getAsTag();

        if (message.startsWith("!")) {
            String[] args = message.split(" ");
            String command = args[0];
            String[] commandArgs = new String[args.length - 1];

            switch (command) {
                case "avatar" -> event.getChannel().sendMessage(event.getAuthor().getAvatarUrl()).queue();

                case "ping" -> event.getChannel().sendMessage("Pong!").queue();

                case "echo" -> {
                    event.getChannel().sendMessage(String.join(" ", commandArgs)).queue();
                    System.out.println(String.join(" ", commandArgs));
                }

                case "help" -> event.getChannel().sendMessage("```!ping\n!echo <text>\n!avatar <user>```").queue();

                default -> event.getChannel().sendMessage("Invalid command. Use !help to see a list of commands.").queue();
            }
        }
    }
}
