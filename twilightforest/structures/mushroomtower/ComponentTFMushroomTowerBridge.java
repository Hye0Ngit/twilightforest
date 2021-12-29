// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.mushroomtower;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.TwilightForestMod;
import net.minecraft.util.Rotation;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.structures.StructureTFComponentOld;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFMushroomTowerBridge extends ComponentTFMushroomTowerWing
{
    int dSize;
    int dHeight;
    
    public ComponentTFMushroomTowerBridge() {
    }
    
    protected ComponentTFMushroomTowerBridge(final TFFeature feature, final int i, final int x, final int y, final int z, final int pSize, final int pHeight, final EnumFacing direction) {
        super(feature, i, x, y, z, pSize, pHeight, direction);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, this.size - 1, this.height - 1, 3, direction);
        this.dSize = pSize;
        this.dHeight = pHeight;
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("destSize", this.dSize);
        tagCompound.func_74768_a("destHeight", this.dHeight);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.dSize = tagCompound.func_74762_e("destSize");
        this.dHeight = tagCompound.func_74762_e("destHeight");
    }
    
    @Override
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
        final int[] dest = { this.dSize - 1, 1, 1 };
        final boolean madeWing = this.makeTowerWing(list, rand, this.func_74877_c(), dest[0], dest[1], dest[2], this.dSize, this.dHeight, Rotation.NONE);
        if (!madeWing) {
            final int[] dx = this.offsetTowerCoords(dest[0], dest[1], dest[2], this.dSize, EnumFacing.SOUTH);
            TwilightForestMod.LOGGER.info("Making tower wing failed when bridge was already made.  Size = {}, x = {}, z = {}", (Object)this.dSize, (Object)dx[0], (Object)dx[2]);
        }
    }
    
    public StructureBoundingBox getWingBB() {
        final int[] dest = this.offsetTowerCoords(this.dSize - 1, 1, 1, this.dSize, this.func_186165_e());
        return StructureTFComponentOld.getComponentToAddBoundingBox(dest[0], dest[1], dest[2], 0, 0, 0, this.dSize - 1, this.dHeight - 1, this.dSize - 1, this.func_186165_e());
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 0; x < this.dSize; ++x) {
            this.func_175811_a(world, this.deco.fenceState, x, 1, 0, sbb);
            this.func_175811_a(world, this.deco.fenceState, x, 1, 2, sbb);
            this.func_175811_a(world, this.isAscender ? this.deco.floorState.func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.JUNGLE) : this.deco.floorState, x, 0, 1, sbb);
        }
        this.func_74878_a(world, sbb, 0, 1, 1, 2, 2, 1);
        return true;
    }
}
