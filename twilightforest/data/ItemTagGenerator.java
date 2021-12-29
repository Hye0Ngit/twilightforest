// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import twilightforest.TwilightForestMod;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.Block;
import twilightforest.block.KeepsakeCasketBlock;
import twilightforest.item.TFItems;
import net.minecraft.world.item.Items;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraftforge.common.Tags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.data.tags.ItemTagsProvider;

public class ItemTagGenerator extends ItemTagsProvider
{
    public static final Tag.Named<Item> TWILIGHT_OAK_LOGS;
    public static final Tag.Named<Item> CANOPY_LOGS;
    public static final Tag.Named<Item> MANGROVE_LOGS;
    public static final Tag.Named<Item> DARKWOOD_LOGS;
    public static final Tag.Named<Item> TIME_LOGS;
    public static final Tag.Named<Item> TRANSFORMATION_LOGS;
    public static final Tag.Named<Item> MINING_LOGS;
    public static final Tag.Named<Item> SORTING_LOGS;
    public static final Tag.Named<Item> TWILIGHT_LOGS;
    public static final Tag.Named<Item> TF_FENCES;
    public static final Tag.Named<Item> TF_FENCE_GATES;
    public static final Tag.Named<Item> PAPER;
    public static final Tag.Named<Item> TOWERWOOD;
    public static final Tag.Named<Item> FIERY_VIAL;
    public static final Tag.Named<Item> ARCTIC_FUR;
    public static final Tag.Named<Item> CARMINITE_GEMS;
    public static final Tag.Named<Item> FIERY_INGOTS;
    public static final Tag.Named<Item> IRONWOOD_INGOTS;
    public static final Tag.Named<Item> KNIGHTMETAL_INGOTS;
    public static final Tag.Named<Item> STEELEAF_INGOTS;
    public static final Tag.Named<Item> STORAGE_BLOCKS_ARCTIC_FUR;
    public static final Tag.Named<Item> STORAGE_BLOCKS_CARMINITE;
    public static final Tag.Named<Item> STORAGE_BLOCKS_FIERY;
    public static final Tag.Named<Item> STORAGE_BLOCKS_IRONWOOD;
    public static final Tag.Named<Item> STORAGE_BLOCKS_KNIGHTMETAL;
    public static final Tag.Named<Item> STORAGE_BLOCKS_STEELEAF;
    public static final Tag.Named<Item> ORES_IRONWOOD;
    public static final Tag.Named<Item> ORES_KNIGHTMETAL;
    public static final Tag.Named<Item> PORTAL_ACTIVATOR;
    public static final Tag.Named<Item> WIP;
    public static final Tag.Named<Item> NYI;
    public static final Tag.Named<Item> KOBOLD_PACIFICATION_BREADS;
    public static final Tag.Named<Item> TF_MUSIC_DISCS;
    public static final Tag.Named<Item> BANNED_UNCRAFTING_INGREDIENTS;
    public static final Tag.Named<Item> BANNED_UNCRAFTABLES;
    
    public ItemTagGenerator(final DataGenerator generator, final BlockTagsProvider blockprovider, final ExistingFileHelper exFileHelper) {
        super(generator, blockprovider, "twilightforest", exFileHelper);
    }
    
    protected void m_6577_() {
        this.m_126533_((Tag.Named)BlockTagGenerator.TWILIGHT_OAK_LOGS, (Tag.Named)ItemTagGenerator.TWILIGHT_OAK_LOGS);
        this.m_126533_((Tag.Named)BlockTagGenerator.CANOPY_LOGS, (Tag.Named)ItemTagGenerator.CANOPY_LOGS);
        this.m_126533_((Tag.Named)BlockTagGenerator.MANGROVE_LOGS, (Tag.Named)ItemTagGenerator.MANGROVE_LOGS);
        this.m_126533_((Tag.Named)BlockTagGenerator.DARKWOOD_LOGS, (Tag.Named)ItemTagGenerator.DARKWOOD_LOGS);
        this.m_126533_((Tag.Named)BlockTagGenerator.TIME_LOGS, (Tag.Named)ItemTagGenerator.TIME_LOGS);
        this.m_126533_((Tag.Named)BlockTagGenerator.TRANSFORMATION_LOGS, (Tag.Named)ItemTagGenerator.TRANSFORMATION_LOGS);
        this.m_126533_((Tag.Named)BlockTagGenerator.MINING_LOGS, (Tag.Named)ItemTagGenerator.MINING_LOGS);
        this.m_126533_((Tag.Named)BlockTagGenerator.SORTING_LOGS, (Tag.Named)ItemTagGenerator.SORTING_LOGS);
        this.m_126533_((Tag.Named)BlockTagGenerator.TF_LOGS, (Tag.Named)ItemTagGenerator.TWILIGHT_LOGS);
        this.m_126548_(ItemTags.f_13182_).m_126580_((Tag.Named)ItemTagGenerator.TWILIGHT_LOGS);
        this.m_126548_(ItemTags.f_13181_).m_126580_((Tag.Named)ItemTagGenerator.TWILIGHT_OAK_LOGS).m_126580_((Tag.Named)ItemTagGenerator.CANOPY_LOGS).m_126580_((Tag.Named)ItemTagGenerator.MANGROVE_LOGS).m_126580_((Tag.Named)ItemTagGenerator.TIME_LOGS).m_126580_((Tag.Named)ItemTagGenerator.TRANSFORMATION_LOGS).m_126580_((Tag.Named)ItemTagGenerator.MINING_LOGS).m_126580_((Tag.Named)ItemTagGenerator.SORTING_LOGS);
        this.m_126533_(BlockTags.f_13104_, ItemTags.f_13180_);
        this.m_126533_(BlockTags.f_13035_, ItemTags.f_13143_);
        this.m_126533_(BlockTags.f_13090_, ItemTags.f_13168_);
        this.m_126533_((Tag.Named)BlockTagGenerator.TF_FENCES, (Tag.Named)ItemTagGenerator.TF_FENCES);
        this.m_126533_((Tag.Named)BlockTagGenerator.TF_FENCE_GATES, (Tag.Named)ItemTagGenerator.TF_FENCE_GATES);
        this.m_126533_(BlockTags.f_13098_, ItemTags.f_13176_);
        this.m_126533_((Tag.Named)Tags.Blocks.FENCES, (Tag.Named)Tags.Items.FENCES);
        this.m_126533_((Tag.Named)Tags.Blocks.FENCE_GATES, (Tag.Named)Tags.Items.FENCE_GATES);
        this.m_126533_((Tag.Named)Tags.Blocks.FENCES_WOODEN, (Tag.Named)Tags.Items.FENCES_WOODEN);
        this.m_126533_((Tag.Named)Tags.Blocks.FENCE_GATES_WOODEN, (Tag.Named)Tags.Items.FENCE_GATES_WOODEN);
        this.m_126533_(BlockTags.f_13097_, ItemTags.f_13175_);
        this.m_126533_(BlockTags.f_13031_, ItemTags.f_13139_);
        this.m_126533_(BlockTags.f_13096_, ItemTags.f_13174_);
        this.m_126533_(BlockTags.f_13030_, ItemTags.f_13138_);
        this.m_126533_(BlockTags.f_13092_, ItemTags.f_13170_);
        this.m_126533_(BlockTags.f_13100_, ItemTags.f_13177_);
        this.m_126533_(BlockTags.f_13102_, ItemTags.f_13178_);
        this.m_126533_(BlockTags.f_13095_, ItemTags.f_13173_);
        this.m_126548_(ItemTags.f_13157_).m_126584_((Object[])new Item[] { ((StandingSignBlock)TFBlocks.TWILIGHT_OAK_SIGN.get()).m_5456_(), ((StandingSignBlock)TFBlocks.CANOPY_SIGN.get()).m_5456_(), ((StandingSignBlock)TFBlocks.MANGROVE_SIGN.get()).m_5456_(), ((StandingSignBlock)TFBlocks.DARKWOOD_SIGN.get()).m_5456_(), ((StandingSignBlock)TFBlocks.TIME_SIGN.get()).m_5456_(), ((StandingSignBlock)TFBlocks.TRANSFORMATION_SIGN.get()).m_5456_(), ((StandingSignBlock)TFBlocks.MINING_SIGN.get()).m_5456_(), ((StandingSignBlock)TFBlocks.SORTING_SIGN.get()).m_5456_() });
        this.m_126533_((Tag.Named)Tags.Blocks.CHESTS_WOODEN, (Tag.Named)Tags.Items.CHESTS_WOODEN);
        this.m_126533_((Tag.Named)BlockTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR, (Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR);
        this.m_126533_((Tag.Named)BlockTagGenerator.STORAGE_BLOCKS_CARMINITE, (Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_CARMINITE);
        this.m_126533_((Tag.Named)BlockTagGenerator.STORAGE_BLOCKS_FIERY, (Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_FIERY);
        this.m_126533_((Tag.Named)BlockTagGenerator.STORAGE_BLOCKS_IRONWOOD, (Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_IRONWOOD);
        this.m_126533_((Tag.Named)BlockTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL, (Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL);
        this.m_126533_((Tag.Named)BlockTagGenerator.STORAGE_BLOCKS_STEELEAF, (Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_STEELEAF);
        this.m_126548_((Tag.Named)Tags.Items.STORAGE_BLOCKS).m_126580_((Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_FIERY).m_126580_((Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR).m_126580_((Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_CARMINITE).m_126580_((Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_IRONWOOD).m_126580_((Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL).m_126580_((Tag.Named)ItemTagGenerator.STORAGE_BLOCKS_STEELEAF);
        this.m_126533_((Tag.Named)BlockTagGenerator.ORES_IRONWOOD, (Tag.Named)ItemTagGenerator.ORES_IRONWOOD);
        this.m_126533_((Tag.Named)BlockTagGenerator.ORES_KNIGHTMETAL, (Tag.Named)ItemTagGenerator.ORES_KNIGHTMETAL);
        this.m_126548_((Tag.Named)Tags.Items.ORES).m_126580_((Tag.Named)ItemTagGenerator.ORES_IRONWOOD).m_126580_((Tag.Named)ItemTagGenerator.ORES_KNIGHTMETAL);
        this.m_126533_((Tag.Named)BlockTagGenerator.TOWERWOOD, (Tag.Named)ItemTagGenerator.TOWERWOOD);
        this.m_126548_((Tag.Named)ItemTagGenerator.PAPER).m_126582_((Object)Items.f_42516_);
        this.m_126548_((Tag.Named)Tags.Items.FEATHERS).m_126582_((Object)Items.f_42402_).m_126582_((Object)TFItems.RAVEN_FEATHER.get());
        this.m_126548_((Tag.Named)ItemTagGenerator.FIERY_VIAL).m_126584_((Object[])new Item[] { (Item)TFItems.FIERY_BLOOD.get(), (Item)TFItems.FIERY_TEARS.get() });
        this.m_126548_((Tag.Named)ItemTagGenerator.ARCTIC_FUR).m_126582_((Object)TFItems.ARCTIC_FUR.get());
        this.m_126548_((Tag.Named)ItemTagGenerator.CARMINITE_GEMS).m_126582_((Object)TFItems.CARMINITE.get());
        this.m_126548_((Tag.Named)ItemTagGenerator.FIERY_INGOTS).m_126582_((Object)TFItems.FIERY_INGOT.get());
        this.m_126548_((Tag.Named)ItemTagGenerator.IRONWOOD_INGOTS).m_126582_((Object)TFItems.IRONWOOD_INGOT.get());
        this.m_126548_((Tag.Named)ItemTagGenerator.KNIGHTMETAL_INGOTS).m_126582_((Object)TFItems.KNIGHTMETAL_INGOT.get());
        this.m_126548_((Tag.Named)ItemTagGenerator.STEELEAF_INGOTS).m_126582_((Object)TFItems.STEELEAF_INGOT.get());
        this.m_126548_((Tag.Named)Tags.Items.GEMS).m_126580_((Tag.Named)ItemTagGenerator.CARMINITE_GEMS);
        this.m_126548_((Tag.Named)Tags.Items.INGOTS).m_126580_((Tag.Named)ItemTagGenerator.IRONWOOD_INGOTS).m_126580_((Tag.Named)ItemTagGenerator.FIERY_INGOTS).m_126580_((Tag.Named)ItemTagGenerator.KNIGHTMETAL_INGOTS).m_126580_((Tag.Named)ItemTagGenerator.STEELEAF_INGOTS);
        this.m_126548_((Tag.Named)ItemTagGenerator.ORES_IRONWOOD).m_126582_((Object)TFItems.RAW_IRONWOOD.get());
        this.m_126548_((Tag.Named)ItemTagGenerator.ORES_KNIGHTMETAL).m_126582_((Object)TFItems.ARMOR_SHARD_CLUSTER.get());
        this.m_126548_((Tag.Named)ItemTagGenerator.PORTAL_ACTIVATOR).m_126580_((Tag.Named)Tags.Items.GEMS_DIAMOND);
        this.m_126548_(ItemTags.f_144320_).m_126584_((Object[])new Item[] { (Item)TFItems.FIERY_HELMET.get(), (Item)TFItems.FIERY_CHESTPLATE.get(), (Item)TFItems.FIERY_LEGGINGS.get(), (Item)TFItems.FIERY_BOOTS.get(), (Item)TFItems.ARCTIC_HELMET.get(), (Item)TFItems.ARCTIC_CHESTPLATE.get(), (Item)TFItems.ARCTIC_LEGGINGS.get(), (Item)TFItems.ARCTIC_BOOTS.get(), (Item)TFItems.YETI_HELMET.get(), (Item)TFItems.YETI_CHESTPLATE.get(), (Item)TFItems.YETI_LEGGINGS.get(), (Item)TFItems.YETI_BOOTS.get() });
        this.m_126548_((Tag.Named)ItemTagGenerator.WIP).m_126584_((Object[])new Item[] { ((KeepsakeCasketBlock)TFBlocks.KEEPSAKE_CASKET.get()).m_5456_(), (Item)TFItems.CUBE_OF_ANNIHILATION.get() });
        this.m_126548_((Tag.Named)ItemTagGenerator.NYI).m_126584_((Object[])new Item[] { ((Block)TFBlocks.CINDER_FURNACE.get()).m_5456_(), ((RotatedPillarBlock)TFBlocks.CINDER_LOG.get()).m_5456_(), ((Block)TFBlocks.CINDER_WOOD.get()).m_5456_(), ((Block)TFBlocks.TWILIGHT_PORTAL_MINIATURE_STRUCTURE.get()).m_5456_(), ((Block)TFBlocks.NAGA_COURTYARD_MINIATURE_STRUCTURE.get()).m_5456_(), ((Block)TFBlocks.LICH_TOWER_MINIATURE_STRUCTURE.get()).m_5456_(), ((Block)TFBlocks.AURORALIZED_GLASS.get()).m_5456_(), ((RotatedPillarBlock)TFBlocks.SLIDER.get()).m_5456_(), ((RotatedPillarBlock)TFBlocks.TWISTED_STONE.get()).m_5456_(), ((Block)TFBlocks.TWISTED_STONE_PILLAR.get()).m_5456_(), (Item)TFItems.ORE_METER.get() });
        this.m_126548_((Tag.Named)ItemTagGenerator.KOBOLD_PACIFICATION_BREADS).m_126582_((Object)Items.f_42406_);
        this.m_126548_((Tag.Named)ItemTagGenerator.TF_MUSIC_DISCS).m_126584_((Object[])new Item[] { (Item)TFItems.MUSIC_DISC_FINDINGS.get(), (Item)TFItems.MUSIC_DISC_HOME.get(), (Item)TFItems.MUSIC_DISC_MAKER.get(), (Item)TFItems.MUSIC_DISC_MOTION.get(), (Item)TFItems.MUSIC_DISC_RADIANCE.get(), (Item)TFItems.MUSIC_DISC_STEPS.get(), (Item)TFItems.MUSIC_DISC_SUPERSTITIOUS.get(), (Item)TFItems.MUSIC_DISC_THREAD.get(), (Item)TFItems.MUSIC_DISC_WAYFARER.get() });
        this.m_126548_(ItemTags.f_13158_).m_126580_((Tag.Named)ItemTagGenerator.TF_MUSIC_DISCS);
        this.m_126548_((Tag.Named)ItemTagGenerator.BANNED_UNCRAFTING_INGREDIENTS).m_126584_((Object[])new Item[] { ((Block)TFBlocks.INFESTED_TOWERWOOD.get()).m_5456_(), ((SaplingBlock)TFBlocks.HOLLOW_OAK_SAPLING.get()).m_5456_(), ((SaplingBlock)TFBlocks.TIME_SAPLING.get()).m_5456_(), ((SaplingBlock)TFBlocks.TRANSFORMATION_SAPLING.get()).m_5456_(), ((SaplingBlock)TFBlocks.MINING_SAPLING.get()).m_5456_(), ((SaplingBlock)TFBlocks.SORTING_SAPLING.get()).m_5456_() });
        this.m_126548_((Tag.Named)ItemTagGenerator.BANNED_UNCRAFTABLES).m_126582_((Object)((Block)TFBlocks.GIANT_LOG.get()).m_5456_());
        this.m_126548_(ItemTags.f_13151_).m_126584_((Object[])new Item[] { (Item)TFItems.GOLDEN_MINOTAUR_AXE.get(), (Item)TFItems.CHARM_OF_KEEPING_3.get(), (Item)TFItems.CHARM_OF_LIFE_2.get(), (Item)TFItems.LAMP_OF_CINDERS.get() });
    }
    
    static {
        TWILIGHT_OAK_LOGS = ItemTags.m_13194_(TwilightForestMod.prefix("twilight_oak_logs").toString());
        CANOPY_LOGS = ItemTags.m_13194_(TwilightForestMod.prefix("canopy_logs").toString());
        MANGROVE_LOGS = ItemTags.m_13194_(TwilightForestMod.prefix("mangrove_logs").toString());
        DARKWOOD_LOGS = ItemTags.m_13194_(TwilightForestMod.prefix("darkwood_logs").toString());
        TIME_LOGS = ItemTags.m_13194_(TwilightForestMod.prefix("timewood_logs").toString());
        TRANSFORMATION_LOGS = ItemTags.m_13194_(TwilightForestMod.prefix("transwood_logs").toString());
        MINING_LOGS = ItemTags.m_13194_(TwilightForestMod.prefix("mining_logs").toString());
        SORTING_LOGS = ItemTags.m_13194_(TwilightForestMod.prefix("sortwood_logs").toString());
        TWILIGHT_LOGS = ItemTags.m_13194_(TwilightForestMod.prefix("logs").toString());
        TF_FENCES = ItemTags.m_13194_(TwilightForestMod.prefix("fences").toString());
        TF_FENCE_GATES = ItemTags.m_13194_(TwilightForestMod.prefix("fence_gates").toString());
        PAPER = ItemTags.m_13194_("forge:paper");
        TOWERWOOD = ItemTags.m_13194_(TwilightForestMod.prefix("towerwood").toString());
        FIERY_VIAL = ItemTags.m_13194_(TwilightForestMod.prefix("fiery_vial").toString());
        ARCTIC_FUR = ItemTags.m_13194_(TwilightForestMod.prefix("arctic_fur").toString());
        CARMINITE_GEMS = ItemTags.m_13194_("forge:gems/carminite");
        FIERY_INGOTS = ItemTags.m_13194_("forge:ingots/fiery");
        IRONWOOD_INGOTS = ItemTags.m_13194_("forge:ingots/ironwood");
        KNIGHTMETAL_INGOTS = ItemTags.m_13194_("forge:ingots/knightmetal");
        STEELEAF_INGOTS = ItemTags.m_13194_("forge:ingots/steeleaf");
        STORAGE_BLOCKS_ARCTIC_FUR = ItemTags.m_13194_("forge:storage_blocks/arctic_fur");
        STORAGE_BLOCKS_CARMINITE = ItemTags.m_13194_("forge:storage_blocks/carminite");
        STORAGE_BLOCKS_FIERY = ItemTags.m_13194_("forge:storage_blocks/fiery");
        STORAGE_BLOCKS_IRONWOOD = ItemTags.m_13194_("forge:storage_blocks/ironwood");
        STORAGE_BLOCKS_KNIGHTMETAL = ItemTags.m_13194_("forge:storage_blocks/knightmetal");
        STORAGE_BLOCKS_STEELEAF = ItemTags.m_13194_("forge:storage_blocks/steeleaf");
        ORES_IRONWOOD = ItemTags.m_13194_("forge:ores/ironwood");
        ORES_KNIGHTMETAL = ItemTags.m_13194_("forge:ores/knightmetal");
        PORTAL_ACTIVATOR = ItemTags.m_13194_(TwilightForestMod.prefix("portal/activator").toString());
        WIP = ItemTags.m_13194_(TwilightForestMod.prefix("wip").toString());
        NYI = ItemTags.m_13194_(TwilightForestMod.prefix("nyi").toString());
        KOBOLD_PACIFICATION_BREADS = ItemTags.m_13194_(TwilightForestMod.prefix("kobold_pacification_breads").toString());
        TF_MUSIC_DISCS = ItemTags.m_13194_(TwilightForestMod.prefix("tf_music_discs").toString());
        BANNED_UNCRAFTING_INGREDIENTS = ItemTags.m_13194_(TwilightForestMod.prefix("banned_uncrafting_ingredients").toString());
        BANNED_UNCRAFTABLES = ItemTags.m_13194_(TwilightForestMod.prefix("banned_uncraftables").toString());
    }
}
