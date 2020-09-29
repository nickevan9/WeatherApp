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

import com.example.weatherapp.R;


public class CircularSeekBar extends View {
    protected static final int h0 = Color.argb(100, 74, 138, 255);

    protected static final int i0 = Color.argb(235, 74, 138, 255);

    protected static final int j0 = Color.argb(235, 74, 138, 255);

    protected static final int k0 = Color.argb(135, 74, 138, 255);

    protected int mPointerAlpha = 135;

    protected int mPointerAlphaOnTouch = 100;

    protected float C;

    protected float D;

    protected Path E;

    protected Path F;

    protected Path G;

    protected Path H;

    protected int mMaxProcess;

    protected int mCurProcess;

    protected boolean K;

    protected boolean L;

    protected boolean M;

    protected boolean lockEnabled = true;

//    protected boolean O = true;
//
//    protected boolean P = false;
//
//    protected boolean Q = false;
//
//    protected float R1;
//
//    protected float S;
//
//    protected float T;
//
//    protected float U;
//
//    protected float V;
//
//    protected float W;

    protected final float density = (getResources().getDisplayMetrics()).density;

//    protected boolean a0;

    protected Drawable mIndicatorIcon;

    protected float b0;

    protected Paint c;

    protected float c0;

    protected Paint d;

    protected float d0;

    protected Paint e;

    protected float[] e0 = new float[2];

    protected Paint f;

    protected OnCircularSeekBarChangeListener circularSeekBarChangeListener;

    protected Paint g;

    protected boolean isTouchEnabled = false;

    protected Paint h;

    protected Paint mPointerPaint;

    protected Paint j;

    protected float k;

    protected float l;

    protected float m;

    protected float n;

    protected float o;

    protected float p;

    public SparseArray<float[]> positionPercent = new SparseArray();

    protected float startAngle;

    protected float endAngle;

    private RectF rectF = new RectF();

    protected RectF s = new RectF();

    protected int mFinishedColor = h0;

    protected int mPointerColor = i0;

    protected int MPointerHaloColor = j0;

    protected int mPointerHaloColorOnTouch = k0;

    protected int mCircleColor = Color.YELLOW;

    protected int y = Color.TRANSPARENT;

    protected int mCircleProgressColor = Color.BLUE;

    public CircularSeekBar(Context paramContext) {
        super(paramContext);
        initAttributes(paramContext, null, 0);
    }

    public CircularSeekBar(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        initAttributes(paramContext, paramAttributeSet, 0);
    }

    public CircularSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        initAttributes(paramContext, paramAttributeSet, paramInt);
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

    protected void initAttributes() {
        this.d0 = this.mCurProcess / this.mMaxProcess * this.C + this.startAngle;
        this.d0 %= 360.0F;
    }

    protected void initAttributes(Context paramContext, TypedArray paramTypedArray) {
        this.l = paramTypedArray.getDimension(R.styleable.CircularSeekBar_circle_x_radius, this.density * 30.0F);
        this.m = paramTypedArray.getDimension(R.styleable.CircularSeekBar_circle_y_radius, this.density * 30.0F);
        this.n = paramTypedArray.getDimension(R.styleable.CircularSeekBar_ci_width, this.density * 7.0F);
        this.o = paramTypedArray.getDimension(R.styleable.CircularSeekBar_ci_height, this.density * 6.0F);
        this.p = paramTypedArray.getDimension(R.styleable.CircularSeekBar_circle_stroke_width, this.density * 1.0F);
        this.k = paramTypedArray.getDimension(R.styleable.CircularSeekBar_circle_stroke_width, this.density * 1.0F);
        this.mFinishedColor = paramTypedArray.getColor(R.styleable.CircularSeekBar_finished_color, h0);
        this.mPointerColor = paramTypedArray.getColor(R.styleable.CircularSeekBar_pointer_color, i0);
        this.MPointerHaloColor = paramTypedArray.getColor(R.styleable.CircularSeekBar_pointer_halo_color, j0);
        this.mPointerHaloColorOnTouch = paramTypedArray.getColor(R.styleable.CircularSeekBar_pointer_halo_color_ontouch, k0);
        this.mCircleColor = paramTypedArray.getColor(R.styleable.CircularSeekBar_circle_color, Color.YELLOW);
        this.mCircleProgressColor = paramTypedArray.getColor(R.styleable.CircularSeekBar_circle_progress_color, Color.BLUE);
        this.y = paramTypedArray.getColor(R.styleable.CircularSeekBar_circleColor, Color.TRANSPARENT);
        this.mPointerAlpha = Color.alpha(this.MPointerHaloColor);
        this.mPointerAlphaOnTouch = paramTypedArray.getInt(R.styleable.CircularSeekBar_pointer_alpha_ontouch, 100);
        int icPositionX = this.mPointerAlphaOnTouch;
        if (icPositionX > 255 || icPositionX < 0)
            this.mPointerAlphaOnTouch = 100;
        this.mMaxProcess = paramTypedArray.getInt(R.styleable.CircularSeekBar_circle_max_progress, 100);
        this.mCurProcess = paramTypedArray.getInt(R.styleable.CircularSeekBar_progress, 0);
//        this.K = paramTypedArray.getBoolean(22, false);
        this.K = false;
//        this.L = paramTypedArray.getBoolean(9, true);
        this.L = true;
//        this.M = paramTypedArray.getBoolean(11, false);
        this.M = false;
        this.lockEnabled = paramTypedArray.getBoolean(R.styleable.CircularSeekBar_lock_enabled, true);
        Drawable drawable = paramTypedArray.getDrawable(R.styleable.CircularSeekBar_pointer_icon);
        this.mIndicatorIcon = ContextCompat.getDrawable(paramContext, R.drawable.ic_sun);
        if (drawable != null)
            this.mIndicatorIcon = drawable;
        icPositionX = this.mIndicatorIcon.getIntrinsicWidth() / 4;
        int icPositionY = this.mIndicatorIcon.getIntrinsicHeight() / 4;
        this.mIndicatorIcon.setBounds(-icPositionX, -icPositionY, icPositionX, icPositionY);
        this.startAngle = (paramTypedArray.getFloat(R.styleable.CircularSeekBar_start_angle, 270.0F) % 360.0F + 360.0F) % 360.0F;
        this.endAngle = (paramTypedArray.getFloat(R.styleable.CircularSeekBar_end_angle, 270.0F) % 360.0F + 360.0F) % 360.0F;
        float start = this.startAngle;
        float end = this.endAngle;
        if (start == end)
            this.endAngle = end - 0.1F;
    }

    protected void initAttributes(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CircularSeekBar, paramInt, 0);
        initAttributes(paramContext, typedArray);
        typedArray.recycle();
        initStyle();
    }

    protected void b() {
        PathMeasure pathMeasure = new PathMeasure(this.H, false);
        if (!pathMeasure.getPosTan(pathMeasure.getLength(), this.e0, null))
            (new PathMeasure(this.G, false)).getPosTan(0.0F, this.e0, null);
    }

    protected void c() {
        this.D = this.d0 - this.startAngle;
        float f1 = this.D;
        float f2 = f1;
        if (f1 < 0.0F)
            f2 = f1 + 360.0F;
        this.D = f2;
    }

    protected void initCircle() {
        this.C = (360.0F - this.startAngle - this.endAngle) % 360.0F;
        if (this.C <= 0.0F)
            this.C = 360.0F;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mIndicatorIcon;
        if (drawable != null && drawable.isStateful()) {
            int[] arrayOfInt = getDrawableState();
            this.mIndicatorIcon.setState(arrayOfInt);
        }
        invalidate();
    }

    protected void initStyle() {
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
        this.g.setMaskFilter((MaskFilter)new BlurMaskFilter(this.density * 5.0F, BlurMaskFilter.Blur.NORMAL));

        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setColor(this.mFinishedColor);
        this.d.setStyle(Paint.Style.FILL_AND_STROKE);

        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.h.setDither(true);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(this.mPointerColor);
        this.h.setStrokeWidth(this.n);

        this.mPointerPaint = new Paint();
        this.mPointerPaint.set(this.h);
        this.mPointerPaint.setColor(this.MPointerHaloColor);
        this.mPointerPaint.setAlpha(this.mPointerAlpha);
        this.mPointerPaint.setStrokeWidth(this.n + this.o);

        this.j = new Paint();
        this.j.set(this.h);
        this.j.setStrokeWidth(this.p);
        this.j.setStyle(Paint.Style.STROKE);
    }

    protected void initPath() {
        this.G = new Path();
        this.G.addArc(this.s, this.startAngle, this.C);
        this.F = new Path();
        this.F.addArc(this.s, this.C, -this.startAngle);
        this.E = new Path();
        this.E.addArc(this.s, this.startAngle, this.C);
        this.H = new Path();
        this.H.addArc(this.s, this.startAngle, this.D);
    }

    protected void initRectF() {
        RectF rectF = this.s;
        float f1 = this.b0;
        float f2 = -f1;
        float f3 = this.c0;
        rectF.set(f2, -f3, f1, f3);
    }

    public int getCircleColor() {
        return this.mCircleColor;
    }

    public int getCircleFillColor() {
        return this.y;
    }

    public int getCircleProgressColor() {
        return this.mCircleProgressColor;
    }

    public int getFinishedColor() {
        return this.mFinishedColor;
    }

    public boolean getIsTouchEnabled() {
        return this.isTouchEnabled;
    }

    public int getPointerAlpha() {
        return this.mPointerAlpha;
    }

    public int getPointerAlphaOnTouch() {
        return this.mPointerAlphaOnTouch;
    }

    public int getPointerColor() {
        return this.mPointerColor;
    }

    public int getPointerHaloColor() {
        return this.MPointerHaloColor;
    }

    public int getProgress() {
        return Math.round(this.mMaxProcess * this.D / this.C);
    }

    protected void init() {
        initCircle();
        initAttributes();
        c();
        initRectF();
        initPath();
        b();
    }

    public boolean isLockEnabled() {
        return this.lockEnabled;
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
        this.mIndicatorIcon.draw(paramCanvas);
        this.positionPercent.put(this.mCurProcess, this.e0);
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
        init();
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        Bundle bundle = (Bundle)paramParcelable;
        super.onRestoreInstanceState(bundle.getParcelable("PARENT"));
        this.mMaxProcess = bundle.getInt("MAX");
        this.mCurProcess = bundle.getInt("PROGRESS");
        this.mCircleColor = bundle.getInt("mCircleColor");
        this.mCircleProgressColor = bundle.getInt("mCircleProgressColor");
        this.mFinishedColor = bundle.getInt("mFinishedColor");
        this.mPointerColor = bundle.getInt("mPointerColor");
        this.MPointerHaloColor = bundle.getInt("mPointerHaloColor");
        this.mPointerHaloColorOnTouch = bundle.getInt("mPointerHaloColorOnTouch");
        this.mPointerAlpha = bundle.getInt("mPointerAlpha");
        this.mPointerAlphaOnTouch = bundle.getInt("mPointerAlphaOnTouch");
        this.lockEnabled = bundle.getBoolean("lockEnabled");
        this.isTouchEnabled = bundle.getBoolean("isTouchEnabled");
        initStyle();
        init();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("PARENT", parcelable);
        bundle.putInt("MAX", this.mMaxProcess);
        bundle.putInt("PROGRESS", this.mCurProcess);
        bundle.putInt("mCircleColor", this.mCircleColor);
        bundle.putInt("mCircleProgressColor", this.mCircleProgressColor);
        bundle.putInt("mFinishedColor", this.mFinishedColor);
        bundle.putInt("mPointerColor", this.mPointerColor);
        bundle.putInt("mPointerHaloColor", this.MPointerHaloColor);
        bundle.putInt("mPointerHaloColorOnTouch", this.mPointerHaloColorOnTouch);
        bundle.putInt("mPointerAlpha", this.mPointerAlpha);
        bundle.putInt("mPointerAlphaOnTouch", this.mPointerAlphaOnTouch);
        bundle.putBoolean("lockEnabled", this.lockEnabled);
        bundle.putBoolean("isTouchEnabled", this.isTouchEnabled);
        return (Parcelable)bundle;
    }

    public void setCircleColor(int paramInt) {
        this.mCircleColor = paramInt;
        this.c.setColor(this.mCircleColor);
        invalidate();
    }

    public void setCircleFillColor(int paramInt) {
        this.y = paramInt;
        this.e.setColor(this.y);
        invalidate();
    }

    public void setCircleProgressColor(int paramInt) {
        this.mCircleProgressColor = paramInt;
        this.f.setColor(this.mCircleProgressColor);
        invalidate();
    }

    public void setFinishedColor(int paramInt) {
        this.mFinishedColor = paramInt;
        invalidate();
    }

    public void setIsTouchEnabled(boolean paramBoolean) {
        this.isTouchEnabled = paramBoolean;
    }

    public void setLockEnabled(boolean paramBoolean) {
        this.lockEnabled = paramBoolean;
    }

    public void setMax(int paramInt) {
        if (paramInt > 0) {
            if (paramInt <= this.mCurProcess) {
                this.mCurProcess = 0;
                OnCircularSeekBarChangeListener onCircularSeekBarChangeListener = this.circularSeekBarChangeListener;
                if (onCircularSeekBarChangeListener != null)
                    onCircularSeekBarChangeListener.onProgressChanged(this, this.mCurProcess, false);
            }
            this.mMaxProcess = paramInt;
            init();
            invalidate();
        }
    }

    public void setOnSeekBarChangeListener(OnCircularSeekBarChangeListener paramOnCircularSeekBarChangeListener) {
        this.circularSeekBarChangeListener = paramOnCircularSeekBarChangeListener;
    }

    public void setPointerAlpha(int paramInt) {
        if (paramInt >= 0 && paramInt <= 255) {
            this.mPointerAlpha = paramInt;
            this.mPointerPaint.setAlpha(this.mPointerAlpha);
            invalidate();
        }
    }

    public void setPointerAlphaOnTouch(int paramInt) {
        if (paramInt >= 0 && paramInt <= 255)
            this.mPointerAlphaOnTouch = paramInt;
    }

    public void setPointerColor(int paramInt) {
        this.mPointerColor = paramInt;
        this.h.setColor(this.mPointerColor);
        invalidate();
    }

    public void setPointerHaloColor(int paramInt) {
        this.MPointerHaloColor = paramInt;
        this.mPointerPaint.setColor(this.MPointerHaloColor);
        invalidate();
    }

    public void setPointerIcon(Drawable paramDrawable) {
        this.mIndicatorIcon = paramDrawable;
    }

    public void setProgress(int paramInt) {
        if (this.mCurProcess != paramInt) {
            this.mCurProcess = paramInt;
            OnCircularSeekBarChangeListener onCircularSeekBarChangeListener = this.circularSeekBarChangeListener;
            if (onCircularSeekBarChangeListener != null)
                onCircularSeekBarChangeListener.onProgressChanged(this, paramInt, false);
            init();
            invalidate();
        }
    }

    protected void setProgressBasedOnAngle(float paramFloat) {
        this.d0 = paramFloat;
        c();
        this.mCurProcess = Math.round(this.mMaxProcess * this.D / this.C);
    }

    public static interface OnCircularSeekBarChangeListener {
        void onProgressChanged(CircularSeekBar param1CircularSeekBar, int param1Int, boolean param1Boolean);

        void onStartTrackingTouch(CircularSeekBar param1CircularSeekBar);

        void onStopTrackingTouch(CircularSeekBar param1CircularSeekBar);
    }
}
