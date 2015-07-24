package com.example.mirai16.familytree2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import DB.DBOpenHelper;

/**
 * Created by mirai16 on 2015/07/03.
 * 人物登録画面
 */
public class RegisterActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button button4 = (Button) this.findViewById(R.id.button4);
        button4.setOnClickListener(onClickListener);
        Button button5 = (Button) this.findViewById(R.id.button5);
        button5.setOnClickListener(onClickListener);
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            boolean fly = false;
            if(v.getId() == R.id.button5) fly = true;
            if (v.getId() == R.id.button4) {
                EditText edit = (EditText) findViewById(R.id.editText);
                SpannableStringBuilder sp = (SpannableStringBuilder)edit.getText();
                String name = sp.toString();
                // 名前の取得
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
                //性別の取得
                int id = rg.getCheckedRadioButtonId();
                //選択されていなければ-1が返る

                if ((name.equals("")) || (id < 0)) {
                    AlertDialog.Builder dlg;
                    dlg = new AlertDialog.Builder(RegisterActivity.this);
                    dlg.setTitle("エラー");
                    dlg.setMessage("自分の名前、性別を入力してください。");
                    dlg.show();
                    dlg.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            RegisterActivity.this.finish();
                        }
                    });

                    //名前、性別が選択されていないのでエラーメッセージを出す。画面遷移しない。
                } else {
                    registerClick(name, id);
                    fly = true;
                }
            }
            if (fly) {
                // 画面遷移

                Intent intent;
                intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);

            }

        }
    };

    private void registerClick(String name,int id) {

        ContentValues values = new ContentValues();
        // 名前の取得

        values.put("name", name);

        // 性別の取得
        String sex = "male";
        RadioButton radioButton = (RadioButton)findViewById(id);
        if (radioButton.getText().toString().equals("female")) {
            sex = "female";
        }
        values.put("sex", sex);

        // DB登録
        DBOpenHelper helper = new DBOpenHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        long ret;
        try {
            ret = db.insert("Family", null, values);
        } finally {
            db.close();
        }
        /*
        if (ret == -1) {
            Toast.makeText(this, "登録失敗", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "登録成功", Toast.LENGTH_SHORT).show();
        }*/
    }
}
