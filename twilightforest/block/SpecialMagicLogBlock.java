// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.inventory.DoubleSidedInventory;
import java.util.Iterator;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.block.ChestBlock;
import net.minecraft.inventory.IInventory;
import java.util.ArrayList;
import twilightforest.item.OreMagnetItem;
import net.minecraftforge.fml.network.PacketDistributor;
import twilightforest.network.TFPacketHandler;
import twilightforest.network.ChangeBiomePacket;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.RegistryKey;
import twilightforest.worldgen.biomes.BiomeKeys;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import twilightforest.util.WorldUtil;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import java.util.Random;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.state.BooleanProperty;
import twilightforest.enums.MagicWoodVariant;
import net.minecraft.block.RotatedPillarBlock;

public class SpecialMagicLogBlock extends RotatedPillarBlock
{
    private final MagicWoodVariant magicWoodVariant;
    public static final BooleanProperty ACTIVE;
    
    protected SpecialMagicLogBlock(final AbstractBlock.Properties props, final MagicWoodVariant variant) {
        super(props.func_200943_b(2.0f).func_200947_a(SoundType.field_185848_a).func_235838_a_(state -> 15));
        this.magicWoodVariant = variant;
        this.func_180632_j((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)SpecialMagicLogBlock.ACTIVE, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> container) {
        super.func_206840_a((StateContainer.Builder)container);
        container.func_206894_a(new Property[] { (Property)SpecialMagicLogBlock.ACTIVE });
    }
    
    public int tickRate() {
        return 20;
    }
    
    public void func_220082_b(final BlockState state, final World world, final BlockPos pos, final BlockState oldState, final boolean isMoving) {
        world.func_205220_G_().func_205360_a(pos, (Object)this, this.tickRate());
    }
    
    @Deprecated
    public void func_225534_a_(final BlockState state, final ServerWorld world, final BlockPos pos, final Random rand) {
        if (world.field_72995_K || !(boolean)state.func_177229_b((Property)SpecialMagicLogBlock.ACTIVE)) {
            return;
        }
        switch (this.magicWoodVariant) {
            case TIME: {
                world.func_184133_a((PlayerEntity)null, pos, TFSounds.TIME_CORE, SoundCategory.BLOCKS, 0.1f, 0.5f);
                this.doTreeOfTimeEffect((World)world, pos, rand);
                break;
            }
            case TRANS: {
                world.func_184133_a((PlayerEntity)null, pos, TFSounds.TRANSFORMATION_CORE, SoundCategory.BLOCKS, 0.1f, rand.nextFloat() * 2.0f);
                this.doTreeOfTransformationEffect((World)world, pos, rand);
                break;
            }
            case MINE: {
                this.doMinersTreeEffect((World)world, pos, rand);
                break;
            }
            case SORT: {
                this.doSortingTreeEffect((World)world, pos, rand);
                break;
            }
        }
        world.func_205220_G_().func_205360_a(pos, (Object)this, this.tickRate());
    }
    
    @Deprecated
    public ActionResultType func_225533_a_(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand handIn, final BlockRayTraceResult hit) {
        if (!(boolean)state.func_177229_b((Property)SpecialMagicLogBlock.ACTIVE)) {
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)SpecialMagicLogBlock.ACTIVE, (Comparable)true));
            world.func_205220_G_().func_205360_a(pos, (Object)this, this.tickRate());
            return ActionResultType.SUCCESS;
        }
        if (state.func_177229_b((Property)SpecialMagicLogBlock.ACTIVE)) {
            world.func_175656_a(pos, (BlockState)state.func_206870_a((Property)SpecialMagicLogBlock.ACTIVE, (Comparable)false));
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }
    
    private void doTreeOfTimeEffect(final World world, final BlockPos pos, final Random rand) {
        for (int numticks = 24 * this.tickRate(), i = 0; i < numticks; ++i) {
            final BlockPos dPos = WorldUtil.randomOffset(rand, pos, 16);
            final BlockState state = world.func_180495_p(dPos);
            if (state.func_204519_t()) {
                state.func_227034_b_((ServerWorld)world, dPos, rand);
            }
            final TileEntity te = world.func_175625_s(dPos);
            if (te instanceof ITickableTileEntity && !te.func_145837_r()) {
                ((ITickableTileEntity)te).func_73660_a();
            }
        }
    }
    
    private void doTreeOfTransformationEffect(final World world, final BlockPos pos, final Random rand) {
        final int WIDTH_BITS = (int)Math.round(Math.log(16.0) / Math.log(2.0)) - 2;
        final int HEIGHT_BITS = (int)Math.round(Math.log(256.0) / Math.log(2.0)) - 2;
        final int HORIZONTAL_MASK = (1 << WIDTH_BITS) - 1;
        final int VERTICAL_MASK = (1 << HEIGHT_BITS) - 1;
        final Biome targetBiome = (Biome)world.func_241828_r().func_243612_b(Registry.field_239720_u_).func_230516_a_((RegistryKey)BiomeKeys.ENCHANTED_FOREST);
        for (int i = 0; i < 16; ++i) {
            final BlockPos dPos = WorldUtil.randomOffset(rand, pos, 16, 0, 16);
            if (dPos.func_177951_i((Vector3i)pos) <= 256.0) {
                final Biome biomeAt = world.func_226691_t_(dPos);
                if (biomeAt != targetBiome) {
                    final Chunk chunkAt = world.func_212866_a_(dPos.func_177958_n() >> 4, dPos.func_177952_p() >> 4);
                    final int x = dPos.func_177958_n() >> 2 & HORIZONTAL_MASK;
                    final int z = dPos.func_177952_p() >> 2 & HORIZONTAL_MASK;
                    if (chunkAt.func_225549_i_().field_227054_f_[z << WIDTH_BITS | x] != targetBiome) {
                        for (int dy = 0; dy < 255; dy += 4) {
                            final int y = MathHelper.func_76125_a(dy >> 2, 0, VERTICAL_MASK);
                            chunkAt.func_225549_i_().field_227054_f_[y << WIDTH_BITS + WIDTH_BITS | z << WIDTH_BITS | x] = targetBiome;
                        }
                        if (world instanceof ServerWorld) {
                            this.sendChangedBiome(chunkAt, dPos, targetBiome);
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    private void sendChangedBiome(final Chunk chunk, final BlockPos pos, final Biome biome) {
        final ChangeBiomePacket message = new ChangeBiomePacket(pos, biome.getRegistryName());
        TFPacketHandler.CHANNEL.send(PacketDistributor.TRACKING_CHUNK.with(() -> chunk), (Object)message);
    }
    
    private void doMinersTreeEffect(final World world, final BlockPos pos, final Random rand) {
        final BlockPos dPos = WorldUtil.randomOffset(rand, pos, 32);
        final int moved = OreMagnetItem.doMagnet(world, pos, dPos);
        if (moved > 0) {
            world.func_184133_a((PlayerEntity)null, pos, TFSounds.MAGNET_GRAB, SoundCategory.BLOCKS, 0.1f, 1.0f);
        }
    }
    
    private void doSortingTreeEffect(final World world, final BlockPos pos, final Random rand) {
        final List<IInventory> chests = new ArrayList<IInventory>();
        int itemCount = 0;
        for (final BlockPos iterPos : WorldUtil.getAllAround(pos, 16)) {
            IInventory chestInventory = null;
            IInventory teInventory = null;
            final Block block = world.func_180495_p(iterPos).func_177230_c();
            if (block instanceof ChestBlock) {
                chestInventory = ChestBlock.func_226916_a_((ChestBlock)block, block.func_176223_P(), world, iterPos, true);
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
                    if (!currentItem3.func_190926_b() && currentItem3 != beingSorted && beingSorted.func_77969_a(currentItem3) && currentItem3.func_77978_p() != null && beingSorted.func_77978_p() != null && beingSorted.func_77978_p().equals((Object)currentItem3.func_77978_p()) && currentItem3.func_190916_E() <= beingSorted.func_77976_d() - beingSorted.func_190916_E()) {
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
            if (chest instanceof DoubleSidedInventory && ((DoubleSidedInventory)chest).func_90010_a(testChest)) {
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
    
    static {
        ACTIVE = BooleanProperty.func_177716_a("active");
    }
}
