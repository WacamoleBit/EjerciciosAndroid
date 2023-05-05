package com.example.ejercicios;

import android.provider.BaseColumns;

public final class CancionesContract {
    private CancionesContract() {}

// Se definen las constantes que se estarán utilizando
    public static class CancionesTab implements BaseColumns {
        public static final String TABLE_NAME = "Canción";
        public static final String COLUMN_TITULO = "Título";
        public static final String COLUMN_CANTANTE = "Cantante";
    }
}
