package com.example.weatherapp.widget.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.weatherapp.R
import kotlin.math.min

class ProgressCustom(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var mPositionProgress = 0

    private var mListProgressItem = mutableListOf<ProgressItem>()

    private val mProgressPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mTextPaintProcess: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mCirclePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mTextStatus: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var mProgressItemWidth: Float = 0.0f
    private var mProgressItemRight: Float = 0.0f
    private var mLastProgressX = 0F

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

        mHeight = when (mHeightMode) {
            MeasureSpec.EXACTLY -> mHeightSize
            MeasureSpec.AT_MOST -> 100
            else -> 100
        }

        setMeasuredDimension(mWidth, mHeight)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mLastProgressX = 0F
        mProgressItemRight = 0F

        mProgressPaint.apply {
            strokeWidth = 4F
        }

        mTextPaintProcess.apply {
            color = Color.WHITE
            textSize = 24F
            textAlign = Paint.Align.LEFT
        }

        mCirclePaint.apply {
            color = Color.WHITE
        }

        mTextStatus.apply {
            color = Color.parseColor("#C5C9DF")
            textSize = 24F
            textAlign = Paint.Align.LEFT
        }

        mListProgressItem = initListProgressItem()

        val mWidthScreen = width.toFloat()
        val mHeightScreen = height.toFloat()

        val mCenterY = mHeightScreen / 2

        canvas!!.drawText("0", mLastProgressX + 2, mCenterY - 20F, mTextPaintProcess)
        canvas.drawText("Tốt", mLastProgressX + 2, mCenterY + 30F, mTextStatus)

        for (i in 0 until mListProgressItem.size) {
            val mProgressItem = mListProgressItem[i]

            mProgressPaint.color = resources.getColor(
                mProgressItem.color
            )

            mProgressItemWidth = (mProgressItem.progressItemPercentage * mWidthScreen / 500)

            mProgressItemRight = mLastProgressX + mProgressItemWidth

            if (i == mListProgressItem.size - 1) {
                mProgressItemRight = mWidthScreen

                mTextPaintProcess.textAlign = Paint.Align.RIGHT

                mTextStatus.textAlign = Paint.Align.RIGHT

                canvas.drawLine(
                    mLastProgressX,
                    mCenterY,
                    mProgressItemRight,
                    mCenterY,
                    mProgressPaint
                )

                canvas.drawText(
                    mProgressItem.progressValue.toString(),
                    mProgressItemRight - 2,
                    mCenterY - 20F,
                    mTextPaintProcess
                )

                canvas.drawText("Nguy hiểm", mProgressItemRight - 2, mCenterY + 30F, mTextStatus)

            } else {
                canvas.drawLine(
                    mLastProgressX,
                    mCenterY,
                    mProgressItemRight,
                    mCenterY,
                    mProgressPaint
                )

                canvas.drawText(
                    mProgressItem.progressValue.toString(),
                    mProgressItemRight,
                    mCenterY - 20F,
                    mTextPaintProcess
                )
            }

            val positionProgressX = mPositionProgress * mWidthScreen / 500

            canvas.drawCircle(positionProgressX, mCenterY, 10F, mCirclePaint)

            mLastProgressX = mProgressItemRight

        }

    }

    fun updateProgress(progressPosition: Int) {
        this.mPositionProgress = progressPosition
        invalidate()
    }

    fun initListProgressItem(): MutableList<ProgressItem> {
        mListProgressItem.clear()

        mListProgressItem.add(
            ProgressItem(
                R.color.colorFirst,
                50F,
                50
                ,
                resources.getString(R.string.excellent_title),
                resources.getString(R.string.excellent_description)
            )
        )

        mListProgressItem.add(
            ProgressItem(
                R.color.colorSecond,
                50F,
                100
                ,
                resources.getString(R.string.good_title),
                resources.getString(R.string.good_description)
            )
        )

        mListProgressItem.add(
            ProgressItem(
                R.color.colorThird,
                50F,
                150,
                resources.getString(R.string.slight_pollution_title),
                resources.getString(R.string.slight_pollution_description)
            )
        )

        mListProgressItem.add(
            ProgressItem(
                R.color.colorFourth,
                50F,
                200,
                resources.getString(R.string.moderate_pollution_title),
                resources.getString(R.string.moderate_pollution_description)
            )
        )

        mListProgressItem.add(
            ProgressItem(
                R.color.colorFifth,
                100F,
                300,
                resources.getString(R.string.heavily_polluted_title),
                resources.getString(R.string.heavily_polluted_description)
            )
        )

        mListProgressItem.add(
            ProgressItem(
                R.color.colorSixth,
                200F,
                500,
                resources.getString(R.string.heavy_pollution_title),
                resources.getString(R.string.heavy_pollution_description)
            )
        )

        return mListProgressItem
    }

}