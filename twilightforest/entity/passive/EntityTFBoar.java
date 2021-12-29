// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityPig;

public class EntityTFBoar extends EntityPig
{
    public static final ResourceLocation LOOT_TABLE;
    
    public EntityTFBoar(final World world) {
        super(world);
        this.func_70105_a(0.9f, 0.9f);
    }
    
    public EntityTFBoar(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    public ResourceLocation func_184647_J() {
        return EntityTFBoar.LOOT_TABLE;
    }
    
    public EntityPig func_90011_a(final EntityAgeable entityanimal) {
        return new EntityTFBoar(this.field_70170_p);
    }
    
    static {
        LOOT_TABLE = TwilightForestMod.prefix("entities/boar");
    }
}
