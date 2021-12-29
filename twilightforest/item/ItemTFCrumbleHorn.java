// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.advancements.TFAdvancements;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.world.IBlockAccess;
import java.util.Iterator;
import net.minecraft.util.math.BlockPos;
import twilightforest.util.WorldUtil;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumActionResult;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import java.util.function.Supplier;
import net.minecraft.block.BlockSand;
import twilightforest.enums.TowerWoodVariant;
import twilightforest.block.BlockTFTowerWood;
import twilightforest.enums.UnderBrickVariant;
import twilightforest.block.BlockTFUnderBrick;
import twilightforest.enums.MazestoneVariant;
import twilightforest.block.BlockTFMazestone;
import twilightforest.block.TFBlocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import java.util.ArrayList;
import net.minecraft.item.EnumRarity;
import java.util.function.UnaryOperator;
import net.minecraft.block.state.IBlockState;
import java.util.function.Predicate;
import org.apache.commons.lang3.tuple.Pair;
import java.util.List;

public class ItemTFCrumbleHorn extends ItemTF
{
    private static final int CHANCE_HARVEST = 20;
    private static final int CHANCE_CRUMBLE = 5;
    private final List<Pair<Predicate<IBlockState>, UnaryOperator<IBlockState>>> crumbleTransforms;
    private final List<Predicate<IBlockState>> harvestedStates;
    
    ItemTFCrumbleHorn(final EnumRarity rarity) {
        super(rarity);
        this.crumbleTransforms = new ArrayList<Pair<Predicate<IBlockState>, UnaryOperator<IBlockState>>>();
        this.harvestedStates = new ArrayList<Predicate<IBlockState>>();
        this.field_77777_bU = 1;
        this.func_77656_e(1024);
        this.addCrumbleTransforms();
    }
    
    private void addCrumbleTransforms() {
        this.addCrumble(() -> Blocks.field_150348_b, () -> Blocks.field_150347_e.func_176223_P());
        this.addCrumble(state -> state.func_177230_c() == Blocks.field_150417_aV && state.func_177229_b((IProperty)BlockStoneBrick.field_176249_a) == BlockStoneBrick.EnumType.DEFAULT, state -> state.func_177226_a((IProperty)BlockStoneBrick.field_176249_a, (Comparable)BlockStoneBrick.EnumType.CRACKED));
        this.addCrumble(state -> state.func_177230_c() == TFBlocks.maze_stone && state.func_177229_b((IProperty)BlockTFMazestone.VARIANT) == MazestoneVariant.BRICK, state -> state.func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.CRACKED));
        this.addCrumble(state -> state.func_177230_c() == TFBlocks.underbrick && state.func_177229_b((IProperty)BlockTFUnderBrick.VARIANT) == UnderBrickVariant.NORMAL, state -> state.func_177226_a((IProperty)BlockTFUnderBrick.VARIANT, (Comparable)UnderBrickVariant.CRACKED));
        this.addCrumble(state -> state.func_177230_c() == TFBlocks.tower_wood && state.func_177229_b((IProperty)BlockTFTowerWood.VARIANT) == TowerWoodVariant.PLAIN, state -> state.func_177226_a((IProperty)BlockTFTowerWood.VARIANT, (Comparable)TowerWoodVariant.CRACKED));
        this.addCrumble(() -> Blocks.field_150347_e, () -> Blocks.field_150351_n.func_176223_P());
        this.addCrumble(() -> Blocks.field_150322_A, () -> Blocks.field_150354_m.func_176223_P());
        this.addCrumble(() -> Blocks.field_180395_cM, () -> Blocks.field_150354_m.func_176223_P().func_177226_a((IProperty)BlockSand.field_176504_a, (Comparable)BlockSand.EnumType.RED_SAND));
        this.addCrumble(() -> Blocks.field_150349_c, () -> Blocks.field_150346_d.func_176223_P());
        this.addCrumble(() -> Blocks.field_150391_bh, () -> Blocks.field_150346_d.func_176223_P());
        this.addHarvest(() -> Blocks.field_150351_n);
        this.addHarvest(() -> Blocks.field_150346_d);
        this.addHarvest(() -> Blocks.field_150354_m);
        this.addHarvest(() -> Blocks.field_150435_aG);
    }
    
    private void addCrumble(final Supplier<Block> block, final Supplier<IBlockState> result) {
        this.addCrumble(state -> state.func_177230_c() == block.get(), state -> result.get());
    }
    
    private void addCrumble(final Predicate<IBlockState> test, final UnaryOperator<IBlockState> transform) {
        this.crumbleTransforms.add((Pair<Predicate<IBlockState>, UnaryOperator<IBlockState>>)Pair.of((Object)test, (Object)transform));
    }
    
    private void addHarvest(final Supplier<Block> block) {
        this.addHarvest(state -> state.func_177230_c() == block.get());
    }
    
    private void addHarvest(final Predicate<IBlockState> test) {
        this.harvestedStates.add(test);
    }
    
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, final EnumHand hand) {
        player.func_184598_c(hand);
        player.func_184185_a(SoundEvents.field_187757_eG, 1.0f, 0.8f);
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    public void onUsingTick(final ItemStack stack, final EntityLivingBase living, final int count) {
        if (count > 10 && count % 5 == 0 && !living.field_70170_p.field_72995_K) {
            final int crumbled = this.doCrumble(stack, living.field_70170_p, living);
            if (crumbled > 0) {
                stack.func_77972_a(crumbled, living);
            }
            living.field_70170_p.func_184148_a((EntityPlayer)null, living.field_70165_t, living.field_70163_u, living.field_70161_v, SoundEvents.field_187757_eG, living.func_184176_by(), 1.0f, 0.8f);
        }
    }
    
    public EnumAction func_77661_b(final ItemStack stack) {
        return EnumAction.BOW;
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
    
    public boolean canContinueUsing(final ItemStack oldStack, final ItemStack newStack) {
        return oldStack.func_77973_b() == newStack.func_77973_b();
    }
    
    public boolean shouldCauseReequipAnimation(final ItemStack oldStack, final ItemStack newStack, final boolean slotChanged) {
        return slotChanged || newStack.func_77973_b() != oldStack.func_77973_b();
    }
    
    private int doCrumble(final ItemStack stack, final World world, final EntityLivingBase living) {
        final double range = 3.0;
        final double radius = 2.0;
        final Vec3d srcVec = new Vec3d(living.field_70165_t, living.field_70163_u + living.func_70047_e(), living.field_70161_v);
        final Vec3d lookVec = living.func_70040_Z().func_186678_a(3.0);
        final Vec3d destVec = srcVec.func_178787_e(lookVec);
        final AxisAlignedBB crumbleBox = new AxisAlignedBB(destVec.field_72450_a - 2.0, destVec.field_72448_b - 2.0, destVec.field_72449_c - 2.0, destVec.field_72450_a + 2.0, destVec.field_72448_b + 2.0, destVec.field_72449_c + 2.0);
        return this.crumbleBlocksInAABB(stack, world, living, crumbleBox);
    }
    
    private int crumbleBlocksInAABB(final ItemStack stack, final World world, final EntityLivingBase living, final AxisAlignedBB box) {
        int crumbled = 0;
        for (final BlockPos pos : WorldUtil.getAllInBB(box)) {
            if (this.crumbleBlock(stack, world, living, pos)) {
                ++crumbled;
            }
        }
        return crumbled;
    }
    
    private boolean crumbleBlock(final ItemStack stack, final World world, final EntityLivingBase living, final BlockPos pos) {
        final IBlockState state = world.func_180495_p(pos);
        final Block block = state.func_177230_c();
        if (block.isAir(state, (IBlockAccess)world, pos)) {
            return false;
        }
        for (final Pair<Predicate<IBlockState>, UnaryOperator<IBlockState>> transform : this.crumbleTransforms) {
            if (((Predicate)transform.getLeft()).test(state) && world.field_73012_v.nextInt(5) == 0) {
                world.func_180501_a(pos, (IBlockState)((UnaryOperator)transform.getRight()).apply(state), 3);
                world.func_175718_b(2001, pos, Block.func_176210_f(state));
                this.postTrigger(living, stack, world, pos);
                return true;
            }
        }
        for (final Predicate<IBlockState> predicate : this.harvestedStates) {
            if (predicate.test(state) && world.field_73012_v.nextInt(20) == 0) {
                if (living instanceof EntityPlayer) {
                    if (block.canHarvestBlock((IBlockAccess)world, pos, (EntityPlayer)living)) {
                        world.func_175698_g(pos);
                        block.func_180657_a(world, (EntityPlayer)living, pos, state, world.func_175625_s(pos), ItemStack.field_190927_a);
                        world.func_175718_b(2001, pos, Block.func_176210_f(state));
                        this.postTrigger(living, stack, world, pos);
                        return true;
                    }
                    continue;
                }
                else {
                    if (ForgeEventFactory.getMobGriefingEvent(world, (Entity)living)) {
                        world.func_175655_b(pos, true);
                        this.postTrigger(living, stack, world, pos);
                        return true;
                    }
                    continue;
                }
            }
        }
        return false;
    }
    
    private void postTrigger(final EntityLivingBase living, final ItemStack stack, final World world, final BlockPos pos) {
        if (living instanceof EntityPlayerMP) {
            TFAdvancements.ITEM_USE_TRIGGER.trigger((EntityPlayerMP)living, stack, world, pos);
        }
    }
}
