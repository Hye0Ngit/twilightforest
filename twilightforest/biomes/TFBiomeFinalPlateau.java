// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.biomes;

import twilightforest.TFAchievementPage;
import net.minecraft.stats.Achievement;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import twilightforest.entity.passive.EntityTFRaven;
import twilightforest.block.TFBlocks;

public class TFBiomeFinalPlateau extends TFBiomeBase
{
    public TFBiomeFinalPlateau(final int i) {
        super(i);
        this.field_76752_A = TFBlocks.deadrock;
        this.field_150604_aj = 0;
        this.field_76753_B = TFBlocks.deadrock;
        this.field_76754_C = 1;
        this.field_76750_F = 0.3f;
        this.field_76751_G = 0.2f;
        this.getTFBiomeDecorator().canopyPerChunk = -999.0f;
        this.getTFBiomeDecorator().setTreesPerChunk(-999);
        this.field_76760_I.field_76808_K = false;
        this.field_76762_K.clear();
        this.field_76762_K.add(new BiomeGenBase.SpawnListEntry((Class)EntityTFRaven.class, 10, 4, 4));
    }
    
    @Override
    public Block getStoneReplacementBlock() {
        return TFBlocks.deadrock;
    }
    
    @Override
    public byte getStoneReplacementMeta() {
        return 2;
    }
    
    @Override
    protected Achievement getRequiredAchievement() {
        return TFAchievementPage.twilightProgressGlacier;
    }
}
