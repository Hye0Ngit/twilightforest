// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.server.ServerWorld;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.item.BoneMealItem;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.Property;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.block.IGrowable;
import net.minecraft.block.Block;

public class UberousSoilBlock extends Block implements IGrowable
{
    private static final VoxelShape AABB;
    
    protected UberousSoilBlock(final AbstractBlock.Properties props) {
        super(props);
    }
    
    @Deprecated
    public VoxelShape func_220053_a(final BlockState state, final IBlockReader worldIn, final BlockPos pos, final ISelectionContext context) {
        return UberousSoilBlock.AABB;
    }
    
    public boolean canSustainPlant(final BlockState state, final IBlockReader world, final BlockPos pos, final Direction direction, final IPlantable plantable) {
        if (direction != Direction.UP) {
            return false;
        }
        final PlantType plantType = plantable.getPlantType(world, pos.func_177972_a(direction));
        return plantType == PlantType.CROP || plantType == PlantType.PLAINS || plantType == PlantType.CAVE;
    }
    
    public void func_220069_a(final BlockState state, final World world, final BlockPos pos, final Block blockIn, final BlockPos fromPos, final boolean isMoving) {
        final BlockState above = world.func_180495_p(pos.func_177984_a());
        final Material aboveMaterial = above.func_185904_a();
        if (aboveMaterial.func_76220_a()) {
            world.func_175656_a(pos, Blocks.field_150346_d.func_176223_P());
        }
        if (above.func_177230_c() instanceof IPlantable) {
            final IPlantable plant = (IPlantable)above.func_177230_c();
            if (plant.getPlantType((IBlockReader)world, pos.func_177984_a()) == PlantType.CROP) {
                world.func_175656_a(pos, (BlockState)Blocks.field_150458_ak.func_176223_P().func_206870_a((Property)FarmlandBlock.field_176531_a, (Comparable)2));
            }
            else if (plant.getPlantType((IBlockReader)world, pos.func_177984_a()) == PlantType.PLAINS) {
                world.func_175656_a(pos, Blocks.field_196658_i.func_176223_P());
            }
            else {
                world.func_175656_a(pos, Blocks.field_150346_d.func_176223_P());
            }
            BoneMealItem.func_195966_a(new ItemStack((IItemProvider)Items.field_196106_bc), world, pos.func_177984_a());
            BoneMealItem.func_195966_a(new ItemStack((IItemProvider)Items.field_196106_bc), world, pos.func_177984_a());
            BoneMealItem.func_195966_a(new ItemStack((IItemProvider)Items.field_196106_bc), world, pos.func_177984_a());
            BoneMealItem.func_195966_a(new ItemStack((IItemProvider)Items.field_196106_bc), world, pos.func_177984_a());
            world.func_217379_c(2005, pos.func_177984_a(), 0);
        }
    }
    
    public boolean func_176473_a(final IBlockReader world, final BlockPos pos, final BlockState state, final boolean isClient) {
        return true;
    }
    
    public boolean func_180670_a(final World world, final Random rand, final BlockPos pos, final BlockState state) {
        return true;
    }
    
    public void func_225535_a_(final ServerWorld world, final Random rand, BlockPos pos, final BlockState state) {
        pos = pos.func_177972_a(Direction.Plane.HORIZONTAL.func_179518_a(rand));
        final Block blockAt = world.func_180495_p(pos).func_177230_c();
        if (world.func_175623_d(pos.func_177984_a()) && (blockAt == Blocks.field_150346_d || blockAt == Blocks.field_196658_i || blockAt == Blocks.field_150458_ak)) {
            world.func_175656_a(pos, this.func_176223_P());
        }
    }
    
    static {
        AABB = VoxelShapes.func_197881_a(new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.9375, 1.0));
    }
}
