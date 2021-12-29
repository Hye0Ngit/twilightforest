// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.RootVariant;
import twilightforest.block.BlockTFRoots;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFOreMeter extends ItemTF
{
    protected ItemTFOreMeter() {
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final EntityPlayer player, @Nonnull final EnumHand hand) {
        final int useX = MathHelper.func_76128_c(player.field_70165_t);
        final int useZ = MathHelper.func_76128_c(player.field_70161_v);
        if (!world.field_72995_K) {
            this.countOreInArea(player, world, useX, useZ, 3);
        }
        return (ActionResult<ItemStack>)ActionResult.newResult(EnumActionResult.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    private void countOreInArea(final EntityPlayer player, final World world, final int useX, final int useZ, final int radius) {
        final int chunkX = useX >> 4;
        final int chunkZ = useZ >> 4;
        int countStone = 0;
        int countDirt = 0;
        int countGravel = 0;
        int countCoal = 0;
        int countIron = 0;
        int countGold = 0;
        int countDiamond = 0;
        int countLapis = 0;
        int countRedstone = 0;
        int countExposedDiamond = 0;
        int countRoots = 0;
        int countOreRoots = 0;
        int total = 0;
        final ScanResult dummy = new ScanResult();
        for (int cx = chunkX - radius; cx <= chunkX + radius; ++cx) {
            for (int cz = chunkZ - radius; cz <= chunkZ + radius; ++cz) {
                final Map<IBlockState, ScanResult> results = this.countBlocksInChunk(world, chunkX, chunkZ);
                countStone += results.entrySet().stream().filter(e -> e.getKey().func_177230_c() == Blocks.field_150348_b).mapToInt(e -> e.getValue().count).sum();
                countDirt += results.entrySet().stream().filter(e -> e.getKey().func_177230_c() == Blocks.field_150346_d).mapToInt(e -> e.getValue().count).sum();
                countGravel += results.getOrDefault(Blocks.field_150351_n.func_176223_P(), dummy).count;
                countCoal += results.getOrDefault(Blocks.field_150365_q.func_176223_P(), dummy).count;
                countIron += results.getOrDefault(Blocks.field_150366_p.func_176223_P(), dummy).count;
                countGold += results.getOrDefault(Blocks.field_150352_o.func_176223_P(), dummy).count;
                countDiamond += results.getOrDefault(Blocks.field_150482_ag.func_176223_P(), dummy).count;
                countLapis += results.getOrDefault(Blocks.field_150369_x.func_176223_P(), dummy).count;
                countRedstone += results.getOrDefault(Blocks.field_150450_ax.func_176223_P(), dummy).count + results.getOrDefault(Blocks.field_150439_ay.func_176223_P(), dummy).count;
                countExposedDiamond += results.getOrDefault(Blocks.field_150482_ag.func_176223_P(), dummy).exposedCount;
                countRoots += results.getOrDefault(TFBlocks.root.func_176223_P().func_177226_a((IProperty)BlockTFRoots.VARIANT, (Comparable)RootVariant.ROOT), dummy).count;
                countOreRoots += results.getOrDefault(TFBlocks.root.func_176223_P().func_177226_a((IProperty)BlockTFRoots.VARIANT, (Comparable)RootVariant.LIVEROOT), dummy).count;
            }
        }
        total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
        player.func_145747_a(new TextComponentTranslation(this.func_77658_a() + ".name", new Object[0]).func_150258_a("!"));
        player.func_145747_a((ITextComponent)new TextComponentTranslation("twilightforest.ore_meter.range", new Object[] { radius, chunkX, chunkZ }));
        player.func_145747_a(new TextComponentTranslation(Blocks.field_150365_q.func_149739_a() + ".name", new Object[0]).func_150258_a(" - " + countCoal + " " + this.percent(countCoal, total)));
        player.func_145747_a(new TextComponentTranslation(Blocks.field_150366_p.func_149739_a() + ".name", new Object[0]).func_150258_a(" - " + countIron + " " + this.percent(countIron, total)));
        player.func_145747_a(new TextComponentTranslation(Blocks.field_150352_o.func_149739_a() + ".name", new Object[0]).func_150258_a(" - " + countGold + " " + this.percent(countGold, total)));
        player.func_145747_a(new TextComponentTranslation(Blocks.field_150482_ag.func_149739_a() + ".name", new Object[0]).func_150258_a(" - " + countDiamond + " " + this.percent(countDiamond, total) + ", ").func_150257_a((ITextComponent)new TextComponentTranslation("twilightforest.ore_meter.exposed", new Object[] { countExposedDiamond })));
        player.func_145747_a(new TextComponentTranslation(Blocks.field_150369_x.func_149739_a() + ".name", new Object[0]).func_150258_a(" - " + countLapis + " " + this.percent(countLapis, total)));
        player.func_145747_a(new TextComponentTranslation(Blocks.field_150450_ax.func_149739_a() + ".name", new Object[0]).func_150258_a(" - " + countRedstone + " " + this.percent(countRedstone, total)));
        player.func_145747_a(new TextComponentTranslation(new ItemStack(TFBlocks.root).func_77977_a() + ".name", new Object[0]).func_150258_a(" - " + countRoots + " " + this.percent(countRoots, total)));
        player.func_145747_a(new TextComponentTranslation(new ItemStack(TFBlocks.root, 1, 1).func_77977_a() + ".name", new Object[0]).func_150258_a(" - " + countOreRoots + " " + this.percent(countOreRoots, total)));
    }
    
    private String percent(final int count, final int total) {
        return Float.toString(count / (float)total * 100.0f) + "%";
    }
    
    private Map<IBlockState, ScanResult> countBlocksInChunk(final World world, final int cx, final int cz) {
        final Map<IBlockState, ScanResult> ret = new IdentityHashMap<IBlockState, ScanResult>();
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int x = cx << 4; x < (cx << 4) + 16; ++x) {
            for (int z = cz << 4; z < (cz << 4) + 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    final IBlockState state = world.func_180495_p((BlockPos)pos.func_181079_c(x, y, z));
                    final ScanResult scanResult;
                    final ScanResult res = scanResult = ret.computeIfAbsent(state, s -> new ScanResult());
                    ++scanResult.count;
                    for (final EnumFacing e : EnumFacing.field_82609_l) {
                        if (world.func_175623_d((BlockPos)pos.func_181079_c(x, y, z).func_189536_c(e))) {
                            final ScanResult scanResult2 = res;
                            ++scanResult2.exposedCount;
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }
    
    private static class ScanResult
    {
        int count;
        int exposedCount;
    }
}
