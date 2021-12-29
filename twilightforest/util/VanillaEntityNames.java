// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraft.util.ResourceLocation;

public class VanillaEntityNames
{
    public static final ResourceLocation PIG;
    public static final ResourceLocation SHEEP;
    public static final ResourceLocation COW;
    public static final ResourceLocation CHICKEN;
    public static final ResourceLocation RABBIT;
    public static final ResourceLocation PARROT;
    public static final ResourceLocation WOLF;
    public static final ResourceLocation VILLAGER;
    public static final ResourceLocation BAT;
    public static final ResourceLocation CAVE_SPIDER;
    public static final ResourceLocation SPIDER;
    public static final ResourceLocation ZOMBIE;
    public static final ResourceLocation SKELETON;
    public static final ResourceLocation BLAZE;
    public static final ResourceLocation ZOMBIE_PIGMAN;
    public static final ResourceLocation WITCH;
    
    private static ResourceLocation prefix(final String path) {
        return new ResourceLocation("minecraft", path);
    }
    
    static {
        PIG = prefix("pig");
        SHEEP = prefix("sheep");
        COW = prefix("cow");
        CHICKEN = prefix("chicken");
        RABBIT = prefix("rabbit");
        PARROT = prefix("parrot");
        WOLF = prefix("wolf");
        VILLAGER = prefix("villager");
        BAT = prefix("bat");
        CAVE_SPIDER = prefix("cave_spider");
        SPIDER = prefix("spider");
        ZOMBIE = prefix("zombie");
        SKELETON = prefix("skeleton");
        BLAZE = prefix("blaze");
        ZOMBIE_PIGMAN = prefix("zombie_pigman");
        WITCH = prefix("witch");
    }
}
