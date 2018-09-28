package edu.upc.jediupc.jediapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final char OP_SUM = '+';
    private static final char OP_MINUS = '-';
    private static final char OP_MUL = '*';
    private static final char OP_DIV = '/';
    private static final char NOP = '0';


    TextView tv;

    float curr = 0;
    float prev = 0;
    char op = NOP;


    private View.OnClickListener onNumberClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            int num = -1;
            switch (id) {
                case R.id.b0:
                    num = 0;
                    break;
                case R.id.b1:
                    num = 1;
                    break;
                case R.id.b2:
                    num = 2;
                    break;
                case R.id.b3:
                    num = 3;
                    break;
                case R.id.b4:
                    num = 4;
                    break;
                case R.id.b5:
                    num = 5;
                    break;
                case R.id.b6:
                    num = 6;
                    break;
                case R.id.b7:
                    num = 7;
                    break;
                case R.id.b8:
                    num = 8;
                    break;
                case R.id.b9:
                    num = 9;
                    break;
            }
            curr = curr * 10 + num;
            tv.setText(String.valueOf(curr));
        }
    };

    private View.OnClickListener onOperationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();

            if (id == R.id.beq) {
                onEquals();
                return;
            }

            switch (id) {
                case R.id.bplus:
                    op = OP_SUM;
                    break;
                case R.id.bminus:
                    op = OP_MINUS;
                    break;
                case R.id.bmul:
                    op = OP_MUL;
                    break;
                case R.id.bdiv:
                    op = OP_DIV;
                    break;
            }
            prev = curr;
            curr = 0;
            tv.setText(String.valueOf(op));
        }
    };

    private void onEquals() {
        if (op == NOP) {
            return;
        }

        float res = 0;
        switch (op) {
            case OP_SUM:
                res = curr + prev;
                break;
            case OP_MINUS:
                res = prev - curr;
                break;
            case OP_MUL:
                res = curr * prev;
                break;
            case OP_DIV:
                res = prev / curr;
                break;
        }

        tv.setText(String.valueOf(res));
        curr = res;
        prev = 0;
        op = NOP;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);

        findViewById(R.id.b0).setOnClickListener(onNumberClickListener);
        findViewById(R.id.b1).setOnClickListener(onNumberClickListener);
        findViewById(R.id.b2).setOnClickListener(onNumberClickListener);
        findViewById(R.id.b3).setOnClickListener(onNumberClickListener);
        findViewById(R.id.b4).setOnClickListener(onNumberClickListener);
        findViewById(R.id.b5).setOnClickListener(onNumberClickListener);
        findViewById(R.id.b6).setOnClickListener(onNumberClickListener);
        findViewById(R.id.b7).setOnClickListener(onNumberClickListener);
        findViewById(R.id.b8).setOnClickListener(onNumberClickListener);
        findViewById(R.id.b9).setOnClickListener(onNumberClickListener);

        findViewById(R.id.bplus).setOnClickListener(onOperationClickListener);
        findViewById(R.id.bminus).setOnClickListener(onOperationClickListener);
        findViewById(R.id.bmul).setOnClickListener(onOperationClickListener);
        findViewById(R.id.bdiv).setOnClickListener(onOperationClickListener);
        findViewById(R.id.beq).setOnClickListener(onOperationClickListener);


    }


}
