// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.ChatFormatting;
import twilightforest.TwilightForestMod;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import java.util.List;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import twilightforest.block.entity.TFBlockEntities;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import twilightforest.block.entity.CicadaBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.network.chat.MutableComponent;

public class CicadaBlock extends CritterBlock
{
    private static final MutableComponent TOOLTIP;
    
    protected CicadaBlock(final BlockBehaviour.Properties props) {
        super(props);
    }
    
    @Nullable
    @Override
    public BlockEntity m_142194_(final BlockPos pos, final BlockState state) {
        return new CicadaBlockEntity(pos, state);
    }
    
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> m_142354_(final Level level, final BlockState state, final BlockEntityType<T> type) {
        return (BlockEntityTicker<T>)m_152132_((BlockEntityType)type, (BlockEntityType)TFBlockEntities.CICADA.get(), CicadaBlockEntity::tick);
    }
    
    @Override
    public ItemStack getSquishResult() {
        return new ItemStack((ItemLike)Items.f_42490_, 1);
    }
    
    public void m_6786_(final LevelAccessor pLevel, final BlockPos pPos, final BlockState pState) {
        super.m_6786_(pLevel, pPos, pState);
        if (pLevel.m_5776_()) {
            Minecraft.m_91087_().m_91106_().m_120386_(TFSounds.CICADA.m_11660_(), SoundSource.NEUTRAL);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public void m_5871_(final ItemStack stack, final BlockGetter world, final List<Component> tooltip, final TooltipFlag flag) {
        super.m_5871_(stack, world, (List)tooltip, flag);
        if (ModList.get().isLoaded("immersiveengineering")) {
            tooltip.add((Component)CicadaBlock.TOOLTIP);
        }
    }
    
    static {
        TOOLTIP = new TranslatableComponent("block.twilightforest.cicada.desc").m_130940_(TwilightForestMod.getRarity().f_43022_).m_130940_(ChatFormatting.ITALIC);
    }
}
