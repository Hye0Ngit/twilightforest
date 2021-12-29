// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.structures.finalcastle.StructureTFDecoratorCastle;
import twilightforest.structures.stronghold.StrongholdDecorator;
import twilightforest.structures.mushroomtower.MushroomTowerDecorator;
import twilightforest.structures.icetower.IceTowerDecorator;
import twilightforest.structures.darktower.StructureDecoratorDarkTower;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.block.BlockState;

public class TFStructureDecorator
{
    public BlockState blockState;
    public BlockState accentState;
    public BlockState stairState;
    public BlockState fenceState;
    public BlockState pillarState;
    public BlockState platformState;
    public BlockState floorState;
    public BlockState roofState;
    public StructurePiece.BlockSelector randomBlocks;
    
    public TFStructureDecorator() {
        this.blockState = Blocks.field_150348_b.func_176223_P();
        this.accentState = Blocks.field_150347_e.func_176223_P();
        this.stairState = Blocks.field_222438_lb.func_176223_P();
        this.fenceState = Blocks.field_180407_aO.func_176223_P();
        this.pillarState = Blocks.field_196696_di.func_176223_P();
        this.platformState = Blocks.field_150333_U.func_176223_P();
        this.floorState = Blocks.field_196696_di.func_176223_P();
        this.roofState = Blocks.field_196696_di.func_176223_P();
        this.randomBlocks = new StrongholdStones();
    }
    
    public static String getDecoString(final TFStructureDecorator deco) {
        if (deco instanceof StructureDecoratorDarkTower) {
            return "DecoDarkTower";
        }
        if (deco instanceof IceTowerDecorator) {
            return "DecoIceTower";
        }
        if (deco instanceof MushroomTowerDecorator) {
            return "DecoMushroomTower";
        }
        if (deco instanceof StrongholdDecorator) {
            return "DecoStronghold";
        }
        if (deco instanceof StructureTFDecoratorCastle) {
            return "DecoCastle";
        }
        return "";
    }
    
    public static TFStructureDecorator getDecoFor(final String decoString) {
        if (decoString.equals("DecoDarkTower")) {
            return new StructureDecoratorDarkTower();
        }
        if (decoString.equals("DecoIceTower")) {
            return new IceTowerDecorator();
        }
        if (decoString.equals("DecoMushroomTower")) {
            return new MushroomTowerDecorator();
        }
        if (decoString.equals("DecoStronghold")) {
            return new StrongholdDecorator();
        }
        if (decoString.equals("DecoCastle")) {
            return new StructureTFDecoratorCastle();
        }
        return new TFStructureDecorator();
    }
}
