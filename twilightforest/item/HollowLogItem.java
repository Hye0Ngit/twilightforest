// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import twilightforest.block.HollowLogClimbable;
import twilightforest.block.HollowLogVertical;
import twilightforest.block.HollowLogHorizontal;
import net.minecraft.world.item.BlockItem;

public class HollowLogItem extends BlockItem
{
    private final HollowLogHorizontal horizontalLog;
    private final HollowLogVertical verticalLog;
    private final HollowLogClimbable climbable;
    
    public HollowLogItem(final RegistryObject<HollowLogHorizontal> horizontalLog, final RegistryObject<HollowLogVertical> verticalLog, final RegistryObject<HollowLogClimbable> climbable, final Item.Properties properties) {
        super((Block)verticalLog.get(), properties);
        this.horizontalLog = (HollowLogHorizontal)horizontalLog.get();
        this.verticalLog = (HollowLogVertical)verticalLog.get();
        this.climbable = (HollowLogClimbable)climbable.get();
    }
    
    @Nullable
    protected BlockState m_5965_(final BlockPlaceContext context) {
        return switch (context.m_43719_().m_122434_()) {
            case Y -> this.verticalLog.m_5573_(context);
            case X,  Z -> this.horizontalLog.m_5573_(context);
            default -> throw new IncompatibleClassChangeError();
        };
    }
    
    public void m_6192_(final Map<Block, Item> pBlockToItemMap, final Item pItem) {
        super.m_6192_((Map)pBlockToItemMap, pItem);
        pBlockToItemMap.put(this.horizontalLog, pItem);
        pBlockToItemMap.put(this.verticalLog, pItem);
        pBlockToItemMap.put((Block)this.climbable, pItem);
    }
    
    public void removeFromBlockToItemMap(final Map<Block, Item> blockToItemMap, final Item itemIn) {
        super.removeFromBlockToItemMap((Map)blockToItemMap, itemIn);
        blockToItemMap.remove(this.horizontalLog);
        blockToItemMap.remove(this.verticalLog);
        blockToItemMap.remove(this.climbable);
    }
}
