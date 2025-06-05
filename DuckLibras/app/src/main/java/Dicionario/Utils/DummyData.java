package Dicionario.Utils;

import java.util.ArrayList;
import java.util.List;

import Dicionario.Data.SignItem;

public class DummyData {
    public static List<SignItem> getSigns() {
        List<SignItem> list = new ArrayList<>();
        list.add(new SignItem("Amor", "https://link-para-imagem1.com/amor.png"));
        list.add(new SignItem("Obrigado", "https://link-para-imagem2.com/obrigado.png"));
        list.add(new SignItem("Casa", "https://link-para-imagem3.com/casa.png"));
        return list;
    }
}
