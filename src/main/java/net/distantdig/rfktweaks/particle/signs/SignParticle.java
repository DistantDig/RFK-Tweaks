package net.distantdig.rfktweaks.particle.signs;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;

public abstract class SignParticle extends TextureSheetParticle {
    private float startQuadSize;

    protected SignParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        super(level, x, y, z);

        this.gravity = 0.0f;
        this.lifetime = 40;
        this.rCol = 1.0f;
        this.gCol = 1.0f;
        this.bCol = 1.0f;
        this.quadSize = 0.7f;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.age == 1) {
            this.startQuadSize = this.quadSize;
        }

        float f = ((float) this.age) / (float) this.lifetime;
        float curve = 1.0f - (1.0f - f) * (1.0f - f);
        float endQuadSize = 0.4f;

        this.quadSize = startQuadSize + (endQuadSize - startQuadSize) * curve;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
