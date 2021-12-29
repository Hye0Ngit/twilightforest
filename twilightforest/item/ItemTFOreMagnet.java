// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.block.properties.IProperty;
import twilightforest.enums.RootVariant;
import twilightforest.block.BlockTFRoots;
import twilightforest.block.TFBlocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.Block;
import com.google.common.base.Predicate;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.MathHelper;
import java.util.Iterator;
import java.util.Set;
import net.minecraft.block.state.IBlockState;
import java.util.HashSet;
import net.minecraft.init.Blocks;
import twilightforest.world.feature.TFGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.item.EnumAction;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.util.ResourceLocation;

public class ItemTFOreMagnet extends ItemTF
{
    private static final float WIGGLE = 10.0f;
    
    protected ItemTFOreMagnet() {
        this.field_77777_bU = 1;
        this.func_77656_e(12);
        this.func_185043_a(new ResourceLocation("pull"), (IItemPropertyGetter)new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float func_185085_a(final ItemStack stack, @Nullable final World worldIn, @Nullable final EntityLivingBase entityIn) {
                if (entityIn == null) {
                    return 0.0f;
                }
                final ItemStack itemstack = entityIn.func_184607_cu();
                return (!itemstack.func_190926_b() && itemstack.func_77973_b() == TFItems.ore_magnet) ? ((stack.func_77988_m() - entityIn.func_184605_cv()) / 20.0f) : 0.0f;
            }
        });
        this.func_185043_a(new ResourceLocation("pulling"), (IItemPropertyGetter)new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float func_185085_a(final ItemStack stack, @Nullable final World worldIn, @Nullable final EntityLivingBase entityIn) {
                return (entityIn != null && entityIn.func_184587_cr() && entityIn.func_184607_cu() == stack) ? 1.0f : 0.0f;
            }
        });
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, @Nonnull final EnumHand hand) {
        player.func_184598_c(hand);
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    public void func_77615_a(final ItemStack stack, final World world, final EntityLivingBase living, final int useRemaining) {
        final int useTime = this.func_77626_a(stack) - useRemaining;
        if (!world.field_72995_K && useTime > 10) {
            int moved = this.doMagnet(world, living, 0.0f, 0.0f);
            if (moved == 0) {
                moved = this.doMagnet(world, living, 10.0f, 0.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, 10.0f, 10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, 0.0f, 10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, -10.0f, 10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, -10.0f, 0.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, -10.0f, -10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, 0.0f, -10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, living, 10.0f, -10.0f);
            }
            if (moved > 0) {
                stack.func_77972_a(moved, living);
                world.func_184148_a((EntityPlayer)null, living.field_70165_t, living.field_70163_u, living.field_70161_v, SoundEvents.field_187534_aX, living.func_184176_by(), 1.0f, 1.0f);
            }
        }
    }
    
    public float getXpRepairRatio(final ItemStack stack) {
        return 0.1f;
    }
    
    @Nonnull
    public EnumAction func_77661_b(final ItemStack stack) {
        return EnumAction.BOW;
    }
    
    public int func_77626_a(final ItemStack stack) {
        return 72000;
    }
    
    private int doMagnet(final World world, final EntityLivingBase living, final float yawOffset, final float pitchOffset) {
        final double range = 32.0;
        final Vec3d srcVec = new Vec3d(living.field_70165_t, living.field_70163_u + living.func_70047_e(), living.field_70161_v);
        final Vec3d lookVec = this.getOffsetLook(living, yawOffset, pitchOffset);
        final Vec3d destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        return doMagnet(world, new BlockPos(srcVec), new BlockPos(destVec));
    }
    
    public static int doMagnet(final World world, final BlockPos usePos, final BlockPos destPos) {
        int blocksMoved = 0;
        final BlockPos[] lineArray = TFGenerator.getBresehnamArrays(usePos, destPos);
        IBlockState foundState = Blocks.field_150350_a.func_176223_P();
        BlockPos foundPos = null;
        BlockPos basePos = null;
        boolean isNetherrack = false;
        for (final BlockPos coord : lineArray) {
            final IBlockState searchState = world.func_180495_p(coord);
            if (basePos == null) {
                if (isReplaceable(world, searchState, coord)) {
                    basePos = coord;
                }
                else if (isNetherReplaceable(world, searchState, coord)) {
                    isNetherrack = true;
                    basePos = coord;
                }
            }
            else if (foundPos == null && searchState.func_177230_c() != Blocks.field_150350_a && isOre(searchState) && world.func_175625_s(coord) == null) {
                foundState = searchState;
                foundPos = coord;
            }
        }
        if (basePos != null && foundState.func_177230_c() != Blocks.field_150350_a) {
            final Set<BlockPos> veinBlocks = new HashSet<BlockPos>();
            findVein(world, foundPos, foundState, veinBlocks);
            final int offX = basePos.func_177958_n() - foundPos.func_177958_n();
            final int offY = basePos.func_177956_o() - foundPos.func_177956_o();
            final int offZ = basePos.func_177952_p() - foundPos.func_177952_p();
            for (final BlockPos coord2 : veinBlocks) {
                final BlockPos replacePos = coord2.func_177982_a(offX, offY, offZ);
                final IBlockState replaceState = world.func_180495_p(replacePos);
                Label_0325: {
                    if (isNetherrack) {
                        if (isNetherReplaceable(world, replaceState, replacePos)) {
                            break Label_0325;
                        }
                    }
                    else if (isReplaceable(world, replaceState, replacePos)) {
                        break Label_0325;
                    }
                    if (replaceState.func_177230_c() != Blocks.field_150350_a) {
                        continue;
                    }
                }
                world.func_180501_a(coord2, isNetherrack ? Blocks.field_150424_aL.func_176223_P() : Blocks.field_150348_b.func_176223_P(), 2);
                world.func_180501_a(replacePos, foundState, 2);
                ++blocksMoved;
            }
        }
        return blocksMoved;
    }
    
    private Vec3d getOffsetLook(final EntityLivingBase living, final float yawOffset, final float pitchOffset) {
        final float var2 = MathHelper.func_76134_b(-(living.field_70177_z + yawOffset) * 0.017453292f - 3.1415927f);
        final float var3 = MathHelper.func_76126_a(-(living.field_70177_z + yawOffset) * 0.017453292f - 3.1415927f);
        final float var4 = -MathHelper.func_76134_b(-(living.field_70125_A + pitchOffset) * 0.017453292f);
        final float var5 = MathHelper.func_76126_a(-(living.field_70125_A + pitchOffset) * 0.017453292f);
        return new Vec3d((double)(var3 * var4), (double)var5, (double)(var2 * var4));
    }
    
    private static boolean isReplaceable(final World world, final IBlockState state, final BlockPos pos) {
        final Block block = state.func_177230_c();
        return block == Blocks.field_150346_d || block == Blocks.field_150349_c || block == Blocks.field_150351_n || (block != Blocks.field_150350_a && block.isReplaceableOreGen(state, (IBlockAccess)world, pos, (Predicate)BlockMatcher.func_177642_a(Blocks.field_150348_b)));
    }
    
    private static boolean isNetherReplaceable(final World world, final IBlockState state, final BlockPos pos) {
        return state.func_177230_c() == Blocks.field_150424_aL || (state.func_177230_c() != Blocks.field_150350_a && state.func_177230_c().isReplaceableOreGen(state, (IBlockAccess)world, pos, (Predicate)BlockMatcher.func_177642_a(Blocks.field_150424_aL)));
    }
    
    private static boolean findVein(final World world, final BlockPos here, final IBlockState oreState, final Set<BlockPos> veinBlocks) {
        if (veinBlocks.contains(here)) {
            return false;
        }
        if (veinBlocks.size() >= 24) {
            return false;
        }
        if (world.func_180495_p(here) == oreState) {
            veinBlocks.add(here);
            for (final EnumFacing e : EnumFacing.field_82609_l) {
                findVein(world, here.func_177972_a(e), oreState, veinBlocks);
            }
            return true;
        }
        return false;
    }
    
    private static boolean isOre(final IBlockState state) {
        final Block block = state.func_177230_c();
        return block != Blocks.field_150365_q && (block == Blocks.field_150366_p || block == Blocks.field_150482_ag || block == Blocks.field_150412_bA || block == Blocks.field_150352_o || block == Blocks.field_150369_x || block == Blocks.field_150450_ax || block == Blocks.field_150439_ay || block == Blocks.field_150449_bY || state == TFBlocks.root.func_176223_P().func_177226_a((IProperty)BlockTFRoots.VARIANT, (Comparable)RootVariant.LIVEROOT) || state.func_177230_c().getRegistryName().func_110623_a().contains("ore"));
    }
}
