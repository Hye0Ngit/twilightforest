// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.finalcastle;

import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFCastleGuardian extends ModelBase
{
    public ModelRenderer MainBody;
    public ModelRenderer MidBody;
    public ModelRenderer Head;
    public ModelRenderer PlateGroup1;
    public ModelRenderer PlateGroup2;
    public ModelRenderer PlateGroup3;
    public ModelRenderer PlateGroup4;
    public ModelRenderer PlateGroup5;
    public ModelRenderer PlateGroup6;
    public ModelRenderer Plating;
    public ModelRenderer SpikeWrapper;
    public ModelRenderer InnerSupport;
    public ModelRenderer Support;
    public ModelRenderer Spike;
    public ModelRenderer SpikeCap;
    public ModelRenderer Plating_1;
    public ModelRenderer SpikeWrapper_1;
    public ModelRenderer InnerSupport_1;
    public ModelRenderer Support_1;
    public ModelRenderer Spike_1;
    public ModelRenderer SpikeCap_1;
    public ModelRenderer Plating_2;
    public ModelRenderer SpikeWrapper_2;
    public ModelRenderer InnerSupport_2;
    public ModelRenderer Support_2;
    public ModelRenderer Spike_2;
    public ModelRenderer SpikeCap_2;
    public ModelRenderer Plating_3;
    public ModelRenderer SpikeWrapper_3;
    public ModelRenderer InnerSupport_3;
    public ModelRenderer Support_3;
    public ModelRenderer Spike_3;
    public ModelRenderer SpikeCap_3;
    public ModelRenderer Plating_4;
    public ModelRenderer SpikeWrapper_4;
    public ModelRenderer InnerSupport_4;
    public ModelRenderer Support_4;
    public ModelRenderer Spike_4;
    public ModelRenderer SpikeCap_4;
    public ModelRenderer Plating_5;
    public ModelRenderer SpikeWrapper_5;
    public ModelRenderer InnerSupport_5;
    public ModelRenderer Support_5;
    public ModelRenderer Spike_5;
    public ModelRenderer SpikeCap_5;
    public ModelRenderer RunedSiding1;
    public ModelRenderer Bridge1;
    public ModelRenderer RunedSiding2;
    public ModelRenderer Bridge2;
    public ModelRenderer RunedSiding3;
    public ModelRenderer Bridge3;
    public ModelRenderer RunedSiding4;
    public ModelRenderer Bridge4;
    public ModelRenderer Cover;
    public ModelRenderer HeadGroup2;
    public ModelRenderer HeadGroup3;
    public ModelRenderer HeadGroup4;
    public ModelRenderer HeadGroup5;
    public ModelRenderer HeadGroup6;
    public ModelRenderer EyeBack;
    public ModelRenderer HeadGroup1;
    public ModelRenderer HeadPlate;
    public ModelRenderer HeadSpikeWrapper;
    public ModelRenderer HeadExtended;
    public ModelRenderer HeadSpike;
    public ModelRenderer HeadPlate_1;
    public ModelRenderer HeadSpikeWrapper_1;
    public ModelRenderer HeadExtended_1;
    public ModelRenderer HeadSpike_1;
    public ModelRenderer HeadPlate_2;
    public ModelRenderer HeadSpikeWrapper_2;
    public ModelRenderer HeadExtended_2;
    public ModelRenderer HeadSpike_2;
    public ModelRenderer HeadPlate_3;
    public ModelRenderer HeadSpikeWrapper_3;
    public ModelRenderer HeadExtended_3;
    public ModelRenderer HeadSpike_3;
    public ModelRenderer HeadPlate_4;
    public ModelRenderer HeadSpikeWrapper_4;
    public ModelRenderer HeadExtended_4;
    public ModelRenderer HeadSpike_4;
    public ModelRenderer Eye;
    public ModelRenderer HeadPlate_5;
    public ModelRenderer HeadSpikeWrapper_5;
    public ModelRenderer HeadExtended_5;
    public ModelRenderer EyeFrameR;
    public ModelRenderer EyeFrameL;
    public ModelRenderer EyeFrameLB;
    public ModelRenderer EyeFrameRT;
    public ModelRenderer EyeFrameLT;
    public ModelRenderer EyeFrameRB;
    public ModelRenderer HeadSpike_5;
    private static final Minecraft minecraft;
    
    public ModelTFCastleGuardian() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.SpikeWrapper_5 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.SpikeWrapper_5.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.SpikeWrapper_5, 0.0f, 0.5235988f, 0.0f);
        (this.EyeFrameL = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(-4.0f, 0.0f, -9.2f);
        this.EyeFrameL.func_78790_a(0.0f, -11.0f, 0.0f, 1, 5, 2, 0.0f);
        (this.Plating = new ModelRenderer((ModelBase)this, 0, 32)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Plating.func_78790_a(29.0f, -8.0f, -8.0f, 1, 16, 16, 0.0f);
        this.setRotateAngle(this.Plating, 0.7853982f, 0.0f, -0.7853982f);
        (this.SpikeCap = new ModelRenderer((ModelBase)this, 7, 25)).func_78793_a(8.0f, -1.0f, 8.0f);
        this.SpikeCap.func_78790_a(0.0f, 0.0f, 0.0f, 6, 11, 6, 0.0f);
        (this.Spike_1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -20.0f, 0.0f);
        this.Spike_1.func_78790_a(1.0f, 0.0f, 1.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Spike_1, 0.0f, 0.7853982f, -0.60650194f);
        this.HeadExtended_2 = new ModelRenderer((ModelBase)this, 64, 33);
        this.HeadExtended_2.field_78809_i = true;
        this.HeadExtended_2.func_78793_a(0.0f, -18.0f, -5.0f);
        this.HeadExtended_2.func_78790_a(-5.0f, 1.0f, 0.0f, 10, 1, 9, 0.0f);
        this.setRotateAngle(this.HeadExtended_2, -0.21816616f, 0.0f, 0.0f);
        (this.SpikeWrapper_1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.SpikeWrapper_1.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.SpikeWrapper_1, 0.0f, 0.5235988f, 0.0f);
        (this.Plating_1 = new ModelRenderer((ModelBase)this, 0, 32)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Plating_1.func_78790_a(29.0f, -8.0f, -8.0f, 1, 16, 16, 0.0f);
        this.setRotateAngle(this.Plating_1, 0.7853982f, 0.0f, -0.7853982f);
        (this.HeadPlate_5 = new ModelRenderer((ModelBase)this, 86, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadPlate_5.func_78790_a(-5.0f, -17.0f, -9.2f, 10, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadPlate_5, 0.19634955f, 0.0f, 0.0f);
        (this.HeadGroup1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -2.0f, 0.0f);
        this.HeadGroup1.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        (this.Support = new ModelRenderer((ModelBase)this, 31, 24)).func_78793_a(0.0f, -7.0f, 0.0f);
        this.Support.func_78790_a(23.5f, 0.0f, 0.0f, 6, 7, 7, 0.0f);
        (this.Plating_5 = new ModelRenderer((ModelBase)this, 0, 32)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Plating_5.func_78790_a(29.0f, -8.0f, -8.0f, 1, 16, 16, 0.0f);
        this.setRotateAngle(this.Plating_5, 0.7853982f, 0.0f, -0.7853982f);
        (this.Spike_4 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -20.0f, 0.0f);
        this.Spike_4.func_78790_a(1.0f, 0.0f, 1.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Spike_4, 0.0f, 0.7853982f, -0.60650194f);
        (this.MainBody = new ModelRenderer((ModelBase)this, 6, 49)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.MainBody.func_78790_a(-7.0f, 18.8f, -7.5f, 14, 2, 14, 0.0f);
        this.setRotateAngle(this.MainBody, 0.0f, 1.5707964f, 0.0f);
        (this.HeadSpikeWrapper_3 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpikeWrapper_3.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadSpikeWrapper_3, 0.0f, 2.0943952f, 0.0f);
        (this.SpikeCap_3 = new ModelRenderer((ModelBase)this, 7, 25)).func_78793_a(8.0f, -1.0f, 8.0f);
        this.SpikeCap_3.func_78790_a(0.0f, 0.0f, 0.0f, 6, 11, 6, 0.0f);
        (this.SpikeWrapper = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.SpikeWrapper.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.SpikeWrapper, 0.0f, 0.5235988f, 0.0f);
        (this.Bridge3 = new ModelRenderer((ModelBase)this, 36, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Bridge3.func_78790_a(-4.0f, -3.0f, 6.0f, 8, 9, 3, 0.0f);
        this.setRotateAngle(this.Bridge3, -0.283616f, -2.3561945f, 0.0f);
        (this.HeadSpikeWrapper_4 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpikeWrapper_4.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadSpikeWrapper_4, 0.0f, 2.0943952f, 0.0f);
        (this.HeadSpikeWrapper_5 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpikeWrapper_5.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadSpikeWrapper_5, 0.0f, 2.0943952f, 0.0f);
        (this.Support_3 = new ModelRenderer((ModelBase)this, 31, 24)).func_78793_a(0.0f, -7.0f, 0.0f);
        this.Support_3.func_78790_a(23.5f, 0.0f, 0.0f, 6, 7, 7, 0.0f);
        (this.InnerSupport_3 = new ModelRenderer((ModelBase)this, 23, 38)).func_78793_a(0.0f, -10.0f, 0.0f);
        this.InnerSupport_3.func_78790_a(7.0f, -1.4f, -4.0f, 11, 2, 8, 0.0f);
        this.setRotateAngle(this.InnerSupport_3, 0.0f, 0.0f, -0.4553564f);
        (this.SpikeWrapper_4 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.SpikeWrapper_4.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.SpikeWrapper_4, 0.0f, 0.5235988f, 0.0f);
        (this.HeadSpikeWrapper_2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpikeWrapper_2.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadSpikeWrapper_2, 0.0f, 2.0943952f, 0.0f);
        (this.HeadSpike_4 = new ModelRenderer((ModelBase)this, 57, 21)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpike_4.func_78790_a(3.7f, -17.9f, 3.7f, 4, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadSpike_4, 0.0f, 0.7853982f, 0.26703537f);
        (this.HeadPlate_2 = new ModelRenderer((ModelBase)this, 58, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadPlate_2.func_78790_a(-5.0f, -17.0f, -9.2f, 10, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadPlate_2, 0.19634955f, 0.0f, 0.0f);
        (this.EyeFrameR = new ModelRenderer((ModelBase)this, 4, 0)).func_78793_a(3.0f, 0.0f, -9.2f);
        this.EyeFrameR.func_78790_a(0.0f, -11.0f, 0.0f, 1, 5, 2, 0.0f);
        (this.EyeFrameLT = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(-4.0f, -10.0f, -9.2f);
        this.EyeFrameLT.func_78790_a(0.0f, -5.0f, 0.0f, 1, 5, 2, 0.0f);
        this.setRotateAngle(this.EyeFrameLT, 0.0f, 0.0f, 0.7853982f);
        (this.SpikeWrapper_3 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.SpikeWrapper_3.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.SpikeWrapper_3, 0.0f, 0.5235988f, 0.0f);
        (this.Eye = new ModelRenderer((ModelBase)this, 73, 21)).func_78793_a(0.0f, 4.8f, 0.5f);
        this.Eye.func_78790_a(-2.0f, -2.0f, -2.0f, 4, 4, 4, 0.0f);
        this.setRotateAngle(this.Eye, -0.7853982f, -0.6981317f, 1.5707964f);
        (this.HeadSpike_5 = new ModelRenderer((ModelBase)this, 57, 21)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpike_5.func_78790_a(3.7f, -17.9f, 3.7f, 4, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadSpike_5, 0.0f, 0.7853982f, 0.26703537f);
        (this.Support_5 = new ModelRenderer((ModelBase)this, 31, 24)).func_78793_a(0.0f, -7.0f, 0.0f);
        this.Support_5.func_78790_a(23.5f, 0.0f, 0.0f, 6, 7, 7, 0.0f);
        (this.InnerSupport_2 = new ModelRenderer((ModelBase)this, 23, 38)).func_78793_a(0.0f, -10.0f, 0.0f);
        this.InnerSupport_2.func_78790_a(7.0f, -1.4f, -4.0f, 11, 2, 8, 0.0f);
        this.setRotateAngle(this.InnerSupport_2, 0.0f, 0.0f, -0.4553564f);
        (this.HeadGroup3 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -2.0f, 0.0f);
        this.HeadGroup3.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadGroup3, 0.0f, 2.0943952f, 0.0f);
        (this.InnerSupport_5 = new ModelRenderer((ModelBase)this, 23, 38)).func_78793_a(0.0f, -10.0f, 0.0f);
        this.InnerSupport_5.func_78790_a(7.0f, -1.4f, -4.0f, 11, 2, 8, 0.0f);
        this.setRotateAngle(this.InnerSupport_5, 0.0f, 0.0f, -0.4553564f);
        (this.EyeBack = new ModelRenderer((ModelBase)this, 114, 0)).func_78793_a(0.0f, -13.4f, -9.8f);
        this.EyeBack.func_78790_a(-3.0f, 0.0f, 0.0f, 6, 9, 1, 0.0f);
        this.HeadExtended = new ModelRenderer((ModelBase)this, 64, 33);
        this.HeadExtended.field_78809_i = true;
        this.HeadExtended.func_78793_a(0.0f, -18.0f, -5.0f);
        this.HeadExtended.func_78790_a(-5.0f, 1.0f, 0.0f, 10, 1, 9, 0.0f);
        this.setRotateAngle(this.HeadExtended, -0.21816616f, 0.0f, 0.0f);
        (this.Support_1 = new ModelRenderer((ModelBase)this, 31, 24)).func_78793_a(0.0f, -7.0f, 0.0f);
        this.Support_1.func_78790_a(23.5f, 0.0f, 0.0f, 6, 7, 7, 0.0f);
        (this.Plating_2 = new ModelRenderer((ModelBase)this, 0, 32)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Plating_2.func_78790_a(29.0f, -8.0f, -8.0f, 1, 16, 16, 0.0f);
        this.setRotateAngle(this.Plating_2, 0.7853982f, 0.0f, -0.7853982f);
        (this.HeadPlate_3 = new ModelRenderer((ModelBase)this, 58, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadPlate_3.func_78790_a(-5.0f, -17.0f, -9.2f, 10, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadPlate_3, 0.19634955f, 0.0f, 0.0f);
        (this.HeadGroup6 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -2.0f, 0.0f);
        this.HeadGroup6.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadGroup6, 0.0f, 5.2359877f, 0.0f);
        (this.MidBody = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 3.0f, 0.0f);
        this.MidBody.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        (this.PlateGroup1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 35.0f, 0.0f);
        this.PlateGroup1.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        (this.Bridge4 = new ModelRenderer((ModelBase)this, 36, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Bridge4.func_78790_a(-4.0f, -3.0f, 6.0f, 8, 9, 3, 0.0f);
        this.setRotateAngle(this.Bridge4, -0.283616f, -0.7853982f, 0.0f);
        (this.HeadSpikeWrapper_1 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpikeWrapper_1.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadSpikeWrapper_1, 0.0f, 2.0943952f, 0.0f);
        (this.SpikeCap_2 = new ModelRenderer((ModelBase)this, 7, 25)).func_78793_a(8.0f, -1.0f, 8.0f);
        this.SpikeCap_2.func_78790_a(0.0f, 0.0f, 0.0f, 6, 11, 6, 0.0f);
        (this.HeadSpike_1 = new ModelRenderer((ModelBase)this, 57, 21)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpike_1.func_78790_a(3.7f, -17.9f, 3.7f, 4, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadSpike_1, 0.0f, 0.7853982f, 0.26703537f);
        (this.InnerSupport_4 = new ModelRenderer((ModelBase)this, 23, 38)).func_78793_a(0.0f, -10.0f, 0.0f);
        this.InnerSupport_4.func_78790_a(7.0f, -1.4f, -4.0f, 11, 2, 8, 0.0f);
        this.setRotateAngle(this.InnerSupport_4, 0.0f, 0.0f, -0.4553564f);
        (this.RunedSiding4 = new ModelRenderer((ModelBase)this, 48, 48)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.RunedSiding4.func_78790_a(-4.0f, -4.0f, 6.0f, 8, 10, 4, 0.0f);
        this.setRotateAngle(this.RunedSiding4, -0.3926991f, -1.5707964f, 0.0f);
        (this.SpikeCap_1 = new ModelRenderer((ModelBase)this, 7, 25)).func_78793_a(8.0f, -1.0f, 8.0f);
        this.SpikeCap_1.func_78790_a(0.0f, 0.0f, 0.0f, 6, 11, 6, 0.0f);
        (this.Head = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 2.5f, 0.0f);
        this.Head.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        (this.EyeFrameRT = new ModelRenderer((ModelBase)this, 6, 7)).func_78793_a(4.0f, -10.0f, -9.2f);
        this.EyeFrameRT.func_78790_a(0.0f, 0.4f, 0.0f, 1, 5, 2, 0.0f);
        this.setRotateAngle(this.EyeFrameRT, 0.0f, 0.0f, 2.3561945f);
        (this.RunedSiding1 = new ModelRenderer((ModelBase)this, 48, 48)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.RunedSiding1.func_78790_a(-4.0f, -4.0f, 6.0f, 8, 10, 4, 0.0f);
        this.setRotateAngle(this.RunedSiding1, -0.3926991f, 0.0f, 0.0f);
        (this.PlateGroup3 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 35.0f, 0.0f);
        this.PlateGroup3.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.PlateGroup3, 0.0f, 2.0943952f, 0.0f);
        (this.Plating_3 = new ModelRenderer((ModelBase)this, 0, 32)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Plating_3.func_78790_a(29.0f, -8.0f, -8.0f, 1, 16, 16, 0.0f);
        this.setRotateAngle(this.Plating_3, 0.7853982f, 0.0f, -0.7853982f);
        (this.Bridge1 = new ModelRenderer((ModelBase)this, 36, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Bridge1.func_78790_a(-4.0f, -3.0f, 6.0f, 8, 9, 3, 0.0f);
        this.setRotateAngle(this.Bridge1, -0.283616f, 0.7853982f, 0.0f);
        (this.EyeFrameRB = new ModelRenderer((ModelBase)this, 6, 0)).func_78793_a(4.0f, -7.0f, -9.2f);
        this.EyeFrameRB.func_78790_a(0.0f, -5.0f, 0.0f, 1, 5, 2, 0.0f);
        this.setRotateAngle(this.EyeFrameRB, 0.0f, 0.0f, -2.3561945f);
        (this.PlateGroup4 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 35.0f, 0.0f);
        this.PlateGroup4.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.PlateGroup4, 0.0f, 3.1415927f, 0.0f);
        (this.Cover = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Cover.func_78790_a(-6.0f, -0.6f, -6.0f, 12, 1, 12, 0.0f);
        this.setRotateAngle(this.Cover, 0.0f, 0.7853982f, 0.0f);
        (this.HeadExtended_1 = new ModelRenderer((ModelBase)this, 64, 33)).func_78793_a(0.0f, -18.0f, -5.0f);
        this.HeadExtended_1.func_78790_a(-5.0f, 1.0f, 0.0f, 10, 1, 9, 0.0f);
        this.setRotateAngle(this.HeadExtended_1, -0.21816616f, 0.0f, 0.0f);
        (this.Spike = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -20.0f, 0.0f);
        this.Spike.func_78790_a(1.0f, 0.0f, 1.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Spike, 0.0f, 0.7853982f, -0.60650194f);
        this.HeadExtended_4 = new ModelRenderer((ModelBase)this, 64, 33);
        this.HeadExtended_4.field_78809_i = true;
        this.HeadExtended_4.func_78793_a(0.0f, -18.0f, -5.0f);
        this.HeadExtended_4.func_78790_a(-5.0f, 1.0f, 0.0f, 10, 1, 9, 0.0f);
        this.setRotateAngle(this.HeadExtended_4, -0.21816616f, 0.0f, 0.0f);
        (this.InnerSupport_1 = new ModelRenderer((ModelBase)this, 23, 38)).func_78793_a(0.0f, -10.0f, 0.0f);
        this.InnerSupport_1.func_78790_a(7.0f, -1.4f, -4.0f, 11, 2, 8, 0.0f);
        this.setRotateAngle(this.InnerSupport_1, 0.0f, 0.0f, -0.4553564f);
        (this.SpikeCap_5 = new ModelRenderer((ModelBase)this, 7, 25)).func_78793_a(8.0f, -1.0f, 8.0f);
        this.SpikeCap_5.func_78790_a(0.0f, 0.0f, 0.0f, 6, 11, 6, 0.0f);
        (this.HeadExtended_5 = new ModelRenderer((ModelBase)this, 64, 33)).func_78793_a(0.0f, -18.0f, -5.0f);
        this.HeadExtended_5.func_78790_a(-5.0f, 1.0f, 0.0f, 10, 1, 9, 0.0f);
        this.setRotateAngle(this.HeadExtended_5, -0.21816616f, 0.0f, 0.0f);
        (this.Support_4 = new ModelRenderer((ModelBase)this, 31, 24)).func_78793_a(0.0f, -7.0f, 0.0f);
        this.Support_4.func_78790_a(23.5f, 0.0f, 0.0f, 6, 7, 7, 0.0f);
        (this.HeadPlate_1 = new ModelRenderer((ModelBase)this, 58, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadPlate_1.func_78790_a(-5.0f, -17.0f, -9.2f, 10, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadPlate_1, 0.19634955f, 0.0f, 0.0f);
        (this.HeadGroup2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -2.0f, 0.0f);
        this.HeadGroup2.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadGroup2, 0.0f, 1.0471976f, 0.0f);
        (this.PlateGroup2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 35.0f, 0.0f);
        this.PlateGroup2.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.PlateGroup2, 0.0f, 1.0471976f, 0.0f);
        (this.SpikeWrapper_2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.SpikeWrapper_2.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.SpikeWrapper_2, 0.0f, 0.5235988f, 0.0f);
        (this.InnerSupport = new ModelRenderer((ModelBase)this, 23, 38)).func_78793_a(0.0f, -10.0f, 0.0f);
        this.InnerSupport.func_78790_a(7.0f, -1.4f, -4.0f, 11, 2, 8, 0.0f);
        this.setRotateAngle(this.InnerSupport, 0.0f, 0.0f, -0.4553564f);
        (this.Spike_2 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -20.0f, 0.0f);
        this.Spike_2.func_78790_a(1.0f, 0.0f, 1.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Spike_2, 0.0f, 0.7853982f, -0.60650194f);
        (this.RunedSiding3 = new ModelRenderer((ModelBase)this, 48, 48)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.RunedSiding3.func_78790_a(-4.0f, -4.0f, 6.0f, 8, 10, 4, 0.0f);
        this.setRotateAngle(this.RunedSiding3, -0.3926991f, 3.1415927f, 0.0f);
        (this.HeadPlate = new ModelRenderer((ModelBase)this, 58, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadPlate.func_78790_a(-5.0f, -17.0f, -9.2f, 10, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadPlate, 0.19634955f, 0.0f, 0.0f);
        (this.PlateGroup6 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 35.0f, 0.0f);
        this.PlateGroup6.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.PlateGroup6, 0.0f, 5.2359877f, 0.0f);
        (this.HeadGroup4 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -2.0f, 0.0f);
        this.HeadGroup4.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadGroup4, 0.0f, 3.1415927f, 0.0f);
        (this.RunedSiding2 = new ModelRenderer((ModelBase)this, 48, 48)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.RunedSiding2.func_78790_a(-4.0f, -4.0f, 6.0f, 8, 10, 4, 0.0f);
        this.setRotateAngle(this.RunedSiding2, -0.3926991f, 1.5707964f, 0.0f);
        (this.Spike_5 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -20.0f, 0.0f);
        this.Spike_5.func_78790_a(1.0f, 0.0f, 1.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Spike_5, 0.0f, 0.7853982f, -0.60650194f);
        (this.Bridge2 = new ModelRenderer((ModelBase)this, 36, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Bridge2.func_78790_a(-4.0f, -3.0f, 6.0f, 8, 9, 3, 0.0f);
        this.setRotateAngle(this.Bridge2, -0.283616f, 2.3561945f, 0.0f);
        (this.Spike_3 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -20.0f, 0.0f);
        this.Spike_3.func_78790_a(1.0f, 0.0f, 1.0f, 12, 12, 12, 0.0f);
        this.setRotateAngle(this.Spike_3, 0.0f, 0.7853982f, -0.60650194f);
        (this.HeadGroup5 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -2.0f, 0.0f);
        this.HeadGroup5.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadGroup5, 0.0f, 4.1887903f, 0.0f);
        (this.SpikeCap_4 = new ModelRenderer((ModelBase)this, 7, 25)).func_78793_a(8.0f, -1.0f, 8.0f);
        this.SpikeCap_4.func_78790_a(0.0f, 0.0f, 0.0f, 6, 11, 6, 0.0f);
        (this.HeadSpikeWrapper = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpikeWrapper.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.HeadSpikeWrapper, 0.0f, 2.0943952f, 0.0f);
        (this.HeadExtended_3 = new ModelRenderer((ModelBase)this, 64, 33)).func_78793_a(0.0f, -18.0f, -5.0f);
        this.HeadExtended_3.func_78790_a(-5.0f, 1.0f, 0.0f, 10, 1, 9, 0.0f);
        this.setRotateAngle(this.HeadExtended_3, -0.21816616f, 0.0f, 0.0f);
        (this.HeadPlate_4 = new ModelRenderer((ModelBase)this, 58, 0)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadPlate_4.func_78790_a(-5.0f, -17.0f, -9.2f, 10, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadPlate_4, 0.19634955f, 0.0f, 0.0f);
        (this.PlateGroup5 = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, 35.0f, 0.0f);
        this.PlateGroup5.func_78790_a(0.0f, 0.0f, 0.0f, 0, 0, 0, 0.0f);
        this.setRotateAngle(this.PlateGroup5, 0.0f, 4.1887903f, 0.0f);
        (this.HeadSpike = new ModelRenderer((ModelBase)this, 57, 21)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpike.func_78790_a(3.7f, -17.9f, 3.7f, 4, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadSpike, 0.0f, 0.7853982f, 0.26703537f);
        (this.HeadSpike_2 = new ModelRenderer((ModelBase)this, 57, 21)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpike_2.func_78790_a(3.7f, -17.9f, 3.7f, 4, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadSpike_2, 0.0f, 0.7853982f, 0.26703537f);
        (this.HeadSpike_3 = new ModelRenderer((ModelBase)this, 57, 21)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.HeadSpike_3.func_78790_a(3.7f, -17.9f, 3.7f, 4, 17, 4, 0.0f);
        this.setRotateAngle(this.HeadSpike_3, 0.0f, 0.7853982f, 0.26703537f);
        (this.EyeFrameLB = new ModelRenderer((ModelBase)this, 0, 7)).func_78793_a(-4.0f, -7.0f, -9.2f);
        this.EyeFrameLB.func_78790_a(0.0f, 0.4f, 0.0f, 1, 5, 2, 0.0f);
        this.setRotateAngle(this.EyeFrameLB, 0.0f, 0.0f, -0.7853982f);
        (this.Support_2 = new ModelRenderer((ModelBase)this, 31, 24)).func_78793_a(0.0f, -7.0f, 0.0f);
        this.Support_2.func_78790_a(23.5f, 0.0f, 0.0f, 6, 7, 7, 0.0f);
        (this.Plating_4 = new ModelRenderer((ModelBase)this, 0, 32)).func_78793_a(0.0f, 0.0f, 0.0f);
        this.Plating_4.func_78790_a(29.0f, -8.0f, -8.0f, 1, 16, 16, 0.0f);
        this.setRotateAngle(this.Plating_4, 0.7853982f, 0.0f, -0.7853982f);
        this.PlateGroup6.func_78792_a(this.SpikeWrapper_5);
        this.HeadPlate_5.func_78792_a(this.EyeFrameL);
        this.PlateGroup1.func_78792_a(this.Plating);
        this.Spike.func_78792_a(this.SpikeCap);
        this.SpikeWrapper_1.func_78792_a(this.Spike_1);
        this.HeadPlate_2.func_78792_a(this.HeadExtended_2);
        this.PlateGroup2.func_78792_a(this.SpikeWrapper_1);
        this.PlateGroup2.func_78792_a(this.Plating_1);
        this.HeadGroup1.func_78792_a(this.HeadPlate_5);
        this.Head.func_78792_a(this.HeadGroup1);
        this.Plating.func_78792_a(this.Support);
        this.PlateGroup6.func_78792_a(this.Plating_5);
        this.SpikeWrapper_4.func_78792_a(this.Spike_4);
        this.HeadGroup5.func_78792_a(this.HeadSpikeWrapper_3);
        this.Spike_3.func_78792_a(this.SpikeCap_3);
        this.PlateGroup1.func_78792_a(this.SpikeWrapper);
        this.MidBody.func_78792_a(this.Bridge3);
        this.HeadGroup6.func_78792_a(this.HeadSpikeWrapper_4);
        this.HeadGroup1.func_78792_a(this.HeadSpikeWrapper_5);
        this.Plating_3.func_78792_a(this.Support_3);
        this.PlateGroup4.func_78792_a(this.InnerSupport_3);
        this.PlateGroup5.func_78792_a(this.SpikeWrapper_4);
        this.HeadGroup4.func_78792_a(this.HeadSpikeWrapper_2);
        this.HeadSpikeWrapper_4.func_78792_a(this.HeadSpike_4);
        this.HeadGroup4.func_78792_a(this.HeadPlate_2);
        this.HeadPlate_5.func_78792_a(this.EyeFrameR);
        this.HeadPlate_5.func_78792_a(this.EyeFrameLT);
        this.PlateGroup4.func_78792_a(this.SpikeWrapper_3);
        this.EyeBack.func_78792_a(this.Eye);
        this.HeadSpikeWrapper_5.func_78792_a(this.HeadSpike_5);
        this.Plating_5.func_78792_a(this.Support_5);
        this.PlateGroup3.func_78792_a(this.InnerSupport_2);
        this.Head.func_78792_a(this.HeadGroup3);
        this.PlateGroup6.func_78792_a(this.InnerSupport_5);
        this.Head.func_78792_a(this.EyeBack);
        this.HeadPlate.func_78792_a(this.HeadExtended);
        this.Plating_1.func_78792_a(this.Support_1);
        this.PlateGroup3.func_78792_a(this.Plating_2);
        this.HeadGroup5.func_78792_a(this.HeadPlate_3);
        this.Head.func_78792_a(this.HeadGroup6);
        this.MainBody.func_78792_a(this.PlateGroup1);
        this.MidBody.func_78792_a(this.Bridge4);
        this.HeadGroup3.func_78792_a(this.HeadSpikeWrapper_1);
        this.Spike_2.func_78792_a(this.SpikeCap_2);
        this.HeadSpikeWrapper_1.func_78792_a(this.HeadSpike_1);
        this.PlateGroup5.func_78792_a(this.InnerSupport_4);
        this.MidBody.func_78792_a(this.RunedSiding4);
        this.Spike_1.func_78792_a(this.SpikeCap_1);
        this.HeadPlate_5.func_78792_a(this.EyeFrameRT);
        this.MidBody.func_78792_a(this.RunedSiding1);
        this.MainBody.func_78792_a(this.PlateGroup3);
        this.PlateGroup4.func_78792_a(this.Plating_3);
        this.MidBody.func_78792_a(this.Bridge1);
        this.HeadPlate_5.func_78792_a(this.EyeFrameRB);
        this.MainBody.func_78792_a(this.PlateGroup4);
        this.MidBody.func_78792_a(this.Cover);
        this.HeadPlate_1.func_78792_a(this.HeadExtended_1);
        this.SpikeWrapper.func_78792_a(this.Spike);
        this.HeadPlate_4.func_78792_a(this.HeadExtended_4);
        this.PlateGroup2.func_78792_a(this.InnerSupport_1);
        this.Spike_5.func_78792_a(this.SpikeCap_5);
        this.HeadPlate_5.func_78792_a(this.HeadExtended_5);
        this.Plating_4.func_78792_a(this.Support_4);
        this.HeadGroup3.func_78792_a(this.HeadPlate_1);
        this.Head.func_78792_a(this.HeadGroup2);
        this.MainBody.func_78792_a(this.PlateGroup2);
        this.PlateGroup3.func_78792_a(this.SpikeWrapper_2);
        this.PlateGroup1.func_78792_a(this.InnerSupport);
        this.SpikeWrapper_2.func_78792_a(this.Spike_2);
        this.MidBody.func_78792_a(this.RunedSiding3);
        this.HeadGroup2.func_78792_a(this.HeadPlate);
        this.MainBody.func_78792_a(this.PlateGroup6);
        this.Head.func_78792_a(this.HeadGroup4);
        this.MidBody.func_78792_a(this.RunedSiding2);
        this.SpikeWrapper_5.func_78792_a(this.Spike_5);
        this.MidBody.func_78792_a(this.Bridge2);
        this.SpikeWrapper_3.func_78792_a(this.Spike_3);
        this.Head.func_78792_a(this.HeadGroup5);
        this.Spike_4.func_78792_a(this.SpikeCap_4);
        this.HeadGroup2.func_78792_a(this.HeadSpikeWrapper);
        this.HeadPlate_3.func_78792_a(this.HeadExtended_3);
        this.HeadGroup6.func_78792_a(this.HeadPlate_4);
        this.MainBody.func_78792_a(this.PlateGroup5);
        this.HeadSpikeWrapper.func_78792_a(this.HeadSpike);
        this.HeadSpikeWrapper_2.func_78792_a(this.HeadSpike_2);
        this.HeadSpikeWrapper_3.func_78792_a(this.HeadSpike_3);
        this.HeadPlate_5.func_78792_a(this.EyeFrameLB);
        this.Plating_2.func_78792_a(this.Support_2);
        this.PlateGroup5.func_78792_a(this.Plating_4);
    }
    
    public void func_78088_a(final Entity entityIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        final float partialTicks = ModelTFCastleGuardian.minecraft.func_184121_ak();
        this.MainBody.func_78785_a(scale);
        this.MidBody.func_78785_a(scale);
        this.Head.field_78796_g = netHeadYaw / 57.295776f;
        this.Head.func_78785_a(scale);
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
    
    static {
        minecraft = Minecraft.func_71410_x();
    }
}
