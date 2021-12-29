// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import twilightforest.TFSounds;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityCow;

public class EntityTFDeer extends EntityCow
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFDeer(final World world) {
        super(world);
        this.func_70105_a(0.7f, 2.3f);
    }
    
    public EntityTFDeer(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIAvoidEntity((EntityCreature)this, (Class)EntityPlayer.class, 16.0f, 1.5, 1.8));
    }
    
    public float func_70047_e() {
        return this.field_70131_O * 0.7f;
    }
    
    protected SoundEvent func_184639_G() {
        return TFSounds.DEER_IDLE;
    }
    
    protected SoundEvent func_184601_bQ(final DamageSource damageSourceIn) {
        return TFSounds.DEER_HURT;
    }
    
    protected SoundEvent func_184615_bR() {
        return TFSounds.DEER_DEATH;
    }
    
    protected void func_180429_a(final BlockPos pos, final Block block) {
    }
    
    public boolean func_184645_a(final EntityPlayer entityplayer, final EnumHand hand) {
        final ItemStack itemstack = entityplayer.func_184586_b(hand);
        return itemstack.func_77973_b() != Items.field_151133_ar && super.func_184645_a(entityplayer, hand);
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFDeer.LOOT_TABLE;
    }
    
    public EntityCow func_90011_a(final EntityAgeable entityanimal) {
        return new EntityTFDeer(this.field_70170_p);
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/deer");
    }
}
