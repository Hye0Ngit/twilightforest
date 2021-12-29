// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.BlockState;
import net.minecraft.util.Rotation;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.loot.TFTreasure;
import net.minecraft.block.Blocks;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class MazeRoomBossComponent extends MazeRoomComponent
{
    public MazeRoomBossComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(MinotaurMazePieces.TFMMRB, nbt);
    }
    
    public MazeRoomBossComponent(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(MinotaurMazePieces.TFMMRB, feature, i, rand, x, y, z);
    }
    
    @Override
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        if (this.func_175807_a((IBlockReader)world, 7, 1, 0, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 6, 1, 0, 9, 4, 0, Blocks.field_180407_aO.func_176223_P(), MazeRoomBossComponent.AIR, false);
        }
        if (this.func_175807_a((IBlockReader)world, 7, 1, 15, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 6, 1, 15, 9, 4, 15, Blocks.field_180407_aO.func_176223_P(), MazeRoomBossComponent.AIR, false);
        }
        if (this.func_175807_a((IBlockReader)world, 0, 1, 7, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 0, 1, 6, 0, 4, 9, Blocks.field_180407_aO.func_176223_P(), MazeRoomBossComponent.AIR, false);
        }
        if (this.func_175807_a((IBlockReader)world, 15, 1, 7, sbb).func_177230_c() == Blocks.field_150350_a) {
            this.func_175804_a(world, sbb, 15, 1, 6, 15, 4, 9, Blocks.field_180407_aO.func_176223_P(), MazeRoomBossComponent.AIR, false);
        }
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                final boolean mycelium = rand.nextInt(dist + 1) > 0;
                final boolean mushroom = rand.nextInt(dist) > 0;
                final boolean mushRed = rand.nextBoolean();
                if (mycelium) {
                    this.func_175811_a(world, Blocks.field_150391_bh.func_176223_P(), x, 0, z, sbb);
                }
                if (mushroom) {
                    this.func_175811_a(world, (mushRed ? Blocks.field_150337_Q : Blocks.field_150338_P).func_176223_P(), x, 1, z, sbb);
                }
            }
        }
        final BlockState redMushroom = Blocks.field_150419_aX.func_176223_P();
        final BlockState brownMushroom = Blocks.field_150420_aW.func_176223_P();
        this.func_175804_a(world, sbb, 1, 1, 1, 3, 1, 3, redMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 1, 2, 1, 1, 3, 4, redMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 2, 2, 1, 4, 3, 1, redMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 1, 4, 1, 3, 4, 3, redMushroom, MazeRoomBossComponent.AIR, false);
        this.placeTreasureAtCurrentPosition(world, 3, 2, 3, TFTreasure.labyrinth_room, sbb);
        this.func_175804_a(world, sbb, 12, 1, 12, 14, 1, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 14, 2, 11, 14, 3, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 11, 2, 14, 14, 3, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 12, 4, 12, 14, 4, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.placeTreasureAtCurrentPosition(world, 12, 2, 12, TFTreasure.labyrinth_room, sbb);
        this.func_175804_a(world, sbb, 1, 1, 12, 3, 1, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 1, 2, 11, 1, 3, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 2, 2, 14, 4, 3, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 1, 4, 12, 3, 4, 14, redMushroom, MazeRoomBossComponent.AIR, false);
        this.placeTreasureAtCurrentPosition(world, 3, 2, 12, TFTreasure.labyrinth_room, sbb);
        this.func_175804_a(world, sbb, 12, 1, 1, 14, 1, 3, brownMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 11, 2, 1, 14, 3, 1, brownMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 14, 2, 2, 14, 3, 4, brownMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 12, 4, 1, 14, 4, 3, brownMushroom, MazeRoomBossComponent.AIR, false);
        this.placeTreasureAtCurrentPosition(world, 12, 2, 3, TFTreasure.labyrinth_room, sbb);
        this.func_175804_a(world, sbb, 5, 4, 5, 7, 5, 7, brownMushroom, MazeRoomBossComponent.AIR, false);
        this.func_175804_a(world, sbb, 8, 4, 8, 10, 5, 10, redMushroom, MazeRoomBossComponent.AIR, false);
        final BlockState taurSpawner = ((Block)TFBlocks.boss_spawner_minoshroom.get()).func_176223_P();
        this.setBlockStateRotated(world, taurSpawner, 7, 1, 7, Rotation.NONE, sbb);
        return true;
    }
}
