package com.dasheck.calendarwidget.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.dasheck.calendarwidget.R;

/**
 * Created by dasheck on 12/13/15.
 */
public class TriangleView extends View {

  private int fillColor;
  private Paint paint;

  public TriangleView(Context context) {
    super(context);
    preparePaint();
  }

  public TriangleView(Context context, AttributeSet attrs) {
    super(context, attrs);
    processCustomAttributes(context, attrs);
  }

  public TriangleView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    processCustomAttributes(context, attrs);
  }

  private void processCustomAttributes(Context context, AttributeSet attrs) {
    TypedArray array =
        context.getTheme().obtainStyledAttributes(attrs, R.styleable.TriangleView, 0, 0);

    try {
      fillColor = array.getColor(R.styleable.TriangleView_fillColor, Color.BLACK);
    } finally {
      array.recycle();
    }

    preparePaint();
  }

  public int getFillColor() {
    return fillColor;
  }

  public void setFillColor(int fillColor) {
    this.fillColor = fillColor;
    preparePaint();
  }

  private void preparePaint() {
    paint = new Paint();
    paint.setColor(fillColor);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    int width = getWidth();
    int height = getHeight();

    Path path = new Path();
    path.moveTo(0, 0);
    path.lineTo(width, 0);
    path.lineTo(width / 2, height);
    path.lineTo(0, 0);
    path.close();

    canvas.drawPath(path, paint);
  }
}
