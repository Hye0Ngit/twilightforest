// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.dispenser;

import java.util.Iterator;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockSource;
import twilightforest.item.CrumbleHornItem;
import java.util.function.UnaryOperator;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.Predicate;
import org.apache.commons.lang3.tuple.Pair;
import java.util.List;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;

public class CrumbleDispenseBehavior extends DefaultDispenseItemBehavior
{
    boolean fired;
    private final List<Pair<Predicate<BlockState>, UnaryOperator<BlockState>>> crumbleTransforms;
    private final List<Predicate<BlockState>> harvestedStates;
    
    public CrumbleDispenseBehavior() {
        this.fired = false;
        this.crumbleTransforms = CrumbleHornItem.crumbleTransforms;
        this.harvestedStates = CrumbleHornItem.harvestedStates;
    }
    
    protected ItemStack m_7498_(final BlockSource source, final ItemStack stack) {
        boolean crumbled = false;
        boolean harvested = false;
        final Level world = (Level)source.m_7727_();
        final BlockPos blockpos = source.m_7961_().m_142300_((Direction)source.m_6414_().m_61143_((Property)DispenserBlock.f_52659_));
        final BlockState blockstate = world.m_8055_(blockpos);
        if (!world.f_46443_ && stack.m_41776_() != stack.m_41773_() + 1) {
            for (final Pair<Predicate<BlockState>, UnaryOperator<BlockState>> transform : this.crumbleTransforms) {
                if (((Predicate)transform.getLeft()).test(blockstate)) {
                    world.m_7731_(blockpos, (BlockState)((UnaryOperator)transform.getRight()).apply(blockstate), 3);
                    crumbled = true;
                }
            }
            if (crumbled) {
                world.m_46796_(2001, blockpos, Block.m_49956_(blockstate));
                if (stack.m_41629_(1, world.f_46441_, (ServerPlayer)null)) {
                    stack.m_41764_(0);
                }
                this.fired = true;
            }
            for (final Predicate<BlockState> predicate : this.harvestedStates) {
                if (predicate.test(blockstate)) {
                    world.m_46961_(blockpos, true);
                    harvested = true;
                }
            }
            if (harvested) {
                if (stack.m_41629_(1, world.f_46441_, (ServerPlayer)null)) {
                    stack.m_41764_(0);
                }
                this.fired = true;
            }
            return stack;
        }
        return stack;
    }
    
    protected void m_6823_(final BlockSource source) {
        if (this.fired) {
            super.m_6823_(source);
            this.fired = false;
        }
        else {
            source.m_7727_().m_46796_(1001, source.m_7961_(), 0);
        }
    }
}
