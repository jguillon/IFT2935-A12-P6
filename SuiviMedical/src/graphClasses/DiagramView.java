package graphClasses;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.view.View;

/**
 * GraphView shows data as scaled line 
 * code utilise de GraphView: http://android.arnodenhond.com/components/graphview
 */
public class DiagramView extends View {


	private Paint paint;
	private double[] values;
	private String[] dates;
	private String title;

	public DiagramView(Context context, double[] values, String[] dates, String title) {
		super(context);
		this.values = values;
		this.dates = dates;
		this.title = title;
		paint = new Paint();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		float border = 20;
		float horstart = border * 2;
		float height = getHeight();
		float width = getWidth() - 10;
		float max = getMax();
		float min = getMin();
		float diff = max - min;
		float graphheight = height - (2 * border);
		float graphwidth = width - (2 * border);

		paint.setTextAlign(Align.LEFT);

		paint.setColor(Color.DKGRAY);
		canvas.drawLine(horstart, height, width, height, paint);
		paint.setColor(Color.BLACK);
		canvas.drawText(Float.toString(getMax()), 0, height, paint);
		
		paint.setColor(Color.DKGRAY);
		canvas.drawLine(horstart, horstart, width, horstart, paint);
		paint.setColor(Color.BLACK);
		canvas.drawText(Float.toString(getMin()), 0, horstart, paint);
		
		
		for (int i = 0; i < dates.length; i++) {
			paint.setColor(Color.DKGRAY);
			float x = ((graphwidth / (dates.length - 1)) * i) + horstart;
			canvas.drawLine(x, height - border, x, border, paint);
			paint.setTextAlign(Align.CENTER);
			if (i==dates.length-1)
				paint.setTextAlign(Align.RIGHT);
			if (i==0)
				paint.setTextAlign(Align.LEFT);
			paint.setColor(Color.BLACK);
			canvas.drawText(dates[i], x, height - 4, paint);
		}

		paint.setTextAlign(Align.CENTER);
		canvas.drawText(title, (graphwidth / 2) + horstart, border - 4, paint);

		if (max != min) {
			paint.setColor(Color.LTGRAY);

		{
				float datalength = values.length;
				float colwidth = (width - (2 * border)) / datalength;
				float halfcol = colwidth / 2;
				float lasth = 0;
				for (int i = 0; i < values.length; i++) {
					float val = (float)values[i] - min;
					float rat = val / diff;
					float h = graphheight * rat;
					if (i > 0)
						canvas.drawLine(((i - 1) * colwidth) + (horstart + 1) + halfcol, (border - lasth) + graphheight, (i * colwidth) + (horstart + 1) + halfcol, (border - h) + graphheight, paint);
					lasth = h;
				}
			}
		}
	}

	private float getMax() {
		float largest = Integer.MIN_VALUE;
		for (int i = 0; i < values.length; i++)
			if (values[i] > largest)
				largest = (float) values[i];
		return largest;
	}

	private float getMin() {
		float smallest = Integer.MAX_VALUE;
		for (int i = 0; i < values.length; i++)
			if (values[i] < smallest)
				smallest = (float) values[i];
		return smallest;
	}

}
