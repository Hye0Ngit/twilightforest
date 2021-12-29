// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import twilightforest.TwilightForestMod;
import twilightforest.item.TFItems;
import net.minecraft.item.Items;
import twilightforest.block.TFBlocks;
import net.minecraft.block.StandingSignBlock;
import net.minecraftforge.common.Tags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.data.ItemTagsProvider;

public class ItemTagGenerator extends ItemTagsProvider
{
    public static final ITag.INamedTag<Item> TWILIGHT_OAK_LOGS;
    public static final ITag.INamedTag<Item> CANOPY_LOGS;
    public static final ITag.INamedTag<Item> MANGROVE_LOGS;
    public static final ITag.INamedTag<Item> DARKWOOD_LOGS;
    public static final ITag.INamedTag<Item> TIME_LOGS;
    public static final ITag.INamedTag<Item> TRANSFORMATION_LOGS;
    public static final ITag.INamedTag<Item> MINING_LOGS;
    public static final ITag.INamedTag<Item> SORTING_LOGS;
    public static final ITag.INamedTag<Item> TWILIGHT_LOGS;
    public static final ITag.INamedTag<Item> TF_FENCES;
    public static final ITag.INamedTag<Item> TF_FENCE_GATES;
    public static final ITag.INamedTag<Item> PAPER;
    public static final ITag.INamedTag<Item> TOWERWOOD;
    public static final ITag.INamedTag<Item> FIERY_VIAL;
    public static final ITag.INamedTag<Item> ARCTIC_FUR;
    public static final ITag.INamedTag<Item> CARMINITE_GEMS;
    public static final ITag.INamedTag<Item> FIERY_INGOTS;
    public static final ITag.INamedTag<Item> IRONWOOD_INGOTS;
    public static final ITag.INamedTag<Item> KNIGHTMETAL_INGOTS;
    public static final ITag.INamedTag<Item> STEELEAF_INGOTS;
    public static final ITag.INamedTag<Item> STORAGE_BLOCKS_ARCTIC_FUR;
    public static final ITag.INamedTag<Item> STORAGE_BLOCKS_CARMINITE;
    public static final ITag.INamedTag<Item> STORAGE_BLOCKS_FIERY;
    public static final ITag.INamedTag<Item> STORAGE_BLOCKS_IRONWOOD;
    public static final ITag.INamedTag<Item> STORAGE_BLOCKS_KNIGHTMETAL;
    public static final ITag.INamedTag<Item> STORAGE_BLOCKS_STEELEAF;
    public static final ITag.INamedTag<Item> ORES_IRONWOOD;
    public static final ITag.INamedTag<Item> ORES_KNIGHTMETAL;
    public static final ITag.INamedTag<Item> PORTAL_ACTIVATOR;
    
    public ItemTagGenerator(final DataGenerator generator, final BlockTagsProvider blockprovider, final ExistingFileHelper exFileHelper) {
        super(generator, blockprovider, "twilightforest", exFileHelper);
    }
    
    protected void func_200432_c() {
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.TWILIGHT_OAK_LOGS, (ITag.INamedTag)ItemTagGenerator.TWILIGHT_OAK_LOGS);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.CANOPY_LOGS, (ITag.INamedTag)ItemTagGenerator.CANOPY_LOGS);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.MANGROVE_LOGS, (ITag.INamedTag)ItemTagGenerator.MANGROVE_LOGS);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.DARKWOOD_LOGS, (ITag.INamedTag)ItemTagGenerator.DARKWOOD_LOGS);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.TIME_LOGS, (ITag.INamedTag)ItemTagGenerator.TIME_LOGS);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.TRANSFORMATION_LOGS, (ITag.INamedTag)ItemTagGenerator.TRANSFORMATION_LOGS);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.MINING_LOGS, (ITag.INamedTag)ItemTagGenerator.MINING_LOGS);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.SORTING_LOGS, (ITag.INamedTag)ItemTagGenerator.SORTING_LOGS);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.TF_LOGS, (ITag.INamedTag)ItemTagGenerator.TWILIGHT_LOGS);
        this.func_240522_a_(ItemTags.field_200038_h).func_240531_a_((ITag.INamedTag)ItemTagGenerator.TWILIGHT_LOGS);
        this.func_240522_a_(ItemTags.field_232912_o_).func_240531_a_((ITag.INamedTag)ItemTagGenerator.TWILIGHT_OAK_LOGS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.CANOPY_LOGS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.MANGROVE_LOGS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.TIME_LOGS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.TRANSFORMATION_LOGS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.MINING_LOGS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.SORTING_LOGS);
        this.func_240521_a_(BlockTags.field_200030_g, ItemTags.field_200037_g);
        this.func_240521_a_(BlockTags.field_206952_E, ItemTags.field_206963_E);
        this.func_240521_a_(BlockTags.field_199898_b, ItemTags.field_199905_b);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.TF_FENCES, (ITag.INamedTag)ItemTagGenerator.TF_FENCES);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.TF_FENCE_GATES, (ITag.INamedTag)ItemTagGenerator.TF_FENCE_GATES);
        this.func_240521_a_(BlockTags.field_219756_j, ItemTags.field_219777_j);
        this.func_240521_a_((ITag.INamedTag)Tags.Blocks.FENCES, (ITag.INamedTag)Tags.Items.FENCES);
        this.func_240521_a_((ITag.INamedTag)Tags.Blocks.FENCE_GATES, (ITag.INamedTag)Tags.Items.FENCE_GATES);
        this.func_240521_a_((ITag.INamedTag)Tags.Blocks.FENCES_WOODEN, (ITag.INamedTag)Tags.Items.FENCES_WOODEN);
        this.func_240521_a_((ITag.INamedTag)Tags.Blocks.FENCE_GATES_WOODEN, (ITag.INamedTag)Tags.Items.FENCE_GATES_WOODEN);
        this.func_240521_a_(BlockTags.field_202895_i, ItemTags.field_202899_i);
        this.func_240521_a_(BlockTags.field_203292_x, ItemTags.field_203442_w);
        this.func_240521_a_(BlockTags.field_202894_h, ItemTags.field_202898_h);
        this.func_240521_a_(BlockTags.field_203291_w, ItemTags.field_203441_v);
        this.func_240521_a_(BlockTags.field_200151_d, ItemTags.field_200153_d);
        this.func_240521_a_(BlockTags.field_202896_j, ItemTags.field_202900_j);
        this.func_240521_a_(BlockTags.field_212186_k, ItemTags.field_212188_k);
        this.func_240521_a_(BlockTags.field_200152_g, ItemTags.field_200154_g);
        this.func_240522_a_(ItemTags.field_219773_J).func_240534_a_((Object[])new Item[] { ((StandingSignBlock)TFBlocks.twilight_oak_sign.get()).func_199767_j(), ((StandingSignBlock)TFBlocks.canopy_sign.get()).func_199767_j(), ((StandingSignBlock)TFBlocks.mangrove_sign.get()).func_199767_j(), ((StandingSignBlock)TFBlocks.darkwood_sign.get()).func_199767_j(), ((StandingSignBlock)TFBlocks.time_sign.get()).func_199767_j(), ((StandingSignBlock)TFBlocks.trans_sign.get()).func_199767_j(), ((StandingSignBlock)TFBlocks.mine_sign.get()).func_199767_j(), ((StandingSignBlock)TFBlocks.sort_sign.get()).func_199767_j() });
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR, (ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_CARMINITE, (ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_CARMINITE);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_FIERY, (ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_FIERY);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_IRONWOOD, (ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_IRONWOOD);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL, (ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.STORAGE_BLOCKS_STEELEAF, (ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_STEELEAF);
        this.func_240522_a_((ITag.INamedTag)Tags.Items.STORAGE_BLOCKS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_FIERY).func_240531_a_((ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_ARCTIC_FUR).func_240531_a_((ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_CARMINITE).func_240531_a_((ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_IRONWOOD).func_240531_a_((ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_KNIGHTMETAL).func_240531_a_((ITag.INamedTag)ItemTagGenerator.STORAGE_BLOCKS_STEELEAF);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.ORES_IRONWOOD, (ITag.INamedTag)ItemTagGenerator.ORES_IRONWOOD);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.ORES_KNIGHTMETAL, (ITag.INamedTag)ItemTagGenerator.ORES_KNIGHTMETAL);
        this.func_240522_a_((ITag.INamedTag)Tags.Items.ORES).func_240531_a_((ITag.INamedTag)ItemTagGenerator.ORES_IRONWOOD).func_240531_a_((ITag.INamedTag)ItemTagGenerator.ORES_KNIGHTMETAL);
        this.func_240521_a_((ITag.INamedTag)BlockTagGenerator.TOWERWOOD, (ITag.INamedTag)ItemTagGenerator.TOWERWOOD);
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.PAPER).func_240534_a_((Object[])new Item[] { Items.field_151121_aF });
        this.func_240522_a_((ITag.INamedTag)Tags.Items.FEATHERS).func_240534_a_((Object[])new Item[] { Items.field_151008_G }).func_240534_a_((Object[])new Item[] { (Item)TFItems.raven_feather.get() });
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.FIERY_VIAL).func_240534_a_((Object[])new Item[] { (Item)TFItems.fiery_blood.get(), (Item)TFItems.fiery_tears.get() });
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.ARCTIC_FUR).func_240534_a_((Object[])new Item[] { (Item)TFItems.arctic_fur.get() });
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.CARMINITE_GEMS).func_240534_a_((Object[])new Item[] { (Item)TFItems.carminite.get() });
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.FIERY_INGOTS).func_240534_a_((Object[])new Item[] { (Item)TFItems.fiery_ingot.get() });
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.IRONWOOD_INGOTS).func_240534_a_((Object[])new Item[] { (Item)TFItems.ironwood_ingot.get() });
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.KNIGHTMETAL_INGOTS).func_240534_a_((Object[])new Item[] { (Item)TFItems.knightmetal_ingot.get() });
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.STEELEAF_INGOTS).func_240534_a_((Object[])new Item[] { (Item)TFItems.steeleaf_ingot.get() });
        this.func_240522_a_((ITag.INamedTag)Tags.Items.GEMS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.CARMINITE_GEMS);
        this.func_240522_a_((ITag.INamedTag)Tags.Items.INGOTS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.IRONWOOD_INGOTS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.FIERY_INGOTS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.KNIGHTMETAL_INGOTS).func_240531_a_((ITag.INamedTag)ItemTagGenerator.STEELEAF_INGOTS);
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.ORES_IRONWOOD).func_240534_a_((Object[])new Item[] { (Item)TFItems.ironwood_raw.get() });
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.ORES_KNIGHTMETAL).func_240534_a_((Object[])new Item[] { (Item)TFItems.armor_shard_cluster.get() });
        this.func_240522_a_((ITag.INamedTag)ItemTagGenerator.PORTAL_ACTIVATOR).func_240531_a_((ITag.INamedTag)Tags.Items.GEMS_DIAMOND);
    }
    
    static {
        TWILIGHT_OAK_LOGS = ItemTags.func_199901_a(TwilightForestMod.prefix("twilight_oak_logs").toString());
        CANOPY_LOGS = ItemTags.func_199901_a(TwilightForestMod.prefix("canopy_logs").toString());
        MANGROVE_LOGS = ItemTags.func_199901_a(TwilightForestMod.prefix("mangrove_logs").toString());
        DARKWOOD_LOGS = ItemTags.func_199901_a(TwilightForestMod.prefix("darkwood_logs").toString());
        TIME_LOGS = ItemTags.func_199901_a(TwilightForestMod.prefix("timewood_logs").toString());
        TRANSFORMATION_LOGS = ItemTags.func_199901_a(TwilightForestMod.prefix("transwood_logs").toString());
        MINING_LOGS = ItemTags.func_199901_a(TwilightForestMod.prefix("mining_logs").toString());
        SORTING_LOGS = ItemTags.func_199901_a(TwilightForestMod.prefix("sortwood_logs").toString());
        TWILIGHT_LOGS = ItemTags.func_199901_a(TwilightForestMod.prefix("logs").toString());
        TF_FENCES = ItemTags.func_199901_a(TwilightForestMod.prefix("fences").toString());
        TF_FENCE_GATES = ItemTags.func_199901_a(TwilightForestMod.prefix("fence_gates").toString());
        PAPER = ItemTags.func_199901_a("forge:paper");
        TOWERWOOD = ItemTags.func_199901_a(TwilightForestMod.prefix("towerwood").toString());
        FIERY_VIAL = ItemTags.func_199901_a(TwilightForestMod.prefix("fiery_vial").toString());
        ARCTIC_FUR = ItemTags.func_199901_a(TwilightForestMod.prefix("arctic_fur").toString());
        CARMINITE_GEMS = ItemTags.func_199901_a("forge:gems/carminite");
        FIERY_INGOTS = ItemTags.func_199901_a("forge:ingots/fiery");
        IRONWOOD_INGOTS = ItemTags.func_199901_a("forge:ingots/ironwood");
        KNIGHTMETAL_INGOTS = ItemTags.func_199901_a("forge:ingots/knightmetal");
        STEELEAF_INGOTS = ItemTags.func_199901_a("forge:ingots/steeleaf");
        STORAGE_BLOCKS_ARCTIC_FUR = ItemTags.func_199901_a("forge:storage_blocks/arctic_fur");
        STORAGE_BLOCKS_CARMINITE = ItemTags.func_199901_a("forge:storage_blocks/carminite");
        STORAGE_BLOCKS_FIERY = ItemTags.func_199901_a("forge:storage_blocks/fiery");
        STORAGE_BLOCKS_IRONWOOD = ItemTags.func_199901_a("forge:storage_blocks/ironwood");
        STORAGE_BLOCKS_KNIGHTMETAL = ItemTags.func_199901_a("forge:storage_blocks/knightmetal");
        STORAGE_BLOCKS_STEELEAF = ItemTags.func_199901_a("forge:storage_blocks/steeleaf");
        ORES_IRONWOOD = ItemTags.func_199901_a("forge:ores/ironwood");
        ORES_KNIGHTMETAL = ItemTags.func_199901_a("forge:ores/knightmetal");
        PORTAL_ACTIVATOR = ItemTags.func_199901_a(TwilightForestMod.prefix("portal/activator").toString());
    }
}
