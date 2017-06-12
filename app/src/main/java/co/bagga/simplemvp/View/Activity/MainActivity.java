package co.bagga.simplemvp.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import co.bagga.simplemvp.Presentation.UserPresenter;
import co.bagga.simplemvp.R;
import co.bagga.simplemvp.SimpleMvp;

public class MainActivity extends AppCompatActivity implements co.bagga.simplemvp.View.Activity.UserView {

    @Inject
    UserPresenter userPresenter;

    protected EditText editText;
    protected EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((SimpleMvp)getApplication()).getAppComponent().inject(this);
        userPresenter.setView(this);


        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userPresenter.saveUser();
            }
        });
    }

    @Override
    public int getUserId() {
        return 0;
    }

    @Override
    public void displayFirstName(String name) {
        editText.setText(name);
    }

    @Override
    public void displayLastName(String name) {
        editText2.setText(name);
    }

    @Override
    public void showUserNotFoundMessage() {
        Toast.makeText(this, "User Not Found", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User Saved", Toast.LENGTH_LONG).show();
    }

    @Override
    public String getFirstName() {
        return editText.getText().toString();
    }

    @Override
    public String getLastName() {
        return editText2.getText().toString();
    }

    @Override
    public void showUserNameIsRequired() {
        Toast.makeText(this, "User Name is Required", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        userPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        userPresenter.pause();
    }
}
