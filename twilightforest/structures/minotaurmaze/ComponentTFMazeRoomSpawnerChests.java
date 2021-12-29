// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.TFTreasure;
import twilightforest.entity.TFCreatures;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;

public class ComponentTFMazeRoomSpawnerChests extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomSpawnerChests() {
    }
    
    public ComponentTFMazeRoomSpawnerChests(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        this.placePillarEnclosure(world, sbb, 3, 3);
        this.placePillarEnclosure(world, sbb, 10, 3);
        this.placePillarEnclosure(world, sbb, 3, 10);
        this.placePillarEnclosure(world, sbb, 10, 10);
        this.placeSpawnerAtCurrentPosition(world, rand, 4, 2, 4, TFCreatures.getSpawnerNameFor("Minotaur"), sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 4, 2, 11, TFTreasure.labyrinth_room, sbb);
        this.placeTreasureAtCurrentPosition(world, rand, 11, 2, 4, TFTreasure.labyrinth_room, sbb);
        this.func_74864_a(world, Block.field_72046_aM.field_71990_ca, 0, 11, 1, 11, sbb);
        this.func_74864_a(world, Block.field_72091_am.field_71990_ca, 0, 10, 0, 11, sbb);
        this.func_74864_a(world, Block.field_72091_am.field_71990_ca, 0, 11, 0, 10, sbb);
        this.func_74864_a(world, Block.field_72091_am.field_71990_ca, 0, 11, 0, 12, sbb);
        this.func_74864_a(world, Block.field_72091_am.field_71990_ca, 0, 12, 0, 11, sbb);
        return true;
    }
    
    private void placePillarEnclosure(final World world, final StructureBoundingBox sbb, final int dx, final int dz) {
        for (int y = 1; y < 5; ++y) {
            this.func_74864_a(world, TFBlocks.mazestone.field_71990_ca, 2, dx + 0, y, dz + 0, sbb);
            this.func_74864_a(world, TFBlocks.mazestone.field_71990_ca, 2, dx + 2, y, dz + 0, sbb);
            this.func_74864_a(world, TFBlocks.mazestone.field_71990_ca, 2, dx + 0, y, dz + 2, sbb);
            this.func_74864_a(world, TFBlocks.mazestone.field_71990_ca, 2, dx + 2, y, dz + 2, sbb);
        }
        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, 0, dx + 1, 1, dz + 1, sbb);
        this.func_74864_a(world, Block.field_71988_x.field_71990_ca, 0, dx + 1, 4, dz + 1, sbb);
        this.func_74864_a(world, Block.field_72063_at.field_71990_ca, this.getStairMeta(1), dx + 1, 1, dz + 0, sbb);
        this.func_74864_a(world, Block.field_72063_at.field_71990_ca, this.getStairMeta(0), dx + 0, 1, dz + 1, sbb);
        this.func_74864_a(world, Block.field_72063_at.field_71990_ca, this.getStairMeta(2), dx + 2, 1, dz + 1, sbb);
        this.func_74864_a(world, Block.field_72063_at.field_71990_ca, this.getStairMeta(3), dx + 1, 1, dz + 2, sbb);
        this.func_74864_a(world, Block.field_72063_at.field_71990_ca, this.getStairMeta(1) + 4, dx + 1, 4, dz + 0, sbb);
        this.func_74864_a(world, Block.field_72063_at.field_71990_ca, this.getStairMeta(0) + 4, dx + 0, 4, dz + 1, sbb);
        this.func_74864_a(world, Block.field_72063_at.field_71990_ca, this.getStairMeta(2) + 4, dx + 2, 4, dz + 1, sbb);
        this.func_74864_a(world, Block.field_72063_at.field_71990_ca, this.getStairMeta(3) + 4, dx + 1, 4, dz + 2, sbb);
        this.func_74864_a(world, Block.field_72002_bp.field_71990_ca, 0, dx + 1, 2, dz + 0, sbb);
        this.func_74864_a(world, Block.field_72002_bp.field_71990_ca, 0, dx + 0, 2, dz + 1, sbb);
        this.func_74864_a(world, Block.field_72002_bp.field_71990_ca, 0, dx + 2, 2, dz + 1, sbb);
        this.func_74864_a(world, Block.field_72002_bp.field_71990_ca, 0, dx + 1, 2, dz + 2, sbb);
        this.func_74864_a(world, Block.field_72002_bp.field_71990_ca, 0, dx + 1, 3, dz + 0, sbb);
        this.func_74864_a(world, Block.field_72002_bp.field_71990_ca, 0, dx + 0, 3, dz + 1, sbb);
        this.func_74864_a(world, Block.field_72002_bp.field_71990_ca, 0, dx + 2, 3, dz + 1, sbb);
        this.func_74864_a(world, Block.field_72002_bp.field_71990_ca, 0, dx + 1, 3, dz + 2, sbb);
    }
}
