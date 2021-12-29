// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.passive;

import java.util.Collections;
import java.util.EnumMap;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.EntityAgeable;
import javax.annotation.Nullable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.world.DifficultyInstance;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.item.EnumDyeColor;
import java.util.Map;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntitySheep;

public class EntityTFBighorn extends EntitySheep
{
    public static final ResourceLocation SHEARED_LOOT_TABLE;
    public static final Map<EnumDyeColor, ResourceLocation> COLORED_LOOT_TABLES;
    
    public EntityTFBighorn(final World world) {
        super(world);
        this.func_70105_a(0.9f, 1.3f);
    }
    
    public EntityTFBighorn(final World world, final double x, final double y, final double z) {
        this(world);
        this.func_70107_b(x, y, z);
    }
    
    public ResourceLocation func_184647_J() {
        return this.func_70892_o() ? EntityTFBighorn.SHEARED_LOOT_TABLE : EntityTFBighorn.COLORED_LOOT_TABLES.get(this.func_175509_cj());
    }
    
    private static EnumDyeColor getRandomFleeceColor(final Random random) {
        return random.nextBoolean() ? EnumDyeColor.BROWN : EnumDyeColor.func_176764_b(random.nextInt(16));
    }
    
    public IEntityLivingData func_180482_a(final DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        livingdata = super.func_180482_a(difficulty, livingdata);
        this.func_175512_b(getRandomFleeceColor(this.field_70170_p.field_73012_v));
        return livingdata;
    }
    
    public EntitySheep func_90011_a(final EntityAgeable ageable) {
        final EntityTFBighorn otherParent = (EntityTFBighorn)ageable;
        final EntityTFBighorn babySheep = new EntityTFBighorn(this.field_70170_p);
        babySheep.func_175512_b(this.func_175511_a((EntityAnimal)this, (EntityAnimal)otherParent));
        return babySheep;
    }
    
    static {
        SHEARED_LOOT_TABLE = TwilightForestMod.prefix("entities/bighorn_sheep/sheared");
        final Map<EnumDyeColor, ResourceLocation> map = new EnumMap<EnumDyeColor, ResourceLocation>(EnumDyeColor.class);
        for (final EnumDyeColor color : EnumDyeColor.values()) {
            map.put(color, TwilightForestMod.prefix("entities/bighorn_sheep/" + color.func_176610_l()));
        }
        COLORED_LOOT_TABLES = Collections.unmodifiableMap((Map<? extends EnumDyeColor, ? extends ResourceLocation>)map);
    }
}
