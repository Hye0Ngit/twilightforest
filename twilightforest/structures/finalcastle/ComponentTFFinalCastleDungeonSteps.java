// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import net.minecraft.util.Rotation;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFFinalCastleDungeonSteps extends StructureTFComponentOld
{
    public ComponentTFFinalCastleDungeonSteps() {
    }
    
    public ComponentTFFinalCastleDungeonSteps(final Random rand, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        this.spawnListIndex = 2;
        this.func_186164_a(rotation);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox2(x, y, z, -2, -15, -3, 5, 15, 20, rotation);
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    public ComponentTFFinalCastleDungeonSteps buildMoreStepsTowards(final StructureComponent parent, final List<StructureComponent> list, final Random rand, final Rotation rotation) {
        final EnumFacing direction = this.getStructureRelativeRotation(rotation);
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
        final ComponentTFFinalCastleDungeonSteps steps = new ComponentTFFinalCastleDungeonSteps(rand, this.field_74886_g + 1, dx, dy, dz, direction);
        list.add(steps);
        steps.func_74861_a(this, list, rand);
        return steps;
    }
    
    public ComponentTFFinalCastleDungeonEntrance buildLevelUnder(final StructureComponent parent, final List<StructureComponent> list, final Random rand, final int level) {
        final int dx = this.func_74865_a(2, 19);
        final int dy = this.func_74862_a(-7);
        final int dz = this.func_74873_b(2, 19);
        final ComponentTFFinalCastleDungeonEntrance room = new ComponentTFFinalCastleDungeonEntrance(this.getFeatureType(), rand, 8, dx, dy, dz, this.func_186165_e(), level);
        list.add(room);
        room.func_74861_a(this, list, rand);
        return room;
    }
    
    public ComponentTFFinalCastleDungeonForgeRoom buildBossRoomUnder(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final int dx = this.func_74865_a(2, 19);
        final int dy = this.func_74862_a(-31);
        final int dz = this.func_74873_b(2, 19);
        final ComponentTFFinalCastleDungeonForgeRoom room = new ComponentTFFinalCastleDungeonForgeRoom(this.getFeatureType(), rand, 8, dx, dy, dz, this.field_74885_f);
        list.add(room);
        room.func_74861_a((StructureComponent)this, (List)list, rand);
        return room;
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final IBlockState stairState = this.deco.stairState.func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.SOUTH);
        for (int z = 0; z < 15; ++z) {
            final int y = 14 - z;
            this.func_175804_a(world, sbb, 0, y, z, 4, y, z, stairState, stairState, false);
            this.func_74878_a(world, sbb, 0, y + 1, z, 4, y + 6, z);
        }
        this.func_74878_a(world, sbb, 0, 0, 15, 4, 5, 19);
        return true;
    }
}
