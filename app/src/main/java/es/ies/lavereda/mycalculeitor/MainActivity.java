package es.ies.lavereda.mycalculeitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button n0;
    private Button n1;
    private Button n2;
    private Button n3;
    private Button n4;
    private Button n5;
    private Button n6;
    private Button n7;
    private Button n8;
    private Button n9;
    private Button botonSuma;
    private Button botonResta;
    private Button botonMultipl;
    private Button botonDividir;
    private Button botonIgual;
    private Button botonClear;
    private TextView display;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton radioSuma;
    private RadioButton radioResta;
    private RadioButton radioMultipli;
    private RadioButton radioDividir;
    private int aux;
    private int aux2;
    private int resultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n0=findViewById(R.id.n0);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        n3=findViewById(R.id.n3);
        n4=findViewById(R.id.n4);
        n5=findViewById(R.id.n5);
        n6=findViewById(R.id.n6);
        n7=findViewById(R.id.n7);
        n8=findViewById(R.id.n8);
        n9=findViewById(R.id.n9);
        botonIgual=findViewById(R.id.igualButon);
        botonSuma=findViewById(R.id.sumaButon);
        botonResta=findViewById(R.id.restaButon);
        botonMultipl=findViewById(R.id.multiplicButon);
        botonDividir=findViewById(R.id.dividirButon);
        botonClear=findViewById(R.id.clearButton);
        display=findViewById(R.id.textView);
        checkBox=findViewById(R.id.checkBox);
        radioGroup=findViewById(R.id.radioG);
        radioSuma=findViewById(R.id.radioSuma);
        radioResta=findViewById(R.id.radioResta);
        radioMultipli=findViewById(R.id.radioMultipl);
        radioDividir=findViewById(R.id.radioDivi);

        n0.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        botonIgual.setOnClickListener(this);
        botonSuma.setOnClickListener(this);
        botonDividir.setOnClickListener(this);
        botonResta.setOnClickListener(this);
        botonMultipl.setOnClickListener(this);
        botonClear.setOnClickListener(this);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    radioGroup.setVisibility(View.VISIBLE);
                else
                    radioGroup.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view instanceof Button) {
            Button b = (Button) view;

            if (b==botonIgual){
                display.setText(String.valueOf(resultado));
                aux=Integer.parseInt(display.getText().toString());
            }else if (b==botonSuma){
                aux=Integer.parseInt(display.getText().toString());
                display.setText("0");
                if (aux!=0)
                    aux+=aux;
            }else if (b==botonResta){
                aux=Integer.parseInt(display.getText().toString());
                resultado=aux-Integer.parseInt(display.getText().toString());
                display.setText(resultado);
            }else if (b==botonMultipl){
                aux=Integer.parseInt(display.getText().toString());
                resultado=aux*Integer.parseInt(display.getText().toString());
                display.setText(resultado);
            }else if (b==botonDividir){
                aux=Integer.parseInt(display.getText().toString());
                resultado=aux/Integer.parseInt(display.getText().toString());
                display.setText(resultado);
            }else if (b==botonClear) {
                display.setText("0");
                aux = 0;
            }else {
                if  (display.getText().equals("0"))
                    display.setText(b.getTag().toString());
                else
                    display.setText(display.getText()+b.getTag().toString());

            }
        }

        if(view instanceof RadioButton) {
            RadioButton rd = (RadioButton) view;
            if (rd == radioSuma) {
                botonSuma.setEnabled(false);
                botonResta.setEnabled(true);
                botonMultipl.setEnabled(true);
                botonDividir.setEnabled(true);
            }
            if (rd == radioResta) {
                botonSuma.setEnabled(true);
                botonResta.setEnabled(false);
                botonMultipl.setEnabled(true);
                botonDividir.setEnabled(true);
            }
            if (rd == radioMultipli) {
                botonSuma.setEnabled(true);
                botonResta.setEnabled(true);
                botonMultipl.setEnabled(false);
                botonDividir.setEnabled(true);
            }
            if (rd == radioDividir) {
                botonSuma.setEnabled(true);
                botonResta.setEnabled(true);
                botonMultipl.setEnabled(true);
                botonDividir.setEnabled(false);
            }
        }
    }
}