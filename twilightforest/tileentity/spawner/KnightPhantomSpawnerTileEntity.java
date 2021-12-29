// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity.spawner;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import twilightforest.item.TFItems;
import net.minecraft.util.IItemProvider;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.Difficulty;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import net.minecraft.entity.player.PlayerEntity;
import twilightforest.entity.TFEntities;
import twilightforest.tileentity.TFTileEntities;
import net.minecraft.tileentity.TileEntityType;
import twilightforest.entity.boss.KnightPhantomEntity;

public class KnightPhantomSpawnerTileEntity extends BossSpawnerTileEntity<KnightPhantomEntity>
{
    private static final int COUNT = 6;
    private int spawned;
    
    public KnightPhantomSpawnerTileEntity() {
        super((TileEntityType<?>)TFTileEntities.KNIGHT_PHANTOM_SPAWNER.get(), TFEntities.knight_phantom);
        this.spawned = 0;
    }
    
    @Override
    public boolean anyPlayerInRange() {
        final PlayerEntity closestPlayer = this.field_145850_b.func_217366_a(this.field_174879_c.func_177958_n() + 0.5, this.field_174879_c.func_177956_o() + 0.5, this.field_174879_c.func_177952_p() + 0.5, (double)this.getRange(), false);
        return closestPlayer != null && closestPlayer.func_226278_cu_() > this.field_174879_c.func_177956_o() - 2;
    }
    
    @Override
    protected boolean spawnMyBoss(final IServerWorld world) {
        for (int i = this.spawned; i < 6; ++i) {
            final KnightPhantomEntity myCreature = this.makeMyCreature();
            final float angle = 60.0f * i;
            final float distance = 4.0f;
            final double rx = this.field_174879_c.func_177958_n() + 0.5 + Math.cos(angle * 3.141592653589793 / 180.0) * 4.0;
            final double ry = this.field_174879_c.func_177956_o();
            final double rz = this.field_174879_c.func_177952_p() + 0.5 + Math.sin(angle * 3.141592653589793 / 180.0) * 4.0;
            myCreature.func_70012_b(rx, ry, rz, world.func_201672_e().field_73012_v.nextFloat() * 360.0f, 0.0f);
            myCreature.func_213386_a(world, world.func_175649_E(new BlockPos((Vector3i)myCreature.func_233580_cy_())), SpawnReason.SPAWNER, null, null);
            if (i == 5 && world.func_175659_aa() == Difficulty.HARD) {
                myCreature.func_184201_a(EquipmentSlotType.OFFHAND, new ItemStack((IItemProvider)TFItems.knightmetal_shield.get()));
            }
            this.initializeCreature(myCreature);
            myCreature.setNumber(i);
            if (world.func_217376_c((Entity)myCreature)) {
                ++this.spawned;
            }
        }
        return this.spawned == 6;
    }
}
