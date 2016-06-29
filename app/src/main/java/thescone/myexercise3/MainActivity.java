package thescone.myexercise3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // layout
        RelativeLayout rl = new RelativeLayout(this);
        rl.setBackgroundColor(Color.GREEN);

        // button
        Button redButton = new Button(this);
        redButton.setText("Log In");
        redButton.setBackgroundColor(Color.RED);

        // Username input
        EditText username = new EditText(this);

        redButton.setId(1);
        username.setId(2);

        // set position details for BUTTON
        // whenever you wanna layout something explicitly in certain position, you need to give it this rule
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // set position details for USERNAME
        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        // give rules to position widgets
        usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0,0,0,50); // int left, int top, int right, int bottom

        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        //get bunch of info of app
        Resources r = getResources();
        // method setWidth only accept px value, so have to convert to dp
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200,
                r.getDisplayMetrics()
        ); // 200dp

        username.setWidth(px);

        // if want to add widget to layout, use method .addView()
        rl.addView(redButton, buttonDetails); // means add redButton into view with buttonDetails position properties
        rl.addView(username, usernameDetails);

        // set this activity display this view
        setContentView(rl);
    }
}
