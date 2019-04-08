package com.example.juzza.mygamifieddegree;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

public class level3 extends AppCompatActivity {

    TextView txt1,txt2,txt3,txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        txt4=findViewById(R.id.target);

        txt1.setOnLongClickListener(longClickListener);
        txt2.setOnLongClickListener(longClickListener);
        txt3.setOnLongClickListener(longClickListener);

        txt4.setOnDragListener(dragListener);

    }

    View.OnLongClickListener longClickListener=new View.OnLongClickListener(){
        @Override
        public boolean onLongClick(View view) {
            ClipData data=ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder=new View.DragShadowBuilder(view);
            view.startDrag(data,shadowBuilder,view,0);

            return true;
        }
    };

    View.OnDragListener dragListener=new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent =event.getAction();
            final View view=(View) event.getLocalState();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:


                     if(view.getId()==R.id.txt1){
                         txt4.setText("1 is entered");

                     }else if(view.getId()==R.id.txt2){txt4.setText("2 is entered");}
                     else  if(view.getId()==R.id.txt3){txt4.setText("3 is entered");}


                    break;

                case DragEvent.ACTION_DRAG_EXITED:




                    if(view.getId()==R.id.txt1){
                        txt4.setText("1 is exitted");

                    }else if(view.getId()==R.id.txt2){txt4.setText("2 is exitted");}
                    else  if(view.getId()==R.id.txt3){txt4.setText("3 is exitted");}

                    break;

                case DragEvent.ACTION_DROP:

                    if(view.getId()==R.id.txt1){
                        txt4.setText("");


                    }else if(view.getId()==R.id.txt2){txt4.setText("2 is dropped");}
                    else  if(view.getId()==R.id.txt3){txt4.setText("3 is dropped");}


                    view.animate()
                            .x(txt4.getX())
                            .y(txt4.getY())
                            .setDuration(700)
                            .start();
                    break;




            }


            return true;
        }
    };
}
