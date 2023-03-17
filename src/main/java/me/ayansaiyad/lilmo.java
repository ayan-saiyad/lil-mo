package me.ayansaiyad;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class lilmo extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {

        String token = System.getenv("lilmo_key");

        JDABuilder builder = JDABuilder.createDefault(token)
                .setActivity(Activity.playing("with your mom"))
                .addEventListeners(new lilmo());
        builder.build();

    }

}
