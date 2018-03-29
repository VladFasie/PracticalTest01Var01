package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {

    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);

        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);

        b1.setOnClickListener(buttonClickListener);
        b2.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("text")) {
            String tmp = intent.getStringExtra("text");
            Toast.makeText(this, tmp, Toast.LENGTH_LONG).show();
        }
    }

    private ButtonClickListener buttonClickListener = new PracticalTest01Var01SecondaryActivity.ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            //Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);

            switch(view.getId()) {
                case R.id.button:
                    //intent.putExtra("text", "Register");
                    setResult(RESULT_OK, null);
                    break;
                case R.id.button2:
                    //intent.putExtra("text", "Cancel");
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }
}
