// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Random;
import net.minecraft.world.World;
import java.util.Iterator;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.state.StateContainer;
import net.minecraft.state.Property;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.Direction;
import java.util.Map;
import net.minecraft.state.BooleanProperty;
import net.minecraft.block.Block;

public class TrollsteinnBlock extends Block
{
    private static final BooleanProperty DOWN_LIT;
    private static final BooleanProperty UP_LIT;
    private static final BooleanProperty NORTH_LIT;
    private static final BooleanProperty SOUTH_LIT;
    private static final BooleanProperty WEST_LIT;
    private static final BooleanProperty EAST_LIT;
    private static final Map<Direction, BooleanProperty> PROPERTY_MAP;
    private static final int LIGHT_THRESHHOLD = 7;
    
    TrollsteinnBlock(final AbstractBlock.Properties props) {
        super(props);
        this.func_180632_j((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.field_176227_L.func_177621_b()).func_206870_a((Property)TrollsteinnBlock.DOWN_LIT, (Comparable)false)).func_206870_a((Property)TrollsteinnBlock.UP_LIT, (Comparable)false)).func_206870_a((Property)TrollsteinnBlock.NORTH_LIT, (Comparable)false)).func_206870_a((Property)TrollsteinnBlock.SOUTH_LIT, (Comparable)false)).func_206870_a((Property)TrollsteinnBlock.WEST_LIT, (Comparable)false)).func_206870_a((Property)TrollsteinnBlock.EAST_LIT, (Comparable)false));
    }
    
    protected void func_206840_a(final StateContainer.Builder<Block, BlockState> builder) {
        super.func_206840_a((StateContainer.Builder)builder);
        builder.func_206894_a(new Property[] { (Property)TrollsteinnBlock.DOWN_LIT, (Property)TrollsteinnBlock.UP_LIT, (Property)TrollsteinnBlock.NORTH_LIT, (Property)TrollsteinnBlock.SOUTH_LIT, (Property)TrollsteinnBlock.WEST_LIT, (Property)TrollsteinnBlock.EAST_LIT });
    }
    
    public BlockState func_196271_a(final BlockState state, final Direction dirToNeighbor, final BlockState neighborState, final IWorld world, final BlockPos pos, final BlockPos neighborPos) {
        final boolean lit = world.func_201696_r(neighborPos) > 7;
        return (BlockState)state.func_206870_a((Property)TrollsteinnBlock.PROPERTY_MAP.get(dirToNeighbor), (Comparable)lit);
    }
    
    public BlockState func_196258_a(final BlockItemUseContext ctx) {
        BlockState ret = this.func_176223_P();
        for (final Map.Entry<Direction, BooleanProperty> e : TrollsteinnBlock.PROPERTY_MAP.entrySet()) {
            final int light = ctx.func_195991_k().func_201696_r(ctx.func_195995_a().func_177972_a((Direction)e.getKey()));
            ret = (BlockState)ret.func_206870_a((Property)e.getValue(), (Comparable)(light > 7));
        }
        return ret;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void func_180655_c(final BlockState state, final World world, final BlockPos pos, final Random rand) {
        if (rand.nextInt(2) == 0) {
            this.sparkle(world, pos);
        }
    }
    
    private void sparkle(final World world, final BlockPos pos) {
        final Random random = world.field_73012_v;
        final int threshhold = 7;
        for (final Direction side : Direction.values()) {
            double rx = pos.func_177958_n() + random.nextFloat();
            double ry = pos.func_177956_o() + random.nextFloat();
            double rz = pos.func_177952_p() + random.nextFloat();
            if (side == Direction.DOWN && !world.func_180495_p(pos.func_177977_b()).func_200015_d((IBlockReader)world, pos) && world.func_201696_r(pos.func_177977_b()) <= threshhold) {
                ry = pos.func_177956_o() - 0.0625;
            }
            if (side == Direction.UP && !world.func_180495_p(pos.func_177984_a()).func_200015_d((IBlockReader)world, pos) && world.func_201696_r(pos.func_177984_a()) <= threshhold) {
                ry = pos.func_177956_o() + 0.0625 + 1.0;
            }
            if (side == Direction.NORTH && !world.func_180495_p(pos.func_177978_c()).func_200015_d((IBlockReader)world, pos) && world.func_201696_r(pos.func_177978_c()) <= threshhold) {
                rz = pos.func_177952_p() - 0.0625;
            }
            if (side == Direction.SOUTH && !world.func_180495_p(pos.func_177968_d()).func_200015_d((IBlockReader)world, pos) && world.func_201696_r(pos.func_177968_d()) <= threshhold) {
                rz = pos.func_177952_p() + 0.0625 + 1.0;
            }
            if (side == Direction.WEST && !world.func_180495_p(pos.func_177976_e()).func_200015_d((IBlockReader)world, pos) && world.func_201696_r(pos.func_177976_e()) <= threshhold) {
                rx = pos.func_177958_n() - 0.0625;
            }
            if (side == Direction.EAST && !world.func_180495_p(pos.func_177974_f()).func_200015_d((IBlockReader)world, pos) && world.func_201696_r(pos.func_177974_f()) <= threshhold) {
                rx = pos.func_177958_n() + 0.0625 + 1.0;
            }
            if (rx < pos.func_177958_n() || rx > pos.func_177958_n() + 1 || ry < 0.0 || ry > pos.func_177956_o() + 1 || rz < pos.func_177952_p() || rz > pos.func_177952_p() + 1) {
                world.func_195594_a((IParticleData)new RedstoneParticleData(0.0f, random.nextFloat(), 1.0f, 1.0f), rx, ry, rz, 0.25, -1.0, 0.5);
            }
        }
    }
    
    static {
        DOWN_LIT = BooleanProperty.func_177716_a("down");
        UP_LIT = BooleanProperty.func_177716_a("up");
        NORTH_LIT = BooleanProperty.func_177716_a("north");
        SOUTH_LIT = BooleanProperty.func_177716_a("south");
        WEST_LIT = BooleanProperty.func_177716_a("west");
        EAST_LIT = BooleanProperty.func_177716_a("east");
        PROPERTY_MAP = (Map)ImmutableMap.builder().put((Object)Direction.DOWN, (Object)TrollsteinnBlock.DOWN_LIT).put((Object)Direction.UP, (Object)TrollsteinnBlock.UP_LIT).put((Object)Direction.NORTH, (Object)TrollsteinnBlock.NORTH_LIT).put((Object)Direction.SOUTH, (Object)TrollsteinnBlock.SOUTH_LIT).put((Object)Direction.WEST, (Object)TrollsteinnBlock.WEST_LIT).put((Object)Direction.EAST, (Object)TrollsteinnBlock.EAST_LIT).build();
    }
}
