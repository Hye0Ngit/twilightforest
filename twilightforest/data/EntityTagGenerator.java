// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.data;

import twilightforest.TwilightForestMod;
import twilightforest.entity.TFEntities;
import net.minecraft.tags.EntityTypeTags;
import javax.annotation.Nullable;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.entity.EntityType;
import net.minecraft.tags.Tag;
import net.minecraft.data.tags.EntityTypeTagsProvider;

public class EntityTagGenerator extends EntityTypeTagsProvider
{
    public static final Tag.Named<EntityType<?>> BOSSES;
    public static final Tag.Named<EntityType<?>> LICH_POPPABLES;
    public static final Tag.Named<EntityType<?>> RIDES_OBSTRUCT_SNATCHING;
    
    public EntityTagGenerator(final DataGenerator dataGenerator, @Nullable final ExistingFileHelper existingFileHelper) {
        super(dataGenerator, "twilightforest", existingFileHelper);
    }
    
    protected void m_6577_() {
        this.m_126548_(EntityTypeTags.f_13120_).m_126582_((Object)TFEntities.SKELETON_DRUID);
        this.m_126548_(EntityTypeTags.f_13123_).m_126584_((Object[])new EntityType[] { TFEntities.ICE_ARROW, TFEntities.SEEKER_ARROW });
        this.m_126548_(EntityTypeTags.f_144295_).m_126582_((Object)TFEntities.FIRE_BEETLE);
        this.m_126548_((Tag.Named)EntityTagGenerator.BOSSES).m_126584_((Object[])new EntityType[] { TFEntities.NAGA, TFEntities.LICH, TFEntities.MINOSHROOM, TFEntities.HYDRA, TFEntities.KNIGHT_PHANTOM, TFEntities.UR_GHAST, TFEntities.ALPHA_YETI, TFEntities.SNOW_QUEEN, TFEntities.PLATEAU_BOSS });
        this.m_126548_(EntityTypeTags.f_13124_).m_126584_((Object[])new EntityType[] { TFEntities.NATURE_BOLT, TFEntities.LICH_BOLT, TFEntities.WAND_BOLT, TFEntities.LICH_BOMB, TFEntities.CICADA_SHOT, TFEntities.MOONWORM_SHOT, TFEntities.SLIME_BLOB, TFEntities.THROWN_WEP, TFEntities.THROWN_ICE, TFEntities.FALLING_ICE, TFEntities.ICE_SNOWBALL });
        this.m_126548_(EntityTypeTags.f_144291_).m_126584_((Object[])new EntityType[] { TFEntities.PENGUIN, TFEntities.STABLE_ICE_CORE, TFEntities.UNSTABLE_ICE_CORE, TFEntities.SNOW_GUARDIAN, TFEntities.ICE_CRYSTAL }).m_126584_((Object[])new EntityType[] { TFEntities.RAVEN, TFEntities.SQUIRREL, TFEntities.DWARF_RABBIT, TFEntities.TINY_BIRD, TFEntities.KOBOLD, TFEntities.DEATH_TOME, TFEntities.MOSQUITO_SWARM, TFEntities.TOWERWOOD_BORER });
        this.m_126548_(EntityTypeTags.f_144294_).m_126584_((Object[])new EntityType[] { TFEntities.PENGUIN, TFEntities.STABLE_ICE_CORE, TFEntities.UNSTABLE_ICE_CORE, TFEntities.SNOW_GUARDIAN, TFEntities.ICE_CRYSTAL }).m_126584_((Object[])new EntityType[] { TFEntities.WRAITH, TFEntities.KNIGHT_PHANTOM, TFEntities.WINTER_WOLF, TFEntities.YETI }).m_126580_((Tag.Named)EntityTagGenerator.BOSSES);
        this.m_126548_((Tag.Named)EntityTagGenerator.LICH_POPPABLES).m_126580_(EntityTypeTags.f_13120_).m_126584_((Object[])new EntityType[] { EntityType.f_20501_, EntityType.f_20566_, EntityType.f_20479_, EntityType.f_20558_, TFEntities.SWARM_SPIDER });
        this.m_126548_((Tag.Named)EntityTagGenerator.RIDES_OBSTRUCT_SNATCHING).m_126584_((Object[])new EntityType[] { TFEntities.PINCH_BEETLE, TFEntities.YETI, TFEntities.ALPHA_YETI });
    }
    
    static {
        BOSSES = EntityTypeTags.m_13127_(TwilightForestMod.prefix("bosses").toString());
        LICH_POPPABLES = EntityTypeTags.m_13127_(TwilightForestMod.prefix("lich_poppables").toString());
        RIDES_OBSTRUCT_SNATCHING = EntityTypeTags.m_13127_(TwilightForestMod.prefix("rides_obstruct_snatching").toString());
    }
}
