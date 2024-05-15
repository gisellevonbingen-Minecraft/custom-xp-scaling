package tech.harrynull.custom_xp.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tech.harrynull.custom_xp.CustomXpScaling;

@Mixin(Player.class)
public class PlayerMixin {
	@Shadow public int experienceLevel;

	@Inject(at = @At("HEAD"), method = "getXpNeededForNextLevel", cancellable = true)
	private void getXpNeededForNextLevel(CallbackInfoReturnable<Integer> cir) {
		Integer xp = CustomXpScaling.INSTANCE.evaluateExperience(experienceLevel);
		if (xp == null) return;
		cir.setReturnValue(xp);
	}
}
