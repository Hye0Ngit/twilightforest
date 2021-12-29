// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block.entity;

import net.minecraft.util.Mth;
import net.minecraftforge.items.wrapper.EmptyHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import twilightforest.TFSounds;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.ContainerHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import java.util.Iterator;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;

@OnlyIn(value = Dist.CLIENT, _interface = LidBlockEntity.class)
public class KeepsakeCasketBlockEntity extends RandomizableContainerBlockEntity implements LidBlockEntity
{
    private static final int limit = 45;
    public NonNullList<ItemStack> contents;
    @Nullable
    public String f_58622_;
    @Nullable
    public String casketname;
    @Nullable
    public UUID playeruuid;
    protected float lidAngle;
    protected float prevLidAngle;
    protected int numPlayersUsing;
    private int ticksSinceSync;
    
    public KeepsakeCasketBlockEntity(final BlockPos pos, final BlockState state) {
        super((BlockEntityType)TFBlockEntities.KEEPSAKE_CASKET.get(), pos, state);
        this.contents = (NonNullList<ItemStack>)NonNullList.m_122780_(45, (Object)ItemStack.f_41583_);
    }
    
    public boolean m_7983_() {
        for (final ItemStack itemstack : this.contents) {
            if (!itemstack.m_41619_()) {
                return false;
            }
        }
        return true;
    }
    
    public NonNullList<ItemStack> m_7086_() {
        return this.contents;
    }
    
    public void m_6520_(final NonNullList<ItemStack> itemsIn) {
        for (int limit = Math.min(this.contents.size(), itemsIn.size()), i = 0; i < limit; ++i) {
            final ItemStack stack = (ItemStack)itemsIn.get(i);
            if (stack != null) {
                this.contents.set(i, (Object)itemsIn.get(i));
                itemsIn.set(i, (Object)ItemStack.f_41583_);
            }
        }
    }
    
    protected Component m_6820_() {
        return (Component)new TranslatableComponent("block.twilightforest.keepsake_casket");
    }
    
    protected AbstractContainerMenu m_6555_(final int id, final Inventory player) {
        return (AbstractContainerMenu)new ChestMenu(MenuType.f_39961_, id, player, (Container)this, 5);
    }
    
    public int m_6643_() {
        return 45;
    }
    
    public CompoundTag m_6945_(final CompoundTag compound) {
        super.m_6945_(compound);
        if (!this.m_59634_(compound)) {
            ContainerHelper.m_18973_(compound, (NonNullList)this.contents);
        }
        if (this.playeruuid != null) {
            compound.m_128362_("deadPlayer", this.playeruuid);
        }
        if (this.casketname != null) {
            compound.m_128359_("playerName", this.casketname);
        }
        return compound;
    }
    
    public void m_142466_(final CompoundTag nbt) {
        super.m_142466_(nbt);
        this.contents = (NonNullList<ItemStack>)NonNullList.m_122780_(this.m_6643_(), (Object)ItemStack.f_41583_);
        if (!this.m_59631_(nbt)) {
            ContainerHelper.m_18980_(nbt, (NonNullList)this.contents);
        }
        if (nbt.m_128403_("deadPlayer")) {
            this.playeruuid = nbt.m_128342_("deadPlayer");
        }
        if (nbt.m_128403_("playerName")) {
            this.casketname = nbt.m_128461_("playerName");
        }
    }
    
    public static void tick(final Level level, final BlockPos pos, final BlockState state, final KeepsakeCasketBlockEntity te) {
        if (++te.ticksSinceSync % 20 * 4 == 0) {
            level.m_7696_(pos, (Block)TFBlocks.KEEPSAKE_CASKET.get(), 1, te.numPlayersUsing);
        }
        te.prevLidAngle = te.lidAngle;
        if (te.numPlayersUsing > 0 && te.lidAngle == 0.0f) {
            level.m_5594_((Player)null, pos, TFSounds.CASKET_OPEN, SoundSource.BLOCKS, 0.5f, level.f_46441_.nextFloat() * 0.1f + 0.9f);
        }
        if ((te.numPlayersUsing == 0 && te.lidAngle > 0.0f) || (te.numPlayersUsing > 0 && te.lidAngle < 1.0f)) {
            final float f2 = te.lidAngle;
            if (te.numPlayersUsing > 0) {
                te.lidAngle += 0.025f;
            }
            else {
                te.lidAngle -= 0.075f;
            }
            if (te.lidAngle > 1.0f) {
                te.lidAngle = 1.0f;
            }
            if (te.lidAngle < 0.4f && f2 >= 0.4f) {
                level.m_5594_((Player)null, pos, TFSounds.CASKET_CLOSE, SoundSource.BLOCKS, 0.75f, level.f_46441_.nextFloat() * 0.1f + 0.9f);
            }
            if (te.lidAngle < 0.0f) {
                te.lidAngle = 0.0f;
            }
        }
    }
    
    public boolean m_7531_(final int id, final int type) {
        if (id == 1) {
            this.numPlayersUsing = type;
            return true;
        }
        return super.m_7531_(id, type);
    }
    
    public boolean m_6542_(final Player user) {
        if (this.playeruuid != null) {
            return (user.m_20310_(3) || user.m_36316_().getId().equals(this.playeruuid)) && super.m_6542_(user);
        }
        return super.m_6542_(user);
    }
    
    public boolean m_7525_(final Player user) {
        if (this.playeruuid == null) {
            return super.m_7525_(user);
        }
        if (user.m_20310_(3) || user.m_36316_().getId().equals(this.playeruuid)) {
            return super.m_7525_(user);
        }
        user.m_6330_(TFSounds.CASKET_LOCKED, SoundSource.BLOCKS, 0.5f, 0.5f);
        user.m_5661_((Component)new TranslatableComponent("block.twilightforest.casket.locked", new Object[] { this.f_58622_ }).m_130940_(ChatFormatting.RED), true);
        return false;
    }
    
    protected IItemHandler createUnSidedHandler() {
        return (IItemHandler)new EmptyHandler();
    }
    
    public void m_7651_() {
        this.playeruuid = null;
        this.invalidateCaps();
        super.m_7651_();
    }
    
    public void m_5856_(final Player player) {
        if (!player.m_5833_()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.f_58857_.m_7696_(this.f_58858_, (Block)TFBlocks.KEEPSAKE_CASKET.get(), 1, this.numPlayersUsing);
        }
    }
    
    public void m_5785_(final Player player) {
        if (!player.m_5833_()) {
            --this.numPlayersUsing;
            this.f_58857_.m_7696_(this.f_58858_, (Block)TFBlocks.KEEPSAKE_CASKET.get(), 1, this.numPlayersUsing);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public float m_6683_(final float partialTicks) {
        return Mth.m_14179_(partialTicks, this.prevLidAngle, this.lidAngle);
    }
}
