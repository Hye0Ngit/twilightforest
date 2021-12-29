// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.DeathTome;
import net.minecraft.client.model.HierarchicalModel;

public class DeathTomeModel extends HierarchicalModel<DeathTome>
{
    private final ModelPart root;
    private final ModelPart book;
    private final ModelPart paperStorm;
    private final ModelPart pagesRight;
    private final ModelPart pagesLeft;
    private final ModelPart flippingPageRight;
    private final ModelPart flippingPageLeft;
    private final ModelPart coverRight;
    private final ModelPart coverLeft;
    private final ModelPart loosePage0;
    private final ModelPart loosePage1;
    private final ModelPart loosePage2;
    private final ModelPart loosePage3;
    
    public DeathTomeModel(final ModelPart root) {
        this.root = root;
        this.book = root.m_171324_("book");
        this.pagesRight = this.book.m_171324_("pages_right");
        this.pagesLeft = this.book.m_171324_("pages_left");
        this.flippingPageRight = this.book.m_171324_("flipping_page_right");
        this.flippingPageLeft = this.book.m_171324_("flipping_page_left");
        this.coverRight = this.book.m_171324_("cover_right");
        this.coverLeft = this.book.m_171324_("cover_left");
        this.paperStorm = this.root.m_171324_("paper_storm");
        this.loosePage0 = this.paperStorm.m_171324_("loose_page_0");
        this.loosePage1 = this.paperStorm.m_171324_("loose_page_1");
        this.loosePage2 = this.paperStorm.m_171324_("loose_page_2");
        this.loosePage3 = this.paperStorm.m_171324_("loose_page_3");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition book = partRoot.m_171599_("book", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        book.m_171599_("pages_right", CubeListBuilder.m_171558_().m_171514_(0, 10).m_171481_(0.0f, -4.0f, -0.99f, 5.0f, 8.0f, 1.0f), PartPose.f_171404_);
        book.m_171599_("pages_left", CubeListBuilder.m_171558_().m_171514_(12, 10).m_171481_(0.0f, -4.0f, -0.01f, 5.0f, 8.0f, 1.0f), PartPose.f_171404_);
        book.m_171599_("flipping_page_right", CubeListBuilder.m_171558_().m_171514_(24, 10).m_171481_(0.0f, -4.0f, 0.0f, 5.0f, 8.0f, 0.005f), PartPose.f_171404_);
        book.m_171599_("flipping_page_left", CubeListBuilder.m_171558_().m_171514_(24, 10).m_171481_(0.0f, -4.0f, 0.0f, 5.0f, 8.0f, 0.005f), PartPose.f_171404_);
        book.m_171599_("cover_right", CubeListBuilder.m_171558_().m_171481_(-6.0f, -5.0f, -0.005f, 6.0f, 10.0f, 0.005f), PartPose.m_171419_(0.0f, 0.0f, -1.0f));
        book.m_171599_("cover_left", CubeListBuilder.m_171558_().m_171514_(16, 0).m_171481_(0.0f, -5.0f, -0.005f, 6.0f, 10.0f, 0.005f), PartPose.m_171419_(0.0f, 0.0f, 1.0f));
        book.m_171599_("book_spine", CubeListBuilder.m_171558_().m_171514_(12, 0).m_171481_(-1.0f, -5.0f, 0.0f, 2.0f, 10.0f, 0.005f), PartPose.m_171430_(0.0f, 1.5707964f, 0.0f));
        final PartDefinition paperStorm = partRoot.m_171599_("paper_storm", CubeListBuilder.m_171558_(), PartPose.f_171404_);
        paperStorm.m_171599_("loose_page_0", CubeListBuilder.m_171558_().m_171514_(24, 10).m_171481_(0.0f, -4.0f, -8.0f, 5.0f, 8.0f, 0.005f), PartPose.f_171404_);
        paperStorm.m_171599_("loose_page_1", CubeListBuilder.m_171558_().m_171514_(24, 10).m_171481_(0.0f, -4.0f, 9.0f, 5.0f, 8.0f, 0.005f), PartPose.f_171404_);
        paperStorm.m_171599_("loose_page_2", CubeListBuilder.m_171558_().m_171514_(24, 10).m_171481_(0.0f, -4.0f, 11.0f, 5.0f, 8.0f, 0.005f), PartPose.f_171404_);
        paperStorm.m_171599_("loose_page_3", CubeListBuilder.m_171558_().m_171514_(24, 10).m_171481_(0.0f, -4.0f, 7.0f, 5.0f, 8.0f, 0.005f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final DeathTome entity, final float limbAngle, final float limbDistance, final float customAngle, final float headYaw, final float headPitch) {
        this.root.f_104204_ = 1.5707964f;
        this.book.f_104205_ = -0.87266463f;
        this.paperStorm.f_104204_ = customAngle * 0.017453292f + 1.5707964f;
        this.paperStorm.f_104205_ = 0.87266463f;
    }
    
    public void prepareMobModel(final DeathTome entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final float bounce = entity.f_19797_ + partialTicks;
        final float open = 0.9f;
        final float flipRight = 0.4f;
        final float flipLeft = 0.6f;
        this.book.m_104227_(0.0f, 4.0f + Mth.m_14031_(bounce * 0.3f) * 2.0f, 0.0f);
        final float openAngle = (Mth.m_14031_(bounce * 0.4f) * 0.3f + 1.25f) * open;
        this.coverRight.f_104204_ = 3.1415927f + openAngle;
        this.coverLeft.f_104204_ = -openAngle;
        this.pagesRight.f_104204_ = openAngle;
        this.pagesLeft.f_104204_ = -openAngle;
        this.flippingPageRight.f_104204_ = openAngle - openAngle * 2.0f * flipRight;
        this.flippingPageLeft.f_104204_ = openAngle - openAngle * 2.0f * flipLeft;
        this.pagesRight.f_104200_ = Mth.m_14031_(openAngle);
        this.pagesLeft.f_104200_ = Mth.m_14031_(openAngle);
        this.flippingPageRight.f_104200_ = Mth.m_14031_(openAngle);
        this.flippingPageLeft.f_104200_ = Mth.m_14031_(openAngle);
        this.loosePage0.f_104204_ = bounce / 4.0f;
        this.loosePage0.f_104203_ = Mth.m_14031_(bounce / 5.0f) / 3.0f;
        this.loosePage0.f_104205_ = Mth.m_14089_(bounce / 5.0f) / 5.0f;
        this.loosePage1.f_104204_ = bounce / 3.0f;
        this.loosePage1.f_104203_ = Mth.m_14031_(bounce / 5.0f) / 3.0f;
        this.loosePage1.f_104205_ = Mth.m_14089_(bounce / 5.0f) / 4.0f + 2.0f;
        this.loosePage2.f_104204_ = bounce / 4.0f;
        this.loosePage2.f_104203_ = -Mth.m_14031_(bounce / 5.0f) / 3.0f;
        this.loosePage2.f_104205_ = Mth.m_14089_(bounce / 5.0f) / 5.0f - 1.0f;
        this.loosePage3.f_104204_ = bounce / 4.0f;
        this.loosePage3.f_104203_ = -Mth.m_14031_(bounce / 2.0f) / 4.0f;
        this.loosePage3.f_104205_ = Mth.m_14089_(bounce / 7.0f) / 5.0f;
    }
}
