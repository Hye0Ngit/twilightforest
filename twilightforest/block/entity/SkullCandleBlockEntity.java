// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SkullBlockEntity;

public class SkullCandleBlockEntity extends SkullBlockEntity
{
    public int candleColor;
    public int candleAmount;
    
    public SkullCandleBlockEntity(final BlockPos pos, final BlockState state) {
        super(pos, state);
    }
    
    public SkullCandleBlockEntity(final BlockPos pos, final BlockState state, final int color, final int amount) {
        super(pos, state);
        this.candleColor = color;
        this.candleAmount = amount;
    }
    
    public BlockEntityType<?> m_58903_() {
        return (BlockEntityType<?>)TFBlockEntities.SKULL_CANDLE.get();
    }
    
    public CompoundTag m_6945_(final CompoundTag tag) {
        super.m_6945_(tag);
        tag.m_128405_("CandleColor", this.candleColor);
        if (this.candleAmount != 0) {
            tag.m_128405_("CandleAmount", this.candleAmount);
        }
        return tag;
    }
    
    public void m_142466_(final CompoundTag tag) {
        super.m_142466_(tag);
        this.candleColor = tag.m_128451_("CandleColor");
        this.candleAmount = tag.m_128451_("CandleAmount");
    }
}
