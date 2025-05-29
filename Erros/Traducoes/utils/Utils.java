package com.example.ducklibras.Traducoes.utils;

import android.content.Context;
import android.widget.Toast;

public class Utils {
    public static void mostrarToast(Context context, String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}
