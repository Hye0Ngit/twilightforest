// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.particle.Particle;
import net.minecraft.init.Blocks;
import net.minecraft.client.Minecraft;
import twilightforest.client.particle.TFParticleFactory;
import twilightforest.client.particle.TFParticleType;
import net.minecraft.util.EnumParticleTypes;
import java.util.Random;
import net.minecraftforge.common.EnumPlantType;
import net.minecraft.init.Items;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.IPlantable;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import twilightforest.enums.PlantVariant;
import net.minecraft.block.properties.IProperty;
import twilightforest.client.ModelRegisterCallback;
import net.minecraftforge.common.IShearable;
import net.minecraft.block.BlockBush;

public class BlockTFPlant extends BlockBush implements IShearable, ModelRegisterCallback
{
    public static final IProperty<PlantVariant> VARIANT;
    
    protected BlockTFPlant() {
        super(Material.field_151585_k);
        this.func_149675_a(true);
        this.func_149711_c(0.0f);
        this.func_149672_a(SoundType.field_185850_c);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public BlockStateContainer func_180661_e() {
        return new BlockStateContainer((Block)this, new IProperty[] { BlockTFPlant.VARIANT });
    }
    
    @Deprecated
    public IBlockState func_176203_a(final int meta) {
        final PlantVariant variant = PlantVariant.values()[MathHelper.func_76125_a(meta, 0, PlantVariant.values().length)];
        return this.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)variant);
    }
    
    public int func_176201_c(final IBlockState state) {
        return ((PlantVariant)state.func_177229_b((IProperty)BlockTFPlant.VARIANT)).ordinal();
    }
    
    public void func_176213_c(final World world, final BlockPos pos, final IBlockState state) {
        world.func_175684_a(pos, (Block)this, world.field_73012_v.nextInt(50) + 20);
    }
    
    public boolean func_176196_c(final World world, final BlockPos pos) {
        final IBlockState state = world.func_180495_p(pos);
        return (state.func_177230_c().isAir(state, (IBlockAccess)world, pos) || state.func_185904_a().func_76222_j()) && this.func_180671_f(world, pos, state);
    }
    
    public boolean func_180671_f(final World world, final BlockPos pos, final IBlockState state) {
        final IBlockState soil = world.func_180495_p(pos.func_177977_b());
        if (state.func_177230_c() != this) {
            return canPlaceRootAt(world, pos) || soil.func_177230_c().canSustainPlant(soil, (IBlockAccess)world, pos.func_177977_b(), EnumFacing.UP, (IPlantable)this) || soil.isSideSolid((IBlockAccess)world, pos, EnumFacing.UP) || ((world.func_175699_k(pos) >= 3 || world.func_175678_i(pos)) && soil.func_177230_c().canSustainPlant(soil, (IBlockAccess)world, pos.func_177977_b(), EnumFacing.UP, (IPlantable)this));
        }
        switch ((PlantVariant)state.func_177229_b((IProperty)BlockTFPlant.VARIANT)) {
            case TORCHBERRY:
            case ROOT_STRAND: {
                return canPlaceRootAt(world, pos);
            }
            case FORESTGRASS:
            case DEADBUSH: {
                return soil.func_177230_c().canSustainPlant(soil, (IBlockAccess)world, pos.func_177977_b(), EnumFacing.UP, (IPlantable)this);
            }
            case FALLEN_LEAVES:
            case MUSHGLOOM:
            case MOSSPATCH: {
                return soil.isSideSolid((IBlockAccess)world, pos, EnumFacing.UP);
            }
            default: {
                return (world.func_175699_k(pos) >= 3 || world.func_175678_i(pos)) && soil.func_177230_c().canSustainPlant(soil, (IBlockAccess)world, pos.func_177977_b(), EnumFacing.UP, (IPlantable)this);
            }
        }
    }
    
    public AxisAlignedBB func_185496_a(final IBlockState state, final IBlockAccess access, final BlockPos pos) {
        final PlantVariant variant = (PlantVariant)state.func_177229_b((IProperty)BlockTFPlant.VARIANT);
        long seed = (long)(pos.func_177958_n() * 3129871) ^ pos.func_177956_o() * 116129781L ^ (long)pos.func_177952_p();
        seed = seed * seed * 42317861L + seed * 11L;
        if (variant == PlantVariant.MOSSPATCH) {
            final int xOff0 = (int)(seed >> 12 & 0x3L);
            final int xOff2 = (int)(seed >> 15 & 0x3L);
            final int zOff0 = (int)(seed >> 18 & 0x3L);
            final int zOff2 = (int)(seed >> 21 & 0x3L);
            final boolean xConnect0 = access.func_180495_p(pos.func_177974_f()).func_177230_c() == this && access.func_180495_p(pos.func_177974_f()).func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.MOSSPATCH;
            final boolean xConnect2 = access.func_180495_p(pos.func_177976_e()).func_177230_c() == this && access.func_180495_p(pos.func_177976_e()).func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.MOSSPATCH;
            final boolean zConnect0 = access.func_180495_p(pos.func_177968_d()).func_177230_c() == this && access.func_180495_p(pos.func_177968_d()).func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.MOSSPATCH;
            final boolean zConnect2 = access.func_180495_p(pos.func_177978_c()).func_177230_c() == this && access.func_180495_p(pos.func_177978_c()).func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.MOSSPATCH;
            return new AxisAlignedBB(xConnect2 ? 0.0 : ((double)((1.0f + xOff2) / 16.0f)), 0.0, zConnect2 ? 0.0 : ((double)((1.0f + zOff2) / 16.0f)), xConnect0 ? 1.0 : ((double)((15.0f - xOff0) / 16.0f)), 0.0625, zConnect0 ? 1.0 : ((double)((15.0f - zOff0) / 16.0f)));
        }
        if (variant == PlantVariant.CLOVERPATCH) {
            final int xOff0 = (int)(seed >> 12 & 0x3L);
            final int xOff2 = (int)(seed >> 15 & 0x3L);
            final int zOff0 = (int)(seed >> 18 & 0x3L);
            final int zOff2 = (int)(seed >> 21 & 0x3L);
            final int yOff0 = (int)(seed >> 24 & 0x1L);
            final int yOff2 = (int)(seed >> 27 & 0x1L);
            final boolean xConnect3 = access.func_180495_p(pos.func_177974_f()).func_177230_c() == this && access.func_180495_p(pos.func_177974_f()).func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.CLOVERPATCH;
            final boolean xConnect4 = access.func_180495_p(pos.func_177976_e()).func_177230_c() == this && access.func_180495_p(pos.func_177976_e()).func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.CLOVERPATCH;
            final boolean zConnect3 = access.func_180495_p(pos.func_177968_d()).func_177230_c() == this && access.func_180495_p(pos.func_177968_d()).func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.CLOVERPATCH;
            final boolean zConnect4 = access.func_180495_p(pos.func_177978_c()).func_177230_c() == this && access.func_180495_p(pos.func_177978_c()).func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.CLOVERPATCH;
            return new AxisAlignedBB(xConnect4 ? 0.0 : ((double)((1.0f + xOff2) / 16.0f)), 0.0, zConnect4 ? 0.0 : ((double)((1.0f + zOff2) / 16.0f)), xConnect3 ? 1.0 : ((double)((15.0f - xOff0) / 16.0f)), (double)((1.0f + yOff0 + yOff2) / 16.0f), zConnect3 ? 1.0 : ((double)((15.0f - zOff0) / 16.0f)));
        }
        if (variant == PlantVariant.MAYAPPLE) {
            return new AxisAlignedBB(0.25, 0.0, 0.25, 0.8125, 0.375, 0.8125);
        }
        if (variant == PlantVariant.FALLEN_LEAVES) {
            return new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.0625, 1.0);
        }
        return BlockTFPlant.field_185505_j;
    }
    
    public AxisAlignedBB func_180646_a(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return BlockTFPlant.field_185506_k;
    }
    
    public boolean func_149662_c(final IBlockState state) {
        return false;
    }
    
    public int func_149750_m(final IBlockState state) {
        switch ((PlantVariant)state.func_177229_b((IProperty)BlockTFPlant.VARIANT)) {
            case MUSHGLOOM: {
                return 3;
            }
            case TORCHBERRY: {
                return 8;
            }
            default: {
                return 0;
            }
        }
    }
    
    public static boolean canPlaceRootAt(final World world, final BlockPos pos) {
        final IBlockState state = world.func_180495_p(pos.func_177984_a());
        return state.func_185904_a() == Material.field_151578_c || state.func_185904_a() == Material.field_151577_b || (state.func_177230_c() == TFBlocks.twilight_plant && state.func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.ROOT_STRAND) || state == TFBlocks.root.func_176223_P();
    }
    
    public Block.EnumOffsetType func_176218_Q() {
        return Block.EnumOffsetType.NONE;
    }
    
    public List<ItemStack> getDrops(final IBlockAccess world, final BlockPos pos, final IBlockState state, final int fortune) {
        final List<ItemStack> ret = (List<ItemStack>)NonNullList.func_191196_a();
        switch ((PlantVariant)state.func_177229_b((IProperty)BlockTFPlant.VARIANT)) {
            case TORCHBERRY: {
                ret.add(new ItemStack(TFItems.torchberries));
                break;
            }
            case ROOT_STRAND:
            case FORESTGRASS:
            case DEADBUSH:
            case FALLEN_LEAVES:
            case MOSSPATCH:
            case MAYAPPLE:
            case CLOVERPATCH:
            case FIDDLEHEAD: {
                break;
            }
            default: {
                ret.add(new ItemStack((Block)this, 1, this.func_180651_a(state)));
                break;
            }
        }
        return ret;
    }
    
    public int func_180651_a(final IBlockState state) {
        return this.func_176201_c(state);
    }
    
    public boolean isShearable(final ItemStack item, final IBlockAccess world, final BlockPos pos) {
        return true;
    }
    
    public List<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final BlockPos pos, final int fortune) {
        final List<ItemStack> ret = (List<ItemStack>)NonNullList.func_191196_a();
        ret.add(new ItemStack((Block)this, 1, this.func_180651_a(world.func_180495_p(pos))));
        return ret;
    }
    
    public void func_180657_a(final World world, final EntityPlayer player, final BlockPos pos, final IBlockState state, @Nullable final TileEntity te, final ItemStack stack) {
        if (world.field_72995_K || stack.func_77973_b() != Items.field_151097_aZ) {
            super.func_180657_a(world, player, pos, state, te, stack);
        }
    }
    
    public void func_149666_a(final CreativeTabs creativeTab, final NonNullList<ItemStack> list) {
        for (int n = PlantVariant.values().length, i = 0; i < n; ++i) {
            list.add((Object)new ItemStack((Block)this, 1, i));
        }
    }
    
    public EnumPlantType getPlantType(final IBlockAccess world, final BlockPos pos) {
        final IBlockState blockState = world.func_180495_p(pos);
        if (blockState.func_177230_c() != this) {
            return EnumPlantType.Plains;
        }
        switch ((PlantVariant)blockState.func_177229_b((IProperty)BlockTFPlant.VARIANT)) {
            case MUSHGLOOM:
            case MOSSPATCH: {
                return EnumPlantType.Cave;
            }
            default: {
                return EnumPlantType.Plains;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_180655_c(final IBlockState state, final World world, final BlockPos pos, final Random random) {
        super.func_180655_c(state, world, pos, random);
        if (state.func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.MOSSPATCH && random.nextInt(10) == 0) {
            world.func_175688_a(EnumParticleTypes.TOWN_AURA, (double)(pos.func_177958_n() + random.nextFloat()), (double)(pos.func_177956_o() + 0.1f), (double)(pos.func_177952_p() + random.nextFloat()), 0.0, 0.0, 0.0, new int[0]);
        }
        else if (state.func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.FALLEN_LEAVES && random.nextInt(50) == 0) {
            float dist = 10.0f;
            if (!world.func_175678_i(pos)) {
                for (int y = 0; y <= dist; ++y) {
                    if (world.func_180495_p(pos.func_177981_b(y)).func_185904_a() == Material.field_151584_j) {
                        dist = (float)y;
                        break;
                    }
                }
                if (dist > 10.0f) {
                    return;
                }
            }
            final Particle leaf = TFParticleFactory.createParticle(TFParticleType.FALLEN_LEAF, world, pos.func_177958_n() + random.nextFloat(), pos.func_177956_o() + dist - 0.25f, pos.func_177952_p() + random.nextFloat(), 0.0, 0.0, 0.0);
            final int color = Minecraft.func_71410_x().func_184125_al().func_186724_a(Blocks.field_150362_t.func_176223_P(), (IBlockAccess)world, pos, 0);
            leaf.func_70538_b(MathHelper.func_76125_a((color >> 16 & 0xFF) + BlockTFPlant.RANDOM.nextInt(34) - 17, 0, 255) / 255.0f, MathHelper.func_76125_a((color >> 8 & 0xFF) + BlockTFPlant.RANDOM.nextInt(34) - 17, 0, 255) / 255.0f, MathHelper.func_76125_a((color & 0xFF) + BlockTFPlant.RANDOM.nextInt(34) - 17, 0, 255) / 255.0f);
            Minecraft.func_71410_x().field_71452_i.func_78873_a(leaf);
        }
    }
    
    public void func_180634_a(final World world, final BlockPos pos, final IBlockState state, final Entity entityIn) {
        super.func_180634_a(world, pos, state, entityIn);
        if (world.field_72995_K && state.func_177229_b((IProperty)BlockTFPlant.VARIANT) == PlantVariant.FALLEN_LEAVES && entityIn instanceof EntityLivingBase && (entityIn.field_70159_w != 0.0 || entityIn.field_70179_y != 0.0) && BlockTFPlant.RANDOM.nextBoolean()) {
            final int color = Minecraft.func_71410_x().func_184125_al().func_186724_a(Blocks.field_150362_t.func_176223_P(), (IBlockAccess)world, pos, 0);
            final Particle leaf = TFParticleFactory.createParticle(TFParticleType.FALLEN_LEAF, world, pos.func_177958_n() + world.field_73012_v.nextFloat(), pos.func_177956_o(), pos.func_177952_p() + world.field_73012_v.nextFloat(), world.field_73012_v.nextFloat() * -0.5f * entityIn.field_70159_w, world.field_73012_v.nextFloat() * 0.5f + 0.25f, world.field_73012_v.nextFloat() * -0.5f * entityIn.field_70179_y);
            leaf.func_70538_b(MathHelper.func_76125_a((color >> 16 & 0xFF) + BlockTFPlant.RANDOM.nextInt(34) - 17, 0, 255) / 255.0f, MathHelper.func_76125_a((color >> 8 & 0xFF) + BlockTFPlant.RANDOM.nextInt(34) - 17, 0, 255) / 255.0f, MathHelper.func_76125_a((color & 0xFF) + BlockTFPlant.RANDOM.nextInt(34) - 17, 0, 255) / 255.0f);
            Minecraft.func_71410_x().field_71452_i.func_78873_a(leaf);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer func_180664_k() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        for (int i = 0; i < PlantVariant.values().length; ++i) {
            final String variant = "inventory_" + PlantVariant.values()[i].func_176610_l();
            final ModelResourceLocation mrl = new ModelResourceLocation(this.getRegistryName(), variant);
            ModelLoader.setCustomModelResourceLocation(Item.func_150898_a((Block)this), i, mrl);
        }
    }
    
    public IBlockState getExtendedState(final IBlockState state, final IBlockAccess world, final BlockPos pos) {
        return super.getExtendedState(state, world, pos);
    }
    
    static {
        VARIANT = (IProperty)PropertyEnum.func_177709_a("variant", (Class)PlantVariant.class);
    }
}
