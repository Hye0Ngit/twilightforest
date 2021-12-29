// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.structures.stronghold.StructureTFDecoratorStronghold;
import twilightforest.structures.mushroomtower.StructureDecoratorMushroomTower;
import twilightforest.structures.icetower.StructureDecoratorIceTower;
import twilightforest.structures.darktower.StructureDecoratorDarkTower;
import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructurePieceBlockSelector;

public class StructureTFDecorator
{
    public int blockID;
    public int blockMeta;
    public int accentID;
    public int accentMeta;
    public int stairID;
    public int stairMeta;
    public int fenceID;
    public int fenceMeta;
    public int pillarID;
    public int pillarMeta;
    public int platformID;
    public int platformMeta;
    public int floorID;
    public int floorMeta;
    public StructurePieceBlockSelector randomBlocks;
    
    public StructureTFDecorator() {
        this.blockID = Block.field_71981_t.field_71990_ca;
        this.accentID = Block.field_71978_w.field_71990_ca;
        this.randomBlocks = new StructureTFStrongholdStones();
    }
    
    public static String getDecoString(final StructureTFDecorator deco) {
        if (deco instanceof StructureDecoratorDarkTower) {
            return "DecoDarkTower";
        }
        if (deco instanceof StructureDecoratorIceTower) {
            return "DecoIceTower";
        }
        if (deco instanceof StructureDecoratorMushroomTower) {
            return "DecoMushroomTower";
        }
        if (deco instanceof StructureTFDecoratorStronghold) {
            return "DecoStronghold";
        }
        return "";
    }
    
    public static StructureTFDecorator getDecoFor(final String decoString) {
        if (decoString.equals("DecoDarkTower")) {
            return new StructureDecoratorDarkTower();
        }
        if (decoString.equals("DecoIceTower")) {
            return new StructureDecoratorIceTower();
        }
        if (decoString.equals("DecoMushroomTower")) {
            return new StructureDecoratorMushroomTower();
        }
        if (decoString.equals("DecoStronghold")) {
            return new StructureTFDecoratorStronghold();
        }
        return new StructureTFDecorator();
    }
}
