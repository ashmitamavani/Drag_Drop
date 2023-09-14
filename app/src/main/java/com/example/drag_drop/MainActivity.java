package com.example.drag_drop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);

        txt1.setOnLongClickListener(longClickListener);
        txt2.setOnLongClickListener(longClickListener);
        txt3.setOnDragListener(dragListener);

    }
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            ClipData clipData = ClipData.newPlainText("", "");
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, dragShadowBuilder, v, 0);


            return true;
        }

    };
    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View view= (View) event.getLocalState();
                    Log.d("TTT", "onDrag: DragEntered");
                    if(view.getId()==R.id.txt1)
                    {
                        txt3.setText("Txt1 is Dragged");
                    }
                    if(view.getId()==R.id.txt2)
                    {
                        txt3.setText("Txt2 is Dragged");
                    }
                    break;
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d("TTT", "onDrag: DragStarted");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d("TTT", "onDrag: DragExited");
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d("TTT", "onDrag: DragEnded");
                    break;
                case DragEvent.ACTION_DROP:
                    Log.d("TTT", "onDrag: Dropped");
                    View view1= (View) event.getLocalState();
                    if(view1.getId()==R.id.txt1)
                    {
                        txt1.setText("Txt3");
                    }
                    break;
            }

            return true;
        }
    };
}