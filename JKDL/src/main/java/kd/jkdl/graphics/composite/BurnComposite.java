package main.java.kd.jkdl.graphics.composite;

import java.awt.CompositeContext;
import java.awt.RenderingHints;
import java.awt.image.ColorModel;

public final class BurnComposite extends RGBComposite 
{
	public BurnComposite( float alpha ) 
	{
        super( alpha );
	}

	public CompositeContext createContext( ColorModel srcColorModel, ColorModel dstColorModel, 
			RenderingHints hints ) 
	{
		return new Context( extraAlpha, srcColorModel, dstColorModel );
	}

    static class Context extends RGBCompositeContext 
    {
        public Context( float alpha, ColorModel srcColorModel, ColorModel dstColorModel ) 
        {
            super( alpha, srcColorModel, dstColorModel );
        }

        public void composeRGB( int[] src, int[] dst, float alpha ) 
        {
            int w = src.length;

            for ( int i = 0; i < w; i += 4 ) 
            {
                int sr = src[i];
                int dir = dst[i];
                int sg = src[i+1];
                int dig = dst[i+1];
                int sb = src[i+2];
                int dib = dst[i+2];
                int sa = src[i+3];
                int dia = dst[i+3];
                int dor, dog, dob;

                if (dir != 255)
                {
                	dor = clamp(255-(((int)(255-sr) << 8) / (dir+1)));
                }
                else
                {
                	dor = sr;
                }
                
                if (dig != 255)
                {
                	dog = clamp(255-(((int)(255-sg) << 8) / (dig+1)));
                }
                else
                {
                	dog = sg;
                }
                
                if (dib != 255)
                {
                	dob = clamp(255-(((int)(255-sb) << 8) / (dib+1)));
                }
                else
                {
                	dob = sb;
                }

                float a = alpha*sa/255f;
                float ac = 1-a;

                dst[i] = (int)(a*dor + ac*dir);
                dst[i+1] = (int)(a*dog + ac*dig);
                dst[i+2] = (int)(a*dob + ac*dib);
                dst[i+3] = (int)(sa*alpha + dia*ac);
            }
        }
    }
}