// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.structures.lichtower.ComponentTFTowerRoof;
import twilightforest.structures.lichtower.ComponentTFTowerWing;
import twilightforest.TwilightForestMod;
import twilightforest.util.RotationUtil;
import net.minecraft.util.Rotation;
import twilightforest.structures.StructureTFComponentOld;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFMushroomTowerMain extends ComponentTFMushroomTowerWing
{
    public ComponentTFMushroomTowerMain() {
    }
    
    public ComponentTFMushroomTowerMain(final TFFeature feature, final World world, final Random rand, final int index, final int x, final int y, final int z) {
        this(feature, world, rand, index, x + 15, y + 4, z + 15, EnumFacing.NORTH);
    }
    
    public ComponentTFMushroomTowerMain(final TFFeature feature, final World world, final Random rand, final int index, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, index, x, y, z, 15, 8 + rand.nextInt(3) * 4, rotation);
        if (this.deco == null) {
            this.deco = new StructureDecoratorMushroomTower();
        }
    }
    
    protected ComponentTFMushroomTowerMain(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, pSize, pHeight, direction);
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        this.addOpening(0, 1, this.size / 2, Rotation.CLOCKWISE_180);
        this.hasBase = true;
        Rotation mainDir = null;
        if (this.func_74877_c() < 3) {
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
                    this.makeBridge(list, rand, this.func_74877_c() + 1, dest[0], dest[1], dest[2], this.size - 4, childHeight, j);
                }
            }
        }
        else {
            this.makeARoof(parent, list, rand);
        }
    }
    
    private Rotation makeAscenderTower(final List<StructureComponent> list, final Random rand) {
        final Rotation mainDir = RotationUtil.ROTATIONS[rand.nextInt(4)];
        final int[] dest = this.getValidOpening(rand, mainDir);
        final int childHeight = this.height - dest[1] + (rand.nextInt(2) + rand.nextInt(2) + 3) * 4 + 1;
        final boolean madeIt = this.makeBridge(list, rand, this.func_74877_c() + 1, dest[0], dest[1], dest[2], this.size - 4, childHeight, mainDir, true);
        if (madeIt) {
            TwilightForestMod.LOGGER.debug("Main tower made a bridge to another tower");
            return mainDir;
        }
        TwilightForestMod.LOGGER.info("Main tower failed to branch off at index {}", (Object)this.field_74886_g);
        return null;
    }
    
    @Override
    public void makeARoof(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        final ComponentTFTowerRoof roof = new ComponentTFTowerRoofMushroom(this.getFeatureType(), this.func_74877_c() + 1, this, 1.6f);
        list.add(roof);
        roof.func_74861_a((StructureComponent)this, (List)list, rand);
    }
    
    @Override
    protected void makeDoorOpening(final World world, final int dx, final int dy, final int dz, final StructureBoundingBox sbb) {
        super.makeDoorOpening(world, dx, dy, dz, sbb);
        if (dx == 0) {
            this.func_175811_a(world, ComponentTFMushroomTowerMain.AIR, dx + 1, dy + 0, dz, sbb);
            this.func_175811_a(world, ComponentTFMushroomTowerMain.AIR, dx + 1, dy + 1, dz, sbb);
        }
        if (dx == this.size - 1) {
            this.func_175811_a(world, ComponentTFMushroomTowerMain.AIR, dx - 1, dy + 0, dz, sbb);
            this.func_175811_a(world, ComponentTFMushroomTowerMain.AIR, dx - 1, dy + 1, dz, sbb);
        }
        if (dz == 0) {
            this.func_175811_a(world, ComponentTFMushroomTowerMain.AIR, dx, dy + 0, dz + 1, sbb);
            this.func_175811_a(world, ComponentTFMushroomTowerMain.AIR, dx, dy + 1, dz + 1, sbb);
        }
        if (dz == this.size - 1) {
            this.func_175811_a(world, ComponentTFMushroomTowerMain.AIR, dx, dy + 0, dz - 1, sbb);
            this.func_175811_a(world, ComponentTFMushroomTowerMain.AIR, dx, dy + 1, dz - 1, sbb);
        }
    }
}
