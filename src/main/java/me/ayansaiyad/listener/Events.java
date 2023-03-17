package me.ayansaiyad.listener;


import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Events extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        User user = event.getUser();
        String emoji = event.getEmoji().getAsReactionCode();
        Channel channel = event.getChannel();
        String link = event.getJumpUrl();

        String message = user.getAsTag() + " reacted to a message with " + emoji + " in " + channel.getAsMention() + "\n" + link;

        event.getGuild().getTextChannelById(channel.getId()).sendMessage(message).queue();

    }

    public static void main(String[] args)  {

    }
}
