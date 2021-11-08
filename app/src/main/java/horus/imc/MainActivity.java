package horus.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt_weight_;
    private EditText txt_height_;
    private TextView txt_result_;
    private Button btn_check_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_weight_ = findViewById(R.id.txt_weight);
        txt_height_ = findViewById(R.id.txt_height);
        txt_result_ = findViewById(R.id.txt_result);
        btn_check_ = findViewById(R.id.btn_check);

        register_events();
    }

    private void register_events() {
        btn_check_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validate_input()) {
                    Toast.makeText(MainActivity.this, R.string.msg_invalid_input, Toast.LENGTH_LONG).show();
                    return;
                }

                check_imc();
            }
        });
    }

    private boolean validate_input() {
        if(txt_weight_.getText().length() == 0)
            return false;

        if(txt_height_.getText().length() == 0)
            return false;

        if(Float.parseFloat(txt_weight_.getText().toString()) <= 0.0f)
            return false;

        if(Float.parseFloat(txt_height_.getText().toString()) <= 0.0f)
            return false;

        return true;
    }

    private void check_imc() {
        float weight = Float.parseFloat(txt_weight_.getText().toString());
        float height = Float.parseFloat(txt_height_.getText().toString());

        float imc = weight / (height * height);

        if(imc < 16) {
            txt_result_.setText(R.string.result_message_0);
            txt_result_.setBackgroundColor(getColor(R.color.result_message_0));
        }
        else if(imc >= 16 && imc < 17) {
            txt_result_.setText(R.string.result_message_1);
            txt_result_.setBackgroundColor(getColor(R.color.result_message_1));
        }
        else if(imc >= 17 && imc <= 18.5) {
            txt_result_.setText(R.string.result_message_2);
            txt_result_.setBackgroundColor(getColor(R.color.result_message_2));
        }
        else if(imc >= 18.5 && imc < 25) {
            txt_result_.setText(R.string.result_message_3);
            txt_result_.setBackgroundColor(getColor(R.color.result_message_3));
        }
        else if(imc >= 25 && imc < 30) {
            txt_result_.setText(R.string.result_message_4);
            txt_result_.setBackgroundColor(getColor(R.color.result_message_4));
        }
        else if(imc >= 30 && imc < 35) {
            txt_result_.setText(R.string.result_message_5);
            txt_result_.setBackgroundColor(getColor(R.color.result_message_5));
        }
        else if(imc >= 35 && imc < 40) {
            txt_result_.setText(R.string.result_message_6);
            txt_result_.setBackgroundColor(getColor(R.color.result_message_6));
        }
        else if(imc >= 40) {
            txt_result_.setText(R.string.result_message_7);
            txt_result_.setBackgroundColor(getColor(R.color.result_message_7));
        }
        else {
            txt_result_.setText(R.string.result_message_error);
        }
    }
}