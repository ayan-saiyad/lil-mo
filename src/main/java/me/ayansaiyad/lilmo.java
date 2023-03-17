package me.ayansaiyad;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.jetbrains.annotations.NotNull;

public class lilmo extends ListenerAdapter{

    private final ShardManager shardmanager;
    public lilmo() throws LoginException {

        String token = System.getenv("lilmo_key");

       DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
       builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.playing("with your mom"));
        builder.addEventListeners(new lilmo());
        shardmanager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardmanager;
    }

    public static void main(String[] args) {
        try {
            lilmo bot = new lilmo();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
