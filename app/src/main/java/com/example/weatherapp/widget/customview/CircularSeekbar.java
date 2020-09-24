package com.example.weatherapp.widget.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;

import android.view.View;
import androidx.core.content.ContextCompat;


public class CircularSeekBar extends View {
    protected static final int h0 = Color.argb(100, 74, 138, 255);

    protected static final int i0 = Color.argb(235, 74, 138, 255);

    protected static final int j0 = Color.argb(235, 74, 138, 255);

    protected static final int k0 = Color.argb(135, 74, 138, 255);

    protected int A = 135;

    protected int B = 100;

    protected float C;

    protected float D;

    protected Path E;

    protected Path F;

    protected Path G;

    protected Path H;

    protected int I;

    protected int J;

    protected boolean K;

    protected boolean L;

    protected boolean M;

    protected boolean N = true;

    protected boolean O = true;

    protected boolean P = false;

    protected boolean Q = false;

    protected float R;

    protected float S;

    protected float T;

    protected float U;

    protected float V;

    protected float W;

    protected final float a = (getResources().getDisplayMetrics()).density;

    protected boolean a0;

    protected Drawable b;

    protected float b0;

    protected Paint c;

    protected float c0;

    protected Paint d;

    protected float d0;

    protected Paint e;

    protected float[] e0 = new float[2];

    protected Paint f;

    protected OnCircularSeekBarChangeListener f0;

    protected Paint g;

    protected boolean g0 = false;

    protected Paint h;

    protected Paint i;

    protected Paint j;

    protected float k;

    protected float l;

    protected float m;

    protected float n;

    protected float o;

    protected float p;

    public SparseArray<float[]> positionPercent = new SparseArray();

    protected float q;

    protected float r;

    private RectF rectF = new RectF();

    protected RectF s = new RectF();

    protected int t = h0;

    protected int u = i0;

    protected int v = j0;

    protected int w = k0;

    protected int x = -256;

    protected int y = -1;

    protected int z = -16776961;

    public CircularSeekBar(Context paramContext) {
        super(paramContext);
        a(paramContext, null, 0);
    }

    public CircularSeekBar(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext, paramAttributeSet, 0);
    }

    public CircularSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext, paramAttributeSet, paramInt);
    }

    private void calculateRecF(int paramInt1, int paramInt2) {
        paramInt1 = Math.min(paramInt1, paramInt2);
        float f1 = this.k - this.n - this.p * 1.5F - 4.0F;
        RectF rectF = this.rectF;
        float f2 = 0.0F - f1;
        rectF.set(f2, f2, View.MeasureSpec.getSize(paramInt1) + f1, View.MeasureSpec.getSize(paramInt1) + f1);
    }

    private void drawFinishedColor(Canvas paramCanvas) {
        float f = this.d0 - 180.0F;
        paramCanvas.rotate(270.0F, (getWidth() / 2), (getHeight() / 2));
        paramCanvas.drawArc(this.rectF, 270.0F - f, f * 2.0F, false, this.d);
        paramCanvas.rotate(90.0F, (getWidth() / 2), (getHeight() / 2));
    }

    protected void a() {
        this.d0 = this.J / this.I * this.C + this.q;
        this.d0 %= 360.0F;
    }

    protected void a(Context paramContext, TypedArray paramTypedArray) {
        this.l = paramTypedArray.getDimension(4, this.a * 30.0F);
        this.m = paramTypedArray.getDimension(5, this.a * 30.0F);
        this.n = paramTypedArray.getDimension(19, this.a * 7.0F);
        this.o = paramTypedArray.getDimension(18, this.a * 6.0F);
        this.p = paramTypedArray.getDimension(15, this.a * 1.0F);
        this.k = paramTypedArray.getDimension(3, this.a * 1.0F);
        this.t = paramTypedArray.getColor(7, h0);
        this.u = paramTypedArray.getColor(14, i0);
        this.v = paramTypedArray.getColor(16, j0);
        this.w = paramTypedArray.getColor(17, k0);
        this.x = paramTypedArray.getColor(0, -256);
        this.z = paramTypedArray.getColor(2, -16776961);
        this.y = paramTypedArray.getColor(1, -1);
        this.A = Color.alpha(this.v);
        this.B = paramTypedArray.getInt(13, 100);
        int i = this.B;
        if (i > 255 || i < 0)
            this.B = 100;
        this.I = paramTypedArray.getInt(10, 100);
        this.J = paramTypedArray.getInt(20, 0);
        this.K = paramTypedArray.getBoolean(22, false);
        this.L = paramTypedArray.getBoolean(9, true);
        this.M = paramTypedArray.getBoolean(11, false);
        this.N = paramTypedArray.getBoolean(8, true);
        Drawable drawable = paramTypedArray.getDrawable(12);
        this.b = ContextCompat.getDrawable(paramContext, 2131165744);
        if (drawable != null)
            this.b = drawable;
        i = this.b.getIntrinsicWidth() / 4;
        int j = this.b.getIntrinsicHeight() / 4;
        this.b.setBounds(-i, -j, i, j);
        this.q = (paramTypedArray.getFloat(21, 270.0F) % 360.0F + 360.0F) % 360.0F;
        this.r = (paramTypedArray.getFloat(6, 270.0F) % 360.0F + 360.0F) % 360.0F;
        float f1 = this.q;
        float f2 = this.r;
        if (f1 == f2)
            this.r = f2 - 0.1F;
    }

    protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CircularSeekBar, paramInt, 0);
        a(paramContext, typedArray);
        typedArray.recycle();
        e();
    }

    protected void b() {
        PathMeasure pathMeasure = new PathMeasure(this.H, false);
        if (!pathMeasure.getPosTan(pathMeasure.getLength(), this.e0, null))
            (new PathMeasure(this.G, false)).getPosTan(0.0F, this.e0, null);
    }

    protected void c() {
        this.D = this.d0 - this.q;
        float f1 = this.D;
        float f2 = f1;
        if (f1 < 0.0F)
            f2 = f1 + 360.0F;
        this.D = f2;
    }

    protected void d() {
        this.C = (360.0F - this.q - this.r) % 360.0F;
        if (this.C <= 0.0F)
            this.C = 360.0F;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful()) {
            int[] arrayOfInt = getDrawableState();
            this.b.setState(arrayOfInt);
        }
        invalidate();
    }

    protected void e() {
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setDither(true);
        this.c.setColor(-1);
        this.c.setLinearText(true);
        this.c.setDither(true);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.k);
        this.c.setPathEffect((PathEffect)new DashPathEffect(new float[] { 10.0F, 10.0F, 10.0F, 10.0F }, 0.0F));
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeJoin(Paint.Join.ROUND);
        this.c.setStrokeCap(Paint.Cap.ROUND);
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setDither(true);
        this.e.setColor(this.y);
        this.e.setStyle(Paint.Style.FILL);
        this.f = new Paint();
        this.f.setAntiAlias(true);
        this.f.setDither(true);
        this.f.setColor(0);
        this.f.setStrokeWidth(this.k);
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeJoin(Paint.Join.ROUND);
        this.f.setStrokeCap(Paint.Cap.ROUND);
        this.g = new Paint();
        this.g.set(this.f);
        this.g.setMaskFilter((MaskFilter)new BlurMaskFilter(this.a * 5.0F, BlurMaskFilter.Blur.NORMAL));
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setColor(this.t);
        this.d.setStyle(Paint.Style.FILL_AND_STROKE);
        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.h.setDither(true);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(this.u);
        this.h.setStrokeWidth(this.n);
        this.i = new Paint();
        this.i.set(this.h);
        this.i.setColor(this.v);
        this.i.setAlpha(this.A);
        this.i.setStrokeWidth(this.n + this.o);
        this.j = new Paint();
        this.j.set(this.h);
        this.j.setStrokeWidth(this.p);
        this.j.setStyle(Paint.Style.STROKE);
    }

    protected void f() {
        this.G = new Path();
        this.G.addArc(this.s, this.q, this.C);
        this.F = new Path();
        this.F.addArc(this.s, this.C, -this.q);
        this.E = new Path();
        this.E.addArc(this.s, this.q, this.C);
        this.H = new Path();
        this.H.addArc(this.s, this.q, this.D);
    }

    protected void g() {
        RectF rectF = this.s;
        float f1 = this.b0;
        float f2 = -f1;
        float f3 = this.c0;
        rectF.set(f2, -f3, f1, f3);
    }

    public int getCircleColor() {
        return this.x;
    }

    public int getCircleFillColor() {
        return this.y;
    }

    public int getCircleProgressColor() {
        return this.z;
    }

    public int getFinishedColor() {
        return this.t;
    }

    public boolean getIsTouchEnabled() {
        return this.g0;
    }

    public int getMax() {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield I : I
        //   6: istore_1
        //   7: aload_0
        //   8: monitorexit
        //   9: iload_1
        //   10: ireturn
        //   11: astore_2
        //   12: aload_0
        //   13: monitorexit
        //   14: aload_2
        //   15: athrow
        // Exception table:
        //   from	to	target	type
        //   2	7	11	finally
    }

    public int getPointerAlpha() {
        return this.A;
    }

    public int getPointerAlphaOnTouch() {
        return this.B;
    }

    public int getPointerColor() {
        return this.u;
    }

    public int getPointerHaloColor() {
        return this.v;
    }

    public int getProgress() {
        return Math.round(this.I * this.D / this.C);
    }

    protected void h() {
        d();
        a();
        c();
        g();
        f();
        b();
    }

    public boolean isLockEnabled() {
        return this.N;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        drawFinishedColor(paramCanvas);
        paramCanvas.translate((getWidth() / 2), (getHeight() / 2));
        paramCanvas.drawPath(this.G, this.c);
        paramCanvas.drawPath(this.H, this.g);
        paramCanvas.drawPath(this.H, this.f);
        paramCanvas.drawPath(this.F, this.e);
        paramCanvas.drawLine(0.0F, (paramCanvas.getHeight() / 2), paramCanvas.getWidth(), (paramCanvas.getHeight() / 2), this.c);
        float[] arrayOfFloat = this.e0;
        paramCanvas.translate(arrayOfFloat[0], arrayOfFloat[1]);
        this.b.draw(paramCanvas);
        this.positionPercent.put(this.J, this.e0);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        paramInt2 = View.getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
        paramInt1 = View.getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
        calculateRecF(paramInt1, paramInt2);
        int i = Math.min(paramInt1, paramInt2);
        if (this.L) {
            setMeasuredDimension(i, i);
        } else {
            setMeasuredDimension(paramInt1, paramInt2);
        }
        float f1 = paramInt2 / 2.0F;
        float f2 = this.k;
        float f3 = this.n;
        float f4 = this.p;
        this.c0 = f1 - f2 - f3 - f4 * 1.5F;
        this.b0 = paramInt1 / 2.0F - f2 - f3 - f4 * 1.5F;
        if (this.K) {
            f1 = this.m;
            if (f1 - f2 - f3 - f4 < this.c0)
                this.c0 = f1 - f2 - f3 - f4 * 1.5F;
            f4 = this.l;
            f2 = this.k;
            f3 = this.n;
            f1 = this.p;
            if (f4 - f2 - f3 - f1 < this.b0)
                this.b0 = f4 - f2 - f3 - f1 * 1.5F;
        }
        if (this.L) {
            f2 = Math.min(this.c0, this.b0);
            this.c0 = f2;
            this.b0 = f2;
        }
        h();
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        Bundle bundle = (Bundle)paramParcelable;
        super.onRestoreInstanceState(bundle.getParcelable("PARENT"));
        this.I = bundle.getInt("MAX");
        this.J = bundle.getInt("PROGRESS");
        this.x = bundle.getInt("mCircleColor");
        this.z = bundle.getInt("mCircleProgressColor");
        this.t = bundle.getInt("mFinishedColor");
        this.u = bundle.getInt("mPointerColor");
        this.v = bundle.getInt("mPointerHaloColor");
        this.w = bundle.getInt("mPointerHaloColorOnTouch");
        this.A = bundle.getInt("mPointerAlpha");
        this.B = bundle.getInt("mPointerAlphaOnTouch");
        this.N = bundle.getBoolean("lockEnabled");
        this.g0 = bundle.getBoolean("isTouchEnabled");
        e();
        h();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("PARENT", parcelable);
        bundle.putInt("MAX", this.I);
        bundle.putInt("PROGRESS", this.J);
        bundle.putInt("mCircleColor", this.x);
        bundle.putInt("mCircleProgressColor", this.z);
        bundle.putInt("mFinishedColor", this.t);
        bundle.putInt("mPointerColor", this.u);
        bundle.putInt("mPointerHaloColor", this.v);
        bundle.putInt("mPointerHaloColorOnTouch", this.w);
        bundle.putInt("mPointerAlpha", this.A);
        bundle.putInt("mPointerAlphaOnTouch", this.B);
        bundle.putBoolean("lockEnabled", this.N);
        bundle.putBoolean("isTouchEnabled", this.g0);
        return (Parcelable)bundle;
    }

    public void setCircleColor(int paramInt) {
        this.x = paramInt;
        this.c.setColor(this.x);
        invalidate();
    }

    public void setCircleFillColor(int paramInt) {
        this.y = paramInt;
        this.e.setColor(this.y);
        invalidate();
    }

    public void setCircleProgressColor(int paramInt) {
        this.z = paramInt;
        this.f.setColor(this.z);
        invalidate();
    }

    public void setFinishedColor(int paramInt) {
        this.t = paramInt;
        invalidate();
    }

    public void setIsTouchEnabled(boolean paramBoolean) {
        this.g0 = paramBoolean;
    }

    public void setLockEnabled(boolean paramBoolean) {
        this.N = paramBoolean;
    }

    public void setMax(int paramInt) {
        if (paramInt > 0) {
            if (paramInt <= this.J) {
                this.J = 0;
                OnCircularSeekBarChangeListener onCircularSeekBarChangeListener = this.f0;
                if (onCircularSeekBarChangeListener != null)
                    onCircularSeekBarChangeListener.onProgressChanged(this, this.J, false);
            }
            this.I = paramInt;
            h();
            invalidate();
        }
    }

    public void setOnSeekBarChangeListener(OnCircularSeekBarChangeListener paramOnCircularSeekBarChangeListener) {
        this.f0 = paramOnCircularSeekBarChangeListener;
    }

    public void setPointerAlpha(int paramInt) {
        if (paramInt >= 0 && paramInt <= 255) {
            this.A = paramInt;
            this.i.setAlpha(this.A);
            invalidate();
        }
    }

    public void setPointerAlphaOnTouch(int paramInt) {
        if (paramInt >= 0 && paramInt <= 255)
            this.B = paramInt;
    }

    public void setPointerColor(int paramInt) {
        this.u = paramInt;
        this.h.setColor(this.u);
        invalidate();
    }

    public void setPointerHaloColor(int paramInt) {
        this.v = paramInt;
        this.i.setColor(this.v);
        invalidate();
    }

    public void setPointerIcon(Drawable paramDrawable) {
        this.b = paramDrawable;
    }

    public void setProgress(int paramInt) {
        if (this.J != paramInt) {
            this.J = paramInt;
            OnCircularSeekBarChangeListener onCircularSeekBarChangeListener = this.f0;
            if (onCircularSeekBarChangeListener != null)
                onCircularSeekBarChangeListener.onProgressChanged(this, paramInt, false);
            h();
            invalidate();
        }
    }

    protected void setProgressBasedOnAngle(float paramFloat) {
        this.d0 = paramFloat;
        c();
        this.J = Math.round(this.I * this.D / this.C);
    }

    public static interface OnCircularSeekBarChangeListener {
        void onProgressChanged(CircularSeekBar param1CircularSeekBar, int param1Int, boolean param1Boolean);

        void onStartTrackingTouch(CircularSeekBar param1CircularSeekBar);

        void onStopTrackingTouch(CircularSeekBar param1CircularSeekBar);
    }
}
