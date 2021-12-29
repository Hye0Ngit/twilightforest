// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.state.Property;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.Rotation;
import java.util.List;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.util.Direction;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class FinalCastleDungeonStepsComponent extends TFStructureComponentOld
{
    public FinalCastleDungeonStepsComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(FinalCastlePieces.TFFCDunSt, nbt);
    }
    
    public FinalCastleDungeonStepsComponent(final TFFeature feature, final Random rand, final int i, final int x, final int y, final int z, final Direction rotation) {
        super(FinalCastlePieces.TFFCDunSt, feature, i);
        this.spawnListIndex = 2;
        this.func_186164_a(rotation);
        this.field_74887_e = TFStructureComponentOld.getComponentToAddBoundingBox2(x, y, z, -2, -15, -3, 5, 15, 20, rotation);
    }
    
    public void func_74861_a(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
    }
    
    public FinalCastleDungeonStepsComponent buildMoreStepsTowards(final StructurePiece parent, final List<StructurePiece> list, final Random rand, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        int sx = 2;
        final int sy = 0;
        int sz = 17;
        switch (rotation) {
            case NONE: {
                sz -= 5;
                break;
            }
            case CLOCKWISE_90: {
                sx -= 5;
                break;
            }
            case CLOCKWISE_180: {
                sz += 5;
                break;
            }
            case COUNTERCLOCKWISE_90: {
                sx += 6;
                break;
            }
        }
        final int dx = this.func_74865_a(sx, sz);
        final int dy = this.func_74862_a(sy);
        final int dz = this.func_74873_b(sx, sz);
        final FinalCastleDungeonStepsComponent steps = new FinalCastleDungeonStepsComponent(this.getFeatureType(), rand, this.field_74886_g + 1, dx, dy, dz, direction);
        list.add(steps);
        steps.func_74861_a(this, list, rand);
        return steps;
    }
    
    public FinalCastleDungeonEntranceComponent buildLevelUnder(final StructurePiece parent, final List<StructurePiece> list, final Random rand, final int level) {
        final int dx = this.func_74865_a(2, 19);
        final int dy = this.func_74862_a(-7);
        final int dz = this.func_74873_b(2, 19);
        final FinalCastleDungeonEntranceComponent room = new FinalCastleDungeonEntranceComponent(this.getFeatureType(), rand, 8, dx, dy, dz, this.func_186165_e(), level);
        list.add(room);
        room.func_74861_a(this, list, rand);
        return room;
    }
    
    public FinalCastleDungeonForgeRoomComponent buildBossRoomUnder(final StructurePiece parent, final List<StructurePiece> list, final Random rand) {
        final int dx = this.func_74865_a(2, 19);
        final int dy = this.func_74862_a(-31);
        final int dz = this.func_74873_b(2, 19);
        final FinalCastleDungeonForgeRoomComponent room = new FinalCastleDungeonForgeRoomComponent(this.getFeatureType(), rand, 8, dx, dy, dz, this.func_186165_e());
        list.add(room);
        room.func_74861_a((StructurePiece)this, (List)list, rand);
        return room;
    }
    
    public boolean func_230383_a_(final ISeedReader world, final StructureManager manager, final ChunkGenerator generator, final Random rand, final MutableBoundingBox sbb, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        final BlockState stairState = (BlockState)this.deco.stairState.func_206870_a((Property)StairsBlock.field_176309_a, (Comparable)Direction.SOUTH);
        for (int z = 0; z < 15; ++z) {
            final int y = 14 - z;
            this.func_175804_a(world, sbb, 0, y, z, 4, y, z, stairState, stairState, false);
            this.func_74878_a(world, sbb, 0, y + 1, z, 4, y + 6, z);
        }
        this.func_74878_a(world, sbb, 0, 0, 15, 4, 5, 19);
        return true;
    }
}
