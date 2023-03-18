package me.ayansaiyad;

import me.ayansaiyad.listener.*;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

/**
 * Initializes the bot and builds the shard manager.
 */
public class lilmo {

    private final ShardManager shardManager;


    /**
     * Loads environment variables and builds the bot shard manager.
     * @throws LoginException occurs when bot token is invalid.
     */
    public lilmo() throws LoginException {
        String token = System.getenv("lilmo_key");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("with your mom!!!!!!"));
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);

        shardManager = builder.build();

        //handle reactions
        shardManager.addEventListener(new Reactions());

        //handle messages
        shardManager.addEventListener(new Messages());

        //handle !-commands
        shardManager.addEventListener(new Commands());

    }


    /**
     * Retrieves the bot shard manager.
     * @return the ShardManager instance for the bot.
     */
    public ShardManager getShardManager() {
        return shardManager;
    }


    /**
     * Main method to start the bot.
     */
    public static void main(String[] args) {
        try {
            lilmo bot = new lilmo();
        } catch (LoginException e) {
            System.out.println("ERROR: Provided bot token is invalid!");
        }
    }
}