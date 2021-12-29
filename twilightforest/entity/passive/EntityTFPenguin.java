// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;

public class EntityTFPenguin extends EntityTFBird
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFPenguin(final World world) {
        super(world);
        this.func_70105_a(0.5f, 0.9f);
    }
    
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.75));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIMate((EntityAnimal)this, 1.0));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 0.75, Items.field_151115_aP, false));
        this.field_70714_bg.func_75776_a(4, (EntityAIBase)new EntityAIFollowParent((EntityAnimal)this, 1.149999976158142));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIWander((EntityCreature)this, 1.0));
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, (Class)EntityPlayer.class, 6.0f));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWatchClosest2((EntityLiving)this, (Class)EntityTFPenguin.class, 5.0f, 0.02f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
    }
    
    @Override
    public EntityAnimal createChild(final EntityAgeable entityanimal) {
        return new EntityTFPenguin(this.field_70170_p);
    }
    
    public boolean func_70877_b(final ItemStack stack) {
        return stack.func_77973_b() == Items.field_151115_aP;
    }
    
    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.2);
    }
    
    @Override
    public ResourceLocation func_184647_J() {
        return EntityTFPenguin.LOOT_TABLE;
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/penguin");
    }
}
