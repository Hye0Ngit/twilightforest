// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFTrollSteinn extends Block implements ModelRegisterCallback
{
    static final IProperty<Boolean> DOWN_LIT;
    static final IProperty<Boolean> UP_LIT;
    static final IProperty<Boolean> NORTH_LIT;
    static final IProperty<Boolean> SOUTH_LIT;
    static final IProperty<Boolean> WEST_LIT;
    static final IProperty<Boolean> EAST_LIT;
    private static final int LIGHT_THRESHHOLD = 7;
    
    BlockTFTrollSteinn() {
        super(Material.field_151576_e);
        this.func_149711_c(2.0f);
        this.func_149752_b(15.0f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFTrollSteinn.DOWN_LIT, (Comparable)false).func_177226_a((IProperty)BlockTFTrollSteinn.UP_LIT, (Comparable)false).func_177226_a((IProperty)BlockTFTrollSteinn.NORTH_LIT, (Comparable)false).func_177226_a((IProperty)BlockTFTrollSteinn.SOUTH_LIT, (Comparable)false).func_177226_a((IProperty)BlockTFTrollSteinn.WEST_LIT, (Comparable)false).func_177226_a((IProperty)BlockTFTrollSteinn.EAST_LIT, (Comparable)false));
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFTrollSteinn.DOWN_LIT, BlockTFTrollSteinn.UP_LIT, BlockTFTrollSteinn.NORTH_LIT, BlockTFTrollSteinn.SOUTH_LIT, BlockTFTrollSteinn.WEST_LIT, BlockTFTrollSteinn.EAST_LIT });
    }
    
    public int func_176201_c(final IBlockState state) {
        return 0;
    }
    
    @Deprecated
    public IBlockState func_176221_a(IBlockState state, final IBlockAccess world, final BlockPos pos) {
        if (!(world instanceof World)) {
            return this.func_176223_P();
        }
        for (final SideProps side : SideProps.values()) {
            state = state.func_177226_a(side.prop, (Comparable)(((World)world).func_175699_k(pos.func_177972_a(side.facing)) > 7));
        }
        return state;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_180655_c(final IBlockState state, final World world, final BlockPos pos, final Random rand) {
        if (rand.nextInt(2) == 0) {
            this.sparkle(world, pos);
        }
    }
    
    private void sparkle(final World world, final BlockPos pos) {
        final Random random = world.field_73012_v;
        final int threshhold = 7;
        for (final EnumFacing side : EnumFacing.field_82609_l) {
            double rx = pos.func_177958_n() + random.nextFloat();
            double ry = pos.func_177956_o() + random.nextFloat();
            double rz = pos.func_177952_p() + random.nextFloat();
            if (side == EnumFacing.DOWN && !world.func_180495_p(pos.func_177977_b()).func_185914_p() && world.func_175699_k(pos.func_177977_b()) <= threshhold) {
                ry = pos.func_177956_o() - 0.0625;
            }
            if (side == EnumFacing.UP && !world.func_180495_p(pos.func_177984_a()).func_185914_p() && world.func_175699_k(pos.func_177984_a()) <= threshhold) {
                ry = pos.func_177956_o() + 0.0625 + 1.0;
            }
            if (side == EnumFacing.NORTH && !world.func_180495_p(pos.func_177978_c()).func_185914_p() && world.func_175699_k(pos.func_177978_c()) <= threshhold) {
                rz = pos.func_177952_p() - 0.0625;
            }
            if (side == EnumFacing.SOUTH && !world.func_180495_p(pos.func_177968_d()).func_185914_p() && world.func_175699_k(pos.func_177968_d()) <= threshhold) {
                rz = pos.func_177952_p() + 0.0625 + 1.0;
            }
            if (side == EnumFacing.WEST && !world.func_180495_p(pos.func_177976_e()).func_185914_p() && world.func_175699_k(pos.func_177976_e()) <= threshhold) {
                rx = pos.func_177958_n() - 0.0625;
            }
            if (side == EnumFacing.EAST && !world.func_180495_p(pos.func_177974_f()).func_185914_p() && world.func_175699_k(pos.func_177974_f()) <= threshhold) {
                rx = pos.func_177958_n() + 0.0625 + 1.0;
            }
            if (rx < pos.func_177958_n() || rx > pos.func_177958_n() + 1 || ry < 0.0 || ry > pos.func_177956_o() + 1 || rz < pos.func_177952_p() || rz > pos.func_177952_p() + 1) {
                world.func_175688_a(EnumParticleTypes.REDSTONE, rx, ry, rz, 0.25, -1.0, 0.5, new int[0]);
            }
        }
    }
    
    static {
        DOWN_LIT = (IProperty)PropertyBool.func_177716_a("down");
        UP_LIT = (IProperty)PropertyBool.func_177716_a("up");
        NORTH_LIT = (IProperty)PropertyBool.func_177716_a("north");
        SOUTH_LIT = (IProperty)PropertyBool.func_177716_a("south");
        WEST_LIT = (IProperty)PropertyBool.func_177716_a("west");
        EAST_LIT = (IProperty)PropertyBool.func_177716_a("east");
    }
    
    private enum SideProps
    {
        UP(BlockTFTrollSteinn.UP_LIT, EnumFacing.UP), 
        DOWN(BlockTFTrollSteinn.DOWN_LIT, EnumFacing.DOWN), 
        NORTH(BlockTFTrollSteinn.NORTH_LIT, EnumFacing.NORTH), 
        SOUTH(BlockTFTrollSteinn.SOUTH_LIT, EnumFacing.SOUTH), 
        WEST(BlockTFTrollSteinn.WEST_LIT, EnumFacing.WEST), 
        EAST(BlockTFTrollSteinn.EAST_LIT, EnumFacing.EAST);
        
        private final IProperty<Boolean> prop;
        private final EnumFacing facing;
        
        private SideProps(final IProperty<Boolean> prop, final EnumFacing faceing) {
            this.prop = prop;
            this.facing = faceing;
        }
    }
}
