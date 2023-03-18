package me.ayansaiyad.listener;


import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Reactions extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {

        if (event.getUser().isBot() || event.getUser().getAsTag().equals("momonkey#0020")) return;

        User user = event.getUser();
        String emoji = event.getEmoji().getAsReactionCode();
        Channel channel = event.getChannel();

        String message = user.getAsMention() + " reacted to a message with " + emoji + " in " + channel.getAsMention();

        //id is that of the log channel
        event.getGuild().getTextChannelById("1086183814667182090").sendMessage(message).queue();

    }

    /**
     * adds reactions to message events.
     * @param event the event that triggered the listener.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();

        Emoji snake = Emoji.fromUnicode("U+1F40D");
        if (message.contains("jasper")) {
            event.getMessage().addReaction(snake).queue();
        }

        Emoji monkey = Emoji.fromUnicode("U+1F412");
        if (message.toLowerCase().contains("momo") || message.toLowerCase().contains("ayan")) {
            event.getMessage().addReaction(monkey).queue();
        }

        Emoji[] bomb = {Emoji.fromUnicode("U+1F4A3"), Emoji.fromUnicode("U+1F1F0"), Emoji.fromUnicode("U+1F1FE"), Emoji.fromUnicode("U+1F1F8")};
        if (message.toLowerCase().contains("beko") || message.toLowerCase().contains("bakir")) {
            for (Emoji e : bomb) {
                event.getMessage().addReaction(e).queue();
            }
        }

        Emoji[] ecs = {Emoji.fromUnicode("U+1F1EA"), Emoji.fromUnicode("U+1F1E8"), Emoji.fromUnicode("U+1F1F8"), Emoji.fromUnicode("U+2049")};
        if (message.toLowerCase().contains("ecs") || message.toLowerCase().contains("ec")) {
            for (Emoji e : ecs) {
                event.getMessage().addReaction(e).queue();
            }
        }

    }
}
