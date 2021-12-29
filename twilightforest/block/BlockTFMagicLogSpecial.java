// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.NonNullList;
import net.minecraft.inventory.InventoryLargeChest;
import java.util.Iterator;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.block.BlockChest;
import net.minecraft.inventory.IInventory;
import java.util.ArrayList;
import twilightforest.item.ItemTFOreMagnet;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import twilightforest.network.TFPacketHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import twilightforest.network.PacketChangeBiome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.Vec3i;
import twilightforest.biomes.TFBiomes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.init.Blocks;
import twilightforest.util.WorldUtil;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MagicWoodVariant;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;

public class BlockTFMagicLogSpecial extends BlockTFMagicLog
{
    protected BlockTFMagicLogSpecial() {
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_149738_a(final World world) {
        return 20;
    }
    
    public void func_176213_c(final World world, final BlockPos pos, final IBlockState state) {
        world.func_175684_a(pos, (Block)this, this.func_149738_a(world));
    }
    
    public Item func_180660_a(final IBlockState state, final Random random, final int fortune) {
        return Item.func_150898_a(TFBlocks.magic_log);
    }
    
    @Override
    public int func_180651_a(final IBlockState state) {
        return ((MagicWoodVariant)state.func_177229_b((IProperty)BlockTFMagicLogSpecial.VARIANT)).ordinal();
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random rand) {
        if (world.field_72995_K || state.func_177229_b((IProperty)BlockTFMagicLogSpecial.field_176299_a) != BlockLog.EnumAxis.NONE) {
            return;
        }
        switch ((MagicWoodVariant)state.func_177229_b((IProperty)BlockTFMagicLogSpecial.VARIANT)) {
            case TIME: {
                world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187750_dc, SoundCategory.BLOCKS, 0.1f, 0.5f);
                this.doTreeOfTimeEffect(world, pos, rand);
                break;
            }
            case TRANS: {
                world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187682_dG, SoundCategory.BLOCKS, 0.1f, rand.nextFloat() * 2.0f);
                this.doTreeOfTransformationEffect(world, pos, rand);
                break;
            }
            case MINE: {
                this.doMinersTreeEffect(world, pos, rand);
                break;
            }
            case SORT: {
                this.doSortingTreeEffect(world, pos, rand);
                break;
            }
        }
        world.func_175684_a(pos, (Block)this, this.func_149738_a(world));
    }
    
    public boolean func_180639_a(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player, final EnumHand hand, final EnumFacing side, final float hitX, final float hitY, final float hitZ) {
        if (state.func_177229_b((IProperty)BlockTFMagicLogSpecial.field_176299_a) != BlockLog.EnumAxis.NONE) {
            world.func_175656_a(pos, state.func_177226_a((IProperty)BlockTFMagicLogSpecial.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE));
            world.func_175684_a(pos, (Block)this, this.func_149738_a(world));
            return true;
        }
        if (state.func_177229_b((IProperty)BlockTFMagicLogSpecial.field_176299_a) == BlockLog.EnumAxis.NONE) {
            world.func_175656_a(pos, state.func_177226_a((IProperty)BlockTFMagicLogSpecial.field_176299_a, (Comparable)BlockLog.EnumAxis.Y));
            return true;
        }
        return false;
    }
    
    private void doTreeOfTimeEffect(final World world, final BlockPos pos, final Random rand) {
        for (int numticks = 24 * this.func_149738_a(world), i = 0; i < numticks; ++i) {
            final BlockPos dPos = WorldUtil.randomOffset(rand, pos, 16);
            final IBlockState state = world.func_180495_p(dPos);
            final Block block = state.func_177230_c();
            if (block != Blocks.field_150350_a && block.func_149653_t()) {
                block.func_180650_b(world, dPos, state, rand);
            }
            final TileEntity te = world.func_175625_s(dPos);
            if (te instanceof ITickable && !te.func_145837_r()) {
                ((ITickable)te).func_73660_a();
            }
        }
    }
    
    private void doTreeOfTransformationEffect(final World world, final BlockPos pos, final Random rand) {
        final Biome targetBiome = TFBiomes.enchantedForest;
        for (int i = 0; i < 16; ++i) {
            final BlockPos dPos = WorldUtil.randomOffset(rand, pos, 16, 0, 16);
            if (dPos.func_177951_i((Vec3i)pos) <= 256.0) {
                final Biome biomeAt = world.func_180494_b(dPos);
                if (biomeAt != targetBiome) {
                    final Chunk chunkAt = world.func_175726_f(dPos);
                    chunkAt.func_76605_m()[(dPos.func_177952_p() & 0xF) << 4 | (dPos.func_177958_n() & 0xF)] = (byte)Biome.func_185362_a(targetBiome);
                    if (world instanceof WorldServer) {
                        this.sendChangedBiome(world, dPos, targetBiome);
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private void sendChangedBiome(final World world, final BlockPos pos, final Biome biome) {
        final IMessage message = (IMessage)new PacketChangeBiome(pos, biome);
        final NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(world.field_73011_w.getDimension(), (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p(), 128.0);
        TFPacketHandler.CHANNEL.sendToAllTracking(message, targetPoint);
    }
    
    private void doMinersTreeEffect(final World world, final BlockPos pos, final Random rand) {
        final BlockPos dPos = WorldUtil.randomOffset(rand, pos, 32);
        final int moved = ItemTFOreMagnet.doMagnet(world, pos, dPos);
        if (moved > 0) {
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187534_aX, SoundCategory.BLOCKS, 0.1f, 1.0f);
        }
    }
    
    private void doSortingTreeEffect(final World world, final BlockPos pos, final Random rand) {
        final List<IInventory> chests = new ArrayList<IInventory>();
        int itemCount = 0;
        for (final BlockPos iterPos : WorldUtil.getAllAround(pos, 16)) {
            IInventory chestInventory = null;
            IInventory teInventory = null;
            final Block block = world.func_180495_p(iterPos).func_177230_c();
            if (block instanceof BlockChest) {
                chestInventory = (IInventory)((BlockChest)block).func_189418_a(world, iterPos, true);
            }
            final TileEntity te = world.func_175625_s(iterPos);
            if (te instanceof IInventory && !te.func_145837_r()) {
                teInventory = (IInventory)te;
            }
            if (chestInventory != null && teInventory != null && !this.checkIfChestsContains(chests, teInventory)) {
                boolean empty = true;
                for (int i = 0; i < chestInventory.func_70302_i_(); ++i) {
                    if (!chestInventory.func_70301_a(i).func_190926_b()) {
                        empty = false;
                        ++itemCount;
                    }
                }
                if (empty) {
                    continue;
                }
                chests.add(chestInventory);
            }
        }
        ItemStack beingSorted = ItemStack.field_190927_a;
        int sortedChestNum = -1;
        int sortedSlotNum = -1;
        if (itemCount == 0) {
            return;
        }
        final int itemNumber = rand.nextInt(itemCount);
        int currentNumber = 0;
        for (int j = 0; j < chests.size(); ++j) {
            final IInventory chest = chests.get(j);
            for (int slotNum = 0; slotNum < chest.func_70302_i_(); ++slotNum) {
                final ItemStack currentItem = chest.func_70301_a(slotNum);
                if (!currentItem.func_190926_b() && currentNumber++ == itemNumber) {
                    beingSorted = currentItem;
                    sortedChestNum = j;
                    sortedSlotNum = slotNum;
                }
            }
        }
        if (beingSorted.func_190926_b()) {
            return;
        }
        int matchChestNum = -1;
        int matchCount = 0;
        for (int chestNum = 0; chestNum < chests.size(); ++chestNum) {
            final IInventory chest2 = chests.get(chestNum);
            int currentChestMatches = 0;
            for (int slotNum2 = 0; slotNum2 < chest2.func_70302_i_(); ++slotNum2) {
                final ItemStack currentItem2 = chest2.func_70301_a(slotNum2);
                if (!currentItem2.func_190926_b() && this.isSortingMatch(beingSorted, currentItem2)) {
                    currentChestMatches += currentItem2.func_190916_E();
                }
            }
            if (currentChestMatches > matchCount) {
                matchCount = currentChestMatches;
                matchChestNum = chestNum;
            }
        }
        if (matchChestNum >= 0 && matchChestNum != sortedChestNum) {
            final IInventory moveChest = chests.get(matchChestNum);
            final IInventory oldChest = chests.get(sortedChestNum);
            final int moveSlot = this.getEmptySlotIn(moveChest);
            if (moveSlot >= 0) {
                oldChest.func_70299_a(sortedSlotNum, ItemStack.field_190927_a);
                moveChest.func_70299_a(moveSlot, beingSorted);
            }
        }
        if (beingSorted.func_190916_E() < beingSorted.func_77976_d()) {
            for (final IInventory chest2 : chests) {
                for (int slotNum3 = 0; slotNum3 < chest2.func_70302_i_(); ++slotNum3) {
                    final ItemStack currentItem3 = chest2.func_70301_a(slotNum3);
                    if (!currentItem3.func_190926_b() && currentItem3 != beingSorted && beingSorted.func_77969_a(currentItem3) && currentItem3.func_190916_E() <= beingSorted.func_77976_d() - beingSorted.func_190916_E()) {
                        chest2.func_70299_a(slotNum3, ItemStack.field_190927_a);
                        beingSorted.func_190917_f(currentItem3.func_190916_E());
                        currentItem3.func_190920_e(0);
                    }
                }
            }
        }
    }
    
    private boolean isSortingMatch(final ItemStack beingSorted, final ItemStack currentItem) {
        return beingSorted.func_77973_b().func_77640_w() == currentItem.func_77973_b().func_77640_w();
    }
    
    private boolean checkIfChestsContains(final List<IInventory> chests, final IInventory testChest) {
        for (final IInventory chest : chests) {
            if (chest == testChest) {
                return true;
            }
            if (chest instanceof InventoryLargeChest && ((InventoryLargeChest)chest).func_90010_a(testChest)) {
                return true;
            }
        }
        return false;
    }
    
    private int getEmptySlotIn(final IInventory chest) {
        for (int i = 0; i < chest.func_70302_i_(); ++i) {
            if (chest.func_70301_a(i).func_190926_b()) {
                return i;
            }
        }
        return -1;
    }
    
    @Deprecated
    public int func_149750_m(final IBlockState state) {
        return 15;
    }
    
    @Override
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, 0));
        list.add((Object)new ItemStack((Block)this, 1, 1));
        list.add((Object)new ItemStack((Block)this, 1, 2));
        list.add((Object)new ItemStack((Block)this, 1, 3));
    }
    
    @Override
    protected boolean func_149700_E() {
        return false;
    }
    
    public boolean canSilkHarvest(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player) {
        return false;
    }
}
