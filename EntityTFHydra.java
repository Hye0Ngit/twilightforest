// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFHydra extends xb
{
    public tv[] partArray;
    public ez body;
    public EntityTFHydraHead head1;
    public EntityTFHydraHead head2;
    public EntityTFHydraHead head3;
    public EntityTFHydraNeck neck1a;
    public EntityTFHydraNeck neck1b;
    public EntityTFHydraNeck neck1c;
    public EntityTFHydraNeck neck1d;
    public EntityTFHydraNeck neck2a;
    public EntityTFHydraNeck neck2b;
    public EntityTFHydraNeck neck2c;
    public EntityTFHydraNeck neck2d;
    public EntityTFHydraNeck neck3a;
    public EntityTFHydraNeck neck3b;
    public EntityTFHydraNeck neck3c;
    public EntityTFHydraNeck neck3d;
    public ez leftLeg;
    public ez rightLeg;
    public ez tail;
    tv currentTarget;
    
    public EntityTFHydra(final ge world) {
        super(world);
        this.currentTarget = null;
        this.partArray = new tv[] { (tv)(this.body = new ez((xb)this, "body", 4.0f, 4.0f)), (tv)(this.head1 = new EntityTFHydraHead(this, "head1", 3.0f, 3.0f)), (tv)(this.head2 = new EntityTFHydraHead(this, "head2", 3.0f, 3.0f)), (tv)(this.head3 = new EntityTFHydraHead(this, "head3", 3.0f, 3.0f)), (tv)(this.leftLeg = new ez((xb)this, "leg", 2.0f, 3.0f)), (tv)(this.rightLeg = new ez((xb)this, "leg", 2.0f, 3.0f)), (tv)(this.tail = new ez((xb)this, "tail", 4.0f, 4.0f)), (tv)(this.neck1a = new EntityTFHydraNeck(this, "neck1a", 2.0f, 2.0f)), (tv)(this.neck1b = new EntityTFHydraNeck(this, "neck1b", 2.0f, 2.0f)), (tv)(this.neck1c = new EntityTFHydraNeck(this, "neck1c", 2.0f, 2.0f)), (tv)(this.neck1d = new EntityTFHydraNeck(this, "neck1d", 2.0f, 2.0f)), (tv)(this.neck2a = new EntityTFHydraNeck(this, "neck2a", 2.0f, 2.0f)), (tv)(this.neck2b = new EntityTFHydraNeck(this, "neck2b", 2.0f, 2.0f)), (tv)(this.neck2c = new EntityTFHydraNeck(this, "neck2c", 2.0f, 2.0f)), (tv)(this.neck2d = new EntityTFHydraNeck(this, "neck2d", 2.0f, 2.0f)), (tv)(this.neck3a = new EntityTFHydraNeck(this, "neck3a", 2.0f, 2.0f)), (tv)(this.neck3b = new EntityTFHydraNeck(this, "neck3b", 2.0f, 2.0f)), (tv)(this.neck3c = new EntityTFHydraNeck(this, "neck3c", 2.0f, 2.0f)), (tv)(this.neck3d = new EntityTFHydraNeck(this, "neck3d", 2.0f, 2.0f)) };
        this.b(16.0f, 12.0f);
        this.cd = true;
        this.ae = "/twilightforest/hydra4.png";
        this.bX = true;
    }
    
    public EntityTFHydra(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public int d() {
        return 100;
    }
    
    public void e() {
        this.body.F_();
        this.head1.F_();
        this.head2.F_();
        this.head3.F_();
        this.neck1a.F_();
        this.neck1b.F_();
        this.neck1c.F_();
        this.neck1d.F_();
        this.neck2a.F_();
        this.neck2b.F_();
        this.neck2c.F_();
        this.neck2d.F_();
        this.neck3a.F_();
        this.neck3b.F_();
        this.neck3c.F_();
        this.neck3d.F_();
        if (this.aN > 0) {
            final double d = this.bm + (this.aO - this.bm) / this.aN;
            final double d2 = this.bn + (this.aP - this.bn) / this.aN;
            final double d3 = this.bo + (this.aQ - this.bo) / this.aN;
            double d4;
            for (d4 = this.aR - this.bs; d4 < -180.0; d4 += 360.0) {}
            while (d4 >= 180.0) {
                d4 -= 360.0;
            }
            this.bs += (float)(d4 / this.aN);
            this.bt += (float)((this.aS - this.bt) / this.aN);
            --this.aN;
            this.c(d, d2, d3);
            this.c(this.bs, this.bt);
        }
        rj.a("ai");
        if (this.Q()) {
            this.aZ = false;
            this.aW = 0.0f;
            this.aX = 0.0f;
            this.aY = 0.0f;
        }
        else if (this.aF()) {
            if (this.c_()) {
                rj.a("newAi");
                this.z_();
                rj.a();
            }
            else {
                rj.a("oldAi");
                this.d_();
                rj.a();
                this.X = this.bs;
            }
        }
        rj.a();
        final boolean flag = this.aU();
        final boolean flag2 = this.aV();
        if (this.aZ) {
            if (flag) {
                this.bq += 0.03999999910593033;
            }
            else if (flag2) {
                this.bq += 0.03999999910593033;
            }
            else if (this.bx) {
                this.ac();
            }
        }
        this.aW *= 0.98f;
        this.aX *= 0.98f;
        this.aY *= 0.9f;
        final float f = this.al;
        this.al *= this.J();
        this.a(this.aW, this.aX);
        this.al = f;
        final ez body = this.body;
        final ez body2 = this.body;
        final float n = 6.0f;
        body2.bH = n;
        body.bG = n;
        final EntityTFHydraHead head1 = this.head1;
        final EntityTFHydraHead head2 = this.head1;
        final float n2 = 4.0f;
        head2.bH = n2;
        head1.bG = n2;
        final EntityTFHydraHead head3 = this.head2;
        final EntityTFHydraHead head4 = this.head2;
        final float n3 = 4.0f;
        head4.bH = n3;
        head3.bG = n3;
        final EntityTFHydraHead head5 = this.head3;
        final EntityTFHydraHead head6 = this.head3;
        final float n4 = 4.0f;
        head6.bH = n4;
        head5.bG = n4;
        final float angle = (this.V + 180.0f) * 3.141593f / 180.0f;
        double dx = this.bm - kb.a(angle) * 2.0;
        double dy = this.bn;
        double dz = this.bo + kb.b(angle) * 2.0;
        this.body.c(dx, dy, dz);
        this.bi.a("mobSpell", this.body.bm, this.body.bn, this.body.bo, 0.2, 0.2, 0.2);
        cj vector = cj.b(0.0, 0.0, 7.0);
        vector.a(1.0471976f);
        vector.b(-(this.V + kb.a(this.bT / 5.0f) * 10.0f) * 3.141593f / 180.0f);
        dx = this.bm + vector.a;
        dy = this.bn + vector.b + 3.0;
        dz = this.bo + vector.c;
        this.head1.c(dx, dy, dz);
        this.bi.a("mobSpell", this.head1.bm, this.head1.bn, this.head1.bo, 0.2, 0.5, 0.8);
        vector = cj.b(0.0, 0.0, 9.0);
        vector.a(kb.a(this.bT / 4.0f) * 10.0f * 3.141593f / 180.0f);
        vector.b(-(this.V + 60.0f + kb.a(this.bT / 10.0f) * 10.0f) * 3.141593f / 180.0f);
        dx = this.bm + vector.a;
        dy = this.bn + vector.b + 3.0;
        dz = this.bo + vector.c;
        this.head2.c(dx, dy, dz);
        this.bi.a("mobSpell", this.head2.bm, this.head2.bn, this.head2.bo, 0.8, 0.5, 0.5);
        vector = cj.b(0.0, 0.0, 9.0);
        vector.a((20.0f - kb.a(this.bT / 7.0f) * 27.0f) * 3.141593f / 180.0f);
        vector.b(-(this.V - 60.0f) * 3.141593f / 180.0f);
        dx = this.bm + vector.a;
        dy = this.bn + vector.b + 3.0;
        dz = this.bo + vector.c;
        this.head3.c(dx, dy, dz);
        this.bi.a("mobSpell", this.head3.bm, this.head3.bn, this.head3.bo, 0.3, 0.9, 0.1);
        vector = cj.b(0.0, 3.0, -1.0);
        vector.b(-this.V * 3.141593f / 180.0f);
        this.setNeckPositon(1, this.bm + vector.a, this.bn + vector.b, this.bo + vector.c, this.V, 0.0f);
        vector = cj.b(-1.0, 3.0, 3.0);
        vector.b(-(this.V + 90.0f) * 3.141593f / 180.0f);
        this.setNeckPositon(2, this.bm + vector.a, this.bn + vector.b, this.bo + vector.c, this.V, 0.0f);
        vector = cj.b(1.0, 3.0, 3.0);
        vector.b(-(this.V - 90.0f) * 3.141593f / 180.0f);
        this.setNeckPositon(3, this.bm + vector.a, this.bn + vector.b, this.bo + vector.c, this.V, 0.0f);
    }
    
    protected void setNeckPositon(final int hi, final double startX, final double startY, final double startZ, final float startYaw, final float startPitch) {
        double endX = this.getHead(hi).bm;
        double endY = this.getHead(hi).bn;
        double endZ = this.getHead(hi).bo;
        float endYaw = this.getHead(hi).bs;
        float endPitch = this.getHead(hi).bt;
        while (startYaw - endYaw < -180.0f) {
            endYaw -= 360.0f;
        }
        while (startYaw - endYaw >= 180.0f) {
            endYaw += 360.0f;
        }
        while (startPitch - endPitch < -180.0f) {
            endPitch -= 360.0f;
        }
        while (startPitch - endPitch >= 180.0f) {
            endPitch += 360.0f;
        }
        final cj vector = cj.b(0.0, 0.0, -1.25);
        vector.b(-endYaw * 3.141593f / 180.0f);
        endX += vector.a;
        endY += vector.b;
        endZ += vector.c;
        this.getNeck(hi, 1).c(startX, startY, startZ);
        this.getNeck(hi, 1).bs = startYaw;
        this.getNeck(hi, 1).bt = startPitch;
        this.getNeck(hi, 2).c(endX + (startX - endX) * 0.25, endY + (startY - endY) * 0.25, endZ + (startZ - endZ) * 0.25);
        this.getNeck(hi, 2).bs = endYaw + (startYaw - endYaw) * 0.25f;
        this.getNeck(hi, 2).bt = endPitch + (startPitch - endPitch) * 0.25f;
        this.getNeck(hi, 3).c(endX + (startX - endX) * 0.5, endY + (startY - endY) * 0.5, endZ + (startZ - endZ) * 0.5);
        this.getNeck(hi, 3).bs = endYaw + (startYaw - endYaw) * 0.5f;
        this.getNeck(hi, 3).bt = endPitch + (startPitch - endPitch) * 0.5f;
        this.getNeck(hi, 4).c(endX + (startX - endX) * 0.75, endY + (startY - endY) * 0.75, endZ + (startZ - endZ) * 0.75);
        this.getNeck(hi, 4).bs = endYaw + (startYaw - endYaw) * 0.75f;
        this.getNeck(hi, 4).bt = endPitch + (startPitch - endPitch) * 0.75f;
    }
    
    public EntityTFHydraHead getHead(final int i) {
        if (i == 1) {
            return this.head1;
        }
        if (i == 2) {
            return this.head2;
        }
        if (i == 3) {
            return this.head3;
        }
        return null;
    }
    
    public EntityTFHydraNeck getNeck(final int hi, final int s) {
        if (hi == 1) {
            if (s == 1) {
                return this.neck1a;
            }
            if (s == 2) {
                return this.neck1b;
            }
            if (s == 3) {
                return this.neck1c;
            }
            if (s == 4) {
                return this.neck1d;
            }
            return null;
        }
        else if (hi == 2) {
            if (s == 1) {
                return this.neck2a;
            }
            if (s == 2) {
                return this.neck2b;
            }
            if (s == 3) {
                return this.neck2c;
            }
            if (s == 4) {
                return this.neck2d;
            }
            return null;
        }
        else {
            if (hi != 3) {
                return null;
            }
            if (s == 1) {
                return this.neck3a;
            }
            if (s == 2) {
                return this.neck3b;
            }
            if (s == 3) {
                return this.neck3c;
            }
            if (s == 4) {
                return this.neck3d;
            }
            return null;
        }
    }
    
    protected void d_() {
        System.out.println("Calling updateEntityActionState");
        System.out.println("Current target = " + this.currentTarget);
        ++this.aV;
        final ih entityplayer = this.bi.a((tv)this, -1.0);
        this.aG();
        this.aW = 0.0f;
        this.aX = 0.0f;
        final float f = 32.0f;
        if (this.bS.nextFloat() < 0.7f) {
            final ih entityplayer2 = this.bi.a((tv)this, (double)f);
            if (entityplayer2 != null) {
                this.currentTarget = (tv)entityplayer2;
                this.bc = 100 + this.bS.nextInt(20);
            }
            else {
                this.aY = (this.bS.nextFloat() - 0.5f) * 20.0f;
            }
        }
        if (this.currentTarget != null) {
            this.a(this.currentTarget, 10.0f, (float)this.D());
            if (this.bc-- <= 0 || this.currentTarget.bE || this.currentTarget.j((tv)this) > f * f) {
                this.currentTarget = null;
            }
        }
        else {
            if (this.bS.nextFloat() < 0.05f) {
                this.aY = (this.bS.nextFloat() - 0.5f) * 20.0f;
            }
            this.bs += this.aY;
            this.bt = this.ba;
        }
        final boolean flag = this.aU();
        final boolean flag2 = this.aV();
        if (flag || flag2) {
            this.aZ = (this.bS.nextFloat() < 0.8f);
        }
    }
    
    public void a(final tv entity, final float f, final float f1) {
        super.a(entity, f, f1);
        this.faceEntity(this.head1, entity, f, f1);
        this.faceEntity(this.head2, entity, f, f1);
        this.faceEntity(this.head3, entity, f, f1);
        System.out.println("Looking at " + entity);
    }
    
    public void faceEntity(final EntityTFHydraPart head, final tv entity, final float f, final float f1) {
        final double xOffset = entity.bm - head.bm;
        final double yOffset = entity.bo - head.bo;
        double zOffset;
        if (entity instanceof ne) {
            final ne entityliving = (ne)entity;
            zOffset = head.bn + 1.5 - (entityliving.bn + entityliving.B());
        }
        else {
            zOffset = (entity.bw.b + entity.bw.e) / 2.0 - (head.bn + 1.5);
        }
        final double distance = kb.a(xOffset * xOffset + yOffset * yOffset);
        final float xyAngle = (float)(Math.atan2(yOffset, xOffset) * 180.0 / 3.1415927410125732) - 90.0f;
        final float zdAngle = (float)(-(Math.atan2(zOffset, distance) * 180.0 / 3.1415927410125732));
        head.bt = -updateRotation(head.bt, zdAngle, f1);
        head.bs = updateRotation(head.bs, xyAngle, f);
        System.out.println("Updating head " + head + " with rotation " + zdAngle);
        System.out.println("Updating head " + head + " with rotation " + xyAngle);
    }
    
    private static float updateRotation(final float prevRotation, final float desiredRotation, final float constraint) {
        float f3;
        for (f3 = desiredRotation - prevRotation; f3 < -180.0f; f3 += 360.0f) {}
        while (f3 >= 180.0f) {
            f3 -= 360.0f;
        }
        if (f3 > constraint) {
            f3 = constraint;
        }
        if (f3 < -constraint) {
            f3 = -constraint;
        }
        return prevRotation + f3;
    }
    
    public int D() {
        return 500;
    }
    
    public boolean a(final ez dragonpart, final rq damagesource, final int i) {
        final float f = this.bs * 3.141593f / 180.0f;
        final float f2 = kb.a(f);
        final float f3 = kb.b(f);
        if (damagesource.a() instanceof ih || damagesource == rq.l) {
            this.e(damagesource, i);
        }
        return true;
    }
    
    public tv[] bb() {
        return this.partArray;
    }
    
    public boolean o_() {
        return false;
    }
    
    public boolean e_() {
        return false;
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
        }
    }
}
