// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.network.chat.Component;
import net.minecraft.Util;
import net.minecraft.network.chat.TranslatableComponent;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import javax.annotation.Nonnull;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;

public class OreMeterItem extends Item
{
    protected OreMeterItem(final Item.Properties props) {
        super(props);
    }
    
    @Nonnull
    public InteractionResultHolder<ItemStack> m_7203_(final Level world, final Player player, @Nonnull final InteractionHand hand) {
        final int useX = Mth.m_14107_(player.m_20185_());
        final int useZ = Mth.m_14107_(player.m_20189_());
        if (!world.f_46443_) {
            this.countOreInArea(player, world, useX, useZ, 3);
        }
        return (InteractionResultHolder<ItemStack>)InteractionResultHolder.m_19092_((Object)player.m_21120_(hand), world.f_46443_);
    }
    
    private void countOreInArea(final Player player, final Level world, final int useX, final int useZ, final int radius) {
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
                countStone += results.entrySet().stream().filter(e -> e.getKey().m_60734_() == Blocks.f_50069_).mapToInt(e -> e.getValue().count).sum();
                countDirt += results.entrySet().stream().filter(e -> e.getKey().m_60734_() == Blocks.f_50493_).mapToInt(e -> e.getValue().count).sum();
                countGravel += results.getOrDefault(Blocks.f_49994_.m_49966_(), dummy).count;
                countCoal += results.getOrDefault(Blocks.f_49997_.m_49966_(), dummy).count;
                countIron += results.getOrDefault(Blocks.f_49996_.m_49966_(), dummy).count;
                countGold += results.getOrDefault(Blocks.f_49995_.m_49966_(), dummy).count;
                countDiamond += results.getOrDefault(Blocks.f_50089_.m_49966_(), dummy).count;
                countLapis += results.getOrDefault(Blocks.f_50059_.m_49966_(), dummy).count;
                countRedstone += results.getOrDefault(Blocks.f_50173_.m_49966_(), dummy).count;
                countExposedDiamond += results.getOrDefault(Blocks.f_50089_.m_49966_(), dummy).exposedCount;
                countRoots += results.getOrDefault(((Block)TFBlocks.ROOT_BLOCK.get()).m_49966_(), dummy).count;
                countOreRoots += results.getOrDefault(((Block)TFBlocks.LIVEROOT_BLOCK.get()).m_49966_(), dummy).count;
            }
        }
        final int total = countStone + countDirt + countGravel + countCoal + countIron + countGold + countDiamond + countLapis + countRedstone + countRoots + countOreRoots;
        player.m_6352_((Component)new TranslatableComponent(this.m_5524_()).m_130946_("!"), Util.f_137441_);
        player.m_6352_((Component)new TranslatableComponent("twilightforest.ore_meter.range", new Object[] { radius, chunkX, chunkZ }), Util.f_137441_);
        player.m_6352_((Component)new TranslatableComponent(Blocks.f_49997_.m_7705_()).m_130946_(" - " + countCoal + " " + this.percent(countCoal, total)), Util.f_137441_);
        player.m_6352_((Component)new TranslatableComponent(Blocks.f_49996_.m_7705_()).m_130946_(" - " + countIron + " " + this.percent(countIron, total)), Util.f_137441_);
        player.m_6352_((Component)new TranslatableComponent(Blocks.f_49995_.m_7705_()).m_130946_(" - " + countGold + " " + this.percent(countGold, total)), Util.f_137441_);
        player.m_6352_((Component)new TranslatableComponent(Blocks.f_50089_.m_7705_()).m_130946_(" - " + countDiamond + " " + this.percent(countDiamond, total) + ", ").m_7220_((Component)new TranslatableComponent("twilightforest.ore_meter.exposed", new Object[] { countExposedDiamond })), Util.f_137441_);
        player.m_6352_((Component)new TranslatableComponent(Blocks.f_50059_.m_7705_()).m_130946_(" - " + countLapis + " " + this.percent(countLapis, total)), Util.f_137441_);
        player.m_6352_((Component)new TranslatableComponent(Blocks.f_50173_.m_7705_()).m_130946_(" - " + countRedstone + " " + this.percent(countRedstone, total)), Util.f_137441_);
        player.m_6352_((Component)new TranslatableComponent(((Block)TFBlocks.ROOT_BLOCK.get()).m_7705_()).m_130946_(" - " + countRoots + " " + this.percent(countRoots, total)), Util.f_137441_);
        player.m_6352_((Component)new TranslatableComponent(((Block)TFBlocks.LIVEROOT_BLOCK.get()).m_7705_()).m_130946_(" - " + countOreRoots + " " + this.percent(countOreRoots, total)), Util.f_137441_);
    }
    
    private String percent(final int count, final int total) {
        return "" + count / (float)total * 100.0f;
    }
    
    private Map<BlockState, ScanResult> countBlocksInChunk(final Level world, final int cx, final int cz) {
        final Map<BlockState, ScanResult> ret = new IdentityHashMap<BlockState, ScanResult>();
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int x = cx << 4; x < (cx << 4) + 16; ++x) {
            for (int z = cz << 4; z < (cz << 4) + 16; ++z) {
                for (int y = 0; y < 256; ++y) {
                    final BlockState state = world.m_8055_((BlockPos)pos.m_122178_(x, y, z));
                    final ScanResult scanResult;
                    final ScanResult res = scanResult = ret.computeIfAbsent(state, s -> new ScanResult());
                    ++scanResult.count;
                    for (final Direction e : Direction.values()) {
                        if (world.m_46859_((BlockPos)pos.m_122178_(x, y, z).m_122173_(e))) {
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
