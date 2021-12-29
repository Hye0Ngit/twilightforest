// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityList;
import twilightforest.entity.boss.EntityTFKnightPhantom;

public class TileEntityTFKnightPhantomsSpawner extends TileEntityTFBossSpawner
{
    private static final int COUNT = 6;
    private int spawned;
    
    public TileEntityTFKnightPhantomsSpawner() {
        super(EntityList.func_191306_a((Class)EntityTFKnightPhantom.class));
        this.spawned = 0;
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final EntityPlayer closestPlayer = this.field_145850_b.func_184137_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, (double)this.getRange(), false);
        return closestPlayer != null && closestPlayer.field_70163_u > this.field_174879_c.func_177956_o() - 2;
    }
    
    @Override
    protected boolean spawnMyBoss() {
        for (int i = this.spawned; i < 6; ++i) {
            final EntityLiving myCreature = this.makeMyCreature();
            final float angle = 60.0f * i;
            final float distance = 4.0f;
            final double rx = this.field_174879_c.func_177958_n() + 0.5 + Math.cos(angle * 3.141592653589793 / 180.0) * 4.0;
            final double ry = this.field_174879_c.func_177956_o();
            final double rz = this.field_174879_c.func_177952_p() + 0.5 + Math.sin(angle * 3.141592653589793 / 180.0) * 4.0;
            myCreature.func_70012_b(rx, ry, rz, this.field_145850_b.field_73012_v.nextFloat() * 360.0f, 0.0f);
            myCreature.func_180482_a(this.field_145850_b.func_175649_E(new BlockPos((Entity)myCreature)), (IEntityLivingData)null);
            if (i == 5 && this.field_145850_b.func_175659_aa() == EnumDifficulty.HARD) {
                myCreature.func_184201_a(EntityEquipmentSlot.OFFHAND, new ItemStack(TFItems.knightmetal_shield));
            }
            this.initializeCreature(myCreature);
            ((EntityTFKnightPhantom)myCreature).setNumber(i);
            if (this.field_145850_b.func_72838_d((Entity)myCreature)) {
                ++this.spawned;
            }
        }
        return this.spawned == 6;
    }
    
    @Override
    protected void initializeCreature(final EntityLiving myCreature) {
        if (myCreature instanceof EntityTFKnightPhantom) {
            ((EntityTFKnightPhantom)myCreature).setHomePosAndDistance(this.field_174879_c, 46);
        }
    }
}
