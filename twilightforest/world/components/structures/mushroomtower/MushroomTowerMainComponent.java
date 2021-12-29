// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.mushroomtower;

import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.WorldGenLevel;
import twilightforest.world.components.structures.lichtower.TowerRoofComponent;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import twilightforest.world.components.structures.lichtower.TowerWingComponent;
import twilightforest.TwilightForestMod;
import twilightforest.util.RotationUtil;
import net.minecraft.world.level.block.Rotation;
import twilightforest.world.components.structures.TFStructureComponentOld;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.core.Direction;
import java.util.Random;
import twilightforest.world.registration.TFFeature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;

public class MushroomTowerMainComponent extends MushroomTowerWingComponent
{
    public MushroomTowerMainComponent(final ServerLevel level, final CompoundTag nbt) {
        super(MushroomTowerPieces.TFMTMai, nbt);
    }
    
    public MushroomTowerMainComponent(final TFFeature feature, final Random rand, final int index, final int x, final int y, final int z) {
        this(feature, rand, index, x + 15, y + 4, z + 15, Direction.NORTH);
    }
    
    public MushroomTowerMainComponent(final TFFeature feature, final Random rand, final int index, final int x, final int y, final int z, final Direction rotation) {
        super(MushroomTowerPieces.TFMTMai, feature, index, x, y, z, 15, 8 + rand.nextInt(3) * 4, rotation);
        if (this.deco == null) {
            this.deco = new MushroomTowerDecorator();
        }
    }
    
    protected MushroomTowerMainComponent(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final Direction direction) {
        super(MushroomTowerPieces.TFMTMai, feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void m_142537_(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        if (parent != null && parent instanceof TFStructureComponentOld) {
            this.deco = ((TFStructureComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.hasBase = true;
        Rotation mainDir = null;
        if (this.m_73548_() < 3) {
            for (int i = 0; i < 6; ++i) {
                mainDir = this.makeAscenderTower(list, rand);
                if (mainDir != null) {
                    break;
                }
            }
            for (final Rotation j : RotationUtil.ROTATIONS) {
                if (j != mainDir) {
                    final int[] dest = this.getValidOpening(rand, j);
                    final int childHeight = (rand.nextInt(2) + rand.nextInt(2) + 2) * 4 + 1;
                    this.makeBridge(list, rand, this.m_73548_() + 1, dest[0], dest[1], dest[2], this.size - 4, childHeight, j);
                }
            }
        }
        else {
            this.makeARoof(parent, list, rand);
        }
    }
    
    private Rotation makeAscenderTower(final StructurePieceAccessor list, final Random rand) {
        final Rotation mainDir = RotationUtil.ROTATIONS[rand.nextInt(4)];
        final int[] dest = this.getValidOpening(rand, mainDir);
        final int childHeight = this.height - dest[1] + (rand.nextInt(2) + rand.nextInt(2) + 3) * 4 + 1;
        final boolean madeIt = this.makeBridge(list, rand, this.m_73548_() + 1, dest[0], dest[1], dest[2], this.size - 4, childHeight, mainDir, true);
        if (madeIt) {
            TwilightForestMod.LOGGER.debug("Main tower made a bridge to another tower");
            return mainDir;
        }
        TwilightForestMod.LOGGER.info("Main tower failed to branch off at index {}", (Object)this.f_73384_);
        return null;
    }
    
    @Override
    public void makeARoof(final StructurePiece parent, final StructurePieceAccessor list, final Random rand) {
        final TowerRoofComponent roof = new TowerRoofMushroomComponent(this.getFeatureType(), this.m_73548_() + 1, this, 1.6f, this.m_142171_().m_123341_(), this.m_142171_().m_123342_(), this.m_142171_().m_123343_());
        if (list instanceof StructureStart) {
            final StructureStart<?> start = (StructureStart<?>)list;
            start.m_73602_().add(roof);
        }
        roof.m_142537_((StructurePiece)this, list, rand);
    }
    
    @Override
    protected void makeDoorOpening(final WorldGenLevel world, final int dx, final int dy, final int dz, final BoundingBox sbb) {
        super.makeDoorOpening(world, dx, dy, dz, sbb);
        if (dx == 0) {
            this.m_73434_(world, MushroomTowerMainComponent.AIR, dx + 1, dy, dz, sbb);
            this.m_73434_(world, MushroomTowerMainComponent.AIR, dx + 1, dy + 1, dz, sbb);
        }
        if (dx == this.size - 1) {
            this.m_73434_(world, MushroomTowerMainComponent.AIR, dx - 1, dy, dz, sbb);
            this.m_73434_(world, MushroomTowerMainComponent.AIR, dx - 1, dy + 1, dz, sbb);
        }
        if (dz == 0) {
            this.m_73434_(world, MushroomTowerMainComponent.AIR, dx, dy, dz + 1, sbb);
            this.m_73434_(world, MushroomTowerMainComponent.AIR, dx, dy + 1, dz + 1, sbb);
        }
        if (dz == this.size - 1) {
            this.m_73434_(world, MushroomTowerMainComponent.AIR, dx, dy, dz - 1, sbb);
            this.m_73434_(world, MushroomTowerMainComponent.AIR, dx, dy + 1, dz - 1, sbb);
        }
    }
}
