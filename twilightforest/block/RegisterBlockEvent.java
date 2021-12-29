// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.ArrayList;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import twilightforest.TwilightForestMod;
import net.minecraftforge.fluids.FluidRegistry;
import java.util.Collections;
import twilightforest.client.ModelRegisterCallback;
import java.util.List;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.block.properties.PropertyEnum;
import twilightforest.util.IMapColorSupplier;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.MapColor;
import twilightforest.enums.MagicWoodVariant;
import twilightforest.enums.WoodVariant;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.CastleBrickVariant;
import net.minecraft.block.material.Material;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "twilightforest")
public final class RegisterBlockEvent
{
    public static final Fluid moltenFiery;
    public static final Fluid moltenKnightmetal;
    public static final Fluid essenceFiery;
    public static final ResourceLocation moltenFieryStill;
    public static final ResourceLocation moltenFieryFlow;
    public static final ResourceLocation moltenKnightmetalStill;
    public static final ResourceLocation moltenKnightmetalFlow;
    public static final ResourceLocation essenceFieryStill;
    public static final ResourceLocation essenceFieryFlow;
    
    @SubscribeEvent
    public static void onRegisterBlocks(final RegistryEvent.Register<Block> event) {
        final BlockRegistryHelper blocks = new BlockRegistryHelper((IForgeRegistry<Block>)event.getRegistry());
        blocks.register("twilight_log", "Log", new BlockTFLog());
        blocks.register("root", "Roots", new BlockTFRoots());
        blocks.register("twilight_leaves", "Leaves", new BlockTFLeaves());
        blocks.register("firefly", "Firefly", new BlockTFFirefly());
        blocks.register("cicada", "Cicada", new BlockTFCicada());
        blocks.register("twilight_portal", "Portal", new BlockTFPortal());
        blocks.register("maze_stone", "Mazestone", new BlockTFMazestone());
        blocks.register("hedge", "Hedge", new BlockTFHedge());
        blocks.register("boss_spawner", "BossSpawner", new BlockTFBossSpawner().func_149722_s());
        blocks.register("firefly_jar", "FireflyJar", new BlockTFFireflyJar());
        blocks.register("twilight_plant", "Plant", new BlockTFPlant());
        blocks.register("uncrafting_table", "UncraftingTable", new BlockTFUncraftingTable());
        blocks.register("fire_jet", "FireJet", new BlockTFFireJet());
        blocks.register("naga_stone", "Nagastone", new BlockTFNagastone());
        blocks.register("twilight_sapling", "Sapling", new BlockTFSapling());
        blocks.register("moonworm", "Moonworm", new BlockTFMoonworm());
        blocks.register("magic_log", "MagicLog", new BlockTFMagicLog());
        blocks.register("magic_leaves", "MagicLeaves", new BlockTFMagicLeaves());
        blocks.register("magic_log_core", "MagicLogSpecial", new BlockTFMagicLogSpecial());
        blocks.register("tower_wood", "TowerStone", new BlockTFTowerWood());
        blocks.register("tower_device", "TowerDevice", new BlockTFTowerDevice());
        blocks.register("tower_translucent", "TowerTranslucent", new BlockTFTowerTranslucent());
        blocks.register("trophy", "Trophy", new BlockTFTrophy());
        blocks.register("stronghold_shield", "Shield", new BlockTFShield());
        blocks.register("trophy_pedestal", "TrophyPedestal", new BlockTFTrophyPedestal());
        blocks.register("aurora_block", "AuroraBrick", new BlockTFAuroraBrick());
        blocks.register("underbrick", "UnderBrick", new BlockTFUnderBrick());
        blocks.register("thorns", "Thorns", new BlockTFThorns());
        blocks.register("burnt_thorns", "BurntThorns", new BlockTFBurntThorns());
        blocks.register("thorn_rose", "ThornRose", new BlockTFThornRose());
        blocks.register("twilight_leaves_3", "Leaves3", new BlockTFLeaves3());
        blocks.register("deadrock", "Deadrock", new BlockTFDeadrock());
        blocks.register("dark_leaves", "DarkLeaves", new BlockTFDarkLeaves());
        blocks.register("aurora_pillar", "AuroraPillar", new BlockTFPillar(Material.field_151598_x).func_149711_c(2.0f).func_149752_b(10.0f));
        blocks.register("aurora_slab", "AuroraSlab", new BlockTFAuroraSlab(false));
        blocks.register("double_aurora_slab", "AuroraDoubleSlab", new BlockTFAuroraSlab(true));
        blocks.register("trollsteinn", "TrollSteinn", new BlockTFTrollSteinn());
        blocks.register("wispy_cloud", "WispyCloud", new BlockTFWispyCloud());
        blocks.register("fluffy_cloud", "FluffyCloud", new BlockTFFluffyCloud());
        blocks.register("giant_cobblestone", "GiantCobble", new BlockTFGiantCobble());
        blocks.register("giant_log", "GiantLog", new BlockTFGiantLog());
        blocks.register("giant_leaves", "GiantLeaves", new BlockTFGiantLeaves());
        blocks.register("giant_obsidian", "GiantObsidian", new BlockTFGiantObsidian());
        blocks.register("uberous_soil", "UberousSoil", new BlockTFUberousSoil());
        blocks.register("huge_stalk", "HugeStalk", new BlockTFHugeStalk());
        blocks.register("huge_mushgloom", "HugeGloomBlock", new BlockTFHugeGloomBlock());
        blocks.register("trollvidr", "TrollVidr", new BlockTFTrollRoot());
        blocks.register("unripe_trollber", "UnripeTrollBer", new BlockTFUnripeTorchCluster());
        blocks.register("trollber", "TrollBer", new BlockTFRipeTorchCluster());
        blocks.register("knightmetal_block", "KnightmetalBlock", new BlockTFKnightmetalBlock());
        blocks.register("huge_lilypad", "HugeLilyPad", new BlockTFHugeLilyPad());
        blocks.register("huge_waterlily", "HugeWaterLily", new BlockTFHugeWaterLily());
        blocks.register("slider", "Slider", new BlockTFSlider());
        final Block castleBrick = new BlockTFCastleBlock();
        final IBlockState castleState = castleBrick.func_176223_P();
        blocks.register("castle_brick", "CastleBrick", castleBrick);
        blocks.register("castle_stairs_brick", "CastleStairsBrick", new BlockTFStairs(castleState));
        blocks.register("castle_stairs_worn", "CastleStairsWorn", new BlockTFStairs(castleState.func_177226_a((IProperty)BlockTFCastleBlock.VARIANT, (Comparable)CastleBrickVariant.WORN)));
        blocks.register("castle_stairs_cracked", "CastleStairsCracked", new BlockTFStairs(castleState.func_177226_a((IProperty)BlockTFCastleBlock.VARIANT, (Comparable)CastleBrickVariant.CRACKED)));
        blocks.register("castle_stairs_mossy", "CastleStairsMossy", new BlockTFStairs(castleState.func_177226_a((IProperty)BlockTFCastleBlock.VARIANT, (Comparable)CastleBrickVariant.MOSSY)));
        final Block castlePillar = new BlockTFCastlePillar();
        blocks.register("castle_pillar", "CastlePillar", castlePillar);
        blocks.register("castle_stairs", "CastleStairs", new BlockTFCastleStairs(castlePillar.func_176223_P()));
        blocks.register("castle_rune_brick", "CastleMagic", new BlockTFCastleMagic());
        blocks.register("force_field", "ForceField", new BlockTFForceField());
        blocks.register("cinder_furnace", "CinderFurnaceIdle", new BlockTFCinderFurnace(false));
        blocks.register("cinder_furnace_lit", "CinderFurnaceLit", new BlockTFCinderFurnace(true));
        blocks.register("cinder_log", "CinderLog", new BlockTFCinderLog());
        blocks.register("castle_door", "CastleDoor", new BlockTFCastleDoor(false));
        blocks.register("castle_door_vanished", "CastleDoorVanished", new BlockTFCastleDoor(true));
        blocks.register("castle_unlock", "CastleUnlock", new BlockTFCastleUnlock());
        blocks.register("experiment_115", "experiment115", new BlockTFExperiment115().func_149711_c(0.5f));
        blocks.register("miniature_structure", "MiniatureStructure", new BlockTFMiniatureStructure().func_149711_c(0.75f));
        blocks.register("block_storage", "BlockOfStorage", new BlockTFCompressed());
        blocks.register("lapis_block", "BlockOfLapisTF", new BlockTFLapisBlock());
        blocks.register("spiral_bricks", "SpiralBricks", new BlockTFSpiralBrick());
        final Block etchedNagastone = new BlockTFNagastoneEtched().func_149711_c(1.5f).func_149752_b(10.0f);
        blocks.register("etched_nagastone", "EtchedNagastone", etchedNagastone);
        blocks.register("nagastone_stairs", "NagastoneStairs", new BlockTFNagastoneStairs(etchedNagastone.func_176223_P()).func_149711_c(1.5f).func_149752_b(10.0f));
        blocks.register("nagastone_pillar", "NagastonePillar", new BlockTFNagastonePillar().func_149711_c(1.5f).func_149752_b(10.0f));
        final Block etchedNagastoneMossy = new BlockTFNagastoneEtched().func_149711_c(1.5f).func_149752_b(10.0f);
        blocks.register("etched_nagastone_mossy", "EtchedNagastoneMossy", etchedNagastoneMossy);
        blocks.register("nagastone_stairs_mossy", "NagastoneStairsMossy", new BlockTFNagastoneStairs(etchedNagastoneMossy.func_176223_P()).func_149711_c(1.5f).func_149752_b(10.0f));
        blocks.register("nagastone_pillar_mossy", "NagastonePillarMossy", new BlockTFNagastonePillar().func_149711_c(1.5f).func_149752_b(10.0f));
        final Block etchedNagastoneWeathered = new BlockTFNagastoneEtched().func_149711_c(1.5f).func_149752_b(10.0f);
        blocks.register("etched_nagastone_weathered", "EtchedNagastoneWeathered", etchedNagastoneWeathered);
        blocks.register("nagastone_stairs_weathered", "NagastoneStairsWeathered", new BlockTFNagastoneStairs(etchedNagastoneWeathered.func_176223_P()).func_149711_c(1.5f).func_149752_b(10.0f));
        blocks.register("nagastone_pillar_weathered", "NagastonePillarWeathered", new BlockTFNagastonePillar().func_149711_c(1.5f).func_149752_b(10.0f));
        blocks.register("auroralized_glass", "AuroralizedGlass", new BlockTFAuroralizedGlass());
        blocks.register("iron_ladder", "IronLadder", new BlockTFLadderBars().func_149672_a(SoundType.field_185852_e).func_149711_c(5.0f).func_149752_b(10.0f));
        registerWoodVariants(blocks, BlockTFLog.VARIANT, WoodVariant.values());
        registerWoodVariants(blocks, BlockTFMagicLog.VARIANT, MagicWoodVariant.values());
        blocks.register("terrorcotta_circle", "TerrorCottaCircle", new BlockTFHorizontal(Material.field_151576_e, MapColor.field_151658_d).func_149672_a(SoundType.field_185851_d).func_149711_c(1.7f));
        blocks.register("terrorcotta_diagonal", "TerrorCottaDiagonal", new BlockTFDiagonal(Material.field_151576_e, MapColor.field_151658_d).func_149672_a(SoundType.field_185851_d).func_149711_c(1.7f));
        blocks.register("stone_twist", "StonePillar", new BlockTFPillar(Material.field_151576_e).func_149711_c(1.5f).func_149752_b(10.0f));
        blocks.register("stone_twist_thin", "StonePillarThin", new BlockTFWallPillar(Material.field_151576_e, 12.0, 16.0).func_149711_c(1.5f).func_149752_b(10.0f));
        registerFluidBlock(blocks, RegisterBlockEvent.moltenFiery);
        registerFluidBlock(blocks, RegisterBlockEvent.moltenKnightmetal);
        registerFluidBlock("fiery_essence", blocks, RegisterBlockEvent.essenceFiery);
    }
    
    private static <T extends Enum<T> & IStringSerializable & IMapColorSupplier> void registerWoodVariants(final BlockRegistryHelper blocks, final IProperty<T> key, final T[] types) {
        for (final T woodType : types) {
            String woodName = woodType.func_176610_l();
            String woodNameCapitalized;
            if ("oak".equals(woodName)) {
                woodName = "twilight_oak";
                woodNameCapitalized = "TwilightOak";
            }
            else {
                woodNameCapitalized = woodName.substring(0, 1).toUpperCase() + woodName.substring(1);
            }
            final String inventory = "inventory";
            final IProperty[] noProperty = new IProperty[0];
            final PropertyEnum<T> restrictedKey = (PropertyEnum<T>)PropertyEnum.func_177708_a("variant", key.func_177699_b(), input -> input == woodType);
            final Block planks = blocks.register(woodName + "_planks", woodNameCapitalized + "Planks", new BlockTF(Material.field_151575_d, woodType.supplyMapColor()) {
                @SideOnly(Side.CLIENT)
                public void registerModel() {
                    ModelUtils.registerIncludingItemModels(this, "inventory", (IProperty<?>[])noProperty);
                }
            }).func_149672_a(SoundType.field_185848_a).func_149711_c(2.0f).func_149752_b(5.0f);
            blocks.register(woodName + "_stairs", woodNameCapitalized + "Stairs", new BlockTFStairs(planks.func_176223_P()) {
                @SideOnly(Side.CLIENT)
                @Override
                public void registerModel() {
                    ModelUtils.registerIncludingItemModels((Block)this, "inventory", (IProperty<?>[])noProperty);
                }
            });
            final Block singleSlab = blocks.register(woodName + "_slab", woodNameCapitalized + "Slab", new BlockTFSlab<T>(Material.field_151575_d, woodType.supplyMapColor(), woodType) {
                @Override
                public boolean func_176552_j() {
                    return false;
                }
                
                @Override
                protected Block getSingle() {
                    return (Block)this;
                }
                
                @Override
                public IProperty<T> func_176551_l() {
                    return (IProperty<T>)restrictedKey;
                }
                
                @SideOnly(Side.CLIENT)
                public void registerModel() {
                    ModelUtils.registerIncludingItemModels((Block)this, "inventory", (IProperty)restrictedKey);
                }
            }).func_149672_a(SoundType.field_185848_a).func_149711_c(2.0f).func_149752_b(5.0f);
            blocks.register(woodName + "_doubleslab", woodNameCapitalized + "Slab", new BlockTFSlab<T>(Material.field_151575_d, woodType.supplyMapColor(), woodType) {
                @Override
                public boolean func_176552_j() {
                    return true;
                }
                
                @Override
                protected Block getSingle() {
                    return singleSlab;
                }
                
                @Override
                public IProperty<T> func_176551_l() {
                    return (IProperty<T>)restrictedKey;
                }
                
                @SideOnly(Side.CLIENT)
                public void registerModel() {
                    ModelUtils.registerIncludingItemModels((Block)this, "inventory", (IProperty)restrictedKey);
                }
            }).func_149672_a(SoundType.field_185848_a).func_149711_c(2.0f).func_149752_b(5.0f);
            blocks.register(woodName + "_button", woodNameCapitalized + "Button", new BlockTFButtonWood() {
                @SideOnly(Side.CLIENT)
                public void registerModel() {
                    ModelUtils.registerIncludingItemModels((Block)this, "inventory", (IProperty<?>[])noProperty);
                }
            }).func_149672_a(SoundType.field_185848_a).func_149711_c(0.5f);
            blocks.register(woodName + "_door", woodNameCapitalized + "Door", new BlockTFDoor(Material.field_151575_d, woodType.supplyMapColor(), new ResourceLocation("twilightforest", woodName + "_door")) {
                {
                    this.func_149672_a(SoundType.field_185848_a);
                }
                
                @SideOnly(Side.CLIENT)
                public void registerModel() {
                    ModelUtils.registerIncludingItemModels((Block)this, "inventory", (IProperty)BlockTFDoor.field_176522_N);
                }
            }).func_149711_c(3.0f);
            blocks.register(woodName + "_trapdoor", woodNameCapitalized + "TrapDoor", new BlockTFTrapDoor(Material.field_151575_d, woodType.supplyMapColor()) {
                @SideOnly(Side.CLIENT)
                public void registerModel() {
                    ModelUtils.registerIncludingItemModels((Block)this, "inventory", (IProperty<?>[])noProperty);
                }
            }).func_149672_a(SoundType.field_185848_a).func_149711_c(3.0f);
            blocks.register(woodName + "_fence", woodNameCapitalized + "Fence", new BlockTFFence(Material.field_151575_d, woodType.supplyMapColor()) {
                @SideOnly(Side.CLIENT)
                public void registerModel() {
                    ModelUtils.registerIncludingItemModels((Block)this, "inventory", (IProperty<?>[])noProperty);
                }
            }).func_149672_a(SoundType.field_185848_a).func_149711_c(2.0f).func_149752_b(5.0f);
            blocks.register(woodName + "_gate", woodNameCapitalized + "Gate", new BlockTFFenceGate(woodType.supplyPlankColor()) {
                @SideOnly(Side.CLIENT)
                public void registerModel() {
                    ModelUtils.registerIncludingItemModels((Block)this, "inventory", (IProperty)BlockFenceGate.field_176465_b);
                }
            }).func_149672_a(SoundType.field_185848_a).func_149711_c(2.0f).func_149752_b(5.0f);
            blocks.register(woodName + "_plate", woodNameCapitalized + "Plate", new BlockTFPressurePlate(Material.field_151575_d, woodType.supplyMapColor(), BlockPressurePlate.Sensitivity.EVERYTHING) {
                @SideOnly(Side.CLIENT)
                public void registerModel() {
                    ModelUtils.registerIncludingItemModels((Block)this, "inventory", (IProperty<?>[])noProperty);
                }
            }).func_149672_a(SoundType.field_185848_a).func_149711_c(0.5f);
        }
    }
    
    public static List<ModelRegisterCallback> getBlockModels() {
        return Collections.unmodifiableList((List<? extends ModelRegisterCallback>)BlockRegistryHelper.blockModels);
    }
    
    private static Fluid registerFluid(final Fluid fluid) {
        fluid.setUnlocalizedName(fluid.getName());
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
        return fluid;
    }
    
    private static void registerFluidBlock(final BlockRegistryHelper blocks, final Fluid fluid) {
        registerFluidBlock("molten_" + fluid.getName(), blocks, fluid);
    }
    
    private static void registerFluidBlock(final String registryName, final BlockRegistryHelper blocks, final Fluid fluid) {
        final Block block = new BlockTFFluid(fluid, Material.field_151587_i).func_149663_c("twilightforest." + fluid.getName()).func_149715_a(1.0f);
        blocks.register(registryName, block);
    }
    
    static {
        moltenFieryStill = TwilightForestMod.prefix("blocks/molten_fiery_still");
        moltenFieryFlow = TwilightForestMod.prefix("blocks/molten_fiery_flow");
        moltenKnightmetalStill = TwilightForestMod.prefix("blocks/molten_knightmetal_still");
        moltenKnightmetalFlow = TwilightForestMod.prefix("blocks/molten_knightmetal_flow");
        essenceFieryStill = TwilightForestMod.prefix("blocks/fluid_fiery_still");
        essenceFieryFlow = TwilightForestMod.prefix("blocks/fluid_fiery_flow");
        moltenFiery = registerFluid(new Fluid("fierymetal", RegisterBlockEvent.moltenFieryStill, RegisterBlockEvent.moltenFieryFlow).setTemperature(1000).setLuminosity(15));
        moltenKnightmetal = registerFluid(new Fluid("knightmetal", RegisterBlockEvent.moltenKnightmetalStill, RegisterBlockEvent.moltenKnightmetalFlow).setTemperature(1000).setLuminosity(15));
        essenceFiery = registerFluid(new Fluid("fiery_essence", RegisterBlockEvent.essenceFieryStill, RegisterBlockEvent.essenceFieryFlow).setTemperature(1000));
    }
    
    private static class BlockRegistryHelper
    {
        static final List<ModelRegisterCallback> blockModels;
        private final IForgeRegistry<Block> registry;
        
        BlockRegistryHelper(final IForgeRegistry<Block> registry) {
            this.registry = registry;
        }
        
         <T extends Block> T register(final String registryName, final String translationKey, final T block) {
            block.func_149663_c("twilightforest." + translationKey);
            this.register(registryName, block);
            return block;
        }
        
         <T extends Block> T register(final String registryName, final T block) {
            block.setRegistryName("twilightforest", registryName);
            if (block instanceof ModelRegisterCallback) {
                BlockRegistryHelper.blockModels.add((ModelRegisterCallback)block);
            }
            block.func_149647_a((CreativeTabs)TFItems.creativeTab);
            this.registry.register((IForgeRegistryEntry)block);
            return block;
        }
        
        static {
            blockModels = new ArrayList<ModelRegisterCallback>();
        }
    }
}
