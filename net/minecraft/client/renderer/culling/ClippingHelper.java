package net.minecraft.client.renderer.culling;

public class ClippingHelper
{
    public float[][] frustum = new float[6][4];
    public float[] projectionMatrix = new float[16];
    public float[] modelviewMatrix = new float[16];
    public float[] clippingMatrix = new float[16];
    public boolean disabled = false;

    /**
     * Returns true if the box is inside all 6 clipping planes, otherwise returns false.
     */
    public boolean isBoxInFrustum(double p_78553_1_, double p_78553_3_, double p_78553_5_, double p_78553_7_, double p_78553_9_, double p_78553_11_)
    {
        if (!this.disabled) {
            float f = (float) p_78553_1_;
            float f1 = (float) p_78553_3_;
            float f2 = (float) p_78553_5_;
            float f3 = (float) p_78553_7_;
            float f4 = (float) p_78553_9_;
            float f5 = (float) p_78553_11_;

            for (int i = 0; i < 6; ++i) {
                float[] afloat = this.frustum[i];
                float f6 = afloat[0];
                float f7 = afloat[1];
                float f8 = afloat[2];
                float f9 = afloat[3];

                if (f6 * f + f7 * f1 + f8 * f2 + f9 <= 0.0F && f6 * f3 + f7 * f1 + f8 * f2 + f9 <= 0.0F && f6 * f + f7 * f4 + f8 * f2 + f9 <= 0.0F && f6 * f3 + f7 * f4 + f8 * f2 + f9 <= 0.0F && f6 * f + f7 * f1 + f8 * f5 + f9 <= 0.0F && f6 * f3 + f7 * f1 + f8 * f5 + f9 <= 0.0F && f6 * f + f7 * f4 + f8 * f5 + f9 <= 0.0F && f6 * f3 + f7 * f4 + f8 * f5 + f9 <= 0.0F) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isBoxInFrustumFully(double p_isBoxInFrustumFully_1_, double p_isBoxInFrustumFully_3_, double p_isBoxInFrustumFully_5_, double p_isBoxInFrustumFully_7_, double p_isBoxInFrustumFully_9_, double p_isBoxInFrustumFully_11_)
    {
        if (!this.disabled) {
            float f = (float) p_isBoxInFrustumFully_1_;
            float f1 = (float) p_isBoxInFrustumFully_3_;
            float f2 = (float) p_isBoxInFrustumFully_5_;
            float f3 = (float) p_isBoxInFrustumFully_7_;
            float f4 = (float) p_isBoxInFrustumFully_9_;
            float f5 = (float) p_isBoxInFrustumFully_11_;

            for (int i = 0; i < 6; ++i) {
                float[] afloat = this.frustum[i];
                float f6 = afloat[0];
                float f7 = afloat[1];
                float f8 = afloat[2];
                float f9 = afloat[3];

                float v = f6 * f + f7 * f1 + f8 * f2 + f9;
                float v1 = f6 * f3 + f7 * f1 + f8 * f2 + f9;
                float v2 = f6 * f + f7 * f4 + f8 * f2 + f9;
                float v3 = f6 * f3 + f7 * f4 + f8 * f2 + f9;
                float v4 = f6 * f + f7 * f1 + f8 * f5 + f9;
                float v5 = f6 * f3 + f7 * f1 + f8 * f5 + f9;
                float v6 = f6 * f + f7 * f4 + f8 * f5 + f9;
                float v7 = f6 * f3 + f7 * f4 + f8 * f5 + f9;
                if (i < 4) {
                    if (v <= 0.0F || v1 <= 0.0F || v2 <= 0.0F || v3 <= 0.0F || v4 <= 0.0F || v5 <= 0.0F || v6 <= 0.0F || v7 <= 0.0F) {
                        return false;
                    }
                } else if (v <= 0.0F && v1 <= 0.0F && v2 <= 0.0F && v3 <= 0.0F && v4 <= 0.0F && v5 <= 0.0F && v6 <= 0.0F && v7 <= 0.0F) {
                    return false;
                }
            }

        }
        return true;
    }
}
