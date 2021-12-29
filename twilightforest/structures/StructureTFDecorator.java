// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.structures.stronghold.StructureTFDecoratorStronghold;
import twilightforest.structures.mushroomtower.StructureDecoratorMushroomTower;
import twilightforest.structures.icetower.StructureDecoratorIceTower;
import twilightforest.structures.darktower.StructureDecoratorDarkTower;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.block.Block;

public class StructureTFDecorator
{
    public Block blockID;
    public int blockMeta;
    public Block accentID;
    public int accentMeta;
    public Block stairID;
    public int stairMeta;
    public Block fenceID;
    public int fenceMeta;
    public Block pillarID;
    public int pillarMeta;
    public Block platformID;
    public int platformMeta;
    public Block floorID;
    public int floorMeta;
    public StructureComponent.BlockSelector randomBlocks;
    
    public StructureTFDecorator() {
        this.blockID = Blocks.field_150348_b;
        this.accentID = Blocks.field_150347_e;
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
