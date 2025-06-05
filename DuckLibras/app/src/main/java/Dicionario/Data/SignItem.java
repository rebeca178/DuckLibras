package Dicionario.Data;

public class SignItem {
        private String palavra;
        private String imagemUrl;

        public SignItem(String palavra, String imagemUrl) {
            this.palavra = palavra;
            this.imagemUrl = imagemUrl;
        }

        public String getPalavra() {
            return palavra;
        }

        public String getImagemUrl() {
            return imagemUrl;
        }
    }
