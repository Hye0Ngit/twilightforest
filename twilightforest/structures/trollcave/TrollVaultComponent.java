// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.trollcave;

import twilightforest.loot.TFTreasure;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class TrollVaultComponent extends TFStructureComponentOld
{
    public TrollVaultComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(TrollCavePieces.TFTCVa, nbt);
    }
    
    public TrollVaultComponent(final TFFeature feature, final int index, int x, int y, int z) {
        super(TrollCavePieces.TFTCVa, feature, index);
        this.func_186164_a(Direction.SOUTH);
        x = x >> 2 << 2;
        y = y / 4 * 4;
        z = z >> 2 << 2;
        this.spawnListIndex = -1;
        this.field_74887_e = feature.getComponentToAddBoundingBox(x, y, z, -8, 0, -8, 12, 12, 12, Direction.SOUTH);
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        this.func_175804_a(world, sbb, 0, 0, 0, 11, 11, 11, ((Block)TFBlocks.giant_obsidian.get()).func_176223_P(), ((Block)TFBlocks.giant_obsidian.get()).func_176223_P(), false);
        this.func_74878_a(world, sbb, 4, 4, 4, 7, 7, 7);
        this.func_175804_a(world, sbb, 5, 5, 5, 6, 5, 6, Blocks.field_150347_e.func_176223_P(), Blocks.field_150347_e.func_176223_P(), false);
        this.setDoubleLootChest(world, 5, 6, 5, 5, 6, 6, this.func_186165_e().func_176746_e(), TFTreasure.troll_vault, sbb, false);
        this.setDoubleLootChest(world, 6, 6, 5, 6, 6, 6, this.func_186165_e().func_176746_e(), TFTreasure.troll_garden, sbb, false);
        return true;
    }
}
