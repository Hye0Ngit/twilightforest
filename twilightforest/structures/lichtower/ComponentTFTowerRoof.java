// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.world.gen.structure.StructureComponent;
import java.util.List;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.nbt.NBTTagCompound;
import twilightforest.TFFeature;
import twilightforest.structures.StructureTFComponentOld;

public abstract class ComponentTFTowerRoof extends StructureTFComponentOld
{
    protected int size;
    protected int height;
    
    public ComponentTFTowerRoof() {
    }
    
    public ComponentTFTowerRoof(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i);
        this.spawnListIndex = -1;
    }
    
    @Override
    protected void func_143012_a(final NBTTagCompound tagCompound) {
        super.func_143012_a(tagCompound);
        tagCompound.func_74768_a("roofSize", this.size);
        tagCompound.func_74768_a("roofHeight", this.height);
    }
    
    @Override
    protected void func_143011_b(final NBTTagCompound tagCompound, final TemplateManager templateManager) {
        super.func_143011_b(tagCompound, templateManager);
        this.size = tagCompound.func_74762_e("roofSize");
        this.height = tagCompound.func_74762_e("roofHeight");
    }
    
    protected void makeAttachedOverhangBB(final ComponentTFTowerWing wing) {
        switch (this.func_186165_e()) {
            case SOUTH: {
                this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
                break;
            }
            case WEST: {
                this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
                break;
            }
            case EAST: {
                this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
                break;
            }
            case NORTH: {
                this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f);
                break;
            }
        }
    }
    
    protected void makeCapBB(final ComponentTFTowerWing wing) {
        this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c, wing.func_74874_b().field_78893_d, wing.func_74874_b().field_78894_e + this.height, wing.func_74874_b().field_78892_f);
    }
    
    protected void makeOverhangBB(final ComponentTFTowerWing wing) {
        this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
    }
    
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox structureboundingbox) {
        return false;
    }
    
    public boolean fits(final ComponentTFTowerWing parent, final List<StructureComponent> list, final Random rand) {
        return StructureComponent.func_74883_a((List)list, this.field_74887_e) == parent;
    }
}
