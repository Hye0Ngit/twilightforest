// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.List;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public abstract class ComponentTFTowerRoof extends StructureTFComponent
{
    protected int size;
    protected int height;
    
    public ComponentTFTowerRoof(final int i, final ComponentTFTowerWing wing) {
        super(i);
        this.spawnListIndex = -1;
    }
    
    protected void makeAttachedOverhangBB(final ComponentTFTowerWing wing) {
        switch (this.getCoordBaseMode()) {
            case 0: {
                this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
                break;
            }
            case 1: {
                this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
                break;
            }
            case 2: {
                this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
                break;
            }
            case 3: {
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
    
    public boolean fits(final ComponentTFTowerWing parent, final List list, final Random rand) {
        return func_74883_a(list, this.field_74887_e) == parent;
    }
}
