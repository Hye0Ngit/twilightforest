// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import java.util.function.Supplier;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Blocks;
import java.util.Iterator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.block.Block;
import net.minecraft.state.Property;
import net.minecraft.block.DispenserBlock;
import net.minecraft.util.Direction;
import net.minecraft.item.ItemStack;
import net.minecraft.dispenser.IBlockSource;
import java.util.ArrayList;
import java.util.function.UnaryOperator;
import net.minecraft.block.BlockState;
import java.util.function.Predicate;
import org.apache.commons.lang3.tuple.Pair;
import java.util.List;
import net.minecraft.dispenser.DefaultDispenseItemBehavior;

public class CrumbleDispenseBehavior extends DefaultDispenseItemBehavior
{
    boolean fired;
    private final List<Pair<Predicate<BlockState>, UnaryOperator<BlockState>>> crumbleTransforms;
    private final List<Predicate<BlockState>> harvestedStates;
    
    public CrumbleDispenseBehavior() {
        this.fired = false;
        this.crumbleTransforms = new ArrayList<Pair<Predicate<BlockState>, UnaryOperator<BlockState>>>();
        this.harvestedStates = new ArrayList<Predicate<BlockState>>();
    }
    
    protected ItemStack func_82487_b(final IBlockSource source, final ItemStack stack) {
        this.addCrumbleTransforms();
        boolean crumbled = false;
        boolean harvested = false;
        final World world = (World)source.func_197524_h();
        final BlockPos blockpos = source.func_180699_d().func_177972_a((Direction)source.func_189992_e().func_177229_b((Property)DispenserBlock.field_176441_a));
        final BlockState blockstate = world.func_180495_p(blockpos);
        if (!world.field_72995_K && stack.func_77958_k() != stack.func_77952_i() + 1) {
            for (final Pair<Predicate<BlockState>, UnaryOperator<BlockState>> transform : this.crumbleTransforms) {
                if (((Predicate)transform.getLeft()).test(blockstate)) {
                    world.func_180501_a(blockpos, (BlockState)((UnaryOperator)transform.getRight()).apply(blockstate), 3);
                    crumbled = true;
                }
            }
            if (crumbled) {
                world.func_217379_c(2001, blockpos, Block.func_196246_j(blockstate));
                if (stack.func_96631_a(1, world.field_73012_v, (ServerPlayerEntity)null)) {
                    stack.func_190920_e(0);
                }
                this.fired = true;
            }
            for (final Predicate<BlockState> predicate : this.harvestedStates) {
                if (predicate.test(blockstate)) {
                    world.func_175655_b(blockpos, true);
                    harvested = true;
                }
            }
            if (harvested) {
                if (stack.func_96631_a(1, world.field_73012_v, (ServerPlayerEntity)null)) {
                    stack.func_190920_e(0);
                }
                this.fired = true;
            }
            return stack;
        }
        return stack;
    }
    
    protected void func_82485_a(final IBlockSource source) {
        if (this.fired) {
            super.func_82485_a(source);
            this.fired = false;
        }
        else {
            source.func_197524_h().func_217379_c(1001, source.func_180699_d(), 0);
        }
    }
    
    private void addCrumbleTransforms() {
        this.addCrumble(() -> Blocks.field_196696_di, Blocks.field_196700_dk::func_176223_P);
        this.addCrumble(() -> Blocks.field_235411_nu_, Blocks.field_235412_nv_::func_176223_P);
        this.addCrumble(() -> Blocks.field_235412_nv_, Blocks.field_235406_np_::func_176223_P);
        this.addCrumble(() -> Blocks.field_196653_dH, Blocks.field_235394_nH_::func_176223_P);
        this.addCrumble((Supplier<Block>)TFBlocks.maze_stone_brick, () -> ((Block)TFBlocks.maze_stone_cracked.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.underbrick, () -> ((Block)TFBlocks.underbrick_cracked.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.tower_wood, () -> ((Block)TFBlocks.tower_wood_cracked.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.deadrock, () -> ((Block)TFBlocks.deadrock_cracked.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.castle_brick, () -> ((Block)TFBlocks.castle_brick_cracked.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.nagastone_pillar, () -> ((Block)TFBlocks.nagastone_pillar_weathered.get()).func_176223_P());
        this.addCrumble((Supplier<Block>)TFBlocks.etched_nagastone, () -> ((Block)TFBlocks.etched_nagastone_weathered.get()).func_176223_P());
        this.addCrumble(() -> Blocks.field_150348_b, Blocks.field_150347_e::func_176223_P);
        this.addCrumble(() -> Blocks.field_150347_e, Blocks.field_150351_n::func_176223_P);
        this.addCrumble(() -> Blocks.field_150322_A, Blocks.field_150354_m::func_176223_P);
        this.addCrumble(() -> Blocks.field_180395_cM, Blocks.field_196611_F::func_176223_P);
        this.addCrumble(() -> Blocks.field_196658_i, Blocks.field_150346_d::func_176223_P);
        this.addCrumble(() -> Blocks.field_150391_bh, Blocks.field_150346_d::func_176223_P);
        this.addCrumble(() -> Blocks.field_196661_l, Blocks.field_150346_d::func_176223_P);
        this.addCrumble(() -> Blocks.field_196660_k, Blocks.field_150346_d::func_176223_P);
        this.addCrumble(() -> Blocks.field_235381_mu_, Blocks.field_150424_aL::func_176223_P);
        this.addCrumble(() -> Blocks.field_235372_ml_, Blocks.field_150424_aL::func_176223_P);
        this.addCrumble(() -> Blocks.field_150371_ca, Blocks.field_150354_m::func_176223_P);
        this.addHarvest(() -> Blocks.field_150351_n);
        this.addHarvest(() -> Blocks.field_150346_d);
        this.addHarvest(() -> Blocks.field_150354_m);
        this.addHarvest(() -> Blocks.field_196611_F);
        this.addHarvest(() -> Blocks.field_150435_aG);
        this.addHarvest(() -> Blocks.field_196656_g);
        this.addHarvest(() -> Blocks.field_196650_c);
        this.addHarvest(() -> Blocks.field_196654_e);
    }
    
    private void addCrumble(final Supplier<Block> block, final Supplier<BlockState> result) {
        this.addCrumble(state -> state.func_177230_c() == block.get(), state -> result.get());
    }
    
    private void addCrumble(final Predicate<BlockState> test, final UnaryOperator<BlockState> transform) {
        this.crumbleTransforms.add((Pair<Predicate<BlockState>, UnaryOperator<BlockState>>)Pair.of((Object)test, (Object)transform));
    }
    
    private void addHarvest(final Supplier<Block> block) {
        this.addHarvest(state -> state.func_177230_c() == block.get());
    }
    
    private void addHarvest(final Predicate<BlockState> test) {
        this.harvestedStates.add(test);
    }
}
