package net.frogipher.forlorn.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent SUGAR_PLUM = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build();
    public static final FoodComponent SUGAR_LUMPS = new FoodComponent.Builder().hunger(1).saturationModifier(0f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 60), 0.2f).build();
    public static final FoodComponent BUBBLE_MINT = new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).snack().statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100), 0.3f).build();
    public static final FoodComponent RAW_GLOW_GUPPY = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).snack().statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 80), 0.8f).build();
}
