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

public class DarkTowerMainBridgeComponent extends DarkTowerBridgeComponent
{
    public DarkTowerMainBridgeComponent(final TemplateManager manager, final CompoundNBT nbt) {
        super(DarkTowerPieces.TFDTMB, nbt);
    }
    
    protected DarkTowerMainBridgeComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(DarkTowerPieces.TFDTMB, feature, i, x, y, z, 15, pHeight, direction);
    }
    
    @Override
    public boolean makeTowerWing(final List<StructurePiece> list, final Random rand, final int index, final int x, final int y, final int z, final int wingSize, final int wingHeight, final Rotation rotation) {
        final Direction direction = this.getStructureRelativeRotation(rotation);
        final int[] dx = this.offsetTowerCoords(x, y, z, 19, direction);
        final DarkTowerMainComponent wing = new DarkTowerMainComponent(this.getFeatureType(), rand, index, dx[0], dx[1], dx[2], direction);
        list.add(wing);
        wing.func_74861_a(this, list, rand);
        this.addOpening(x, y, z, rotation);
        return true;
    }
}
