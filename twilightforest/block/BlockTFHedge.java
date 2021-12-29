// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import twilightforest.client.ModelUtils;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.NonNullList;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySpider;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.math.RayTraceResult;
import twilightforest.util.EntityUtil;
import java.util.Random;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathNodeType;
import javax.annotation.Nullable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import twilightforest.enums.HedgeVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraft.block.Block;

public class BlockTFHedge extends Block implements ModelRegisterCallback
{
    public static final IProperty<HedgeVariant> VARIANT;
    private static final AxisAlignedBB HEDGE_BB;
    private final int damageDone;
    
    protected BlockTFHedge() {
        super(Material.field_151570_A);
        this.damageDone = 3;
        this.func_149672_a(SoundType.field_185850_c);
        this.func_149711_c(2.0f);
        this.func_149752_b(10.0f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Deprecated
    public boolean func_176225_a(final IBlockState blockState, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side) {
        return blockAccess.func_180495_p(pos.func_177972_a(side)).func_177230_c() != this && super.func_176225_a(blockState, blockAccess, pos, side);
    }
    
    @Deprecated
    public AxisAlignedBB func_180646_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        if (state.func_177229_b((IProperty)BlockTFHedge.VARIANT) == HedgeVariant.HEDGE) {
            return BlockTFHedge.HEDGE_BB;
        }
        return BlockTFHedge.field_185505_j;
    }
    
    @Deprecated
    public boolean func_149662_c(final IBlockState state) {
        return true;
    }
    
    public int func_180651_a(final IBlockState state) {
        if (state.func_177229_b((IProperty)BlockTFHedge.VARIANT) == HedgeVariant.DARKWOOD_LEAVES) {
            return 3;
        }
        return this.func_176201_c(state);
    }
    
    @Nullable
    public PathNodeType getAiPathNodeType(final IBlockState state, final IBlockAccess world, final BlockPos pos, @Nullable final EntityLiving entity) {
        return (entity != null && state.func_177229_b((IProperty)BlockTFHedge.VARIANT) == HedgeVariant.HEDGE && this.shouldDamage((Entity)entity)) ? PathNodeType.DAMAGE_CACTUS : null;
    }
    
    public void func_180634_a(final World world, final BlockPos pos, final IBlockState state, final Entity entity) {
        if (state.func_177229_b((IProperty)BlockTFHedge.VARIANT) == HedgeVariant.HEDGE && this.shouldDamage(entity)) {
            entity.func_70097_a(DamageSource.field_76367_g, (float)this.damageDone);
        }
    }
    
    public void func_176199_a(final World world, final BlockPos pos, final Entity entity) {
        if (world.func_180495_p(pos).func_177229_b((IProperty)BlockTFHedge.VARIANT) == HedgeVariant.HEDGE && this.shouldDamage(entity)) {
            entity.func_70097_a(DamageSource.field_76367_g, (float)this.damageDone);
        }
    }
    
    public void func_180649_a(final World world, final BlockPos pos, final EntityPlayer player) {
        if (!world.field_72995_K && world.func_180495_p(pos).func_177229_b((IProperty)BlockTFHedge.VARIANT) == HedgeVariant.HEDGE) {
            world.func_175684_a(pos, (Block)this, 10);
        }
    }
    
    public void func_180657_a(final World world, final EntityPlayer player, final BlockPos pos, final IBlockState state, @Nullable final TileEntity te, final ItemStack stack) {
        super.func_180657_a(world, player, pos, state, te, stack);
        if (state.func_177229_b((IProperty)BlockTFHedge.VARIANT) == HedgeVariant.HEDGE) {
            player.func_70097_a(DamageSource.field_76367_g, (float)this.damageDone);
        }
    }
    
    public void func_180650_b(final World world, final BlockPos pos, final IBlockState state, final Random random) {
        final List<EntityPlayer> nearbyPlayers = world.func_72872_a((Class)EntityPlayer.class, new AxisAlignedBB(pos).func_186662_g(8.0));
        for (final EntityPlayer player : nearbyPlayers) {
            if (player.field_82175_bq) {
                final RayTraceResult ray = EntityUtil.rayTrace(player);
                if (ray == null || ray.field_72313_a != RayTraceResult.Type.BLOCK || !pos.equals((Object)ray.func_178782_a())) {
                    continue;
                }
                player.func_70097_a(DamageSource.field_76367_g, (float)this.damageDone);
                world.func_175684_a(pos, (Block)this, 10);
            }
        }
    }
    
    private boolean shouldDamage(final Entity entity) {
        return !(entity instanceof EntitySpider) && !(entity instanceof EntityItem) && !entity.func_145773_az();
    }
    
    public int getFlammability(final IBlockAccess world, final BlockPos pos, final EnumFacing side) {
        final IBlockState state = world.func_180495_p(pos);
        return (state.func_177229_b((IProperty)BlockTFHedge.VARIANT) == HedgeVariant.DARKWOOD_LEAVES) ? 1 : 0;
    }
    
    public int getFireSpreadSpeed(final IBlockAccess world, final BlockPos pos, final EnumFacing side) {
        return 0;
    }
    
    public int func_149745_a(final Random random) {
        return (random.nextInt(40) == 0) ? 1 : 0;
    }
    
    public Item func_180660_a(final IBlockState state, final Random random, final int fortune) {
        if (state.func_177229_b((IProperty)BlockTFHedge.VARIANT) == HedgeVariant.DARKWOOD_LEAVES) {
            return Item.func_150898_a((Block)TFBlocks.twilight_sapling);
        }
        return Items.field_190931_a;
    }
    
    public ItemStack func_185473_a(final World world, final BlockPos pos, final IBlockState state) {
        return new ItemStack((Block)this, 1, this.func_176201_c(state));
    }
    
    public void getDrops(final NonNullList<ItemStack> drops, final IBlockAccess world, final BlockPos pos, final IBlockState state, final int fortune) {
        if (state.func_177229_b((IProperty)BlockTFHedge.VARIANT) == HedgeVariant.DARKWOOD_LEAVES) {
            final Random rand = (world instanceof World) ? ((World)world).field_73012_v : BlockTFHedge.RANDOM;
            if (rand.nextInt(40) == 0) {
                final Item item = this.func_180660_a(state, rand, fortune);
                drops.add((Object)new ItemStack(item, 1, this.func_180651_a(state)));
            }
        }
    }
    
    protected BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFHedge.VARIANT });
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        return this.func_176223_P().func_177226_a((IProperty)BlockTFHedge.VARIANT, (Comparable)HedgeVariant.values()[meta % HedgeVariant.values().length]);
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((HedgeVariant)state.func_177229_b((IProperty)BlockTFHedge.VARIANT)).ordinal();
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelUtils.registerToStateSingleVariant(this, BlockTFHedge.VARIANT);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)HedgeVariant.class);
        HEDGE_BB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.9375, 1.0);
    }
}
