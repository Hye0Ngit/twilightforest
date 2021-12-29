// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import twilightforest.TFSounds;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.ITextComponent;
import java.util.Iterator;
import net.minecraft.tileentity.TileEntityType;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.LockableLootTileEntity;

@OnlyIn(value = Dist.CLIENT, _interface = IChestLid.class)
public class KeepsakeCasketTileEntity extends LockableLootTileEntity implements IChestLid, ITickableTileEntity
{
    private static final int limit = 45;
    public NonNullList<ItemStack> contents;
    @Nullable
    public String name;
    @Nullable
    public String casketname;
    @Nullable
    public UUID playeruuid;
    protected float lidAngle;
    protected float prevLidAngle;
    protected int numPlayersUsing;
    private int ticksSinceSync;
    
    public KeepsakeCasketTileEntity() {
        super((TileEntityType)TFTileEntities.KEEPSAKE_CASKET.get());
        this.contents = (NonNullList<ItemStack>)NonNullList.func_191197_a(45, (Object)ItemStack.field_190927_a);
    }
    
    public boolean func_191420_l() {
        for (final ItemStack itemstack : this.contents) {
            if (!itemstack.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public NonNullList<ItemStack> func_190576_q() {
        return this.contents;
    }
    
    public void func_199721_a(final NonNullList<ItemStack> itemsIn) {
        for (int limit = Math.min(this.contents.size(), itemsIn.size()), i = 0; i < limit; ++i) {
            final ItemStack stack = (ItemStack)itemsIn.get(i);
            if (stack != null) {
                this.contents.set(i, itemsIn.get(i));
                itemsIn.set(i, (Object)ItemStack.field_190927_a);
            }
        }
    }
    
    protected ITextComponent func_213907_g() {
        return (ITextComponent)new TranslationTextComponent("block.twilightforest.keepsake_casket");
    }
    
    protected Container func_213906_a(final int id, final PlayerInventory player) {
        return (Container)new ChestContainer(ContainerType.field_221511_e, id, player, (IInventory)this, 5);
    }
    
    public int func_70302_i_() {
        return 45;
    }
    
    public CompoundNBT func_189515_b(final CompoundNBT compound) {
        super.func_189515_b(compound);
        if (!this.func_184282_c(compound)) {
            ItemStackHelper.func_191282_a(compound, (NonNullList)this.contents);
        }
        if (this.playeruuid != null) {
            compound.func_186854_a("deadPlayer", this.playeruuid);
        }
        if (this.casketname != null) {
            compound.func_74778_a("playerName", this.casketname);
        }
        return compound;
    }
    
    public void func_230337_a_(final BlockState state, final CompoundNBT nbt) {
        super.func_230337_a_(state, nbt);
        this.contents = (NonNullList<ItemStack>)NonNullList.func_191197_a(this.func_70302_i_(), (Object)ItemStack.field_190927_a);
        if (!this.func_184283_b(nbt)) {
            ItemStackHelper.func_191283_b(nbt, (NonNullList)this.contents);
        }
        if (nbt.func_186855_b("deadPlayer")) {
            this.playeruuid = nbt.func_186857_a("deadPlayer");
        }
        if (nbt.func_186855_b("playerName")) {
            this.casketname = nbt.func_74779_i("playerName");
        }
    }
    
    public void func_73660_a() {
        if (++this.ticksSinceSync % 20 * 4 == 0) {
            this.field_145850_b.func_175641_c(this.field_174879_c, (Block)TFBlocks.keepsake_casket.get(), 1, this.numPlayersUsing);
        }
        this.prevLidAngle = this.lidAngle;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0f) {
            this.field_145850_b.func_184133_a((PlayerEntity)null, this.field_174879_c, TFSounds.CASKET_OPEN, SoundCategory.BLOCKS, 0.5f, this.field_145850_b.field_73012_v.nextFloat() * 0.1f + 0.9f);
        }
        if ((this.numPlayersUsing == 0 && this.lidAngle > 0.0f) || (this.numPlayersUsing > 0 && this.lidAngle < 1.0f)) {
            final float f2 = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.025f;
            }
            else {
                this.lidAngle -= 0.075f;
            }
            if (this.lidAngle > 1.0f) {
                this.lidAngle = 1.0f;
            }
            if (this.lidAngle < 0.4f && f2 >= 0.4f) {
                this.field_145850_b.func_184133_a((PlayerEntity)null, this.field_174879_c, TFSounds.CASKET_CLOSE, SoundCategory.BLOCKS, 0.75f, this.field_145850_b.field_73012_v.nextFloat() * 0.1f + 0.9f);
            }
            if (this.lidAngle < 0.0f) {
                this.lidAngle = 0.0f;
            }
        }
    }
    
    public boolean func_145842_c(final int id, final int type) {
        if (id == 1) {
            this.numPlayersUsing = type;
            return true;
        }
        return super.func_145842_c(id, type);
    }
    
    public boolean func_70300_a(final PlayerEntity user) {
        if (this.playeruuid != null) {
            return (user.func_211513_k(3) || user.func_146103_bH().getId().equals(this.playeruuid)) && super.func_70300_a(user);
        }
        return super.func_70300_a(user);
    }
    
    public boolean func_213904_e(final PlayerEntity user) {
        if (this.playeruuid == null) {
            return super.func_213904_e(user);
        }
        if (user.func_211513_k(3) || user.func_146103_bH().getId().equals(this.playeruuid)) {
            return super.func_213904_e(user);
        }
        user.func_213823_a(TFSounds.CASKET_LOCKED, SoundCategory.BLOCKS, 0.5f, 0.5f);
        user.func_146105_b((ITextComponent)new TranslationTextComponent("block.twilightforest.casket.locked", new Object[] { this.name }).func_240699_a_(TextFormatting.RED), true);
        return false;
    }
    
    public void func_145843_s() {
        this.playeruuid = null;
        this.func_145836_u();
        super.func_145843_s();
    }
    
    public void func_174889_b(final PlayerEntity player) {
        if (!player.func_175149_v()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.field_145850_b.func_175641_c(this.field_174879_c, (Block)TFBlocks.keepsake_casket.get(), 1, this.numPlayersUsing);
        }
    }
    
    public void func_174886_c(final PlayerEntity player) {
        if (!player.func_175149_v()) {
            --this.numPlayersUsing;
            this.field_145850_b.func_175641_c(this.field_174879_c, (Block)TFBlocks.keepsake_casket.get(), 1, this.numPlayersUsing);
        }
    }
    
    @OnlyIn(Dist.CLIENT)
    public float func_195480_a(final float partialTicks) {
        return MathHelper.func_219799_g(partialTicks, this.prevLidAngle, this.lidAngle);
    }
}
