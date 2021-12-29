// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.util.Rotation;
import java.util.Random;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import java.util.List;
import net.minecraft.util.Direction;
import twilightforest.TFFeature;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class DarkTowerBossBridgeComponent extends DarkTowerBridgeComponent
{
    public DarkTowerBossBridgeComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(DarkTowerPieces.TFDTBB, nbt);
    }
    
    protected DarkTowerBossBridgeComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(DarkTowerPieces.TFDTBB, feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public boolean makeTowerWing(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, wingSize, direction);
        final DarkTowerBossTrapComponent wing = new DarkTowerBossTrapComponent(this.getFeatureType(), index, dx[0], dx[1], dx[2], wingSize, wingHeight, direction);
        list.add(wing);
        wing.func_74861_a(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
