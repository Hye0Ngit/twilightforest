// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.util;

import net.minecraftforge.common.TierSortingRegistry;
import java.util.List;
import net.minecraft.world.item.Tiers;
import net.minecraft.tags.Tag;
import net.minecraftforge.common.ForgeTier;
import net.minecraft.tags.BlockTags;
import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;

public class TwilightItemTier
{
    public static final Tier IRONWOOD;
    public static final Tier FIERY;
    public static final Tier STEELEAF;
    public static final Tier KNIGHTMETAL;
    public static final Tier GIANT;
    public static final Tier ICE;
    public static final Tier GLASS;
    
    static {
        IRONWOOD = TierSortingRegistry.registerTier((Tier)new ForgeTier(2, 512, 6.5f, 2.0f, 25, (Tag)BlockTags.createOptional(TwilightForestMod.prefix("needs_ironwood_tool")), () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.IRONWOOD_INGOT.get() })), TwilightForestMod.prefix("ironwood"), (List)List.of(Tiers.IRON), (List)List.of(Tiers.DIAMOND));
        FIERY = TierSortingRegistry.registerTier((Tier)new ForgeTier(4, 1024, 9.0f, 4.0f, 10, (Tag)BlockTags.createOptional(TwilightForestMod.prefix("needs_fiery_tool")), () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.FIERY_INGOT.get() })), TwilightForestMod.prefix("fiery"), (List)List.of(Tiers.DIAMOND), (List)List.of(Tiers.NETHERITE));
        STEELEAF = TierSortingRegistry.registerTier((Tier)new ForgeTier(3, 131, 8.0f, 3.0f, 9, (Tag)BlockTags.createOptional(TwilightForestMod.prefix("needs_steeleaf_tool")), () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.STEELEAF_INGOT.get() })), TwilightForestMod.prefix("steeleaf"), (List)List.of(Tiers.IRON), (List)List.of(Tiers.DIAMOND));
        KNIGHTMETAL = TierSortingRegistry.registerTier((Tier)new ForgeTier(3, 512, 8.0f, 3.0f, 8, (Tag)BlockTags.createOptional(TwilightForestMod.prefix("needs_knightmetal_tool")), () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFItems.KNIGHTMETAL_INGOT.get() })), TwilightForestMod.prefix("knightmetal"), (List)List.of(Tiers.IRON), (List)List.of(Tiers.DIAMOND));
        GIANT = TierSortingRegistry.registerTier((Tier)new ForgeTier(1, 1024, 4.0f, 1.0f, 5, (Tag)BlockTags.createOptional(TwilightForestMod.prefix("needs_giant_tool")), () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)TFBlocks.GIANT_COBBLESTONE.get() })), TwilightForestMod.prefix("giant"), (List)List.of(Tiers.STONE), (List)List.of(Tiers.IRON));
        ICE = TierSortingRegistry.registerTier((Tier)new ForgeTier(0, 32, 1.0f, 3.5f, 5, (Tag)BlockTags.createOptional(TwilightForestMod.prefix("needs_ice_tool")), () -> Ingredient.m_43929_(new ItemLike[] { (ItemLike)Blocks.f_50354_ })), TwilightForestMod.prefix("ice"), (List)List.of(), (List)List.of(Tiers.WOOD));
        GLASS = TierSortingRegistry.registerTier((Tier)new ForgeTier(0, 1, 1.0f, 36.0f, 30, (Tag)BlockTags.createOptional(TwilightForestMod.prefix("needs_glass_tool")), () -> Ingredient.f_43901_), TwilightForestMod.prefix("glass"), (List)List.of(), (List)List.of(Tiers.WOOD));
    }
}
