// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.util.StringRepresentable;
import java.util.Random;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.RenderShape;
import java.util.Locale;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import java.util.Objects;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.Property;
import twilightforest.block.entity.SkullCandleBlockEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import javax.annotation.Nullable;
import com.mojang.authlib.GameProfile;
import net.minecraft.world.level.block.SkullBlock;

public abstract class AbstractSkullCandleBlock extends AbstractLightableBlock
{
    private final SkullBlock.Type type;
    private int candleCount;
    private int color;
    @Nullable
    private GameProfile owner;
    
    public AbstractSkullCandleBlock(final SkullBlock.Type type, final BlockBehaviour.Properties properties) {
        super(properties);
        this.type = type;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public int getCandleCount() {
        return this.candleCount;
    }
    
    public SkullBlock.Type getType() {
        return this.type;
    }
    
    protected abstract Iterable<Vec3> getParticleOffsets(final BlockState p0, final Level p1, final BlockPos p2);
    
    public int getLightEmission(final BlockState state, final BlockGetter world, final BlockPos pos) {
        final BlockEntity 7702_ = world.m_7702_(pos);
        if (7702_ instanceof final SkullCandleBlockEntity sc) {
            switch ((Lighting)state.m_61143_((Property)AbstractSkullCandleBlock.LIGHTING)) {
                case NONE: {
                    return 0;
                }
                case NORMAL: {
                    return 3 * sc.candleAmount;
                }
                case OMINOUS: {
                    return 2 * sc.candleAmount;
                }
            }
        }
        return 0;
    }
    
    @Nullable
    public BlockEntity m_142194_(final BlockPos blockPos, final BlockState blockState) {
        return (BlockEntity)new SkullCandleBlockEntity(blockPos, blockState, this.getColor(), this.getCandleCount());
    }
    
    public static Block candleColorToCandle(final String candleName) {
        if (!candleName.equals(CandleColors.PLAIN.m_7912_())) {
            return Objects.requireNonNull((Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation(candleName + "_candle")));
        }
        return Blocks.f_152482_;
    }
    
    public static CandleColors candleToCandleColor(final Item candle) {
        if (candle != Blocks.f_152482_.m_5456_()) {
            return CandleColors.valueOf(candle.getRegistryName().m_135815_().replace("_candle", "").replace("\"", "").toUpperCase(Locale.ROOT));
        }
        return CandleColors.PLAIN;
    }
    
    public RenderShape m_7514_(final BlockState p_49232_) {
        return RenderShape.INVISIBLE;
    }
    
    public void m_6402_(final Level level, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack stack) {
        super.m_6402_(level, pos, state, placer, stack);
        final BlockEntity 7702_;
        final BlockEntity blockentity = 7702_ = level.m_7702_(pos);
        if (7702_ instanceof final SkullCandleBlockEntity sc) {
            if (stack.m_41782_() && stack.m_41783_() != null) {
                final CompoundTag tag = stack.m_41737_("BlockEntityTag");
                if (tag != null) {
                    if (tag.m_128441_("CandleAmount")) {
                        sc.candleAmount = tag.m_128451_("CandleAmount");
                    }
                    if (tag.m_128441_("CandleColor")) {
                        sc.candleColor = tag.m_128451_("CandleColor");
                    }
                }
                if (this.type == SkullBlock.Types.PLAYER) {
                    GameProfile gameprofile = null;
                    final CompoundTag compoundtag = stack.m_41783_();
                    if (compoundtag.m_128425_("SkullOwner", 10)) {
                        gameprofile = NbtUtils.m_129228_(compoundtag.m_128469_("SkullOwner"));
                    }
                    else if (compoundtag.m_128425_("SkullOwner", 8) && !StringUtils.isBlank((CharSequence)compoundtag.m_128461_("SkullOwner"))) {
                        gameprofile = new GameProfile((UUID)null, compoundtag.m_128461_("SkullOwner"));
                    }
                    sc.m_59769_(gameprofile);
                }
            }
        }
    }
    
    public void m_5707_(final Level world, final BlockPos pos, final BlockState state, final Player player) {
        if (!world.f_46443_ && !player.m_7500_()) {
            final BlockEntity 7702_ = world.m_7702_(pos);
            if (7702_ instanceof final SkullCandleBlockEntity sc) {
                this.color = sc.candleColor;
                this.candleCount = sc.candleAmount;
                this.owner = sc.m_59779_();
            }
        }
        super.m_5707_(world, pos, state, player);
    }
    
    public void m_6240_(final Level world, final Player player, final BlockPos pos, final BlockState state, @Nullable final BlockEntity entity, final ItemStack stack) {
        if (!world.f_46443_ && !player.m_7500_() && world.m_46469_().m_46207_(GameRules.f_46136_) && this.candleCount > 0) {
            if (EnchantmentHelper.m_44843_(Enchantments.f_44985_, stack) > 0) {
                final ItemStack newStack = new ItemStack((ItemLike)this);
                final ItemEntity itementity = new ItemEntity(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), newStack);
                final CompoundTag tag = new CompoundTag();
                tag.m_128405_("CandleColor", this.color);
                tag.m_128405_("CandleAmount", this.candleCount);
                newStack.m_41700_("BlockEntityTag", (Tag)tag);
                if (this.owner != null) {
                    newStack.m_41784_().m_128365_("SkullOwner", (Tag)NbtUtils.m_129230_(new CompoundTag(), this.owner));
                }
                itementity.m_32060_();
                world.m_7967_((Entity)itementity);
            }
            else {
                final ItemStack newStack = new ItemStack((ItemLike)candleColorToCandle(CandleColors.colorFromInt(this.color).m_7912_()), this.candleCount);
                final ItemEntity itementity = new ItemEntity(world, (double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_(), newStack);
                world.m_7967_((Entity)itementity);
            }
        }
        super.m_6240_(world, player, pos, state, entity, stack);
    }
    
    public ItemStack getPickBlock(final BlockState state, final HitResult target, final BlockGetter world, final BlockPos pos, final Player player) {
        final ItemStack newStack = new ItemStack((ItemLike)this);
        final CompoundTag tag = new CompoundTag();
        final BlockEntity 7702_ = world.m_7702_(pos);
        if (7702_ instanceof final SkullCandleBlockEntity sc) {
            if (sc.m_59779_() != null) {
                newStack.m_41784_().m_128365_("SkullOwner", (Tag)NbtUtils.m_129230_(new CompoundTag(), sc.m_59779_()));
            }
            tag.m_128405_("CandleColor", sc.candleColor);
            tag.m_128405_("CandleAmount", sc.candleAmount);
            newStack.m_41700_("BlockEntityTag", (Tag)tag);
        }
        return newStack;
    }
    
    @Override
    public InteractionResult m_6227_(final BlockState state, final Level level, final BlockPos pos, final Player player, final InteractionHand hand, final BlockHitResult result) {
        final BlockEntity 7702_ = level.m_7702_(pos);
        if (7702_ instanceof final SkullCandleBlockEntity sc) {
            if (player.m_21120_(hand).m_150922_((net.minecraft.tags.Tag)ItemTags.f_144319_) && player.m_21120_(hand).m_150930_(candleColorToCandle(CandleColors.colorFromInt(sc.candleColor).m_7912_()).m_5456_()) && !player.m_6144_() && sc.candleAmount < 4) {
                final SkullCandleBlockEntity skullCandleBlockEntity = sc;
                ++skullCandleBlockEntity.candleAmount;
                level.m_5594_((Player)null, pos, SoundEvents.f_144101_, SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!player.m_150110_().f_35937_) {
                    player.m_21120_(hand).m_41774_(1);
                }
                level.m_5518_().m_142202_(pos);
                return InteractionResult.m_19078_(level.f_46443_);
            }
        }
        return super.m_6227_(state, level, pos, player, hand, result);
    }
    
    public void m_7100_(final BlockState state, final Level level, final BlockPos pos, final Random rand) {
        if (state.m_61143_((Property)AbstractSkullCandleBlock.LIGHTING) != Lighting.NONE) {
            this.getParticleOffsets(state, level, pos).forEach(offset -> AbstractLightableBlock.addParticlesAndSound(level, offset.m_82520_((double)pos.m_123341_(), (double)pos.m_123342_(), (double)pos.m_123343_()), rand, state.m_61143_((Property)AbstractSkullCandleBlock.LIGHTING) == Lighting.OMINOUS));
        }
    }
    
    public enum CandleColors implements StringRepresentable
    {
        PLAIN(0), 
        WHITE(1), 
        LIGHT_GRAY(2), 
        GRAY(3), 
        BLACK(4), 
        RED(5), 
        ORANGE(6), 
        YELLOW(7), 
        GREEN(8), 
        LIME(9), 
        BLUE(10), 
        CYAN(11), 
        LIGHT_BLUE(12), 
        PURPLE(13), 
        MAGENTA(14), 
        PINK(15), 
        BROWN(16);
        
        private final int value;
        private static final Map<Integer, CandleColors> map;
        
        private CandleColors(final int value) {
            this.value = value;
        }
        
        public static CandleColors colorFromInt(final int value) {
            return CandleColors.map.get(value);
        }
        
        public int getValue() {
            return this.value;
        }
        
        public String m_7912_() {
            return this.name().toLowerCase(Locale.ROOT);
        }
        
        static {
            map = new HashMap<Integer, CandleColors>();
            for (final CandleColors color : values()) {
                CandleColors.map.put(color.value, color);
            }
        }
    }
}
