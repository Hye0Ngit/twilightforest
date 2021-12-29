// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.EnumSet;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import twilightforest.tileentity.TileEntityTFFlameJet;
import twilightforest.tileentity.TileEntityTFPoppingJet;
import twilightforest.tileentity.TileEntityTFSmoker;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import java.util.Set;
import twilightforest.enums.FireJetVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFFireJet extends Block implements ModelRegisterCallback
{
    public static final IProperty<FireJetVariant> VARIANT;
    private static final Set<FireJetVariant> ENCASED;
    
    protected BlockTFFireJet() {
        super(Material.field_151576_e);
        this.func_149711_c(1.5f);
        this.func_149672_a(SoundType.field_185848_a);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.func_149675_a(true);
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFFireJet.VARIANT });
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        final FireJetVariant[] values = FireJetVariant.values();
        final FireJetVariant variant = values[meta % values.length];
        return this.func_176223_P().func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)variant);
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((FireJetVariant)state.func_177229_b((IProperty)BlockTFFireJet.VARIANT)).ordinal();
    }
    
    public int func_180651_a(IBlockState state) {
        switch ((FireJetVariant)state.func_177229_b((IProperty)BlockTFFireJet.VARIANT)) {
            case ENCASED_SMOKER_ON: {
                state = state.func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)FireJetVariant.ENCASED_SMOKER_OFF);
                break;
            }
            case ENCASED_JET_POPPING: {
                state = state.func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)FireJetVariant.ENCASED_JET_IDLE);
                break;
            }
            case ENCASED_JET_FLAME: {
                state = state.func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)FireJetVariant.ENCASED_JET_IDLE);
                break;
            }
            case JET_POPPING: {
                state = state.func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)FireJetVariant.JET_IDLE);
                break;
            }
            case JET_FLAME: {
                state = state.func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)FireJetVariant.JET_IDLE);
                break;
            }
        }
        return this.func_176201_c(state);
    }
    
    public Material func_149688_o(final IBlockState state) {
        return BlockTFFireJet.ENCASED.contains(state.func_177229_b((IProperty)BlockTFFireJet.VARIANT)) ? Material.field_151575_d : Material.field_151576_e;
    }
    
    public MapColor func_180659_g(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return BlockTFFireJet.ENCASED.contains(state.func_177229_b((IProperty)BlockTFFireJet.VARIANT)) ? MapColor.field_151658_d : MapColor.field_151661_c;
    }
    
    public int func_149750_m(final IBlockState state) {
        switch ((FireJetVariant)state.func_177229_b((IProperty)BlockTFFireJet.VARIANT)) {
            case ENCASED_JET_FLAME:
            case JET_FLAME: {
                return 15;
            }
            default: {
                return 0;
            }
        }
    }
    
    @Nullable
    public PathNodeType getAiPathNodeType(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        switch ((FireJetVariant)state.func_177229_b((IProperty)BlockTFFireJet.VARIANT)) {
            case ENCASED_JET_POPPING:
            case JET_POPPING: {
                return PathNodeType.DANGER_FIRE;
            }
            case ENCASED_JET_FLAME:
            case JET_FLAME: {
                return PathNodeType.DAMAGE_FIRE;
            }
            default: {
                return null;
            }
        }
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random random) {
        if (!world.field_72995_K && state.func_177229_b((IProperty)BlockTFFireJet.VARIANT) == FireJetVariant.JET_IDLE) {
            final BlockPos lavaPos = this.findLavaAround(world, pos.func_177977_b());
            if (this.isLava(world, lavaPos)) {
                world.func_175656_a(lavaPos, Blocks.field_150350_a.func_176223_P());
                world.func_180501_a(pos, state.func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)FireJetVariant.JET_POPPING), 2);
            }
        }
    }
    
    @Deprecated
    public void func_189540_a(final IBlockState state, final World world, final BlockPos pos, final Block myBlockID, final BlockPos fromPos) {
        if (world.field_72995_K) {
            return;
        }
        final FireJetVariant variant = (FireJetVariant)state.func_177229_b((IProperty)BlockTFFireJet.VARIANT);
        final boolean powered = world.func_175640_z(pos);
        if (variant == FireJetVariant.ENCASED_SMOKER_OFF && powered) {
            world.func_180501_a(pos, state.func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)FireJetVariant.ENCASED_SMOKER_ON), 3);
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187750_dc, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
        if (variant == FireJetVariant.ENCASED_SMOKER_ON && !powered) {
            world.func_180501_a(pos, state.func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)FireJetVariant.ENCASED_SMOKER_OFF), 3);
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187750_dc, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
        if (variant == FireJetVariant.ENCASED_JET_IDLE && powered) {
            world.func_180501_a(pos, state.func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)FireJetVariant.ENCASED_JET_POPPING), 3);
            world.func_184133_a((EntityPlayer)null, pos, SoundEvents.field_187750_dc, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
    }
    
    private BlockPos findLavaAround(final World world, final BlockPos pos) {
        if (this.isLava(world, pos)) {
            return pos;
        }
        for (int i = 0; i < 3; ++i) {
            final BlockPos randPos = pos.func_177982_a(world.field_73012_v.nextInt(3) - 1, 0, world.field_73012_v.nextInt(3) - 1);
            if (this.isLava(world, randPos)) {
                return randPos;
            }
        }
        return pos;
    }
    
    private boolean isLava(final World world, final BlockPos pos) {
        final IBlockState state = world.func_180495_p(pos);
        final Block b = state.func_177230_c();
        final IProperty<Integer> levelProp = (b instanceof BlockLiquid || b instanceof BlockFluidBase) ? BlockLiquid.field_176367_b : null;
        return state.func_185904_a() == Material.field_151587_i && (levelProp == null || (int)state.func_177229_b((IProperty)levelProp) == 0);
    }
    
    public boolean hasTileEntity(final IBlockState state) {
        switch ((FireJetVariant)state.func_177229_b((IProperty)BlockTFFireJet.VARIANT)) {
            case ENCASED_SMOKER_ON:
            case ENCASED_JET_POPPING:
            case ENCASED_JET_FLAME:
            case JET_POPPING:
            case JET_FLAME:
            case SMOKER: {
                return true;
            }
            default: {
                return false;
            }
        }
    }
    
    @Nullable
    public TileEntity createTileEntity(final World world, final IBlockState state) {
        switch ((FireJetVariant)state.func_177229_b((IProperty)BlockTFFireJet.VARIANT)) {
            case ENCASED_SMOKER_ON:
            case SMOKER: {
                return new TileEntityTFSmoker();
            }
            case JET_POPPING: {
                return new TileEntityTFPoppingJet(FireJetVariant.JET_FLAME);
            }
            case JET_FLAME: {
                return new TileEntityTFFlameJet(FireJetVariant.JET_IDLE);
            }
            case ENCASED_JET_POPPING: {
                return new TileEntityTFPoppingJet(FireJetVariant.ENCASED_JET_FLAME);
            }
            case ENCASED_JET_FLAME: {
                return new TileEntityTFFlameJet(FireJetVariant.ENCASED_JET_IDLE);
            }
            default: {
                return null;
            }
        }
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        list.add((Object)new ItemStack((Block)this, 1, FireJetVariant.SMOKER.ordinal()));
        list.add((Object)new ItemStack((Block)this, 1, FireJetVariant.JET_IDLE.ordinal()));
        list.add((Object)new ItemStack((Block)this, 1, FireJetVariant.ENCASED_SMOKER_OFF.ordinal()));
        list.add((Object)new ItemStack((Block)this, 1, FireJetVariant.ENCASED_JET_IDLE.ordinal()));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final FireJetVariant[] array;
        final FireJetVariant[] variants = array = new FireJetVariant[] { FireJetVariant.SMOKER, FireJetVariant.JET_IDLE, FireJetVariant.ENCASED_SMOKER_OFF, FireJetVariant.ENCASED_JET_IDLE };
        for (final FireJetVariant variant : array) {
            ModelUtils.registerToState(this, variant.ordinal(), this.func_176223_P().func_177226_a((IProperty)BlockTFFireJet.VARIANT, (Comparable)variant));
        }
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)FireJetVariant.class);
        ENCASED = EnumSet.of(FireJetVariant.ENCASED_JET_IDLE, FireJetVariant.ENCASED_JET_FLAME, FireJetVariant.ENCASED_SMOKER_OFF, FireJetVariant.ENCASED_SMOKER_ON, FireJetVariant.ENCASED_JET_POPPING);
    }
}
