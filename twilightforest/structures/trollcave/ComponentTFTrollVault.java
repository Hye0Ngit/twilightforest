// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.loot.TFTreasure;
import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFTrollVault extends StructureTFComponentOld
{
    public ComponentTFTrollVault() {
    }
    
    public ComponentTFTrollVault(final TFFeature feature, final int index, int x, int y, int z) {
        super(feature, index);
        this.func_186164_a(EnumFacing.SOUTH);
        x = x >> 2 << 2;
        y = y / 4 * 4;
        z = z >> 2 << 2;
        this.spawnListIndex = -1;
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, -8, 0, -8, 12, 12, 12, EnumFacing.SOUTH);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_175804_a(world, sbb, 0, 0, 0, 11, 11, 11, TFBlocks.giant_obsidian.func_176223_P(), TFBlocks.giant_obsidian.func_176223_P(), false);
        this.func_74878_a(world, sbb, 4, 4, 4, 7, 7, 7);
        this.func_175804_a(world, sbb, 5, 5, 5, 6, 5, 6, Blocks.field_150347_e.func_176223_P(), Blocks.field_150347_e.func_176223_P(), false);
        this.func_175811_a(world, Blocks.field_150486_ae.func_176223_P(), 5, 6, 5, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 5, 6, 6, TFTreasure.troll_vault, false, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 6, 6, 5, TFTreasure.troll_garden, true, sbb);
        this.func_175811_a(world, Blocks.field_150447_bR.func_176223_P(), 6, 6, 6, sbb);
        return true;
    }
}
