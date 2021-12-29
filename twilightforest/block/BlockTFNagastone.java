// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.block.state.BlockStateContainer;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import javax.annotation.Nonnull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import twilightforest.enums.NagastoneVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFNagastone extends Block implements ModelRegisterCallback
{
    public static final IProperty<NagastoneVariant> VARIANT;
    
    public BlockTFNagastone() {
        super(Material.field_151576_e);
        this.func_149711_c(1.5f);
        this.func_149752_b(10.0f);
        this.func_149672_a(SoundType.field_185851_d);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a((IProperty)BlockTFNagastone.VARIANT, (Comparable)NagastoneVariant.SOLID));
    }
    
    public void func_149666_a(final CreativeTabs creativeTabs, final NonNullList<ItemStack> stackList) {
        stackList.add((Object)new ItemStack((Block)this, 1, 0));
        stackList.add((Object)new ItemStack((Block)this, 1, 1));
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((NagastoneVariant)state.func_177229_b((IProperty)BlockTFNagastone.VARIANT)).ordinal();
    }
    
    @Nonnull
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFNagastone.VARIANT, (Comparable)NagastoneVariant.values()[meta & 0xF]);
    }
    
    @Deprecated
    public void func_189540_a(final IBlockState state, final World world, final BlockPos pos, final Block block, final BlockPos fromPos) {
        world.func_175684_a(pos, (Block)this, this.func_149738_a(world));
    }
    
    public void func_176213_c(final World world, final BlockPos pos, final IBlockState state) {
        world.func_175684_a(pos, (Block)this, this.func_149738_a(world));
    }
    
    public int func_180651_a(final IBlockState state) {
        return NagastoneVariant.isHead((NagastoneVariant)state.func_177229_b((IProperty)BlockTFNagastone.VARIANT)) ? 0 : 1;
    }
    
    @Nonnull
    @Deprecated
    public IBlockState func_180642_a(@Nonnull final World world, @Nonnull final BlockPos pos, @Nonnull final EnumFacing facing, final float hitX, final float hitY, final float hitZ, final int meta, @Nonnull final EntityLivingBase placer) {
        return (meta == 0) ? this.func_176223_P().func_177226_a((IProperty)BlockTFNagastone.VARIANT, (Comparable)NagastoneVariant.getHeadFromFacing(facing.func_176740_k().func_176722_c() ? facing : placer.func_174811_aO().func_176734_d())) : this.func_176223_P();
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState stateIn, final Random rand) {
        if (NagastoneVariant.isHead((NagastoneVariant)stateIn.func_177229_b((IProperty)BlockTFNagastone.VARIANT))) {
            return;
        }
        int connectionCount = 0;
        final EnumFacing[] facings = new EnumFacing[2];
        for (final EnumFacing side : EnumFacing.field_82609_l) {
            if (world.func_180495_p(pos.func_177972_a(side)).func_177230_c() == TFBlocks.naga_stone) {
                if (++connectionCount > 2) {
                    break;
                }
                facings[connectionCount - 1] = side;
            }
        }
        IBlockState stateOut = null;
        switch (connectionCount) {
            case 1: {
                facings[1] = facings[0];
            }
            case 2: {
                stateOut = stateIn.func_177226_a((IProperty)BlockTFNagastone.VARIANT, (Comparable)NagastoneVariant.getVariantFromDoubleFacing(facings[0], facings[1]));
                break;
            }
            default: {
                stateOut = this.func_176223_P();
                break;
            }
        }
        if (stateIn != stateOut) {
            world.func_175656_a(pos, stateOut);
        }
    }
    
    @Nonnull
    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFNagastone.VARIANT });
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToState(this, 0, this.func_176223_P().func_177226_a((IProperty)BlockTFNagastone.VARIANT, (Comparable)NagastoneVariant.EAST_HEAD));
        ModelUtils.registerToState(this, 1, this.func_176223_P().func_177226_a((IProperty)BlockTFNagastone.VARIANT, (Comparable)NagastoneVariant.AXIS_X));
    }
    
    public IBlockState func_185499_a(final IBlockState state, final Rotation rotation) {
        return state.func_177226_a((IProperty)BlockTFNagastone.VARIANT, (Comparable)NagastoneVariant.rotate((NagastoneVariant)state.func_177229_b((IProperty)BlockTFNagastone.VARIANT), rotation));
    }
    
    public IBlockState func_185471_a(final IBlockState state, final Mirror mirror) {
        return state.func_177226_a((IProperty)BlockTFNagastone.VARIANT, (Comparable)NagastoneVariant.mirror((NagastoneVariant)state.func_177229_b((IProperty)BlockTFNagastone.VARIANT), mirror));
    }
    
    protected boolean func_149700_E() {
        return false;
    }
    
    public boolean canSilkHarvest(final World world, final BlockPos pos, final IBlockState state, final EntityPlayer player) {
        return false;
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)NagastoneVariant.class);
    }
}
