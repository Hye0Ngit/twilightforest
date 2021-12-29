// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.structures.finalcastle.StructureTFDecoratorCastle;
import twilightforest.structures.stronghold.StructureTFDecoratorStronghold;
import twilightforest.structures.mushroomtower.StructureDecoratorMushroomTower;
import twilightforest.structures.icetower.StructureDecoratorIceTower;
import twilightforest.structures.darktower.StructureDecoratorDarkTower;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.block.state.IBlockState;

public class StructureTFDecorator
{
    public IBlockState blockState;
    public IBlockState accentState;
    public IBlockState stairState;
    public IBlockState fenceState;
    public IBlockState pillarState;
    public IBlockState platformState;
    public IBlockState floorState;
    public IBlockState roofState;
    public StructureComponent.BlockSelector randomBlocks;
    
    public StructureTFDecorator() {
        this.blockState = Blocks.field_150348_b.func_176223_P();
        this.accentState = Blocks.field_150347_e.func_176223_P();
        this.stairState = Blocks.field_150446_ar.func_176223_P();
        this.fenceState = Blocks.field_180407_aO.func_176223_P();
        this.pillarState = Blocks.field_150417_aV.func_176223_P();
        this.platformState = Blocks.field_150333_U.func_176223_P();
        this.floorState = Blocks.field_150417_aV.func_176223_P();
        this.roofState = Blocks.field_150417_aV.func_176223_P();
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
        if (deco instanceof StructureTFDecoratorCastle) {
            return "DecoCastle";
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
        if (decoString.equals("DecoCastle")) {
            return new StructureTFDecoratorCastle();
        }
        return new StructureTFDecorator();
    }
}
