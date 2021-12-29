// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public class ComponentTFIceTowerBridge extends StructureTFComponentOld
{
    private int length;
    
    public ComponentTFIceTowerBridge() {
    }
    
    public ComponentTFIceTowerBridge(final TFFeature feature, final int index, final int x, final int y, final int z, final int length, final EnumFacing direction) {
        super(feature, index);
        this.length = length;
        this.func_186164_a(direction);
        this.field_74887_e = StructureTFComponentOld.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, length, 6, 5, direction);
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("bridgeLength", this.length);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.length = tagCompound.func_74762_e("bridgeLength");
    }
    
    public void func_74861_a(final StructureComponent parent, final List<StructureComponent> list, final Random rand) {
        if (parent != null && parent instanceof StructureTFComponentOld) {
            this.deco = ((StructureTFComponentOld)parent).deco;
        }
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74878_a(world, sbb, 0, 1, 0, this.length, 5, 4);
        this.func_175804_a(world, sbb, 0, 0, 0, this.length, 0, 4, this.deco.blockState, this.deco.blockState, false);
        this.func_175804_a(world, sbb, 0, 6, 0, this.length, 6, 4, this.deco.blockState, this.deco.blockState, false);
        for (int x = 2; x < this.length; x += 3) {
            this.func_175804_a(world, sbb, x, 1, 0, x, 5, 0, this.deco.pillarState, this.deco.pillarState, false);
            this.func_175804_a(world, sbb, x, 1, 4, x, 5, 4, this.deco.pillarState, this.deco.pillarState, false);
        }
        return true;
    }
}
