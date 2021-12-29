// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.world.gen.feature.structure.StructurePiece;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import java.util.Random;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.math.MutableBoundingBox;
import twilightforest.TFFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.gen.feature.template.TemplateManager;
import twilightforest.structures.TFStructureComponentOld;

public class TowerRoofComponent extends TFStructureComponentOld
{
    protected int size;
    protected int height;
    
    public TowerRoofComponent(final TemplateManager manager, final CompoundNBT nbt) {
        this(LichTowerPieces.TFLTRoo, nbt);
    }
    
    public TowerRoofComponent(final IStructurePieceType piece, final CompoundNBT nbt) {
        super(piece, nbt);
        this.size = nbt.func_74762_e("roofSize");
        this.height = nbt.func_74762_e("roofHeight");
    }
    
    public TowerRoofComponent(final IStructurePieceType type, final TFFeature feature, final int i) {
        super(type, feature, i);
        this.spawnListIndex = -1;
    }
    
    @Override
    protected void func_143011_b(final CompoundNBT tagCompound) {
        super.func_143011_b(tagCompound);
        tagCompound.func_74768_a("roofSize", this.size);
        tagCompound.func_74768_a("roofHeight", this.height);
    }
    
    protected void makeAttachedOverhangBB(final TowerWingComponent wing) {
        switch (this.func_186165_e()) {
            case SOUTH: {
                this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
                break;
            }
            case WEST: {
                this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
                break;
            }
            case EAST: {
                this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
                break;
            }
            case NORTH: {
                this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f);
                break;
            }
        }
    }
    
    protected void makeCapBB(final TowerWingComponent wing) {
        this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c, wing.func_74874_b().field_78893_d, wing.func_74874_b().field_78894_e + this.height, wing.func_74874_b().field_78892_f);
    }
    
    protected void makeOverhangBB(final TowerWingComponent wing) {
        this.field_74887_e = new MutableBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
    }
    
    public boolean func_230383_a_(final ISeedReader worldIn, final StructureManager manager, final ChunkGenerator generator, final Random randomIn, final MutableBoundingBox structureBoundingBoxIn, final ChunkPos chunkPosIn, final BlockPos blockPos) {
        return false;
    }
    
    public boolean fits(final TowerWingComponent parent, final List<StructurePiece> list) {
        return StructurePiece.func_74883_a((List)list, this.field_74887_e) == parent;
    }
}
