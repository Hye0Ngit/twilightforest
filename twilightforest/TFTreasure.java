// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.enchantment.Enchantment;
import twilightforest.block.TFBlocks;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import java.util.Random;

public class TFTreasure
{
    int type;
    Random treasureRNG;
    protected TFTreasureTable useless;
    protected TFTreasureTable common;
    protected TFTreasureTable uncommon;
    protected TFTreasureTable rare;
    protected TFTreasureTable ultrarare;
    public static TFTreasure hill1;
    public static TFTreasure hill2;
    public static TFTreasure hill3;
    public static TFTreasure hedgemaze;
    public static TFTreasure labyrinth_room;
    public static TFTreasure labyrinth_deadend;
    public static TFTreasure tower_room;
    public static TFTreasure tower_library;
    public static TFTreasure basement;
    public static TFTreasure labyrinth_vault;
    public static TFTreasure darktower_cache;
    public static TFTreasure darktower_key;
    public static TFTreasure darktower_boss;
    public static TFTreasure tree_cache;
    public static TFTreasure stronghold_cache;
    public static TFTreasure stronghold_room;
    
    public TFTreasure(final int i) {
        this.type = i;
        this.useless = new TFTreasureTable();
        this.common = new TFTreasureTable();
        this.uncommon = new TFTreasureTable();
        this.rare = new TFTreasureTable();
        this.ultrarare = new TFTreasureTable();
        this.treasureRNG = new Random();
        this.fill(i);
    }
    
    public boolean generate(final World world, final Random rand, final int cx, final int cy, final int cz) {
        return this.generate(world, rand, cx, cy, cz, Block.field_72077_au.field_71990_ca);
    }
    
    public boolean generate(final World world, final Random rand, final int cx, final int cy, final int cz, final int chestBlock) {
        boolean flag = true;
        this.treasureRNG.setSeed(world.func_72905_C() * cx + cy ^ (long)cz);
        world.func_72832_d(cx, cy, cz, chestBlock, 0, 2);
        for (int i = 0; i < 4; ++i) {
            flag &= this.addItemToChest(world, this.treasureRNG, cx, cy, cz, this.getCommonItem(this.treasureRNG));
        }
        for (int i = 0; i < 2; ++i) {
            flag &= this.addItemToChest(world, this.treasureRNG, cx, cy, cz, this.getUncommonItem(this.treasureRNG));
        }
        for (int i = 0; i < 1; ++i) {
            flag &= this.addItemToChest(world, this.treasureRNG, cx, cy, cz, this.getRareItem(this.treasureRNG));
        }
        return flag;
    }
    
    public ItemStack getCommonItem(final Random rand) {
        if (!this.useless.isEmpty() && rand.nextInt(4) == 0) {
            return this.useless.getRandomItem(rand);
        }
        return this.common.getRandomItem(rand);
    }
    
    public ItemStack getUncommonItem(final Random rand) {
        return this.uncommon.getRandomItem(rand);
    }
    
    public ItemStack getRareItem(final Random rand) {
        if (!this.ultrarare.isEmpty() && rand.nextInt(4) == 0) {
            return this.ultrarare.getRandomItem(rand);
        }
        return this.rare.getRandomItem(rand);
    }
    
    protected boolean addItemToChest(final World world, final Random rand, final int cx, final int cy, final int cz, final ItemStack itemStack) {
        final TileEntityChest chest = (TileEntityChest)world.func_72796_p(cx, cy, cz);
        if (chest != null) {
            final int slot = this.findRandomInventorySlot(chest, rand);
            if (slot != -1) {
                chest.func_70299_a(slot, itemStack);
                return true;
            }
        }
        return false;
    }
    
    protected int findRandomInventorySlot(final TileEntityChest chest, final Random rand) {
        for (int i = 0; i < 100; ++i) {
            final int slot = rand.nextInt(chest.func_70302_i_());
            if (chest.func_70301_a(slot) == null) {
                return slot;
            }
        }
        return -1;
    }
    
    protected void fill(final int i) {
        this.useless.add((Block)Block.field_72107_ae, 4);
        this.useless.add((Block)Block.field_72097_ad, 4);
        this.useless.add(Item.field_77676_L, 3);
        this.useless.add(Item.field_77690_S, 2);
        this.useless.add(Item.field_77804_ap, 2);
        this.useless.add(Block.field_72038_aV, 2);
        this.useless.add(Item.field_77758_aJ, 4);
        this.useless.add(Block.field_71939_E, 4);
        this.useless.add(Item.field_82796_bJ, 1);
        this.useless.add(new ItemStack(Item.field_77756_aW, 1, 0));
        if (i == 1) {
            this.common.add(Item.field_77703_o, 4);
            this.common.add(Item.field_77685_T, 4);
            this.common.add(Item.field_77683_K, 4);
            this.common.add(Item.field_77788_aw, 1);
            this.uncommon.add(Item.field_77684_U, 1);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(Item.field_77677_M, 4);
            this.uncommon.add(Item.field_77704_l, 12);
            this.uncommon.add(Block.field_72069_aq, 12);
            this.rare.add(Item.field_77717_p, 3);
            this.rare.add(Item.field_77696_g, 1);
            this.rare.add(TFItems.liveRoot, 3);
            this.ultrarare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(Item.field_77702_n, 1);
            this.ultrarare.add(TFItems.steeleafIngot, 3);
        }
        if (i == 2) {
            this.common.add(Item.field_77703_o, 4);
            this.common.add(Item.field_82797_bK, 4);
            this.common.add(Block.field_72055_aF, 6);
            this.common.add(Item.field_77788_aw, 1);
            this.uncommon.add(Item.field_82795_bM, 2);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(TFItems.ironwoodIngot, 4);
            this.uncommon.add(Item.field_77704_l, 12);
            this.uncommon.add(Block.field_72069_aq, 12);
            this.rare.add(TFItems.nagaScale, 1);
            this.rare.add(TFBlocks.uncraftingTable, 1);
            this.rare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(TFItems.peacockFan, 1);
            this.ultrarare.add(Item.field_77817_bH, 6);
            this.ultrarare.add(Item.field_77702_n, 1);
            this.ultrarare.add(TFItems.charmOfLife1, 1);
        }
        if (i == 3) {
            this.common.add(Item.field_77733_bq, 9);
            this.common.add(Item.field_82794_bL, 4);
            this.common.add(Item.field_77754_aU, 4);
            this.common.add(TFItems.torchberries, 5);
            this.uncommon.add(Item.field_82791_bT, 1);
            this.uncommon.add(TFItems.oreMagnet, 1);
            this.uncommon.add(Item.field_77677_M, 4);
            this.uncommon.add(Item.field_77704_l, 12);
            this.uncommon.add(Block.field_72069_aq, 12);
            this.uncommon.add(TFItems.steeleafIngot, 4);
            this.rare.add(TFItems.nagaScale, 1);
            this.rare.addEnchanted(new ItemStack(TFItems.ironwoodPick, 1), Enchantment.field_77349_p, 1, Enchantment.field_77346_s, 1);
            this.rare.add(TFItems.transformPowder, 12);
            this.ultrarare.add(TFItems.moonwormQueen, 1);
            this.ultrarare.add(TFBlocks.sapling, 1, 4);
            this.ultrarare.add(Item.field_77702_n, 2);
            this.ultrarare.add(TFItems.charmOfLife1, 1);
            this.ultrarare.add(TFItems.charmOfKeeping1, 1);
        }
        if (i == 4) {
            this.common.add(Block.field_71988_x, 4);
            this.common.add((Block)Block.field_72109_af, 4);
            this.common.add((Block)Block.field_72103_ag, 4);
            this.common.add(Item.field_77685_T, 4);
            this.common.add(Item.field_77683_K, 4);
            this.common.add(Item.field_77669_D, 6);
            this.uncommon.add(Item.field_77738_bf, 4);
            this.uncommon.add(Item.field_77740_bh, 4);
            this.uncommon.add(Item.field_77739_bg, 4);
            this.uncommon.add(Item.field_77704_l, 12);
            this.uncommon.add(TFBlocks.firefly, 4);
            this.rare.add(Block.field_71955_W, 3);
            this.rare.add((Item)Item.field_77745_be, 1);
            this.rare.add(Item.field_77765_aA, 1);
            this.rare.add((Item)Item.field_77707_k, 1);
            this.rare.add(Item.field_77706_j, 2);
            this.ultrarare.add(Item.field_77688_Q, 1);
            this.ultrarare.add(Item.field_77702_n, 1);
            this.ultrarare.add(Item.field_77671_F, 1);
            this.ultrarare.add(Item.field_77778_at, 1);
        }
        if (i == 5) {
            this.useless.clear();
            this.common.add(Item.field_77703_o, 4);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(Item.field_77677_M, 4);
            this.common.add(TFItems.ironwoodIngot, 4);
            this.common.add(TFBlocks.firefly, 5);
            this.common.add(Item.field_77771_aG, 1);
            this.uncommon.add(TFItems.steeleafIngot, 6);
            this.uncommon.add(TFItems.steeleafLegs, 1);
            this.uncommon.add(TFItems.steeleafPlate, 1);
            this.uncommon.add(TFItems.steeleafHelm, 1);
            this.uncommon.add(TFItems.steeleafBoots, 1);
            this.uncommon.add(TFItems.steeleafPick, 1);
            this.uncommon.add(TFItems.ironwoodPlate, 1);
            this.uncommon.add(TFItems.ironwoodSword, 1);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.mazeMapFocus, 1);
            this.rare.add(Block.field_72091_am, 3);
            this.rare.add(new ItemStack((Item)Item.field_77726_bs, 1, 16373));
        }
        if (i == 6) {
            this.common.add(Item.field_77669_D, 12);
            this.common.add(Item.field_77705_m, 12);
            this.common.add(Item.field_77704_l, 12);
            this.common.add(TFItems.mazeWafer, 9);
            this.common.add(Item.field_77759_aK, 12);
            this.common.add(Item.field_77770_aF, 4);
            this.common.add(Item.field_77671_F, 1);
            this.uncommon.add(Item.field_77771_aG, 1);
            this.uncommon.add(Item.field_77759_aK, 5);
            this.uncommon.add(Item.field_77703_o, 6);
            this.uncommon.add(TFItems.ironwoodIngot, 8);
            this.uncommon.add(TFBlocks.firefly, 5);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.steeleafIngot, 8);
            this.rare.add(Item.field_77778_at, 1);
            this.rare.add(Item.field_77731_bo, 2);
        }
        if (i == 10) {
            this.useless.clear();
            this.common.add(Item.field_77703_o, 9);
            this.common.add(Item.field_77817_bH, 5);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(TFItems.ironwoodIngot, 9);
            this.common.add(new ItemStack((Item)Item.field_77726_bs, 1, 16369));
            this.common.add(new ItemStack((Item)Item.field_77726_bs, 1, 16373));
            this.common.add(new ItemStack((Item)Item.field_77726_bs, 1, 16370));
            this.uncommon.addEnchanted(new ItemStack((Item)Item.field_77707_k), Enchantment.field_77342_w, 1, Enchantment.field_77344_u, 2);
            this.uncommon.addEnchanted(new ItemStack((Item)Item.field_77707_k), Enchantment.field_77345_t, 3, Enchantment.field_77343_v, 1);
            this.uncommon.addEnchanted(new ItemStack(TFItems.steeleafShovel), Enchantment.field_77349_p, 4, Enchantment.field_77347_r, 2);
            this.uncommon.addEnchanted(new ItemStack(TFItems.steeleafAxe), Enchantment.field_77349_p, 5);
            this.uncommon.add(TFItems.steeleafIngot, 12);
            this.uncommon.addEnchanted(new ItemStack(TFItems.steeleafPlate), Enchantment.field_77332_c, 3);
            this.uncommon.addEnchanted(new ItemStack(TFItems.steeleafLegs), Enchantment.field_77329_d, 4);
            this.uncommon.addEnchanted(new ItemStack(TFItems.steeleafBoots), Enchantment.field_77332_c, 2);
            this.uncommon.addEnchanted(new ItemStack(TFItems.steeleafHelm), Enchantment.field_77340_h, 3);
            this.rare.add(Block.field_72076_bV, 1);
            this.rare.add(Block.field_72066_bS, 1);
            this.rare.addEnchanted(new ItemStack(TFItems.steeleafPick), Enchantment.field_77349_p, 4, Enchantment.field_77348_q, 1);
            this.rare.addEnchanted(new ItemStack(TFItems.steeleafSword), Enchantment.field_77338_j, 4, Enchantment.field_77337_m, 2);
            this.rare.addEnchanted(new ItemStack(TFItems.steeleafSword), Enchantment.field_77336_l, 5, Enchantment.field_77334_n, 2);
            this.rare.addEnchanted(new ItemStack(TFItems.mazebreakerPick), Enchantment.field_77349_p, 4, Enchantment.field_77347_r, 3, Enchantment.field_77346_s, 2);
        }
        if (i == 7) {
            this.common.add(Item.field_77729_bt, 6);
            this.common.add(new ItemStack((Item)Item.field_77726_bs, 1, 0));
            this.common.add(Item.field_77747_aY, 5);
            this.common.add(Item.field_77728_bu, 3);
            this.common.add(Item.field_77732_bp, 1);
            this.common.add(Item.field_77725_bx, 2);
            this.common.add(Item.field_77723_bv, 1);
            this.common.add(Item.field_77813_bB, 2);
            this.common.add(Item.field_77722_bw, 3);
            this.common.add(Item.field_77759_aK, 6);
            this.uncommon.addRandomEnchanted(Item.field_77672_G, 10);
            this.uncommon.addRandomEnchanted((Item)Item.field_77802_ao, 7);
            this.uncommon.add(new ItemStack((Item)Item.field_77726_bs, 1, 16274));
            this.uncommon.add(new ItemStack((Item)Item.field_77726_bs, 1, 16341));
            this.uncommon.add(new ItemStack((Item)Item.field_77726_bs, 1, 16307));
            this.uncommon.add(new ItemStack((Item)Item.field_77726_bs, 1, 16348));
            this.rare.addRandomEnchanted((Item)Item.field_77796_al, 18);
            this.rare.add(new ItemStack((Item)Item.field_77726_bs, 1, 16306));
            this.rare.add(new ItemStack((Item)Item.field_77726_bs, 1, 16305));
            this.rare.add(new ItemStack((Item)Item.field_77726_bs, 1, 32725));
            this.rare.add(new ItemStack((Item)Item.field_77726_bs, 1, 32764));
            this.rare.add(TFItems.transformPowder, 12);
            this.rare.add(TFItems.charmOfLife1, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.addRandomEnchanted(Item.field_77682_J, 20);
            this.ultrarare.add(Item.field_77730_bn, 1);
            this.ultrarare.add(Block.field_72089_ap, 4);
            this.ultrarare.add(Item.field_77702_n, 1);
            this.ultrarare.add(TFItems.moonwormQueen, 1);
            this.ultrarare.add(TFItems.peacockFan, 1);
        }
        if (i == 8) {
            this.common.add(Item.field_77729_bt, 6);
            this.common.add(new ItemStack((Item)Item.field_77726_bs, 1, 0));
            this.common.add(Block.field_72055_aF, 6);
            this.common.add(Item.field_77759_aK, 6);
            this.common.add(Item.field_77755_aX, 6);
            this.common.add(Item.field_77733_bq, 6);
            this.common.add(Item.field_77757_aI, 12);
            this.uncommon.addRandomEnchanted((Item)Item.field_77824_af, 5);
            this.uncommon.add(Item.field_77811_bE, 3);
            this.uncommon.add(Item.field_77760_aL, 5);
            this.uncommon.add((Item)Item.field_82801_bO, 1);
            this.uncommon.add(new ItemStack((Item)Item.field_77726_bs, 1, 16));
            this.uncommon.add(new ItemStack((Item)Item.field_77726_bs, 1, 16276));
            this.uncommon.add(new ItemStack((Item)Item.field_77726_bs, 1, 16312));
            this.rare.addRandomEnchanted((Item)Item.field_77707_k, 5);
            this.rare.addRandomEnchanted(Item.field_77711_v, 10);
            this.rare.addRandomEnchanted(Item.field_77715_r, 15);
            this.rare.add(new ItemStack((Item)Item.field_77726_bs, 1, 32696));
            this.rare.add(new ItemStack((Item)Item.field_77726_bs, 1, 16369));
            this.rare.add(new ItemStack((Item)Item.field_77726_bs, 1, 16373));
            this.rare.add(new ItemStack((Item)Item.field_77726_bs, 1, 16370));
            this.rare.add(TFItems.transformPowder, 12);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.addRandomEnchanted(Item.field_77681_I, 10);
            this.ultrarare.addRandomEnchanted(Item.field_77716_q, 20);
            this.ultrarare.addRandomEnchanted((Item)Item.field_77707_k, 30);
            this.ultrarare.add(Block.field_72093_an, 5);
            this.ultrarare.add(Item.field_77730_bn, 2);
            this.ultrarare.add(Item.field_77809_bD, 6);
        }
        if (i == 9) {
            this.common.add(new ItemStack((Item)Item.field_77726_bs, 1, 0));
            this.common.add(Item.field_77737_bm, 6);
            this.common.add(Item.field_82800_bN, 2);
            this.common.add(Item.field_77685_T, 6);
            this.common.add(Item.field_82794_bL, 6);
            this.common.add(Item.field_82797_bK, 6);
            this.common.add(Item.field_77738_bf, 6);
            this.common.add(Item.field_77786_ax, 1);
            this.common.add(Block.field_72069_aq, 12);
            this.common.add(Item.field_77671_F, 1);
            this.common.add(Item.field_77771_aG, 1);
            this.common.add(Item.field_77740_bh, 5);
            this.uncommon.add(Item.field_77684_U, 8);
            this.uncommon.add(Item.field_77734_bj, 6);
            this.uncommon.add(Item.field_77782_ar, 8);
            this.uncommon.add(Item.field_82795_bM, 8);
            this.uncommon.add(Item.field_77736_bl, 10);
            this.uncommon.add(Item.field_77753_aV, 8);
            this.rare.add(Item.field_77813_bB, 12);
            this.rare.add(Item.field_77706_j, 12);
            this.rare.add((Item)Item.field_82801_bO, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.add(Item.field_77778_at, 2);
            this.ultrarare.add(Item.field_82798_bP, 2);
            this.ultrarare.add(Item.field_77746_aZ, 1);
            this.ultrarare.add(Item.field_77769_aE, 1);
            this.ultrarare.add(new ItemStack(TFBlocks.sapling, 1, 4));
        }
        if (i == 11) {
            this.common.add(Item.field_77669_D, 12);
            this.common.add(new ItemStack(Item.field_77705_m, 12, 1));
            this.common.add(Item.field_77704_l, 12);
            this.common.add(TFItems.experiment115, 9);
            this.common.add(new ItemStack(Block.field_72101_ab, 1, 14));
            this.common.add(Item.field_77767_aC, 6);
            this.uncommon.add(Block.field_72078_bL, 3);
            this.uncommon.add(Item.field_77703_o, 6);
            this.uncommon.add(TFItems.ironwoodIngot, 8);
            this.uncommon.add(TFBlocks.firefly, 5);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.steeleafIngot, 8);
            this.rare.add(Item.field_77702_n, 2);
        }
        if (i == 12) {
            this.useless.clear();
            this.common.add(Item.field_77703_o, 4);
            this.common.add(TFItems.experiment115, 12);
            this.common.add(Item.field_77677_M, 4);
            this.common.add(TFItems.ironwoodIngot, 4);
            this.common.add(TFBlocks.firefly, 5);
            this.common.add(Item.field_77767_aC, 12);
            this.common.add(Item.field_77751_aT, 12);
            this.uncommon.add(TFItems.steeleafIngot, 6);
            this.uncommon.add(TFItems.steeleafLegs, 1);
            this.uncommon.add(TFItems.steeleafPlate, 1);
            this.uncommon.add(TFItems.steeleafHelm, 1);
            this.uncommon.add(TFItems.steeleafBoots, 1);
            this.uncommon.add(TFItems.steeleafPick, 1);
            this.uncommon.add(TFItems.ironwoodPlate, 1);
            this.uncommon.add(TFItems.ironwoodSword, 1);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.rare.add(TFItems.charmOfLife1, 1);
            this.rare.addEnchantedBook(Enchantment.field_77330_e, 3);
            this.rare.addEnchantedBook(Enchantment.field_77337_m, 2);
            this.rare.addEnchantedBook(Enchantment.field_77349_p, 3);
        }
        if (i == 13) {
            this.useless.clear();
            this.common.add(TFItems.carminite, 3);
            this.uncommon.add(TFItems.fieryBlood, 5);
            this.rare.add(new ItemStack(TFItems.trophy, 1, 3));
        }
        if (i == 14) {
            this.common.add(Item.field_82800_bN, 2);
            this.common.add(Item.field_77685_T, 6);
            this.common.add(Item.field_82794_bL, 6);
            this.common.add(Item.field_82797_bK, 6);
            this.common.add(Item.field_77738_bf, 6);
            this.common.add(Item.field_77786_ax, 1);
            this.common.add(Item.field_77771_aG, 1);
            this.common.add(Item.field_77740_bh, 5);
            this.uncommon.add(new ItemStack(TFBlocks.firefly, 12));
            this.uncommon.add(new ItemStack(TFBlocks.sapling, 4, 0));
            this.uncommon.add(new ItemStack(TFBlocks.sapling, 4, 1));
            this.uncommon.add(new ItemStack(TFBlocks.sapling, 4, 2));
            this.uncommon.add(new ItemStack(TFBlocks.sapling, 4, 3));
            this.rare.add(Item.field_82791_bT, 12);
            this.rare.add(Item.field_77706_j, 12);
            this.rare.add(TFItems.charmOfLife1, 1);
            this.rare.add(TFItems.charmOfKeeping1, 1);
            this.ultrarare.add(new ItemStack(TFBlocks.sapling, 1, 4));
            this.ultrarare.add(new ItemStack(TFBlocks.sapling, 1, 5));
            this.ultrarare.add(new ItemStack(TFBlocks.sapling, 1, 6));
            this.ultrarare.add(new ItemStack(TFBlocks.sapling, 1, 7));
            this.ultrarare.add(new ItemStack(TFBlocks.sapling, 1, 8));
        }
        if (i == 15) {
            this.common.add(Item.field_77669_D, 12);
            this.common.add(new ItemStack(Item.field_77705_m, 12));
            this.common.add(Item.field_77704_l, 12);
            this.common.add(TFItems.mazeWafer, 9);
            this.common.add(new ItemStack(Block.field_72101_ab, 1, 11));
            this.common.add(Item.field_77703_o, 2);
            this.uncommon.add(Item.field_77788_aw, 1);
            this.uncommon.add(Item.field_77703_o, 6);
            this.uncommon.add(TFItems.ironwoodIngot, 6);
            this.uncommon.add(TFBlocks.firefly, 5);
            this.uncommon.add(TFItems.charmOfKeeping1, 1);
            this.uncommon.add(TFItems.armorShard, 3);
            this.rare.add(TFItems.knightMetal, 8);
            this.rare.addRandomEnchanted((Item)Item.field_77707_k, 20);
            this.rare.addRandomEnchanted(Item.field_77716_q, 20);
            this.rare.addRandomEnchanted(TFItems.ironwoodSword, 15);
            this.rare.addRandomEnchanted(TFItems.steeleafSword, 10);
            this.ultrarare.addEnchantedBook(Enchantment.field_77336_l, 4);
            this.ultrarare.addEnchantedBook(Enchantment.field_77338_j, 4);
            this.ultrarare.addEnchantedBook(Enchantment.field_77339_k, 4);
            this.ultrarare.addEnchantedBook(Enchantment.field_77347_r, 2);
            this.ultrarare.addEnchantedBook(Enchantment.field_77347_r, 2);
            this.ultrarare.addEnchantedBook(Enchantment.field_77332_c, 3);
            this.ultrarare.addEnchantedBook(Enchantment.field_77328_g, 3);
            this.ultrarare.addEnchantedBook(Enchantment.field_77330_e, 3);
        }
        if (i == 16) {
            this.useless.clear();
            this.common.add(Item.field_77703_o, 4);
            this.common.add(TFItems.mazeWafer, 12);
            this.common.add(Item.field_77677_M, 4);
            this.common.add(TFItems.ironwoodIngot, 4);
            this.common.add(TFBlocks.firefly, 5);
            this.common.add(Item.field_77771_aG, 1);
            this.uncommon.add(TFItems.steeleafIngot, 6);
            this.uncommon.add(TFItems.steeleafLegs, 1);
            this.uncommon.add(TFItems.steeleafPlate, 1);
            this.uncommon.add(TFItems.steeleafHelm, 1);
            this.uncommon.add(TFItems.steeleafBoots, 1);
            this.uncommon.add(TFItems.steeleafPick, 1);
            this.uncommon.add(TFItems.ironwoodPlate, 1);
            this.uncommon.add(TFItems.ironwoodSword, 1);
            this.uncommon.add(TFItems.charmOfLife1, 1);
            this.rare.add(TFItems.mazeMapFocus, 1);
            this.rare.addRandomEnchanted((Item)Item.field_77707_k, 30);
            this.rare.addRandomEnchanted(Item.field_77716_q, 30);
            this.rare.addRandomEnchanted(TFItems.ironwoodSword, 25);
            this.rare.addRandomEnchanted(TFItems.steeleafSword, 20);
            this.rare.addRandomEnchanted(Item.field_77718_z, 15);
        }
    }
    
    static {
        TFTreasure.hill1 = new TFTreasure(1);
        TFTreasure.hill2 = new TFTreasure(2);
        TFTreasure.hill3 = new TFTreasure(3);
        TFTreasure.hedgemaze = new TFTreasure(4);
        TFTreasure.labyrinth_room = new TFTreasure(5);
        TFTreasure.labyrinth_deadend = new TFTreasure(6);
        TFTreasure.tower_room = new TFTreasure(7);
        TFTreasure.tower_library = new TFTreasure(8);
        TFTreasure.basement = new TFTreasure(9);
        TFTreasure.labyrinth_vault = new TFTreasure(10);
        TFTreasure.darktower_cache = new TFTreasure(11);
        TFTreasure.darktower_key = new TFTreasure(12);
        TFTreasure.darktower_boss = new TFTreasure(13);
        TFTreasure.tree_cache = new TFTreasure(14);
        TFTreasure.stronghold_cache = new TFTreasure(15);
        TFTreasure.stronghold_room = new TFTreasure(16);
    }
}
