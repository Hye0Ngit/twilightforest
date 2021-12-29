// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import javax.annotation.Nonnull;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.Item;

public class OreMeterItem extends Item
{
    protected OreMeterItem(final Item.Properties props) {
        super(props);
    }
    
    @Nonnull
    public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity player, @Nonnull final Hand hand) {
        final int useX = MathHelper.func_76128_c(player.func_226277_ct_());
        final int useZ = MathHelper.func_76128_c(player.func_226281_cx_());
        if (!world.field_72995_K) {
            this.countOreInArea(player, world, useX, useZ, 3);
        }
        return (ActionResult<ItemStack>)new ActionResult(ActionResultType.SUCCESS, (Object)player.func_184586_b(hand));
    }
    
    private void countOreInArea(final PlayerEntity player, final World world, final int useX, final int useZ, final int radius) {
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
        final ScanResult dummy = new ScanResult();
        for (int cx = chunkX - radius; cx <= chunkX + radius; ++cx) {
            for (int cz = chunkZ - radius; cz <= chunkZ + radius; ++cz) {
                final Map<BlockState, ScanResult> results = this.countBlocksInChunk(world, chunkX, chunkZ);
                countStone += results.entrySet().stream().filter(e -> e.getKey().func_177230_c() == Blocks.field_150348_b).mapToInt(e -> e.getValue().count).sum();
                countDirt += results.entrySet().stream().filter(e -> e.getKey().func_177230_c() == Blocks.field_150346_d).mapToInt(e -> e.getValue().count).sum();
                countGravel += results.getOrDefault(Blocks.field_150351_n.func_176223_P(), dummy).count;
                countCoal += results.getOrDefault(Blocks.field_150365_q.func_176223_P(), dummy).count;
                countIron += results.getOrDefault(Blocks.field_150366_p.func_176223_P(), dummy).count;
                countGold += results.getOrDefault(Blocks.field_150352_o.func_176223_P(), dummy).count;
                countDiamond += results.getOrDefault(Blocks.field_150482_ag.func_176223_P(), dummy).count;
                countLapis += results.getOrDefault(Blocks.field_150369_x.func_176223_P(), dummy).count;
                countRedstone += results.getOrDefault(Blocks.field_150450_ax.func_176223_P(), dummy).count;
                countExposedDiamond += results.getOrDefault(Blocks.field_150482_ag.func_176223_P(), dummy).exposedCount;
                countRoots += results.getOrDefault(((Block)TFBlocks.root.get()).func_176223_P(), dummy).count;
                countOreRoots += results.getOrDefault(((Block)TFBlocks.liveroot_block.get()).func_176223_P(), dummy).count;
            }
        }
        final int total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
        player.func_145747_a((ITextComponent)new TranslationTextComponent(this.func_77658_a()).func_240702_b_("!"), Util.field_240973_b_);
        player.func_145747_a((ITextComponent)new TranslationTextComponent("twilightforest.ore_meter.range", new Object[] { radius, chunkX, chunkZ }), Util.field_240973_b_);
        player.func_145747_a((ITextComponent)new TranslationTextComponent(Blocks.field_150365_q.func_149739_a()).func_240702_b_(" - " + countCoal + " " + this.percent(countCoal, total)), Util.field_240973_b_);
        player.func_145747_a((ITextComponent)new TranslationTextComponent(Blocks.field_150366_p.func_149739_a()).func_240702_b_(" - " + countIron + " " + this.percent(countIron, total)), Util.field_240973_b_);
        player.func_145747_a((ITextComponent)new TranslationTextComponent(Blocks.field_150352_o.func_149739_a()).func_240702_b_(" - " + countGold + " " + this.percent(countGold, total)), Util.field_240973_b_);
        player.func_145747_a((ITextComponent)new TranslationTextComponent(Blocks.field_150482_ag.func_149739_a()).func_240702_b_(" - " + countDiamond + " " + this.percent(countDiamond, total) + ", ").func_230529_a_((ITextComponent)new TranslationTextComponent("twilightforest.ore_meter.exposed", new Object[] { countExposedDiamond })), Util.field_240973_b_);
        player.func_145747_a((ITextComponent)new TranslationTextComponent(Blocks.field_150369_x.func_149739_a()).func_240702_b_(" - " + countLapis + " " + this.percent(countLapis, total)), Util.field_240973_b_);
        player.func_145747_a((ITextComponent)new TranslationTextComponent(Blocks.field_150450_ax.func_149739_a()).func_240702_b_(" - " + countRedstone + " " + this.percent(countRedstone, total)), Util.field_240973_b_);
        player.func_145747_a((ITextComponent)new TranslationTextComponent(((Block)TFBlocks.root.get()).func_149739_a()).func_240702_b_(" - " + countRoots + " " + this.percent(countRoots, total)), Util.field_240973_b_);
        player.func_145747_a((ITextComponent)new TranslationTextComponent(((Block)TFBlocks.liveroot_block.get()).func_149739_a()).func_240702_b_(" - " + countOreRoots + " " + this.percent(countOreRoots, total)), Util.field_240973_b_);
    }
    
    private String percent(final int count, final int total) {
        return count / (float)total * 100.0f + "%";
    }
    
    private Map<BlockState, ScanResult> countBlocksInChunk(final World world, final int cx, final int cz) {
        final Map<BlockState, ScanResult> ret = new IdentityHashMap<BlockState, ScanResult>();
        final BlockPos.Mutable pos = new BlockPos.Mutable();
        for (int x = cx << 4; x < (cx << 4) + 16; ++x) {
            for (int z = cz << 4; z < (cz << 4) + 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    final BlockState state = world.func_180495_p((BlockPos)pos.func_181079_c(x, y, z));
                    final ScanResult scanResult;
                    final ScanResult res = scanResult = ret.computeIfAbsent(state, s -> new ScanResult());
                    ++scanResult.count;
                    for (final Direction e : Direction.values()) {
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
