// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.util.Rotation;
import twilightforest.util.RotationUtil;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.math.MutableBoundingBox;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class FinalCastleBossGazeboComponent extends TFStructureComponentOld
{
    public FinalCastleBossGazeboComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCBoGaz, nbt);
    }
    
    public FinalCastleBossGazeboComponent(final TFFeature feature, final Random rand, final int i, final TFStructureComponentOld keep) {
        super(FinalCastlePieces.TFFCBoGaz, feature, i);
        this.spawnListIndex = -1;
        this.func_186164_a(keep.func_186165_e());
        this.field_74887_e = new MutableBoundingBox(keep.func_74874_b().field_78897_a + 14, keep.func_74874_b().field_78894_e + 2, keep.func_74874_b().field_78896_c + 14, keep.func_74874_b().field_78893_d - 14, keep.func_74874_b().field_78894_e + 13, keep.func_74874_b().field_78892_f - 14);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        this.deco = new StructureTFDecoratorCastle();
        this.deco.blockState = ((Block)TFBlocks.castle_rune_brick_blue.get()).func_176223_P();
        this.deco.fenceState = ((Block)TFBlocks.force_field_purple.get()).func_176223_P();
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random randomIn, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        for (final Rotation rotation : RotationUtil.ROTATIONS) {
            this.fillBlocksRotated(world, sbb, 0, 0, 0, 0, 10, 20, this.deco.fenceState, rotation);
        }
        this.func_175804_a(world, sbb, 0, 11, 0, 20, 11, 20, this.deco.fenceState, this.deco.fenceState, false);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "Final Boss Here", true, 2.3f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "You win!", true, 2.0f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "You can join the Twilight Forest Discord server to follow", true, 1.0f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "the latest updates on this castle and other content at:", true, 0.7f);
        this.setInvisibleTextEntity(world, 10, 0, 10, sbb, "discord.experiment115.com", true, 0.4f);
        this.func_175811_a(world, ((Block)TFBlocks.boss_spawner_final_boss.get()).func_176223_P(), 10, 1, 10, sbb);
        return true;
    }
}
