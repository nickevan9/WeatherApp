package com.example.weatherapp.widget.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.weatherapp.R
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

class SunInDayCustom(context: Context, attrs: AttributeSet) : View(context, attrs) {

    val dashPath = DashPathEffect(floatArrayOf(10f, 10f), 1.0.toFloat())


    private val mArcPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mArcPaintAgain = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mLinePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mCirclePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mBitmapPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private lateinit var mStartHourSun: String
    private lateinit var mEndHourSun: String
    private lateinit var mNowHourSun: String

    private var mCenterX: Float = 0.0f
    private var mCenterY: Float = 0.0f
    private var mPositionSunX: Float = 0.0f
    private var mPositionSunY: Float = 0.0F
    private var mRadiusNow: Double = 0.0
    private var mLeft: Float = 0.0f
    private var mRight: Float = 0.0f
    private var mOval = RectF()

    init {
        val mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.SunInDayCustom)
        try {
            mStartHourSun = mTypedArray.getString(R.styleable.SunInDayCustom_start_time)!!
            mEndHourSun = mTypedArray.getString(R.styleable.SunInDayCustom_end_time)!!
            mNowHourSun = mTypedArray.getString(R.styleable.SunInDayCustom_now_time)!!
        } catch (e: NullPointerException) {

        } finally {
            mTypedArray.recycle()
        }
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val mDesiredWidth = width
        val mDesireHeight = height
        val mWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val mWidthSize = MeasureSpec.getSize(widthMeasureSpec)
        val mHeightMode = MeasureSpec.getMode(heightMeasureSpec)
        val mHeightSize = MeasureSpec.getSize(heightMeasureSpec)

        val mWidth: Int
        val mHeight: Int

        mWidth = when (mWidthMode) {
            MeasureSpec.EXACTLY -> mWidthSize
            MeasureSpec.AT_MOST -> min(mDesiredWidth, mWidthSize)
            else -> mDesiredWidth
        }

        mHeight = if (mWidth < 1000) {
            when (mHeightMode) {
                MeasureSpec.EXACTLY -> mHeightSize
                MeasureSpec.AT_MOST -> 350
                else -> 350
            }
        } else {
            when (mHeightMode) {
                MeasureSpec.EXACTLY -> mHeightSize
                MeasureSpec.AT_MOST -> 450
                else -> 450
            }
        }

        setMeasuredDimension(mWidth, mHeight)
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mArcPaint.apply {
            color = Color.WHITE
            pathEffect = dashPath
            isAntiAlias = true
            strokeWidth = 5f
            style = Paint.Style.STROKE
        }

        mArcPaintAgain.apply {
            color = Color.GREEN
            pathEffect = dashPath
            isAntiAlias = true
            strokeWidth = 5f
            style = Paint.Style.STROKE
        }

        mLinePaint.apply {
            color = Color.WHITE
        }

        mCirclePaint.apply {
            color = Color.GREEN
        }

        mBitmapPaint.apply {
            color = Color.GREEN
        }

        mTextPaint.apply {
            textSize = 30F
            color = Color.GREEN
            textAlign = Paint.Align.CENTER
        }

        //logic width height of arc

        val width = width.toFloat()
        val height = height.toFloat()

        val radius = width / 3


        mCenterX = width / 2
        mCenterY = height - 60F

        mLeft = mCenterX - radius
        val top = mCenterY - radius
        mRight = mCenterX + radius
        val bottom = mCenterY + radius

        mOval.set(mLeft, top, mRight, bottom)

        //logic time
        val startHourMinute = formatTime(mStartHourSun)
        val endHourMinutes = formatTime(mEndHourSun)
        val nowHourMinutes = formatTime(mNowHourSun)

        val scoreTime = (nowHourMinutes - startHourMinute) / (endHourMinutes - startHourMinute)
        mRadiusNow = 180 * scoreTime

        canvas!!.drawArc(mOval, 180f, 180f, false, mArcPaint)

        canvas.drawLine(0F, mCenterY, width, mCenterY, mLinePaint)

        canvas.drawCircle(mLeft, mCenterY, 10F, mCirclePaint)
        canvas.drawCircle(mRight, mCenterY, 10F, mCirclePaint)

        canvas.drawText(mStartHourSun, mCenterX - radius, mCenterY + 50, mTextPaint)
        canvas.drawText(mEndHourSun, mCenterX + radius, mCenterY + 50, mTextPaint)

        if (nowHourMinutes > startHourMinute && nowHourMinutes < endHourMinutes) {
            canvas.drawArc(mOval, 180f, mRadiusNow.toFloat(), false, mArcPaintAgain)
            val scoreTime = (nowHourMinutes - startHourMinute) / (endHourMinutes - startHourMinute)
            mRadiusNow = 180 * scoreTime

            if (mRadiusNow > 90) {
                mPositionSunX =
                    (mCenterX + sin((Math.toRadians(mRadiusNow - 90))) * radius).toFloat()
                mPositionSunY =
                    (mCenterY - cos((Math.toRadians(mRadiusNow - 90))) * radius).toFloat()
            }
            if (mRadiusNow < 90) {
                mPositionSunX = (mCenterX - sin(Math.toRadians(90 - mRadiusNow)) * radius).toFloat()
                mPositionSunY = (mCenterY - cos(Math.toRadians(90 - mRadiusNow)) * radius).toFloat()
            }

            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_sun)

            canvas.drawBitmap(
                Bitmap.createScaledBitmap(bitmap, 30, 30, false),
                mPositionSunX - 15,
                mPositionSunY - 15,
                mBitmapPaint
            )

        }

    }

    private fun formatTime(time: String): Double {
        val hour = time.subSequence(0, 2).toString().toInt()
        val minute = time.subSequence(3, 5).toString().toInt()
        return (hour * 60 + minute).toDouble()

    }

    fun updateTime(startTime: String, endTime: String, nowTime: String) {
        this.mStartHourSun = startTime
        this.mEndHourSun = endTime
        this.mNowHourSun = nowTime

        invalidate()
    }


}