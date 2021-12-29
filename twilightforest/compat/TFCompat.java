// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.compat;

import twilightforest.entity.boss.EntityTFSnowQueen;
import twilightforest.entity.boss.EntityTFYetiAlpha;
import twilightforest.entity.boss.EntityTFUrGhast;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import twilightforest.entity.boss.EntityTFHydra;
import twilightforest.entity.boss.EntityTFMinoshroom;
import twilightforest.entity.boss.EntityTFLich;
import twilightforest.entity.boss.EntityTFNaga;
import org.apache.commons.lang3.tuple.Pair;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.Entity;
import blusunrize.immersiveengineering.api.ApiUtils;
import blusunrize.immersiveengineering.api.tool.RailgunHandler;
import twilightforest.compat.ie.IEShaderRegister;
import twilightforest.compat.ie.ItemTFShaderGrabbag;
import twilightforest.compat.ie.ItemTFShader;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import java.util.Iterator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.NonNullList;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import twilightforest.enums.TowerWoodVariant;
import twilightforest.block.TFBlocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.Loader;
import java.util.Locale;
import twilightforest.TwilightForestMod;
import twilightforest.item.RegisterItemEvent;

public enum TFCompat
{
    BAUBLES("Baubles"), 
    CHISEL("Chisel") {
        public void init() {
            this.addBlockToCarvingGroup("stonebrick", TFBlocks.spiral_bricks);
            this.addBlockToCarvingGroup("nagastone", TFBlocks.etched_nagastone);
            this.addBlockToCarvingGroup("nagastone", TFBlocks.nagastone_pillar);
            this.addBlockToCarvingGroup("nagastone", TFBlocks.etched_nagastone_mossy);
            this.addBlockToCarvingGroup("nagastone", TFBlocks.nagastone_pillar_mossy);
            this.addBlockToCarvingGroup("nagastone", TFBlocks.etched_nagastone_weathered);
            this.addBlockToCarvingGroup("nagastone", TFBlocks.nagastone_pillar_weathered);
            this.addVariantsToCarvingGroup("nagastone", TFBlocks.naga_stone);
            this.addVariantsToCarvingGroup("nagastonestairs", TFBlocks.nagastone_stairs);
            this.addVariantsToCarvingGroup("nagastonestairs", TFBlocks.nagastone_stairs_mossy);
            this.addVariantsToCarvingGroup("nagastonestairs", TFBlocks.nagastone_stairs_weathered);
            this.addVariantsToCarvingGroup("mazestone", TFBlocks.maze_stone);
            this.addVariantsToCarvingGroup("underbrick", TFBlocks.underbrick);
            for (final TowerWoodVariant variant : TowerWoodVariant.values()) {
                if (variant != TowerWoodVariant.INFESTED) {
                    this.addToCarvingGroup("towerwood", new ItemStack(TFBlocks.tower_wood, 1, variant.ordinal()));
                }
            }
            this.addVariantsToCarvingGroup("deadrock", TFBlocks.deadrock);
            this.addVariantsToCarvingGroup("castlebrick", TFBlocks.castle_brick);
            this.addVariantsToCarvingGroup("castlebrick", TFBlocks.castle_pillar);
            this.addVariantsToCarvingGroup("castlebrickstairs", TFBlocks.castle_stairs);
            this.addBlockToCarvingGroup("castlebrickstairs", TFBlocks.castle_stairs_brick);
            this.addBlockToCarvingGroup("castlebrickstairs", TFBlocks.castle_stairs_cracked);
            this.addBlockToCarvingGroup("castlebrickstairs", TFBlocks.castle_stairs_worn);
            this.addBlockToCarvingGroup("castlebrickstairs", TFBlocks.castle_stairs_mossy);
            this.addBlockToCarvingGroup("terrorcotta", TFBlocks.terrorcotta_circle);
            this.addBlockToCarvingGroup("terrorcotta", TFBlocks.terrorcotta_diagonal);
        }
        
        private void addVariantsToCarvingGroup(final String group, final Block block) {
            final NonNullList<ItemStack> variants = (NonNullList<ItemStack>)NonNullList.func_191196_a();
            block.func_149666_a(CreativeTabs.field_78027_g, (NonNullList)variants);
            for (final ItemStack stack : variants) {
                this.addToCarvingGroup(group, stack);
            }
        }
        
        private void addBlockToCarvingGroup(final String group, final Block block) {
            this.addToCarvingGroup(group, new ItemStack(block));
        }
        
        private void addToCarvingGroup(final String group, final ItemStack stack) {
            final NBTTagCompound nbt = new NBTTagCompound();
            nbt.func_74778_a("group", group);
            nbt.func_74782_a("stack", (NBTBase)stack.serializeNBT());
            FMLInterModComms.sendMessage("chisel", "add_variation", nbt);
        }
    }, 
    FORESTRY("Forestry"), 
    IMMERSIVEENGINEERING("Immersive Engineering") {
        @Override
        protected void initItems(final RegisterItemEvent.ItemRegistryHelper items) {
            items.register("shader", ItemTFShader.shader.func_77655_b("tfEngineeringShader"));
            items.register("shader_bag", ItemTFShaderGrabbag.shader_bag.func_77655_b("tfEngineeringShaderBag"));
            new IEShaderRegister();
        }
        
        @Override
        protected void init() {
            RailgunHandler.projectilePropertyMap.add(Pair.of((Object)ApiUtils.createIngredientStack((Object)TFBlocks.cicada), (Object)new RailgunHandler.RailgunProjectileProperties(2.0, 0.25) {
                public boolean overrideHitEntity(final Entity entityHit, final Entity shooter) {
                    final World world = entityHit.func_130014_f_();
                    world.func_72838_d((Entity)new EntityFallingBlock(world, entityHit.field_70165_t, entityHit.field_70163_u, entityHit.field_70161_v, TFBlocks.cicada.func_176223_P()));
                    world.func_184148_a((EntityPlayer)null, entityHit.field_70165_t, entityHit.field_70163_u, entityHit.field_70161_v, TFSounds.CICADA, SoundCategory.NEUTRAL, 1.0f, (world.field_73012_v.nextFloat() - world.field_73012_v.nextFloat()) * 0.2f + 1.0f);
                    return false;
                }
            }));
            this.excludeFromShaderBags((Class<? extends Entity>)EntityTFNaga.class);
            this.excludeFromShaderBags((Class<? extends Entity>)EntityTFLich.class);
            this.excludeFromShaderBags((Class<? extends Entity>)EntityTFMinoshroom.class);
            this.excludeFromShaderBags((Class<? extends Entity>)EntityTFHydra.class);
            this.excludeFromShaderBags((Class<? extends Entity>)EntityTFKnightPhantom.class);
            this.excludeFromShaderBags((Class<? extends Entity>)EntityTFUrGhast.class);
            this.excludeFromShaderBags((Class<? extends Entity>)EntityTFYetiAlpha.class);
            this.excludeFromShaderBags((Class<? extends Entity>)EntityTFSnowQueen.class);
        }
        
        private void excludeFromShaderBags(final Class<? extends Entity> entityClass) {
            FMLInterModComms.sendMessage("immersiveengineering", "shaderbag_exclude", entityClass.getName());
        }
    }, 
    JEI("Just Enough Items"), 
    TCONSTRUCT("Tinkers' Construct") {
        @Override
        protected boolean preInit() {
            TConstruct.preInit();
            return true;
        }
        
        @Override
        protected void init() {
            TConstruct.init();
        }
        
        @Override
        protected void postInit() {
            TConstruct.postInit();
        }
    }, 
    THAUMCRAFT("Thaumcraft") {
        @Override
        protected boolean preInit() {
            MinecraftForge.EVENT_BUS.register((Object)Thaumcraft.class);
            return true;
        }
    };
    
    private static final TFCompat[] VALUES;
    private final String modName;
    private boolean isActivated;
    
    protected boolean preInit() {
        return true;
    }
    
    protected void init() {
    }
    
    protected void postInit() {
    }
    
    protected void initItems(final RegisterItemEvent.ItemRegistryHelper items) {
    }
    
    public boolean isActivated() {
        return this.isActivated;
    }
    
    private TFCompat(final String modName) {
        this.isActivated = false;
        this.modName = modName;
    }
    
    public static void initCompatItems(final RegisterItemEvent.ItemRegistryHelper items) {
        for (final TFCompat compat : TFCompat.VALUES) {
            if (compat.isActivated) {
                try {
                    compat.initItems(items);
                }
                catch (Exception e) {
                    compat.isActivated = false;
                    TwilightForestMod.LOGGER.error("Had a {} error loading {} compatibility in initializing items!", (Object)e.getLocalizedMessage(), (Object)compat.modName);
                    TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
                }
            }
        }
    }
    
    public static void preInitCompat() {
        for (final TFCompat compat : TFCompat.VALUES) {
            if (Loader.isModLoaded(compat.name().toLowerCase(Locale.ROOT))) {
                try {
                    compat.isActivated = compat.preInit();
                    if (compat.isActivated) {
                        TwilightForestMod.LOGGER.info("Loaded compatibility for mod {}.", (Object)compat.modName);
                    }
                    else {
                        TwilightForestMod.LOGGER.warn("Couldn't activate compatibility for mod {}!", (Object)compat.modName);
                    }
                }
                catch (Exception e) {
                    compat.isActivated = false;
                    TwilightForestMod.LOGGER.error("Had a {} error loading {} compatibility in preInit!", (Object)e.getLocalizedMessage(), (Object)compat.modName);
                    TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
                }
            }
            else {
                compat.isActivated = false;
                TwilightForestMod.LOGGER.info("Skipped compatibility for mod {}.", (Object)compat.modName);
            }
        }
    }
    
    public static void initCompat() {
        for (final TFCompat compat : TFCompat.VALUES) {
            if (compat.isActivated) {
                try {
                    compat.init();
                }
                catch (Exception e) {
                    compat.isActivated = false;
                    TwilightForestMod.LOGGER.error("Had a {} error loading {} compatibility in init!", (Object)e.getLocalizedMessage(), (Object)compat.modName);
                    TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
                }
            }
        }
    }
    
    public static void postInitCompat() {
        for (final TFCompat compat : TFCompat.VALUES) {
            if (compat.isActivated) {
                try {
                    compat.postInit();
                }
                catch (Exception e) {
                    compat.isActivated = false;
                    TwilightForestMod.LOGGER.error("Had a {} error loading {} compatibility in postInit!", (Object)e.getLocalizedMessage(), (Object)compat.modName);
                    TwilightForestMod.LOGGER.catching(e.fillInStackTrace());
                }
            }
        }
    }
    
    static void registerSidedHandler(final Side side, final Object handler) {
        if (FMLCommonHandler.instance().getSide() == side) {
            MinecraftForge.EVENT_BUS.register(handler);
        }
    }
    
    static {
        VALUES = values();
    }
}
