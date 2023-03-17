package me.ayansaiyad.listener;


import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
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

        //id is the that of the log channel
        event.getGuild().getTextChannelById("1086183814667182090").sendMessage(message).queue();

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();
        if (message.contains("hi")) {
            event.getChannel().sendMessage("kys").queue();
        }

        Emoji snake = Emoji.fromUnicode("1086189984442228756");
        if (message.contains("jasper")) {
            event.getMessage().addReaction(snake).queue();
        }


    }
}
