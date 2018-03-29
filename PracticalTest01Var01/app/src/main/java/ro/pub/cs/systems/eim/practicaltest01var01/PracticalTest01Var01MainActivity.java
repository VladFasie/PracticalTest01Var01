package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private Button N, S, V, E;
    private Button navigate;
    private TextView text;
    private int count;
    private int code = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);


        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("count")) {
                count = savedInstanceState.getInt("count");
            } else {
                count = 0;
            }
        } else {
            count = 0;
        }
        count = 0;

        N = (Button)findViewById(R.id.N);
        S = (Button)findViewById(R.id.S);
        E = (Button)findViewById(R.id.E);
        V = (Button)findViewById(R.id.V);

        navigate = (Button)findViewById(R.id.Navigate);

        text = (TextView)findViewById(R.id.Text);

        N.setOnClickListener(buttonClickListener);
        S.setOnClickListener(buttonClickListener);
        E.setOnClickListener(buttonClickListener);
        V.setOnClickListener(buttonClickListener);
        navigate.setOnClickListener(buttonClickListener);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("count", count);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("count")) {
            count = savedInstanceState.getInt("count");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == code) {
            if (resultCode == RESULT_OK)
                Toast.makeText(this, "register", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "cancel", Toast.LENGTH_LONG).show();
        }
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.N:
                    text.setText(text.getText().toString() + "N");
                    count++;
                    break;
                case R.id.S:
                    text.setText(text.getText().toString() + "S");
                    count++;
                    break;
                case R.id.E:
                    text.setText(text.getText().toString() + "E");
                    count++;
                    break;
                case R.id.V:
                    text.setText(text.getText().toString() + "V");
                    count++;
                    break;
                case R.id.Navigate:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
                    intent.putExtra("text", text.getText().toString());
                    startActivityForResult(intent, code);
                    count = 0;
                    text.setText("");
                    break;
            }

            if (count % 3 == 0) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, count + "", duration);
                toast.show();
            }
        }
    }
}
