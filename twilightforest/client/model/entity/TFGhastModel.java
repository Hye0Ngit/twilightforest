// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import java.util.Random;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.model.HierarchicalModel;
import twilightforest.entity.monster.CarminiteGhastguard;

@OnlyIn(Dist.CLIENT)
public class TFGhastModel<T extends CarminiteGhastguard> extends HierarchicalModel<T>
{
    protected static final int tentacleCount = 9;
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart[] tentacles;
    
    public TFGhastModel(final ModelPart root) {
        this.tentacles = new ModelPart[9];
        this.root = root;
        this.body = this.root.m_171324_("body");
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i] = this.body.m_171324_("tentacle_" + i);
        }
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition body = partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f), PartPose.m_171419_(0.0f, 8.0f, 0.0f));
        final Random rand = new Random(1660L);
        for (int i = 0; i < 9; ++i) {
            makeTentacle(body, "tentacle_" + i, rand, i);
        }
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    private static PartDefinition makeTentacle(final PartDefinition parent, final String name, final Random random, final int i) {
        final int length = random.nextInt(7) + 8;
        final float xPoint = ((i % 3 - i / 3 % 2 * 0.5f + 0.25f) / 2.0f * 2.0f - 1.0f) * 5.0f;
        final float zPoint = (i / 3 / 2.0f * 2.0f - 1.0f) * 5.0f;
        return parent.m_171599_(name, CubeListBuilder.m_171558_().m_171481_(-1.0f, 0.0f, -1.0f, 2.0f, (float)length, 2.0f), PartPose.m_171419_(xPoint, 7.0f, zPoint));
    }
    
    public void setupAnim(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i].f_104203_ = 0.2f * Mth.m_14031_(ageInTicks * 0.3f + i) + 0.4f;
        }
        this.body.f_104203_ = headPitch / 57.295776f;
        this.body.f_104204_ = netHeadYaw / 57.295776f;
    }
}
