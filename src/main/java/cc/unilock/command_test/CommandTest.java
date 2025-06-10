package cc.unilock.command_test;

import com.mojang.brigadier.Command;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandTest implements ModInitializer {
	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((commandDispatcher, commandRegistryAccess, registrationEnvironment) -> {
			commandDispatcher.register(literal("stest").executes(ctx -> {
				ctx.getSource().sendFeedback(() -> Text.literal("stest complete!"), false);
				return Command.SINGLE_SUCCESS;
			}));
		});
	}
}
