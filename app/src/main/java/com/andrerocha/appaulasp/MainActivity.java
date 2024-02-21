package com.andrerocha.appaulasp;  //SharedPreferences

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "APP_aulaSp";
    private static final String PREF_NOME = "APP_aulaSp_PREF";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor dados;

    String nomeProduto;
    int codigoProduto;
    float precoProduto;
    boolean estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"onCreate Rodando...");

        sharedPreferences = getSharedPreferences(PREF_NOME, Context.MODE_PRIVATE);
        Log.i(TAG,"onCreate: pasta Shared Criada");

        dados = sharedPreferences.edit();
        nomeProduto = "Notebook";
        codigoProduto = 12345;
        precoProduto = 997.97f;
        estoque = true;



        dados.putString("nomeProduto",nomeProduto);
        dados.putInt("codigoProduto",codigoProduto);
        dados.putFloat("preco",precoProduto);
        dados.putBoolean("estoque",estoque);
        dados.apply(); //salva os dados no xml

        //Modo Debug


        Log.i(TAG,"onCreate: Dados recuperados");
        Log.d(TAG,"onCreate: Nome do produto: "+sharedPreferences.getString("nomeProduto",
                "fora de estoque"));
        Log.d(TAG,"onCreate: Código:......... "+sharedPreferences.getInt("codigoProduto",-1));
        Log.d(TAG,"onCreate: Preco:........."+sharedPreferences.getFloat("preco",-1.0f));
        Log.d(TAG,"onCreate: Tem no Estoque:."+sharedPreferences.getBoolean("estoque",false));

        //dados.clear();
        //dados.apply();

        //dados.remove("estoque");
        //dados.apply();




    }
}