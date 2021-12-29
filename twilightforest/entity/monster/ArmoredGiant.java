// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.monster;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntityType;

public class ArmoredGiant extends GiantMiner
{
    public ArmoredGiant(final EntityType<? extends ArmoredGiant> type, final Level world) {
        super(type, world);
    }
    
    @Override
    protected void m_6851_(final DifficultyInstance difficulty) {
        super.m_6851_(difficulty);
        this.m_8061_(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.f_42425_));
        this.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)Items.f_42468_));
        this.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)Items.f_42469_));
        this.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)Items.f_42470_));
        this.m_8061_(EquipmentSlot.FEET, new ItemStack((ItemLike)Items.f_42471_));
    }
}
