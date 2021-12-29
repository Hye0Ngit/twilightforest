// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import twilightforest.client.renderer.tileentity.TileEntityTFTrophyRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFTrophy;
import twilightforest.block.TFBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import javax.annotation.Nonnull;
import twilightforest.TwilightForestMod;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.text.translation.I18n;
import java.util.Locale;
import net.minecraft.item.Item;
import twilightforest.enums.BossVariant;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFTrophy extends ItemTF
{
    public ItemTFTrophy() {
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.func_77656_e(0);
        this.func_77627_a(true);
    }
    
    public void func_150895_a(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        if (this.func_194125_a(tab)) {
            for (final BossVariant v : BossVariant.values()) {
                if (v != BossVariant.ALPHA_YETI && v != BossVariant.FINAL_BOSS) {
                    list.add((Object)new ItemStack((Item)this, 1, v.ordinal()));
                }
            }
        }
    }
    
    public String func_77653_i(final ItemStack stack) {
        return I18n.func_74837_a(this.func_77667_c(stack), new Object[] { I18n.func_74838_a("entity.twilightforest." + BossVariant.values()[stack.func_77960_j() % BossVariant.values().length].func_176610_l().toLowerCase(Locale.ROOT) + ".name") });
    }
    
    @Nonnull
    @Override
    public EnumRarity func_77613_e(final ItemStack stack) {
        return TwilightForestMod.getRarity();
    }
    
    @Nonnull
    public EnumActionResult func_180614_a(final EntityPlayer playerIn, final World worldIn, BlockPos pos, final EnumHand hand, EnumFacing facing, final float hitX, final float hitY, final float hitZ) {
        if (facing == EnumFacing.DOWN) {
            return EnumActionResult.FAIL;
        }
        if (worldIn.func_180495_p(pos).func_177230_c().func_176200_f((IBlockAccess)worldIn, pos)) {
            facing = EnumFacing.UP;
            pos = pos.func_177977_b();
        }
        final IBlockState iblockstate = worldIn.func_180495_p(pos);
        final Block block = iblockstate.func_177230_c();
        final boolean flag = block.func_176200_f((IBlockAccess)worldIn, pos);
        if (!flag) {
            if (!worldIn.func_180495_p(pos).func_185904_a().func_76220_a() && !worldIn.isSideSolid(pos, facing, true)) {
                return EnumActionResult.FAIL;
            }
            pos = pos.func_177972_a(facing);
        }
        final ItemStack itemstack = playerIn.func_184586_b(hand);
        if (!playerIn.func_175151_a(pos, facing, itemstack) || !TFBlocks.trophy.func_176196_c(worldIn, pos)) {
            return EnumActionResult.FAIL;
        }
        if (worldIn.field_72995_K) {
            return EnumActionResult.SUCCESS;
        }
        worldIn.func_180501_a(pos, TFBlocks.trophy.func_176223_P().func_177226_a((IProperty)BlockTFTrophy.field_176418_a, (Comparable)facing), 11);
        int i = 0;
        if (facing == EnumFacing.UP) {
            i = (MathHelper.func_76128_c(playerIn.field_70177_z * 16.0f / 360.0f + 0.5) & 0xF);
        }
        final TileEntity tileentity = worldIn.func_175625_s(pos);
        if (tileentity instanceof TileEntitySkull) {
            final TileEntitySkull tileentityskull = (TileEntitySkull)tileentity;
            tileentityskull.func_152107_a(itemstack.func_77960_j());
            tileentityskull.func_145903_a(i);
        }
        if (playerIn instanceof EntityPlayerMP) {
            CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)playerIn, pos, itemstack);
        }
        itemstack.func_190918_g(1);
        return EnumActionResult.SUCCESS;
    }
    
    @Nonnull
    public String func_77667_c(final ItemStack stack) {
        return "item.twilightforest.tf_trophy.name";
    }
    
    public boolean isValidArmor(final ItemStack stack, final EntityEquipmentSlot armorType, final Entity entity) {
        return armorType == EntityEquipmentSlot.HEAD;
    }
    
    @Nullable
    public EntityEquipmentSlot getEquipmentSlot(final ItemStack stack) {
        return EntityEquipmentSlot.HEAD;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerModel() {
        final ModelResourceLocation itemModelLocation = new ModelResourceLocation("twilightforest:trophy_tesr", "inventory");
        final TileEntityTFTrophyRenderer tesr = new TileEntityTFTrophyRenderer(itemModelLocation);
        ClientRegistry.bindTileEntitySpecialRenderer((Class)TileEntityTFTrophyRenderer.DummyTile.class, (TileEntitySpecialRenderer)tesr);
        for (final BossVariant variant : BossVariant.values()) {
            if (variant != BossVariant.ALPHA_YETI) {
                ModelLoader.setCustomModelResourceLocation((Item)this, variant.ordinal(), itemModelLocation);
                ForgeHooksClient.registerTESRItemStack((Item)this, variant.ordinal(), (Class)TileEntityTFTrophyRenderer.DummyTile.class);
            }
        }
        ModelBakery.registerItemVariants((Item)this, new ResourceLocation[] { (ResourceLocation)new ModelResourceLocation(new ResourceLocation("twilightforest", "trophy"), "inventory"), (ResourceLocation)new ModelResourceLocation(new ResourceLocation("twilightforest", "trophy_minor"), "inventory"), (ResourceLocation)new ModelResourceLocation(new ResourceLocation("twilightforest", "trophy_quest"), "inventory") });
    }
}
