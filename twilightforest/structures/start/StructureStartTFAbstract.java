// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.start;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.gen.structure.template.TemplateManager;
import twilightforest.structures.StructureTFComponentTemplate;
import java.util.Iterator;
import net.minecraft.world.biome.Biome;
import twilightforest.biomes.TFBiomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.structure.StructureComponent;
import twilightforest.structures.darktower.ComponentTFDarkTowerMain;
import twilightforest.structures.lichtower.ComponentTFTowerMain;
import java.util.Random;
import twilightforest.TFFeature;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureStart;

public abstract class StructureStartTFAbstract extends StructureStart
{
    public StructureStartTFAbstract() {
    }
    
    public StructureStartTFAbstract(final World world, final TFFeature feature, final Random rand, final int chunkX, final int chunkZ) {
        super(chunkX, chunkZ);
        final int x = (chunkX << 4) + 8;
        final int z = (chunkZ << 4) + 8;
        final int y = 32;
        final StructureComponent firstComponent = this.makeFirstComponent(world, feature, rand, x, y, z);
        this.field_75075_a.add(firstComponent);
        firstComponent.func_74861_a(firstComponent, this.field_75075_a, rand);
        this.func_75072_c();
        if (firstComponent instanceof ComponentTFTowerMain || firstComponent instanceof ComponentTFDarkTowerMain) {
            this.moveToAvgGroundLevel(world, x, z);
        }
        this.setupComponents(world);
    }
    
    protected abstract StructureComponent makeFirstComponent(final World p0, final TFFeature p1, final Random p2, final int p3, final int p4, final int p5);
    
    protected void moveToAvgGroundLevel(final World world, final int x, final int z) {
        final Biome biomeAt = world.func_180494_b(new BlockPos(x, 0, z));
        int offY = (int)((biomeAt.func_185355_j() + biomeAt.func_185360_m()) * 8.0f);
        if (biomeAt == TFBiomes.darkForest) {
            offY += 4;
        }
        if (offY > 0) {
            this.field_75074_b.func_78886_a(0, offY, 0);
            for (final StructureComponent com : this.func_186161_c()) {
                com.func_74874_b().func_78886_a(0, offY, 0);
            }
        }
    }
    
    protected void setupComponents(final World world) {
        final TemplateManager templateManager = world.func_72860_G().func_186340_h();
        final MinecraftServer server = world.func_73046_m();
        for (final StructureComponent component : this.field_75075_a) {
            if (component instanceof StructureTFComponentTemplate) {
                ((StructureTFComponentTemplate)component).setup(templateManager, server);
            }
        }
    }
}
